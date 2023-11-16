package com.divpundir.mavlink.connection.udp

import com.divpundir.mavlink.api.MavDialect
import com.divpundir.mavlink.connection.MavConnection

/**
 * A [MavConnection] that acts as a UDP client endpoint.
 */
public interface UdpClientMavConnection : MavConnection

/**
 * Creates a [UdpClientMavConnection] that connects to the specified [host] and [port].
 *
 * For connecting, pings the remote server with 32 bytes of data to let the remote server know its address.
 */
public expect fun UdpClientMavConnection(
    host: String,
    port: Int,
    dialect: MavDialect
): UdpClientMavConnection
