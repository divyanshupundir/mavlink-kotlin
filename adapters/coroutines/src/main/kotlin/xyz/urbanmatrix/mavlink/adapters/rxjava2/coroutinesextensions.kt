package xyz.urbanmatrix.mavlink.adapters.rxjava2

import xyz.urbanmatrix.mavlink.connection.MavConnection

fun MavConnection.asCoroutines(
    onReadEnded: () -> Unit = {}
): CoroutinesMavConnection = CoroutinesMavConnectionImpl(
    this,
    onReadEnded
)