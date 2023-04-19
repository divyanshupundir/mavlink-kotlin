package com.divpundir.mavlink.adapters.rxjava3

import com.divpundir.mavlink.connection.MavConnection

public fun MavConnection.asRx3(
    onIoFailure: Rx3MavConnection.() -> Unit = {}
): Rx3MavConnection = Rx3MavConnectionImpl(
    this,
    onIoFailure
)
