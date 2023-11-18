package com.divpundir.mavlink.adapters.coroutines

import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.connection.StreamState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import okio.IOException
import kotlin.coroutines.cancellation.CancellationException

public interface CoroutinesMavConnection {

    /**
     * The current state of the connection stream.
     */
    public val streamState: StateFlow<StreamState>

    /**
     * A stream of [MavFrame]s.
     */
    public val mavFrame: SharedFlow<MavFrame<out MavMessage<*>>>

    /**
     * Connects the underlying [MavConnection][com.divpundir.mavlink.connection.MavConnection] and start reading from
     * it. This method will suspend till the connection is created and then the [readerScope] will be used to start the
     * reading process in a new coroutine.
     */
    @Throws(IOException::class, CancellationException::class)
    public suspend fun connect(readerScope: CoroutineScope)

    /**
     * Closes the underlying [MavConnection][com.divpundir.mavlink.connection.MavConnection] and stops the reading
     * process.
     */
    @Throws(IOException::class, CancellationException::class)
    public suspend fun close()

    /**
     * Sends the provided [payload] wrapped in a Mavlink v1 frame.
     */
    @Throws(IOException::class, CancellationException::class)
    public suspend fun <T : MavMessage<T>> sendV1(
        systemId: UByte,
        componentId: UByte,
        payload: T
    )

    /**
     * Sends the provided [payload] wrapped in an unsigned MAVLink v2 frame.
     */
    @Throws(IOException::class, CancellationException::class)
    public suspend fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T
    )

    /**
     * Sends the provided [payload] wrapped in a signed MAVLink v2 frame.
     */
    @Throws(IOException::class, CancellationException::class)
    public suspend fun <T : MavMessage<T>> sendSignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T,
        linkId: UByte,
        timestamp: UInt,
        secretKey: ByteArray
    )
}
