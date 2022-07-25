package com.urbanmatrix.mavlink.connection.tcp

import com.urbanmatrix.mavlink.api.MavDialect
import java.io.IOException
import java.net.ServerSocket

class TcpServerMavConnection(
    private val port: Int,
    dialect: MavDialect
) : AbstractTcpMavConnection(dialect) {

    @Throws(IOException::class)
    override fun connect() {
        val server = ServerSocket(port)
        socket = server.accept()
        server.close()
    }
}
