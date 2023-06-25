package com.divpundir.mavlink.connection.tcp

import com.divpundir.mavlink.api.MavDialect
import com.divpundir.mavlink.connection.BufferedMavConnection
import okio.IOException
import okio.buffer
import okio.sink
import okio.source
import java.net.ServerSocket

/**
 * A [MavConnection][com.divpundir.mavlink.connection.MavConnection] interface that acts as a TCP server endpoint.
 *
 * This class listens on the specified [port] for a single connection. Once a connection is established, the server
 * socket is closed.
 */
public class TcpServerMavConnection(
    private val port: Int,
    private val dialect: MavDialect
) : TcpMavConnection() {

    @Throws(IOException::class)
    override fun connect() {
        when (state) {
            is State.Open -> throw IOException("Already Open")

            State.Closed -> {
                val server = ServerSocket(port)
                val socket = server.accept()
                server.close()

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
