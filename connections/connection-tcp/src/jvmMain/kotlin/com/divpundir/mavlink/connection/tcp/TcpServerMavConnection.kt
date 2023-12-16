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

    private var server: ServerSocket? = null

    @Throws(IOException::class)
    override fun open(): MavConnection {
        val svr = ServerSocket(port)
        server = svr

        val socket = svr.accept()
        svr.close()

        return BufferedMavConnection(
            socket.source().buffer(),
            socket.sink().buffer(),
            socket,
            dialect
        )
    }

    @Throws(IOException::class)
    override fun interruptOpen() {
        super.interruptOpen()
        server?.close()
    }
}
