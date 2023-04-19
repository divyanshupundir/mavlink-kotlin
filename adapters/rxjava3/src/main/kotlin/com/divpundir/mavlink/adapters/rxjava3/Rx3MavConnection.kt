package com.divpundir.mavlink.adapters.rxjava3

import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import io.reactivex.rxjava3.annotations.CheckReturnValue
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

public interface Rx3MavConnection {

    @get:CheckReturnValue
    public val mavFrame: Flowable<MavFrame<out MavMessage<*>>>

    @CheckReturnValue
    public fun connect(): Completable

    @CheckReturnValue
    public fun close(): Completable

    @CheckReturnValue
    public fun <T : MavMessage<T>> sendV1(
        systemId: UByte,
        componentId: UByte,
        payload: T
    ): Completable

    @CheckReturnValue
    public fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T
    ): Completable

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
