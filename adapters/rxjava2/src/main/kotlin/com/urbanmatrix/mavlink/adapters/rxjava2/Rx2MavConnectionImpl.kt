package com.urbanmatrix.mavlink.adapters.rxjava2

import com.urbanmatrix.mavlink.api.MavFrame
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.connection.MavConnection
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.processors.FlowableProcessor
import io.reactivex.processors.PublishProcessor
import java.io.IOException
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class Rx2MavConnectionImpl(private val c: MavConnection) : Rx2MavConnection {

    private val mavFrameProcessor: FlowableProcessor<MavFrame<out MavMessage<*>>> = PublishProcessor.create()

    private val mavlinkReadThread: Executor = Executors.newSingleThreadExecutor { Thread(it, "mavlink-read-thread") }

    private var isOpen = false
        @Synchronized set

    override val mavFrame: Flowable<MavFrame<out MavMessage<*>>>
        get() = mavFrameProcessor.onBackpressureBuffer().share()

    override fun connect(): Completable = Completable.fromAction {
        c.connect()
        isOpen = true
        mavlinkReadThread.execute(this::processMavlinkMessages)
    }

    private fun processMavlinkMessages() {
        while (!Thread.currentThread().isInterrupted && isOpen) {
            try {
                mavFrameProcessor.onNext(c.next())
            } catch (e: IOException) {
                isOpen = false
                break
            }
        }
    }

    override fun close(): Completable = Completable.fromAction {
        c.close()
        isOpen = false
        mavFrameProcessor.onComplete()
    }

    override fun <T : MavMessage<T>> sendV1(
        systemId: Int,
        componentId: Int,
        payload: T
    ): Completable = Completable.fromAction {
        c.sendV1(
            systemId,
            componentId,
            payload
        )
    }

    override fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: Int,
        componentId: Int,
        payload: T
    ): Completable = Completable.fromAction {
        c.sendUnsignedV2(
            systemId,
            componentId,
            payload
        )
    }

    override fun <T : MavMessage<T>> sendSignedV2(
        systemId: Int,
        componentId: Int,
        payload: T,
        linkId: Int,
        timestamp: Long,
        secretKey: ByteArray
    ): Completable = Completable.fromAction {
        c.sendSignedV2(
            systemId,
            componentId,
            payload,
            linkId,
            timestamp,
            secretKey
        )
    }
}
