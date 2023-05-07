package com.divpundir.mavlink.adapters.coroutines

import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.connection.MavConnection
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import java.io.IOException

internal class CoroutinesMavConnectionImpl(
    private val connection: MavConnection,
    private val dispatcher: CoroutineDispatcher,
    extraBufferCapacity: Int,
    private val onFailure: CoroutinesMavConnection.() -> Unit
) : CoroutinesMavConnection {

    @Volatile
    private var isOpen = false
        @Synchronized set

    private val _mavFrame = MutableSharedFlow<MavFrame<out MavMessage<*>>>(
        extraBufferCapacity = extraBufferCapacity,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    override val mavFrame = _mavFrame.asSharedFlow()

    @Throws(IOException::class)
    override suspend fun connect(readerScope: CoroutineScope) {
        withContext(dispatcher) {
            connection.connect()
            isOpen = true
        }

        readerScope.launch(dispatcher + CoroutineName("mavlink-read-coroutine")) {
            processMavFrames()
        }
    }

    private suspend fun CoroutineScope.processMavFrames() {
        while (isActive && isOpen) {
            try {
                _mavFrame.emit(connection.next())
            } catch (e: IOException) {
                kotlin.runCatching { connection.close() }
                break
            } catch (e: CancellationException) {
                kotlin.runCatching { connection.close() }
                isOpen = false
                break
            }
        }

        if (isOpen) {
            onFailure()
        }
    }

    @Throws(IOException::class)
    override suspend fun close() {
        withContext(dispatcher) {
            connection.close()
            isOpen = false
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
}
