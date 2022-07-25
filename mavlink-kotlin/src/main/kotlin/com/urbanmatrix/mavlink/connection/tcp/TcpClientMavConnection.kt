package com.urbanmatrix.mavlink.connection.tcp

import com.urbanmatrix.mavlink.api.MavDialect
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

class TcpClientMavConnection(
    private val host: String,
    private val port: Int,
    dialect: MavDialect
) : AbstractTcpMavConnection(dialect) {

    @Throws(IOException::class)
    override fun connect() {
        socket = Socket().apply {
            connect(
                InetSocketAddress(
                    this@TcpClientMavConnection.host,
                    this@TcpClientMavConnection.port
                )
            )
            connect(getInputStream(), getOutputStream())
        }
    }
}
