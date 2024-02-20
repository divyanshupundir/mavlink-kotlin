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
@Deprecated(
    message = "Rx2MavConnection with onFailure callback is deprecated and will be removed in the future releases. " +
        "For checking the states including failure, use Rx2MavConnection.streamState.",
    replaceWith = ReplaceWith(
        expression = "asRx2(scheduler)",
        imports = ["com.divpundir.mavlink.adapters.rxjava2.asRx2"]
    )
)
public fun MavConnection.asRx2(
    scheduler: Scheduler = Schedulers.io(),
    onFailure: Rx2MavConnection.() -> Unit = {}
): Rx2MavConnection = Rx2MavConnectionImpl(
    connection = this,
    scheduler = scheduler,
    onFailure = onFailure
)

/**
 * A helper function to wrap a [MavConnection] as an [Rx2MavConnection]. The returned [Rx2MavConnection] uses the
 * provided [scheduler] to perform the IO operations of reading and sending the messages.
 */
public fun MavConnection.asRx2(
    scheduler: Scheduler = Schedulers.io(),
): Rx2MavConnection = Rx2MavConnectionImpl(
    connection = this,
    scheduler = scheduler,
    onFailure = {}
)
