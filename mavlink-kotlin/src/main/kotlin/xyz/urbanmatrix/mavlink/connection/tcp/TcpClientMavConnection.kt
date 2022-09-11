package xyz.urbanmatrix.mavlink.connection.tcp

import xyz.urbanmatrix.mavlink.api.MavDialect
import xyz.urbanmatrix.mavlink.connection.StreamMavConnection
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

class TcpClientMavConnection(
    private val host: String,
    private val port: Int,
    private val dialect: MavDialect
) : TcpMavConnection() {

    @Throws(IOException::class)
    override fun connect() {
        val socket = Socket().apply {
            connect(
                InetSocketAddress(
                    this@TcpClientMavConnection.host,
                    this@TcpClientMavConnection.port
                )
            )
        }

        state = State.Open(
            StreamMavConnection(
                socket.getInputStream(),
                socket.getOutputStream(),
                socket,
                dialect
            )
        )
    }
}
