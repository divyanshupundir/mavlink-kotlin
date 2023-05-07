package com.divpundir.mavlink.adapters.rxjava3

import com.divpundir.mavlink.connection.MavConnection
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

public fun MavConnection.asRx3(
    scheduler: Scheduler = Schedulers.io(),
    onFailure: Rx3MavConnection.() -> Unit = {}
): Rx3MavConnection = Rx3MavConnectionImpl(
    connection = this,
    scheduler = scheduler,
    onFailure = onFailure
)
