package com.divpundir.mavlink.adapters.coroutines

import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.connection.MavConnection
import kotlinx.coroutines.CoroutineScope
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
    systemId: UByte,
    componentId: UByte,
    payload: T
): Boolean = runCatchingIo {
    sendV1(systemId, componentId, payload)
}

public suspend fun <T : MavMessage<T>> CoroutinesMavConnection.trySendUnsignedV2(
    systemId: UByte,
    componentId: UByte,
    payload: T
): Boolean = runCatchingIo {
    sendUnsignedV2(systemId, componentId, payload)
}

public suspend fun <T : MavMessage<T>> CoroutinesMavConnection.trySendSignedV2(
    systemId: UByte,
    componentId: UByte,
    payload: T,
    linkId: UByte,
    timestamp: UInt,
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
