package com.divpundir.mavlink.connection.tcp

import com.divpundir.mavlink.api.MavDialect
import com.divpundir.mavlink.connection.AbstractMavConnection
import com.divpundir.mavlink.connection.BufferedMavConnection
import com.divpundir.mavlink.connection.MavConnection
import okio.IOException
import okio.buffer
import okio.sink
import okio.source
import java.net.InetSocketAddress
import java.net.Socket

public actual fun TcpClientMavConnection(
    host: String,
    port: Int,
    dialect: MavDialect
): TcpClientMavConnection = JvmTcpClientMavConnection(
    host,
    port,
    dialect
)

private class JvmTcpClientMavConnection(
    host: String,
    port: Int,
    private val dialect: MavDialect
) : AbstractMavConnection(), TcpClientMavConnection {

    private val address = InetSocketAddress(host, port)

    @Throws(IOException::class)
    override fun open(): MavConnection {
        val socket = Socket().apply {
            connect(address)
        }

        return BufferedMavConnection(
            socket.source().buffer(),
            socket.sink().buffer(),
            socket,
            dialect
        )
    }
}
