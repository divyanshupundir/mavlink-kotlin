package xyz.urbanmatrix.mavlink.connection

import xyz.urbanmatrix.mavlink.api.MavFrame
import xyz.urbanmatrix.mavlink.api.MavMessage
import java.io.Closeable
import java.io.IOException

interface MavConnection : Closeable {

    @Throws(IOException::class)
    fun connect()

    @Throws(IOException::class)
    fun next(): MavFrame<out MavMessage<*>>

    @Throws(IOException::class)
    fun <T : MavMessage<T>> sendV1(
        systemId: Int,
        componentId: Int,
        payload: T
    )

    @Throws(IOException::class)
    fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: Int,
        componentId: Int,
        payload: T
    )

    @Throws(IOException::class)
    fun <T : MavMessage<T>> sendSignedV2(
        systemId: Int,
        componentId: Int,
        payload: T,
        linkId: Int,
        timestamp: Long,
        secretKey: ByteArray
    )
}
