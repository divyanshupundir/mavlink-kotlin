package xyz.urbanmatrix.mavlink.adapters.rxjava2

import xyz.urbanmatrix.mavlink.api.MavFrame
import xyz.urbanmatrix.mavlink.api.MavMessage
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.annotations.CheckReturnValue

public interface Rx2MavConnection {

    @get:CheckReturnValue
    public val mavFrame: Flowable<MavFrame<out MavMessage<*>>>

    @CheckReturnValue
    public fun connect(): Completable

    @CheckReturnValue
    public fun close(): Completable

    @CheckReturnValue
    public fun <T : MavMessage<T>> sendV1(
        systemId: Int,
        componentId: Int,
        payload: T
    ): Completable

    @CheckReturnValue
    public fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: Int,
        componentId: Int,
        payload: T
    ): Completable

    @CheckReturnValue
    public fun <T : MavMessage<T>> sendSignedV2(
        systemId: Int,
        componentId: Int,
        payload: T,
        linkId: Int,
        timestamp: Long,
        secretKey: ByteArray
    ): Completable
}
