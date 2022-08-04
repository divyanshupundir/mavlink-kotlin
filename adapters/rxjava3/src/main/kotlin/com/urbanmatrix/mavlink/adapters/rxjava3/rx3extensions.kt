package com.urbanmatrix.mavlink.adapters.rxjava3

import com.urbanmatrix.mavlink.connection.MavConnection

fun MavConnection.asRx3(
    onStreamError: () -> Unit = {}
): Rx3MavConnection = Rx3MavConnectionImpl(
    this,
    onStreamError
)
