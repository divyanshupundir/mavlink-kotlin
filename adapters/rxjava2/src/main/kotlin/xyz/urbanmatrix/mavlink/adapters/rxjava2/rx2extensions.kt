package xyz.urbanmatrix.mavlink.adapters.rxjava2

import xyz.urbanmatrix.mavlink.connection.MavConnection

fun MavConnection.asRx2(
    onReadEnded: () -> Unit = {}
): Rx2MavConnection = Rx2MavConnectionImpl(
    this,
    onReadEnded
)
