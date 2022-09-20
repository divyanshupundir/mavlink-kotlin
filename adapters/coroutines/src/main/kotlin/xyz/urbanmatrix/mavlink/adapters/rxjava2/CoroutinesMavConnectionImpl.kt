package xyz.urbanmatrix.mavlink.adapters.rxjava2

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import xyz.urbanmatrix.mavlink.api.MavFrame
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.connection.MavConnection
import java.io.IOException
import java.util.concurrent.Executors

internal class CoroutinesMavConnectionImpl(
    private val connection: MavConnection,
    private val onReadEnded: () -> Unit
) : CoroutinesMavConnection {

    private val mavlinkReadDispatcher = Executors.newSingleThreadExecutor {
        Thread(it, "mavlink-read-thread")
    }.asCoroutineDispatcher()

    private val mavlinkReadScope = CoroutineScope(mavlinkReadDispatcher + SupervisorJob())

    @Volatile
    private var isOpen = false
        @Synchronized set

    private val _mavFrame  = MutableSharedFlow<MavFrame<out MavMessage<*>>>()
    override val mavFrame: Flow<MavFrame<out MavMessage<*>>> = _mavFrame

    override suspend fun connect() {
        connection.connect()
        isOpen = true
        mavlinkReadScope.launch { processMavFrames() }
    }

    private fun processMavFrames() {
        while (!Thread.currentThread().isInterrupted && isOpen) {
            try {
                _mavFrame.tryEmit(connection.next())
            } catch (e: IOException) {
                kotlin.runCatching { connection.close() }
                isOpen = false
                break
            }
        }
        onReadEnded.invoke()
    }

    override suspend fun close() {
        connection.close()
        isOpen = false
    }

    override suspend fun <T : MavMessage<T>> sendV1(
        systemId: Int,
        componentId: Int,
        payload: T
    ) {
        connection.sendV1(
            systemId,
            componentId,
            payload
        )
    }

    override suspend fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: Int,
        componentId: Int, payload: T
    ) {
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
    ) {
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
