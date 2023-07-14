package com.divpundir.mavlink.connection.tcp

import com.divpundir.mavlink.api.MavDialect
import com.divpundir.mavlink.connection.BufferedMavConnection
import com.divpundir.mavlink.connection.AbstractMavConnection
import com.divpundir.mavlink.connection.MavConnection
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
) : AbstractMavConnection() {

    @Throws(IOException::class)
    protected override fun open(): MavConnection {
        val server = ServerSocket(port)
        val socket = server.accept()
        server.close()

        return BufferedMavConnection(
            socket.source().buffer(),
            socket.sink().buffer(),
            socket,
            dialect
        )
    }
}
