package com.divpundir.mavlink.adapters.coroutines

import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.connection.MavConnection
import com.divpundir.mavlink.connection.StreamState
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import okio.IOException
import kotlin.coroutines.CoroutineContext

internal class CoroutinesMavConnectionImpl(
    private val connection: MavConnection,
    private val context: CoroutineContext,
    private val onFailure: CoroutinesMavConnection.() -> Unit
) : CoroutinesMavConnection {

    private val _streamState = MutableStateFlow<StreamState>(StreamState.Inactive.Stopped)
    override val streamState: StateFlow<StreamState> = _streamState.asStateFlow()

    private val _mavFrame = MutableSharedFlow<MavFrame<out MavMessage<*>>>(
        extraBufferCapacity = 128,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    override val mavFrame = _mavFrame.asSharedFlow()

    @Throws(IOException::class)
    override suspend fun connect(readerScope: CoroutineScope) {
        withContext(context) {
            connection.connect()
            _streamState.value = StreamState.Active
        }

        readerScope.launch(context + CoroutineName("mavlink-read-coroutine")) {
            processMavFrames()
        }
    }

    private suspend fun processMavFrames() {
        while (_streamState.value == StreamState.Active) {
            try {
                _mavFrame.emit(connection.next())
            } catch (e: IOException) {
                if (_streamState.value == StreamState.Active) {
                    _streamState.value = StreamState.Inactive.Failed(e)
                    kotlin.runCatching { connection.close() }
                }
            } catch (e: CancellationException) {
                _streamState.value = StreamState.Inactive.Stopped
                kotlin.runCatching { connection.close() }
            }
        }

        if (_streamState.value is StreamState.Inactive.Failed) {
            onFailure()
        }
    }

    @Throws(IOException::class)
    override suspend fun close() {
        withContext(context) {
            _streamState.value = StreamState.Inactive.Stopped
            connection.close()
        }
    }

    @Throws(IOException::class)
    override suspend fun <T : MavMessage<T>> sendV1(
        systemId: UByte,
        componentId: UByte,
        payload: T
    ) {
        withContext(context) {
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
        withContext(context) {
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
        withContext(context) {
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
}
