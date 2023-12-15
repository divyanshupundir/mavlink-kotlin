package com.divpundir.mavlink.connection.tcp

import com.divpundir.mavlink.api.MavDialect
import com.divpundir.mavlink.connection.MavConnection

/**
 * A [MavConnection] that acts as a TCP client endpoint.
 */
public interface TcpClientMavConnection : MavConnection

/**
 * Creates a [TcpClientMavConnection] that connects to the specified [host] and [port].
 */
public expect fun TcpClientMavConnection(
    host: String,
    port: Int,
    dialect: MavDialect
): TcpClientMavConnection
