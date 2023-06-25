package com.divpundir.mavlink.adapters.coroutines

import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.connection.MavConnection
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import okio.IOException

/**
 * A helper function to wrap a [MavConnection] as a [CoroutinesMavConnection]. The returned [CoroutinesMavConnection]
 * uses the provided [dispatcher] to perform the IO operations of reading and sending the messages. The [onFailure]
 * callback is invoked when an exception is thrown while reading the messages. This can be used to implement a custom
 * reconnection strategy.
 */
public fun MavConnection.asCoroutine(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    onFailure: CoroutinesMavConnection.() -> Unit = {}
): CoroutinesMavConnection = CoroutinesMavConnectionImpl(
    connection = this,
    dispatcher = dispatcher,
    extraBufferCapacity = 128,
    onBufferOverflow = BufferOverflow.DROP_OLDEST,
    onFailure = onFailure
)

/**
 * A wrapper around [CoroutinesMavConnection.connect] that returns `true` if no exception was thrown and `false`
 * otherwise.
 */
public suspend fun CoroutinesMavConnection.tryConnect(readerScope: CoroutineScope): Boolean = runCatchingIo {
    connect(readerScope)
}

/**
 * A wrapper around [CoroutinesMavConnection.close] that returns `true` if no exception was thrown and `false`
 * otherwise.
 */
public suspend fun CoroutinesMavConnection.tryClose(): Boolean = runCatchingIo {
    close()
}

/**
 * A wrapper around [CoroutinesMavConnection.sendV1] that returns `true` if no exception was thrown and `false`
 * otherwise.
 */
public suspend fun <T : MavMessage<T>> CoroutinesMavConnection.trySendV1(
    systemId: UByte,
    componentId: UByte,
    payload: T
): Boolean = runCatchingIo {
    sendV1(systemId, componentId, payload)
}

/**
 * A wrapper around [CoroutinesMavConnection.sendUnsignedV2] that returns `true` if no exception was thrown and `false`
 * otherwise.
 */
public suspend fun <T : MavMessage<T>> CoroutinesMavConnection.trySendUnsignedV2(
    systemId: UByte,
    componentId: UByte,
    payload: T
): Boolean = runCatchingIo {
    sendUnsignedV2(systemId, componentId, payload)
}

/**
 * A wrapper around [CoroutinesMavConnection.sendSignedV2] that returns `true` if no exception was thrown and `false`
 * otherwise.
 */
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
