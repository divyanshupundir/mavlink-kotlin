package xyz.urbanmatrix.mavlink.adapters.rxjava3

import xyz.urbanmatrix.mavlink.connection.MavConnection

fun MavConnection.asRx3(
    onStreamError: () -> Unit = {}
): Rx3MavConnection = Rx3MavConnectionImpl(
    this,
    onStreamError
)
