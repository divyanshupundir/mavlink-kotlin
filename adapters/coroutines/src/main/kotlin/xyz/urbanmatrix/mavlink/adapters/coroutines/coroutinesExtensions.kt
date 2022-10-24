package xyz.urbanmatrix.mavlink.adapters.coroutines

import xyz.urbanmatrix.mavlink.connection.MavConnection

fun MavConnection.asCoroutine(
    onReadEnded: () -> Unit = {}
): CoroutinesMavConnection = CoroutinesMavConnectionImpl(
    this,
    128,
    onReadEnded
)
