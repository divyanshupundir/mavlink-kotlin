package com.divpundir.mavlink.connection.stream

import com.divpundir.mavlink.api.MavDialect
import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.connection.MavConnection
import com.divpundir.mavlink.frame.MavFrameV1Impl
import com.divpundir.mavlink.frame.MavFrameV2Impl
import com.divpundir.mavlink.mavRawFrameReader
import com.divpundir.mavlink.frame.MavFrameType
import com.divpundir.mavlink.frame.MavRawFrame
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

                val companion = getMessageCompanionOrNull(rawFrame)
                if (companion == null) {
                    System.err.println("Message not found in dialect. rawFrame=$rawFrame")
                    reader.drop()
                    continue
                }

                val payload = try {
                    companion.deserialize(rawFrame.payload)
                } catch (e: Exception) {
                    System.err.println("Error deserializing MAVLink message. rawFrame=$rawFrame metadata=$companion")
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
                sequence++,
                systemId,
                componentId,
                payload.instanceCompanion.id,
                payload.serializeV1(),
                payload.instanceCompanion.crcExtra,
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
                payload.instanceCompanion.id,
                payload.serializeV2(),
                payload.instanceCompanion.crcExtra,
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
                payload.instanceCompanion.id,
                payload.serializeV2(),
                payload.instanceCompanion.crcExtra,
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
