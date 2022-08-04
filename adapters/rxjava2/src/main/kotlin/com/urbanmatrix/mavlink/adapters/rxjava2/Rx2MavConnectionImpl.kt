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

internal class Rx2MavConnectionImpl(
    private val connection: MavConnection,
    private val onStreamError: () -> Unit
) : Rx2MavConnection {

    private val mavFrameProcessor: FlowableProcessor<MavFrame<out MavMessage<*>>> = PublishProcessor.create()

    private val mavlinkReadThread: Executor = Executors.newSingleThreadExecutor { Thread(it, "mavlink-read-thread") }

    @Volatile
    private var isOpen = false
        @Synchronized set

    override val mavFrame: Flowable<MavFrame<out MavMessage<*>>>
        get() = mavFrameProcessor.onBackpressureBuffer().share()

    override fun connect(): Completable = Completable.fromAction {
        connection.connect()
        isOpen = true
        mavlinkReadThread.execute(this::processMavFrames)
    }

    private fun processMavFrames() {
        while (!Thread.currentThread().isInterrupted && isOpen) {
            try {
                mavFrameProcessor.onNext(connection.next())
            } catch (e: IOException) {
                e.printStackTrace()
                kotlin.runCatching { connection.close() }
                isOpen = false
                break
            }
        }

        onStreamError.invoke()
    }

    override fun close(): Completable = Completable.fromAction {
        connection.close()
        isOpen = false
    }

    override fun <T : MavMessage<T>> sendV1(
        systemId: Int,
        componentId: Int,
        payload: T
    ): Completable = Completable.fromAction {
        connection.sendV1(
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
        connection.sendUnsignedV2(
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
