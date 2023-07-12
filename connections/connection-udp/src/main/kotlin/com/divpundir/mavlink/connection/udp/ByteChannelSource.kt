package com.divpundir.mavlink.connection.udp

import okio.Buffer
import okio.Source
import okio.Timeout
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.channels.ReadableByteChannel
import kotlin.math.min

internal class ByteChannelSource(
    private val channel: ReadableByteChannel,
    private val timeout: Timeout
) : Source {

    private val cursor: Buffer.UnsafeCursor = Buffer.UnsafeCursor()

    @Throws(IOException::class)
    override fun read(sink: Buffer, byteCount: Long): Long {
        check(channel.isOpen) { "closed" }

        sink.readAndWriteUnsafe(cursor).use { _ ->
            timeout.throwIfReached()

            val oldSize: Long = sink.size
            val length = min(8192, byteCount).toInt()

            cursor.expandBuffer(length)

            val read = channel.read(ByteBuffer.wrap(cursor.data, cursor.start, length))
            return if (read == -1) {
                cursor.resizeBuffer(oldSize)
                -1
            } else {
                cursor.resizeBuffer(oldSize + read)
                read.toLong()
            }
        }
    }

    override fun timeout(): Timeout = timeout

    @Throws(IOException::class)
    override fun close() {
        channel.close()
    }
}
