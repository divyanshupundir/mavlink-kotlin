package com.divpundir.mavlink.adapters.rxjava2

import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.connection.StreamState
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.annotations.CheckReturnValue

public interface Rx2MavConnection {

    /**
     * The current state of the connection stream.
     */
    @get:CheckReturnValue
    public val streamState: Flowable<StreamState>

    /**
     * A stream of [MavFrame]s.
     */
    @get:CheckReturnValue
    public val mavFrame: Flowable<MavFrame<out MavMessage<*>>>

    /**
     * Connects the underlying [MavConnection][com.divpundir.mavlink.connection.MavConnection] and start reading from
     * it. The [Completable] will receive a completed signal when the connection is created and then the reading process
     * will start as a new task. The current implementation uses the
     * [IO Scheduler][io.reactivex.schedulers.Schedulers.IO] by default to schedule the tasks.
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
