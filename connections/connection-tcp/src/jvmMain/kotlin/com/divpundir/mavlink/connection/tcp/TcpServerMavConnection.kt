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

public actual fun TcpServerMavConnection(
    port: Int,
    dialect: MavDialect
): TcpServerMavConnection = JvmTcpServerMavConnection(
    port,
    dialect
)

private class JvmTcpServerMavConnection(
    private val port: Int,
    private val dialect: MavDialect
) : AbstractMavConnection(), TcpServerMavConnection {

    @Throws(IOException::class)
    override fun open(): MavConnection {
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
