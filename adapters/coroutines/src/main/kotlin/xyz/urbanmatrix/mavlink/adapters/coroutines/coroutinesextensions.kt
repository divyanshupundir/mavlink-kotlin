package xyz.urbanmatrix.mavlink.adapters.coroutines

import xyz.urbanmatrix.mavlink.connection.MavConnection

fun MavConnection.asCoroutines(
    onReadEnded: () -> Unit = {}
): CoroutinesMavConnection = CoroutinesMavConnectionImpl(
    this,
    onReadEnded
)