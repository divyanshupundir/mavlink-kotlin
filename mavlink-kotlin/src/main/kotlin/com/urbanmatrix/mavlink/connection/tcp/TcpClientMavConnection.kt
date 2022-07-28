package com.urbanmatrix.mavlink.connection.tcp

import com.urbanmatrix.mavlink.api.MavDialect
import com.urbanmatrix.mavlink.connection.SimpleMavConnection
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
            SimpleMavConnection(
                socket.getInputStream(),
                socket.getOutputStream(),
                socket,
                dialect
            )
        )
    }
}
