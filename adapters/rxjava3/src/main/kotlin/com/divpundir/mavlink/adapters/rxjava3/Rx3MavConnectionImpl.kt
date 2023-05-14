package com.divpundir.mavlink.adapters.rxjava3

import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.connection.MavConnection
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.processors.PublishProcessor
import java.io.IOException

internal class Rx3MavConnectionImpl(
    private val connection: MavConnection,
    private val scheduler: Scheduler,
    private val onFailure: Rx3MavConnection.() -> Unit
) : Rx3MavConnection {

    @Volatile
    private var isOpen = false
        @Synchronized set

    private val _mavFrame = PublishProcessor.create<MavFrame<out MavMessage<*>>>()
    override val mavFrame: Flowable<MavFrame<out MavMessage<*>>> = _mavFrame.onBackpressureBuffer().share()

    override fun connect() = completableSubscribeOn(scheduler) {
        connection.connect()
        isOpen = true
        scheduler.scheduleDirect(this::processMavFrames)
    }

    private fun processMavFrames() {
        while (!Thread.currentThread().isInterrupted && isOpen) {
            try {
                _mavFrame.onNext(connection.next())
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
