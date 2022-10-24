package xyz.urbanmatrix.mavlink.adapters.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import xyz.urbanmatrix.mavlink.api.MavFrame
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.connection.MavConnection
import java.io.IOException

internal class CoroutinesMavConnectionImpl(
    private val connection: MavConnection,
    extraBufferCapacity: Int,
    private val onReadEnded: () -> Unit
) : CoroutinesMavConnection {

    @Volatile
    private var isOpen = false
        @Synchronized set

    private val _mavFrame = MutableSharedFlow<MavFrame<out MavMessage<*>>>(
        extraBufferCapacity = extraBufferCapacity,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    override val mavFrame = _mavFrame.asSharedFlow()

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
            } catch (e: Exception) {
                when (e) {
                    is IOException, is CancellationException -> {
                        kotlin.runCatching { connection.close() }
                        isOpen = false
                        break
                    }

                    else -> throw e
                }
            }
        }
        onReadEnded.invoke()
    }

    override suspend fun close(): Unit = withContext(Dispatchers.IO) {
        connection.close()
        isOpen = false
    }

    override suspend fun <T : MavMessage<T>> sendV1(
        systemId: Int,
        componentId: Int,
        payload: T
    ) = withContext(Dispatchers.IO) {
        connection.sendV1(
            systemId,
            componentId,
            payload
        )
    }

    override suspend fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: Int,
        componentId: Int, payload: T
    ) = withContext(Dispatchers.IO) {
        connection.sendUnsignedV2(
            systemId,
            componentId,
            payload
        )
    }

    override suspend fun <T : MavMessage<T>> sendSignedV2(
        systemId: Int,
        componentId: Int,
        payload: T,
        linkId: Int,
        timestamp: Long,
        secretKey: ByteArray
    ) = withContext(Dispatchers.IO) {
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
