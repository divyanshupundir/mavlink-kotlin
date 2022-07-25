package com.urbanmatrix.mavlink.connection.tcp

import com.urbanmatrix.mavlink.api.MavDialect
import com.urbanmatrix.mavlink.api.MavFrame
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.connection.SimpleMavConnection
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.net.Socket

abstract class AbstractTcpMavConnection(
    dialect: MavDialect
) : TcpMavConnection {

    private val c = SimpleMavConnection(dialect)

    @Volatile
    protected var socket: Socket? = null
        @Synchronized set

    @Throws(IOException::class)
    final override fun connect(inputStream: InputStream, outputStream: OutputStream) {
        c.connect(inputStream, outputStream)
    }

    @Throws(IOException::class)
    final override fun close() {
        socket?.close()
        socket = null
        c.close()
    }

    @Throws(IOException::class)
    final override fun next(): MavFrame<out MavMessage<*>> {
        return c.next()
    }

    @Throws(IOException::class)
    final override fun <T : MavMessage<T>> sendV1(
        systemId: Int,
        componentId: Int,
        payload: T
    ) {
        c.sendV1(
            systemId,
            componentId,
            payload
        )
    }

    @Throws(IOException::class)
    final override fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: Int,
        componentId: Int,
        payload: T
    ) {
        c.sendUnsignedV2(
            systemId,
            componentId,
            payload
        )
    }

    @Throws(IOException::class)
    final override fun <T : MavMessage<T>> sendSignedV2(
        systemId: Int,
        componentId: Int,
        payload: T,
        linkId: Int,
        timestamp: Long,
        secretKey: ByteArray
    ) {
        c.sendSignedV2(
            systemId,
            componentId,
            payload,
            linkId,
            timestamp,
            secretKey
        )
    }
}
