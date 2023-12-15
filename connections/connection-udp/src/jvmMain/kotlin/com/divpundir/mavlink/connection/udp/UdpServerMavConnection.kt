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

public actual fun UdpServerMavConnection(
    port: Int,
    dialect: MavDialect
): UdpServerMavConnection = JvmUdpServerMavConnection(
    port,
    dialect
)

private class JvmUdpServerMavConnection(
    private val port: Int,
    private val dialect: MavDialect
) : AbstractMavConnection(), UdpServerMavConnection {

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
