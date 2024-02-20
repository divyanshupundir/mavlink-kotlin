package com.divpundir.mavlink.connection

import com.divpundir.mavlink.api.MavDialect
import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import kotlinx.atomicfu.atomic
import kotlinx.atomicfu.locks.reentrantLock
import kotlinx.atomicfu.locks.withLock
import okio.BufferedSink
import okio.BufferedSource
import okio.Closeable
import okio.IOException

/**
 * A [MavConnection] implementation that reads [MavFrame]s form a [BufferedSource] and writes them to a [BufferedSink].
 * The [dialect] is used to deserialize the raw frame to a [MavFrame]. The [resource] is the origin of the source and
 * the sink. For example, a TCP Socket or a serial port.
 */
public class BufferedMavConnection(
    private val source: BufferedSource,
    private val sink: BufferedSink,
    private val resource: Closeable,
    private val dialect: MavDialect,
) : MavConnection {

    private val readLock = reentrantLock()
    private val writeLock = reentrantLock()

    private val sequence = atomic(0)

    @Throws(IOException::class)
    override fun connect() { }

    @Throws(IOException::class)
    override fun close() {
        resource.close()
    }

    @Throws(IOException::class)
    override fun next(): MavFrame<out MavMessage<*>> = readLock.withLock {
        nextFrame()
    }

    private fun nextFrame(): MavFrame<out MavMessage<*>> {
        while (true) {
            val rawFrame = nextRawFrame()
            val companion = getMessageCompanionOrNull(rawFrame) ?: continue

            val payload = try {
                companion.deserialize(rawFrame.payload)
            } catch (e: IOException) {
                continue
            }

            return when (rawFrame.stx) {
                MavRawFrame.Stx.V1 -> MavFrameV1Impl(rawFrame, payload)
                MavRawFrame.Stx.V2 -> MavFrameV2Impl(rawFrame, payload)
                else -> throw IllegalStateException("Invalid MAVLink frame marker")
            }
        }
    }

    private fun nextRawFrame(): MavRawFrame {
        while (true) {
            val peeked = source.peek()

            when (peeked.readByte().toUByte()) {
                MavRawFrame.Stx.V1 -> {
                    val payloadSize = peeked.readByte().toUByte().toInt()

                    val remainingSize = MavRawFrame.Sizes.SEQ +
                            MavRawFrame.Sizes.SYS_ID + MavRawFrame.Sizes.COMP_ID + MavRawFrame.Sizes.MSG_ID_V1 +
                            payloadSize + MavRawFrame.Sizes.CHECKSUM

                    if (!peeked.request(remainingSize.toLong())) {
                        source.skip(1)
                        continue
                    }

                    val totalSize = MavRawFrame.Sizes.STX + MavRawFrame.Sizes.LEN + remainingSize.toLong()

                    return MavRawFrame.fromV1Bytes(source.readByteArray(totalSize))
                }

                MavRawFrame.Stx.V2 -> {
                    val payloadSize = peeked.readByte().toUByte().toInt()
                    val incompatibleFlags = peeked.readByte().toUByte()

                    val signatureTotalSize = if (incompatibleFlags == MavRawFrame.Flags.INCOMPAT_SIGNED) {
                        MavRawFrame.Sizes.SIGNATURE_LINK_ID + MavRawFrame.Sizes.SIGNATURE_TIMESTAMP + MavRawFrame.Sizes.SIGNATURE
                    } else {
                        0
                    }

                    val remainingSize = MavRawFrame.Sizes.COMPAT_FLAGS +
                            MavRawFrame.Sizes.SEQ +
                            MavRawFrame.Sizes.SYS_ID + MavRawFrame.Sizes.COMP_ID + MavRawFrame.Sizes.MSG_ID_V2 +
                            payloadSize + MavRawFrame.Sizes.CHECKSUM +
                            signatureTotalSize

                    if (!peeked.request(remainingSize.toLong())) {
                        source.skip(1)
                        continue
                    }

                    val totalSize = MavRawFrame.Sizes.STX + MavRawFrame.Sizes.LEN +
                            MavRawFrame.Sizes.INCOMPAT_FLAGS + remainingSize.toLong()

                    return MavRawFrame.fromV2Bytes(source.readByteArray(totalSize))
                }

                else -> {
                    source.skip(1)
                    continue
                }
            }
        }
    }

    private fun getMessageCompanionOrNull(rawFrame: MavRawFrame): MavMessage.MavCompanion<out MavMessage<*>>? {
        val metadata = dialect.resolveCompanionOrNull(rawFrame.messageId) ?: return null
        if (!rawFrame.validateCrc(metadata.crcExtra)) return null
        return metadata
    }

    @Throws(IOException::class)
    override fun <T : MavMessage<T>> sendV1(
        systemId: UByte,
        componentId: UByte,
        payload: T
    ) {
        send(
            MavRawFrame.createV1(
                seq = sequence.getAndIncrement().toUByte(),
                systemId = systemId,
                componentId = componentId,
                messageId = payload.instanceCompanion.id,
                payload = payload.serializeV1(),
                crcExtra = payload.instanceCompanion.crcExtra,
            )
        )
    }

    @Throws(IOException::class)
    override fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T
    ) {
        send(
            MavRawFrame.createUnsignedV2(
                seq = sequence.getAndIncrement().toUByte(),
                systemId = systemId,
                componentId = componentId,
                messageId = payload.instanceCompanion.id,
                payload = payload.serializeV2(),
                crcExtra = payload.instanceCompanion.crcExtra,
            )
        )
    }

    @Throws(IOException::class)
    override fun <T : MavMessage<T>> sendSignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T,
        linkId: UByte,
        timestamp: UInt,
        secretKey: ByteArray
    ) {
        send(
            MavRawFrame.createSignedV2(
                seq = sequence.getAndIncrement().toUByte(),
                systemId = systemId,
                componentId = componentId,
                messageId = payload.instanceCompanion.id,
                payload = payload.serializeV2(),
                crcExtra = payload.instanceCompanion.crcExtra,
                signatureLinkId = linkId,
                signatureTimestamp = timestamp,
                secretKey = secretKey
            )
        )
    }

    @Throws(IOException::class)
    private fun send(rawFrame: MavRawFrame) {
        writeLock.withLock {
            sink.write(rawFrame.rawBytes)
            sink.flush()
        }
    }
}
