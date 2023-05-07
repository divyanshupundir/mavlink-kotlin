package com.divpundir.mavlink.adapters.rxjava2

import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.connection.MavConnection
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.processors.FlowableProcessor
import io.reactivex.processors.PublishProcessor
import java.io.IOException

internal class Rx2MavConnectionImpl(
    private val connection: MavConnection,
    private val scheduler: Scheduler,
    private val onFailure: Rx2MavConnection.() -> Unit
) : Rx2MavConnection {

    private val mavFrameProcessor: FlowableProcessor<MavFrame<out MavMessage<*>>> = PublishProcessor.create()

    @Volatile
    private var isOpen = false
        @Synchronized set

    override val mavFrame: Flowable<MavFrame<out MavMessage<*>>>
        get() = mavFrameProcessor.onBackpressureBuffer().share()

    override fun connect() = completableSubscribeOn(scheduler) {
        connection.connect()
        isOpen = true
        scheduler.scheduleDirect(this::processMavFrames)
    }

    private fun processMavFrames() {
        while (!Thread.currentThread().isInterrupted && isOpen) {
            try {
                mavFrameProcessor.onNext(connection.next())
            } catch (e: IOException) {
                kotlin.runCatching { connection.close() }
                break
            } catch (e: InterruptedException) {
                kotlin.runCatching { connection.close() }
                isOpen = false
                break
            }
        }

        if (isOpen) {
            onFailure()
        }
    }

    override fun close() = completableSubscribeOn(scheduler) {
        connection.close()
        isOpen = false
    }

    override fun <T : MavMessage<T>> sendV1(
        systemId: UByte,
        componentId: UByte,
        payload: T
    ) = completableSubscribeOn(scheduler) {
        connection.sendV1(
            systemId,
            componentId,
            payload
        )
    }

    override fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T
    ) = completableSubscribeOn(scheduler) {
        connection.sendUnsignedV2(
            systemId,
            componentId,
            payload
        )
    }

    override fun <T : MavMessage<T>> sendSignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T,
        linkId: UByte,
        timestamp: UInt,
        secretKey: ByteArray
    ) = completableSubscribeOn(scheduler) {
        connection.sendSignedV2(
            systemId,
            componentId,
            payload,
            linkId,
            timestamp,
            secretKey
        )
    }

}

private inline fun completableSubscribeOn(
    scheduler: Scheduler,
    crossinline action: () -> Unit
): Completable = Completable.fromAction {
    action()
}.subscribeOn(scheduler)
