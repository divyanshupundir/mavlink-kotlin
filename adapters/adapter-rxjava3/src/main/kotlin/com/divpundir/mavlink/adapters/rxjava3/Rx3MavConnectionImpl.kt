package com.divpundir.mavlink.adapters.rxjava3

import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.connection.MavConnection
import com.divpundir.mavlink.connection.StreamState
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.processors.BehaviorProcessor
import io.reactivex.rxjava3.processors.PublishProcessor
import okio.IOException

internal class Rx3MavConnectionImpl(
    private val connection: MavConnection,
    private val scheduler: Scheduler,
    private val onFailure: Rx3MavConnection.() -> Unit
) : Rx3MavConnection {

    private val _streamState = BehaviorProcessor.createDefault<StreamState>(StreamState.Inactive.Stopped)
    override val streamState: Flowable<StreamState> = _streamState.onBackpressureLatest().share()

    private val _mavFrame = PublishProcessor.create<MavFrame<out MavMessage<*>>>()
    override val mavFrame: Flowable<MavFrame<out MavMessage<*>>> = _mavFrame.onBackpressureBuffer().share()

    override fun connect() = completableSubscribeOn(scheduler) {
        connection.connect()
        _streamState.onNext(StreamState.Active)
        scheduler.scheduleDirect(this::processMavFrames)
    }

    private fun processMavFrames() {
        while (_streamState.value == StreamState.Active) {
            try {
                _mavFrame.onNext(connection.next())
            } catch (e: IOException) {
                if (_streamState.value == StreamState.Active) {
                    _streamState.onNext(StreamState.Inactive.Failed(e))
                    kotlin.runCatching { connection.close() }
                }
            } catch (_: InterruptedException) {
                _streamState.onNext(StreamState.Inactive.Stopped)
                kotlin.runCatching { connection.close() }
            }
        }

        if (_streamState.value is StreamState.Inactive.Failed) {
            onFailure()
        }
    }

    override fun close() = completableSubscribeOn(scheduler) {
        _streamState.onNext(StreamState.Inactive.Stopped)
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
}

private inline fun completableSubscribeOn(
    scheduler: Scheduler,
    crossinline action: () -> Unit
): Completable = Completable.fromAction {
    action()
}.subscribeOn(scheduler)
