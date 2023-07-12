package com.divpundir.mavlink.connection.udp

import com.divpundir.mavlink.api.MavDialect
import com.divpundir.mavlink.connection.AbstractMavConnection
import com.divpundir.mavlink.connection.BufferedMavConnection
import okio.IOException
import okio.buffer
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.DatagramChannel

public class UdpServerMavConnection(
    private val port: Int,
    private val dialect: MavDialect
) : AbstractMavConnection() {

    @Throws(IOException::class)
    override fun connect() {
        when (state) {
            is State.Open -> throw IOException("The connection is already open")

            State.Closed -> {
                val channel = DatagramChannel.open().apply {
                    bind(InetSocketAddress(port))
                    connect(receive(ByteBuffer.allocate(1024)))
                    configureBlocking(false)
                }

                state = State.Open(
                    BufferedMavConnection(
                        ByteChannelSource(channel).buffer(),
                        ByteChannelSink(channel).buffer(),
                        channel,
                        dialect
                    )
                )
            }
        }
    }
}
