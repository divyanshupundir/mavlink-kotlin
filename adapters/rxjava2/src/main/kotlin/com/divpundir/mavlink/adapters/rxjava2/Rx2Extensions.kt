package com.divpundir.mavlink.adapters.rxjava2

import com.divpundir.mavlink.connection.MavConnection

public fun MavConnection.asRx2(
    onIoFailure: Rx2MavConnection.() -> Unit = {}
): Rx2MavConnection = Rx2MavConnectionImpl(
    this,
    onIoFailure
)
