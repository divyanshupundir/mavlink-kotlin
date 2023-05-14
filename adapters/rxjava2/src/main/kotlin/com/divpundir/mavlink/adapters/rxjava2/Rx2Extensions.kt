package com.divpundir.mavlink.adapters.rxjava2

import com.divpundir.mavlink.connection.MavConnection
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * A helper function to wrap a [MavConnection] as an [Rx2MavConnection]. The returned [Rx2MavConnection] uses the
 * provided [scheduler] to perform the IO operations of reading and sending the messages. The [onFailure] callback is
 * invoked when an exception is thrown while reading the messages. This can be used to implement a custom reconnection
 * strategy.
 */
public fun MavConnection.asRx2(
    scheduler: Scheduler = Schedulers.io(),
    onFailure: Rx2MavConnection.() -> Unit = {}
): Rx2MavConnection = Rx2MavConnectionImpl(
    connection = this,
    scheduler = scheduler,
    onFailure = onFailure
)
