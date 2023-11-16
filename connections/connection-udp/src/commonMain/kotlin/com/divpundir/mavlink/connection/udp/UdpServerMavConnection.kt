package com.divpundir.mavlink.connection.udp

import com.divpundir.mavlink.api.MavDialect
import com.divpundir.mavlink.connection.MavConnection

/**
 * A [MavConnection] that acts as a UDP server endpoint.
 */
public interface UdpServerMavConnection : MavConnection

/**
 * Creates a [UdpServerMavConnection] that listens on the specified [port] for a 32-byte ping, and connects to the first
 * sender.
 */
public expect fun UdpServerMavConnection(
    port: Int,
    dialect: MavDialect
): UdpServerMavConnection
