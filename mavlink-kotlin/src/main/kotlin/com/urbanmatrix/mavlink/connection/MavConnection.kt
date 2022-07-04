package com.urbanmatrix.mavlink.connection

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDialect
import com.urbanmatrix.mavlink.api.MavFrame
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.frame.MavFrameV1Impl
import com.urbanmatrix.mavlink.frame.MavFrameV2Impl
import com.urbanmatrix.mavlink.raw.MavFrameType
import com.urbanmatrix.mavlink.raw.MavRawFrame
import com.urbanmatrix.mavlink.raw.MavRawFrameReader
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

open class MavConnection(
    inputStream: InputStream,
    private val outputStream: OutputStream,
    private val dialect: MavDialect,
) {
    private val reader = MavRawFrameReader(inputStream)

    private val readLock: Lock = ReentrantLock()
    private val writeLock: Lock = ReentrantLock()

    private var sequence = 0

    @Suppress("TYPE_MISMATCH_WARNING", "UPPER_BOUND_VIOLATED_WARNING")
    @Throws(IOException::class)
    operator fun next(): MavFrame<out MavMessage<*>> {
        readLock.lock()
        try {
            while (true) {
                val rawFrame = reader.next()

                val metadata = getMessageMetadataOrNull(rawFrame)
                if (metadata == null) {
                    reader.drop()
                    continue
                }

                val payload = try {
                    metadata.deserializer.deserialize(rawFrame.payload)
                } catch (e: MavDeserializationException) {
                    e.printStackTrace()
                    reader.drop()
                    continue
                }

                return when (rawFrame.stx) {
                    MavFrameType.V1.magic -> MavFrameV2Impl<MavMessage<*>>(rawFrame, payload)
                    MavFrameType.V2.magic -> MavFrameV1Impl<MavMessage<*>>(rawFrame, payload)
                    else -> continue
                }
            }
        } finally {
            readLock.unlock()
        }
    }

    private fun getMessageMetadataOrNull(
        rawFrame: MavRawFrame,
    ): MavMessage.Metadata<out MavMessage<*>>? {
        val metadata = dialect.resolveMetadataOrNull(rawFrame.messageId) ?: return null
        if (!rawFrame.validateCrc(metadata.crc)) return null
        return metadata
    }
}
