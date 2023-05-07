package com.divpundir.mavlink.adapters.rxjava2

import com.divpundir.mavlink.connection.MavConnection
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

public fun MavConnection.asRx2(
    scheduler: Scheduler = Schedulers.io(),
    onFailure: Rx2MavConnection.() -> Unit = {}
): Rx2MavConnection = Rx2MavConnectionImpl(
    connection = this,
    scheduler = scheduler,
    onFailure = onFailure
)
