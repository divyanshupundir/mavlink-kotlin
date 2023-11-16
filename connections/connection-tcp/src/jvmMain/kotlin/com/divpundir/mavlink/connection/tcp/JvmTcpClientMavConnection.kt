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
    private val host: String,
    private val port: Int,
    private val dialect: MavDialect
) : AbstractMavConnection(), TcpClientMavConnection {

    @Throws(IOException::class)
    override fun open(): MavConnection {
        val socket = Socket().apply {
            connect(
                InetSocketAddress(
                    this@JvmTcpClientMavConnection.host,
                    this@JvmTcpClientMavConnection.port
                )
            )
        }

        return BufferedMavConnection(
            socket.source().buffer(),
            socket.sink().buffer(),
            socket,
            dialect
        )
    }
}
