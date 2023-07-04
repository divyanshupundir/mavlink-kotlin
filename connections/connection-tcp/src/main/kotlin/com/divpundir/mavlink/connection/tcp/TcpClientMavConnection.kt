package com.divpundir.mavlink.connection.tcp

import com.divpundir.mavlink.api.MavDialect
import com.divpundir.mavlink.connection.BufferedMavConnection
import com.divpundir.mavlink.connection.AbstractMavConnection
import okio.IOException
import okio.buffer
import okio.sink
import okio.source
import java.net.InetSocketAddress
import java.net.Socket

/**
 * A [MavConnection][com.divpundir.mavlink.connection.MavConnection] interface that acts as a TCP client endpoint.
 */
public class TcpClientMavConnection(
    private val host: String,
    private val port: Int,
    private val dialect: MavDialect
) : AbstractMavConnection() {

    @Throws(IOException::class)
    override fun connect() {
        when (state) {
            is State.Open -> throw IOException("Already open")

            State.Closed -> {
                val socket = Socket().apply {
                    connect(
                        InetSocketAddress(
                            this@TcpClientMavConnection.host,
                            this@TcpClientMavConnection.port
                        )
                    )
                }
                state = State.Open(
                    BufferedMavConnection(
                        socket.source().buffer(),
                        socket.sink().buffer(),
                        socket,
                        dialect
                    )
                )
            }
        }
    }
}
