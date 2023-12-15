package com.divpundir.mavlink.connection.tcp

import com.divpundir.mavlink.api.MavDialect
import com.divpundir.mavlink.connection.MavConnection

/**
 * A [MavConnection] that acts as a TCP server endpoint.
 */
public interface TcpServerMavConnection : MavConnection

/**
 * Creates a [TcpServerMavConnection] that listens on the specified [port] for a single connection. Once a connection is
 * established, the server socket is closed.
 */
public expect fun TcpServerMavConnection(
    port: Int,
    dialect: MavDialect
): TcpServerMavConnection
