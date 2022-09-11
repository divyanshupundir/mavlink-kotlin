package xyz.urbanmatrix.mavlink.adapters.rxjava3

import xyz.urbanmatrix.mavlink.connection.MavConnection

fun MavConnection.asRx3(
    onReadEnded: () -> Unit = {}
): Rx3MavConnection = Rx3MavConnectionImpl(
    this,
    onReadEnded
)
