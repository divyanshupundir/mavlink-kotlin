package com.divpundir.mavlink.adapters.rxjava3

import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.connection.MavConnection
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.processors.PublishProcessor
import okio.IOException

internal class Rx3MavConnectionImpl(
    private val connection: MavConnection,
    private val scheduler: Scheduler,
    private val onFailure: Rx3MavConnection.() -> Unit
) : Rx3MavConnection {

    @Volatile
    private var readState = State.STOPPED
        @Synchronized set

    private val _mavFrame = PublishProcessor.create<MavFrame<out MavMessage<*>>>()
    override val mavFrame: Flowable<MavFrame<out MavMessage<*>>> = _mavFrame.onBackpressureBuffer().share()

    override fun connect() = completableSubscribeOn(scheduler) {
        connection.connect()
        readState = State.RUNNING
        scheduler.scheduleDirect(this::processMavFrames)
    }

    private fun processMavFrames() {
        while (readState == State.RUNNING) {
            try {
                _mavFrame.onNext(connection.next())
            } catch (_: IOException) {
                if (readState == State.RUNNING) {
                    readState = State.FAILED
                    kotlin.runCatching { connection.close() }
                }
            } catch (_: InterruptedException) {
                readState = State.STOPPED
                kotlin.runCatching { connection.close() }
            }
        }

        if (readState == State.FAILED) {
            onFailure()
        }
    }

    override fun close() = completableSubscribeOn(scheduler) {
        readState = State.STOPPED
        connection.close()
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

    private enum class State {
        RUNNING,
        STOPPED,
        FAILED
    }
}

private inline fun completableSubscribeOn(
    scheduler: Scheduler,
    crossinline action: () -> Unit
): Completable = Completable.fromAction {
    action()
}.subscribeOn(scheduler)
