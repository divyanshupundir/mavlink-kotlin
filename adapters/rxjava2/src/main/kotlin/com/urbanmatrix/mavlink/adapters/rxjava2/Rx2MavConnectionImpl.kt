package com.urbanmatrix.mavlink.adapters.rxjava2

import com.urbanmatrix.mavlink.api.MavFrame
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.connection.MavConnection
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.processors.FlowableProcessor
import io.reactivex.processors.PublishProcessor

class Rx2MavConnectionImpl(private val c: MavConnection) : Rx2MavConnection {

    private val mavFrameProcessor: FlowableProcessor<MavFrame<out MavMessage<*>>> = PublishProcessor.create()

    override val mavFrame: Flowable<MavFrame<out MavMessage<*>>>
        get() = mavFrameProcessor.onBackpressureBuffer().share()

    override fun connect(): Completable = Completable.create {
        c.connect()
        it.onComplete()
    }

    override fun close(): Completable = Completable.create {
        c.close()
        it.onComplete()
    }

    override fun <T : MavMessage<T>> sendV1(
        systemId: Int,
        componentId: Int,
        payload: T
    ): Completable = Completable.create {
        c.sendV1(
            systemId,
            componentId,
            payload
        )
        it.onComplete()
    }

    override fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: Int,
        componentId: Int,
        payload: T
    ): Completable = Completable.create {
        c.sendUnsignedV2(
            systemId,
            componentId,
            payload
        )
        it.onComplete()
    }

    override fun <T : MavMessage<T>> sendSignedV2(
        systemId: Int,
        componentId: Int,
        payload: T,
        linkId: Int,
        timestamp: Long,
        secretKey: ByteArray
    ): Completable = Completable.create {
        c.sendSignedV2(
            systemId,
            componentId,
            payload,
            linkId,
            timestamp,
            secretKey
        )
        it.onComplete()
    }
}
