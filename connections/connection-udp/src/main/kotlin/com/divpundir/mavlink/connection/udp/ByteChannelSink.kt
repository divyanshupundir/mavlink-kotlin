package com.divpundir.mavlink.connection.udp

import okio.Buffer
import okio.Sink
import okio.Timeout
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.channels.WritableByteChannel
import kotlin.math.min

internal class ByteChannelSink(
    private val channel: WritableByteChannel,
    private val timeout: Timeout = Timeout.NONE
) : Sink {

    private val cursor: Buffer.UnsafeCursor = Buffer.UnsafeCursor()

    @Throws(IOException::class)
    override fun write(source: Buffer, byteCount: Long) {
        check(channel.isOpen) { "closed" }

        if (byteCount == 0L) {
            return
        }

        var remaining = byteCount
        while (remaining > 0) {
            timeout.throwIfReached()

            source.readUnsafe(cursor).use { _ ->
                cursor.seek(0)

                val length = min(cursor.end - cursor.start, remaining.toInt())
                val written = channel.write(ByteBuffer.wrap(cursor.data, cursor.start, length)).toLong()

                remaining -= written
                source.skip(written)
            }
        }
    }

    override fun flush() {}

    override fun timeout(): Timeout = timeout

    @Throws(IOException::class)
    override fun close() {
        channel.close()
    }
}
