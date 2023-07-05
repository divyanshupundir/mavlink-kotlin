package com.divpundir.mavlink.connection

import com.divpundir.mavlink.api.MavDialect
import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import okio.BufferedSink
import okio.BufferedSource
import okio.Closeable
import okio.IOException
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

/**
 * A [MavConnection] implementation that reads [MavFrame]s form a [BufferedSource] and writes them to a [BufferedSink].
 * The [dialect] is used to deserialize the raw frame to a [MavFrame]. The [resource] is the origin of the source and
 * the sink. For example, a TCP Socket or serial port.
 */
public class BufferedMavConnection(
    source: BufferedSource,
    private val sink: BufferedSink,
    private val resource: Closeable,
    private val dialect: MavDialect,
) : MavConnection {

    private val readLock: Lock = ReentrantLock()
    private val writeLock: Lock = ReentrantLock()

    private val reader = MavRawFrameReader(source)

    private var sequence: UByte = 0u

    @Throws(IOException::class)
    override fun connect() {}

    @Throws(IOException::class)
    override fun close() {
        resource.close()
    }

    @Throws(IOException::class)
    override fun next(): MavFrame<out MavMessage<*>> {
        readLock.withLock {
            while (true) {
                val rawFrame = reader.next()

                val companion = getMessageCompanionOrNull(rawFrame)
                if (companion == null) {
                    System.err.println("Message not found in dialect. rawFrame=$rawFrame")
                    continue
                }

                val payload = try {
                    companion.deserialize(rawFrame.payload)
                } catch (e: IOException) {
                    System.err.println("Error deserializing MAVLink message. rawFrame=$rawFrame metadata=$companion")
                    continue
                }

                return when (rawFrame.stx) {
                    MavRawFrame.Stx.V1 -> MavFrameV1Impl(rawFrame, payload)
                    MavRawFrame.Stx.V2 -> MavFrameV2Impl(rawFrame, payload)
                    else -> throw IllegalStateException()
                }
            }
        }
    }

    private fun getMessageCompanionOrNull(
        rawFrame: MavRawFrame,
    ): MavMessage.MavCompanion<out MavMessage<*>>? {
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
                seq = sequence++,
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
                seq = sequence++,
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
                seq = sequence++,
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
