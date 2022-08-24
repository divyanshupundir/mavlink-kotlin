package xyz.urbanmatrix.mavlink.adapters.rxjava2

import xyz.urbanmatrix.mavlink.api.MavFrame
import xyz.urbanmatrix.mavlink.api.MavMessage
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.annotations.CheckReturnValue

interface Rx2MavConnection {

    @get:CheckReturnValue
    val mavFrame: Flowable<MavFrame<out MavMessage<*>>>

    @CheckReturnValue
    fun connect(): Completable

    @CheckReturnValue
    fun close(): Completable

    @CheckReturnValue
    fun <T : MavMessage<T>> sendV1(
        systemId: Int,
        componentId: Int,
        payload: T
    ): Completable

    @CheckReturnValue
    fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: Int,
        componentId: Int,
        payload: T
    ): Completable

    @CheckReturnValue
    fun <T : MavMessage<T>> sendSignedV2(
        systemId: Int,
        componentId: Int,
        payload: T,
        linkId: Int,
        timestamp: Long,
        secretKey: ByteArray
    ): Completable
}
