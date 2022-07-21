package com.urbanmatrix.mavlink.connection

import com.urbanmatrix.mavlink.api.MavDialect
import com.urbanmatrix.mavlink.api.MavFrame
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.frame.MavFrameV1Impl
import com.urbanmatrix.mavlink.frame.MavFrameV2Impl
import com.urbanmatrix.mavlink.mavRawFrameReader
import com.urbanmatrix.mavlink.raw.MavFrameType
import com.urbanmatrix.mavlink.raw.MavRawFrame
import com.urbanmatrix.mavlink.raw.MavRawFrameReader
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class MavConnection(
    inputStream: InputStream?,
    private var outputStream: OutputStream?,
    private val dialect: MavDialect,
) {
    private var reader: MavRawFrameReader? = inputStream?.mavRawFrameReader()

    private val readLock: Lock = ReentrantLock()
    private val writeLock: Lock = ReentrantLock()

    private var sequence = 0

    @Suppress("TYPE_MISMATCH_WARNING", "UPPER_BOUND_VIOLATED_WARNING")
    @Throws(IOException::class)
    fun next(): MavFrame<out MavMessage<*>> {
        readLock.withLock {
            while (true) {
                val r = reader ?: throw IOException("InputStream is null")

                val rawFrame = r.next()

                val metadata = getMessageMetadataOrNull(rawFrame)
                if (metadata == null) {
                    r.drop()
                    continue
                }

                val payload = try {
                    metadata.deserializer.deserialize(rawFrame.payload)
                } catch (e: Exception) {
                    System.err.println("Error deserializing MAVLink message. rawFrame=$rawFrame metadata=$metadata")
                    r.drop()
                    continue
                }

                return when (rawFrame.stx) {
                    MavFrameType.V1.magic -> MavFrameV1Impl<MavMessage<*>>(rawFrame, payload)
                    MavFrameType.V2.magic -> MavFrameV2Impl<MavMessage<*>>(rawFrame, payload)
                    else -> throw IllegalStateException()
                }
            }
        }
    }

    private fun getMessageMetadataOrNull(
        rawFrame: MavRawFrame,
    ): MavMessage.Metadata<out MavMessage<*>>? {
        val metadata = dialect.resolveMetadataOrNull(rawFrame.messageId) ?: return null
        if (!rawFrame.validateCrc(metadata.crc)) return null
        return metadata
    }

    @Throws(IOException::class)
    fun <T : MavMessage<T>> sendV1(
        systemId: Int,
        componentId: Int,
        payload: T
    ) {
        val payloadBytes = payload.serialize()
        writeLock.withLock {
            send(
                MavRawFrame.createV1(
                    sequence++,
                    systemId,
                    componentId,
                    payload.instanceMetadata.id,
                    payloadBytes,
                    payload.instanceMetadata.crc,
                )
            )
        }
    }

    @Throws(IOException::class)
    fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: Int,
        componentId: Int,
        payload: T
    ) {
        val payloadBytes = payload.serialize()
        writeLock.withLock {
            send(
                MavRawFrame.createUnsignedV2(
                    sequence++,
                    systemId,
                    componentId,
                    payload.instanceMetadata.id,
                    payloadBytes,
                    payload.instanceMetadata.crc,
                )
            )
        }
    }

    @Throws(IOException::class)
    fun <T : MavMessage<T>> sendSignedV2(
        systemId: Int,
        componentId: Int,
        payload: T,
        linkId: Int,
        timestamp: Long,
        secretKey: ByteArray
    ) {
        val payloadBytes = payload.serialize()
        writeLock.withLock {
            send(
                MavRawFrame.createSignedV2(
                    sequence++,
                    systemId,
                    componentId,
                    payload.instanceMetadata.id,
                    payloadBytes,
                    payload.instanceMetadata.crc,
                    linkId,
                    timestamp,
                    secretKey
                )
            )
        }
    }

    @Throws(IOException::class)
    private fun send(rawFrame: MavRawFrame) {
        val o = outputStream ?: throw IOException("OutputStream is null")
        o.write(rawFrame.rawBytes)
        o.flush()
    }

    fun swapStreams(inputStream: InputStream?, outputStream: OutputStream?) {
        this.reader = inputStream?.mavRawFrameReader()
        this.outputStream = outputStream
    }
}
