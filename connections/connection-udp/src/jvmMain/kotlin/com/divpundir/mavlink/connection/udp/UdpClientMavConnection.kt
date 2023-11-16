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

public actual fun UdpClientMavConnection(
    host: String,
    port: Int,
    dialect: MavDialect
): UdpClientMavConnection = JvmUdpClientMavConnection(
    host,
    port,
    dialect
)

private class JvmUdpClientMavConnection(
    private val host: String,
    private val port: Int,
    private val dialect: MavDialect
) : AbstractMavConnection(), UdpClientMavConnection {

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
