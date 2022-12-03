package xyz.urbanmatrix.mavlink.adapters.coroutines

import kotlinx.coroutines.CoroutineScope
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.connection.MavConnection
import java.io.IOException

public fun MavConnection.asCoroutine(
    onIoFailure: CoroutinesMavConnection.() -> Unit = {}
): CoroutinesMavConnection = CoroutinesMavConnectionImpl(
    this,
    128,
    onIoFailure
)

public suspend fun CoroutinesMavConnection.tryConnect(readerScope: CoroutineScope): Boolean = runCatchingIo {
    connect(readerScope)
}

public suspend fun CoroutinesMavConnection.tryClose(): Boolean = runCatchingIo {
    close()
}

public suspend fun <T : MavMessage<T>> CoroutinesMavConnection.trySendV1(
    systemId: Int,
    componentId: Int,
    payload: T
): Boolean = runCatchingIo {
    sendV1(systemId, componentId, payload)
}

public suspend fun <T : MavMessage<T>> CoroutinesMavConnection.trySendUnsignedV2(
    systemId: Int,
    componentId: Int,
    payload: T
): Boolean = runCatchingIo {
    sendUnsignedV2(systemId, componentId, payload)
}

public suspend fun <T : MavMessage<T>> CoroutinesMavConnection.trySendSignedV2(
    systemId: Int,
    componentId: Int,
    payload: T,
    linkId: Int,
    timestamp: Long,
    secretKey: ByteArray
): Boolean = runCatchingIo {
    sendSignedV2(systemId, componentId, payload, linkId, timestamp, secretKey)
}

private inline fun runCatchingIo(block: () -> Unit): Boolean = try {
    block()
    true
} catch (e: IOException) {
    false
}
