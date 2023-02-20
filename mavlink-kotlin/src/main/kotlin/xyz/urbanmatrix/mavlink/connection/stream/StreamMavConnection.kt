package xyz.urbanmatrix.mavlink.connection.stream

import xyz.urbanmatrix.mavlink.api.MavDialect
import xyz.urbanmatrix.mavlink.api.MavFrame
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.connection.MavConnection
import xyz.urbanmatrix.mavlink.frame.MavFrameV1Impl
import xyz.urbanmatrix.mavlink.frame.MavFrameV2Impl
import xyz.urbanmatrix.mavlink.mavRawFrameReader
import xyz.urbanmatrix.mavlink.frame.MavFrameType
import xyz.urbanmatrix.mavlink.frame.MavRawFrame
import java.io.Closeable
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

internal class StreamMavConnection(
    inputStream: InputStream,
    private val outputStream: OutputStream,
    private val streamHandle: Closeable,
    private val dialect: MavDialect,
) : MavConnection {

    private val readLock: Lock = ReentrantLock()
    private val writeLock: Lock = ReentrantLock()

    private val reader = inputStream.mavRawFrameReader()

    private var sequence: UByte = 0u

    @Throws(IOException::class)
    override fun connect() {}

    @Throws(IOException::class)
    override fun close() {
        streamHandle.close()
    }

    @Throws(IOException::class)
    override fun next(): MavFrame<out MavMessage<*>> {
        readLock.withLock {
            while (true) {
                val rawFrame = reader.next()

                val metadata = getMessageMetadataOrNull(rawFrame)
                if (metadata == null) {
                    System.err.println("Message not found in dialect. rawFrame=$rawFrame")
                    reader.drop()
                    continue
                }

                val payload = try {
                    metadata.deserializer.deserialize(rawFrame.payload)
                } catch (e: Exception) {
                    System.err.println("Error deserializing MAVLink message. rawFrame=$rawFrame metadata=$metadata")
                    reader.drop()
                    continue
                }

                return when (rawFrame.stx) {
                    MavFrameType.V1.magic -> MavFrameV1Impl(rawFrame, payload)
                    MavFrameType.V2.magic -> MavFrameV2Impl(rawFrame, payload)
                    else -> throw IllegalStateException()
                }
            }
        }
    }

    private fun getMessageMetadataOrNull(
        rawFrame: MavRawFrame,
    ): MavMessage.Metadata<out MavMessage<*>>? {
        val metadata = dialect.resolveMetadataOrNull(rawFrame.messageId) ?: return null
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
                sequence++,
                systemId,
                componentId,
                payload.instanceMetadata.id,
                payload.serializeV1(),
                payload.instanceMetadata.crcExtra,
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
                sequence++,
                systemId,
                componentId,
                payload.instanceMetadata.id,
                payload.serializeV2(),
                payload.instanceMetadata.crcExtra,
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
                sequence++,
                systemId,
                componentId,
                payload.instanceMetadata.id,
                payload.serializeV2(),
                payload.instanceMetadata.crcExtra,
                linkId,
                timestamp,
                secretKey
            )
        )
    }

    @Throws(IOException::class)
    private fun send(rawFrame: MavRawFrame) {
        writeLock.withLock {
            outputStream.write(rawFrame.rawBytes)
            outputStream.flush()
        }
    }
}
