package com.divpundir.mavlink.connection.udp

import com.divpundir.mavlink.api.MavDialect
import com.divpundir.mavlink.connection.AbstractMavConnection
import com.divpundir.mavlink.connection.BufferedMavConnection
import com.divpundir.mavlink.connection.MavConnection
import okio.IOException
import okio.buffer
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.DatagramChannel

/**
 * A [MavConnection][com.divpundir.mavlink.connection.MavConnection] implementation that acts as a UDP server endpoint.
 *
 * Listens on the specified [port] for a 32-byte ping, and connects to the first sender.
 */
public class UdpServerMavConnection(
    private val port: Int,
    private val dialect: MavDialect
) : AbstractMavConnection() {

    @Throws(IOException::class)
    override fun open(): MavConnection {
        val channel = DatagramChannel.open().apply {
            configureBlocking(true)
            bind(InetSocketAddress(port))
            connect(receive(ByteBuffer.allocate(32)))
        }

        return BufferedMavConnection(
            ByteChannelSource(channel).buffer(),
            ByteChannelSink(channel).buffer(),
            channel,
            dialect
        )
    }
}
