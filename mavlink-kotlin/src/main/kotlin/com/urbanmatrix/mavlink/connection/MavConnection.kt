package com.urbanmatrix.mavlink.connection

import com.urbanmatrix.mavlink.api.MavFrame
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.raw.MavRawFrameReader
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

interface MavConnection {

    @Throws(IOException::class)
    fun connect(inputStream: InputStream, outputStream: OutputStream)

    @Throws(IOException::class)
    fun close()

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

    sealed class State {
        class Open(val reader: MavRawFrameReader, val outputStream: OutputStream) : State()
        object Closed : State()
    }
}
