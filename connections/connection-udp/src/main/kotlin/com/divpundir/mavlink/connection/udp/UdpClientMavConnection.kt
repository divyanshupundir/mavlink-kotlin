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
 * A [MavConnection][com.divpundir.mavlink.connection.MavConnection] implementation that acts as a UDP client endpoint.
 *
 * For connecting, pings the remote server with 32 bytes of data to let the remote server know its address.
 */
public class UdpClientMavConnection(
    private val host: String,
    private val port: Int,
    private val dialect: MavDialect
) : AbstractMavConnection() {

    @Throws(IOException::class)
    override fun open(): MavConnection {
        val address = InetSocketAddress(host, port)

        val channel = DatagramChannel.open().apply {
            configureBlocking(true)
            connect(address)
            send(ByteBuffer.allocate(32), address)
            receive(ByteBuffer.allocate(32))
        }

        return BufferedMavConnection(
            ByteChannelSource(channel).buffer(),
            ByteChannelSink(channel).buffer(),
            channel,
            dialect
        )
    }
}
