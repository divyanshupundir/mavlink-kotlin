package com.divpundir.mavlink.connection

import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import java.io.Closeable
import java.io.IOException

public interface MavConnection : Closeable {

    @Throws(IOException::class)
    public fun connect()

    @Throws(IOException::class)
    public fun next(): MavFrame<out MavMessage<*>>

    @Throws(IOException::class)
    public fun <T : MavMessage<T>> sendV1(
        systemId: UByte,
        componentId: UByte,
        payload: T
    )

    @Throws(IOException::class)
    public fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T
    )

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
