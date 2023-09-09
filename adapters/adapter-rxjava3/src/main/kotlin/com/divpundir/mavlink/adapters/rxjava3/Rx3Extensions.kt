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
@Deprecated(
    message = "Rx3MavConnection with onFailure callback is deprecated and will be removed in the future releases. " +
            "For checking the states including failure, use Rx3MavConnection.streamState.",
    replaceWith = ReplaceWith(
        expression = "asRx3(scheduler)",
        imports = ["com.divpundir.mavlink.adapters.rxjava3.asRx3"]
    )
)
public fun MavConnection.asRx3(
    scheduler: Scheduler = Schedulers.io(),
    onFailure: Rx3MavConnection.() -> Unit = {}
): Rx3MavConnection = Rx3MavConnectionImpl(
    connection = this,
    scheduler = scheduler,
    onFailure = onFailure
)

public fun MavConnection.asRx3(
    scheduler: Scheduler = Schedulers.io(),
): Rx3MavConnection = Rx3MavConnectionImpl(
    connection = this,
    scheduler = scheduler,
    onFailure = {}
)
