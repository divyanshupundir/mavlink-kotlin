package com.divpundir.mavlink.adapters.coroutines

import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.connection.MavConnection
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import okio.IOException

internal class CoroutinesMavConnectionImpl(
    private val connection: MavConnection,
    private val dispatcher: CoroutineDispatcher,
    extraBufferCapacity: Int,
    onBufferOverflow: BufferOverflow,
    private val onFailure: CoroutinesMavConnection.() -> Unit
) : CoroutinesMavConnection {

    @Volatile
    private var readState = State.STOPPED
        @Synchronized set

    private val _mavFrame = MutableSharedFlow<MavFrame<out MavMessage<*>>>(
        extraBufferCapacity = extraBufferCapacity,
        onBufferOverflow = onBufferOverflow
    )
    override val mavFrame = _mavFrame.asSharedFlow()

    @Throws(IOException::class)
    override suspend fun connect(readerScope: CoroutineScope) {
        withContext(dispatcher) {
            connection.connect()
            readState = State.RUNNING
        }

        readerScope.launch(dispatcher + CoroutineName("mavlink-read-coroutine")) {
            processMavFrames()
        }
    }

    private suspend fun processMavFrames() {
        while (readState == State.RUNNING) {
            try {
                _mavFrame.emit(connection.next())
            } catch (e: IOException) {
                if (readState == State.RUNNING) {
                    readState = State.FAILED
                    kotlin.runCatching { connection.close() }
                }
            } catch (e: CancellationException) {
                readState = State.STOPPED
                kotlin.runCatching { connection.close() }
            }
        }

        if (readState == State.FAILED) {
            onFailure()
        }
    }

    @Throws(IOException::class)
    override suspend fun close() {
        withContext(dispatcher) {
            readState = State.STOPPED
            connection.close()
        }
    }

    @Throws(IOException::class)
    override suspend fun <T : MavMessage<T>> sendV1(
        systemId: UByte,
        componentId: UByte,
        payload: T
    ) {
        withContext(dispatcher) {
            connection.sendV1(
                systemId,
                componentId,
                payload
            )
        }
    }

    @Throws(IOException::class)
    override suspend fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: UByte,
        componentId: UByte, payload: T
    ) {
        withContext(dispatcher) {
            connection.sendUnsignedV2(
                systemId,
                componentId,
                payload
            )
        }
    }

    @Throws(IOException::class)
    override suspend fun <T : MavMessage<T>> sendSignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T,
        linkId: UByte,
        timestamp: UInt,
        secretKey: ByteArray
    ) {
        withContext(dispatcher) {
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

    private enum class State {
        RUNNING,
        STOPPED,
        FAILED
    }
}
