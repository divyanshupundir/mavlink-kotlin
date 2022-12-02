package xyz.urbanmatrix.mavlink.adapters.rxjava2

import xyz.urbanmatrix.mavlink.connection.MavConnection

fun MavConnection.asRx2(
    onIoFailure: Rx2MavConnection.() -> Unit = {}
): Rx2MavConnection = Rx2MavConnectionImpl(
    this,
    onIoFailure
)
