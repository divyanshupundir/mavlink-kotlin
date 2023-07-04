package com.divpundir.mavlink.adapters.rxjava3

import com.divpundir.mavlink.connection.MavConnection
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * A helper function to wrap a [MavConnection] as an [Rx3MavConnection]. The returned [Rx3MavConnection] uses the
 * provided [scheduler] to perform the IO operations of reading and sending the messages. The [onFailure] callback is
 * invoked when an exception is thrown while reading the messages. This can be used to implement a custom reconnection
 * strategy.
 */
public fun MavConnection.asRx3(
    scheduler: Scheduler = Schedulers.io(),
    onFailure: Rx3MavConnection.() -> Unit = {}
): Rx3MavConnection = Rx3MavConnectionImpl(
    connection = this,
    scheduler = scheduler,
    onFailure = onFailure
)
