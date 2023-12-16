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
    port: Int,
    private val dialect: MavDialect
) : AbstractMavConnection(), UdpServerMavConnection {

    private val channel = DatagramChannel.open().apply {
        configureBlocking(true)
        bind(InetSocketAddress(port))
    }

    @Throws(IOException::class)
    override fun open(): MavConnection {
        channel.connect(channel.receive(ByteBuffer.allocate(32)))

        return BufferedMavConnection(
            ByteChannelSource(channel).buffer(),
            ByteChannelSink(channel).buffer(),
            channel,
            dialect
        )
    }

    @Throws(IOException::class)
    override fun interruptOpen() {
        super.interruptOpen()
        channel.close()
    }
}
