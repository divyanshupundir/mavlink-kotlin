package xyz.urbanmatrix.mavlink.connection.tcp

import xyz.urbanmatrix.mavlink.api.MavDialect
import xyz.urbanmatrix.mavlink.connection.SimpleMavConnection
import java.io.IOException
import java.net.ServerSocket

class TcpServerMavConnection(
    private val port: Int,
    private val dialect: MavDialect
) : TcpMavConnection() {

    @Throws(IOException::class)
    override fun connect() {
        val server = ServerSocket(port)
        val socket = server.accept()
        server.close()

        state = State.Open(
            SimpleMavConnection(
                socket.getInputStream(),
                socket.getOutputStream(),
                socket,
                dialect
            )
        )
    }
}
