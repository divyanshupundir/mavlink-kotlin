package xyz.urbanmatrix.mavlink.adapters.rxjava3

import xyz.urbanmatrix.mavlink.connection.MavConnection

fun MavConnection.asRx3(
    onIoFailure: Rx3MavConnection.() -> Unit = {}
): Rx3MavConnection = Rx3MavConnectionImpl(
    this,
    onIoFailure
)
