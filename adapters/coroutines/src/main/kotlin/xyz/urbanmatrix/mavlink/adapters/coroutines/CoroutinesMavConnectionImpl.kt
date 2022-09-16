package xyz.urbanmatrix.mavlink.adapters.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import xyz.urbanmatrix.mavlink.api.MavFrame
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.connection.MavConnection
import java.io.IOException
import java.util.concurrent.Executors
import kotlin.coroutines.coroutineContext

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

    override val mavFrame: Flow<MavFrame<out MavMessage<*>>>
        get() = TODO("Not yet implemented")

    override suspend fun connect() {
        connection.connect()
        isOpen = true
        mavlinkReadScope.launch { processMavFrames() }
    }

    private suspend fun processMavFrames() {
        while (coroutineContext.isActive && isOpen) {
            try {
                connection.next()
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
