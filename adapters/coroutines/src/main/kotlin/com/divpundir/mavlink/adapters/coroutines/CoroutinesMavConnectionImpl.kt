package com.divpundir.mavlink.adapters.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.connection.MavConnection
import java.io.IOException

internal class CoroutinesMavConnectionImpl(
    private val connection: MavConnection,
    extraBufferCapacity: Int,
    private val onIoFailure: CoroutinesMavConnection.() -> Unit
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
        withContext(Dispatchers.IO) {
            connection.connect()
            isOpen = true
        }

        readerScope.launch(Dispatchers.IO + CoroutineName("mavlink-read-coroutine")) {
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
            onIoFailure()
        }
    }

    @Throws(IOException::class)
    override suspend fun close() {
        withContext(Dispatchers.IO) {
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
        withContext(Dispatchers.IO) {
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
        withContext(Dispatchers.IO) {
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
        withContext(Dispatchers.IO) {
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
