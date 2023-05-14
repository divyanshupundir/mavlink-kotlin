package com.divpundir.mavlink.connection

import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import java.io.Closeable
import java.io.IOException

/**
 * A connection interface with a MAVLink device.
 *
 * All the methods are blocking and can throw [IOException]. This is a design decision to keep the interface simple and
 * to allow the user to decide how to handle the blocking calls and the IO errors.
 *
 * Normally, the users will use wrappers/adapters like the
 * [CoroutinesMavConnection][com.divpundir.mavlink.adapters.coroutines] which provides a coroutine based api to the
 * underlying connection.
 *
 * @see [com.divpundir.mavlink.adapters.coroutines.CoroutinesMavConnection]
 * @see [com.divpundir.mavlink.adapters.rxjava2.Rx2MavConnection]
 * @see [com.divpundir.mavlink.adapters.rxjava3.Rx3MavConnection]
 */
public interface MavConnection : Closeable {

    /**
     * Creates the underlying connection so that the implementation have the resources to manage the input and output of
     * data according to the protocol used. E.g. for TCP connections this would open the socket.
     */
    @Throws(IOException::class)
    public fun connect()

    /**
     * Reads a MAVLink frame from for the underlying connection.
     */
    @Throws(IOException::class)
    public fun next(): MavFrame<out MavMessage<*>>

    /**
     * Sends the provided [payload] wrapped in a Mavlink v1 frame.
     */
    @Throws(IOException::class)
    public fun <T : MavMessage<T>> sendV1(
        systemId: UByte,
        componentId: UByte,
        payload: T
    )

    /**
     * Sends the provided [payload] wrapped in an unsigned MAVLink v2 frame.
     */
    @Throws(IOException::class)
    public fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T
    )

    /**
     * Sends the provided [payload] wrapped in a signed MAVLink v2 frame.
     */
    @Throws(IOException::class)
    public fun <T : MavMessage<T>> sendSignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T,
        linkId: UByte,
        timestamp: UInt,
        secretKey: ByteArray
    )
}
