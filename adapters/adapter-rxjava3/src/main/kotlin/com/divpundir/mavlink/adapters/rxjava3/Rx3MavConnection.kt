package com.divpundir.mavlink.adapters.rxjava3

import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import io.reactivex.rxjava3.annotations.CheckReturnValue
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

public interface Rx3MavConnection {

    /**
     * A stream of [MavFrame]s.
     */
    @get:CheckReturnValue
    public val mavFrame: Flowable<MavFrame<out MavMessage<*>>>

    /**
     * Connects the underlying [MavConnection][com.divpundir.mavlink.connection.MavConnection] and start reading from
     * it. The [Completable] will receive a completed signal when the connection is created and then the reading process
     * will start as a new task. The current implementation uses the
     * [IO Scheduler][io.reactivex.rxjava3.schedulers.Schedulers.IO] by default to schedule the tasks.
     */
    @CheckReturnValue
    public fun connect(): Completable

    /**
     * Closes the underlying [MavConnection][com.divpundir.mavlink.connection.MavConnection] and stops the reading
     * process.
     */
    @CheckReturnValue
    public fun close(): Completable

    /**
     * Sends the provided [payload] wrapped in a Mavlink v1 frame.
     */
    @CheckReturnValue
    public fun <T : MavMessage<T>> sendV1(
        systemId: UByte,
        componentId: UByte,
        payload: T
    ): Completable

    /**
     * Sends the provided [payload] wrapped in an unsigned MAVLink v2 frame.
     */
    @CheckReturnValue
    public fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T
    ): Completable

    /**
     * Sends the provided [payload] wrapped in a signed MAVLink v2 frame.
     */
    @CheckReturnValue
    public fun <T : MavMessage<T>> sendSignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T,
        linkId: UByte,
        timestamp: UInt,
        secretKey: ByteArray
    ): Completable
}
