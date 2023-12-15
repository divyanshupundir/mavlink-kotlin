package com.divpundir.mavlink.connection

import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import kotlinx.atomicfu.locks.SynchronizedObject
import kotlinx.atomicfu.locks.synchronized
import okio.IOException
import kotlin.concurrent.Volatile

/**
 * A connection state aware abstract implementation of [MavConnection].
 *
 * All operations that don't explicitly happen in the correct [state] maintained by the user throw [IOException]. For
 * example, calling [close] again while the previous connection is closed results in an [IOException] being thrown.
 *
 * The benefit of using this class is that it makes the state management of the underlying connection saved in the
 * [State.Open.connection] field more easy and predictable. Also, the inheritors of this class only need to implement
 * the [open] method.
 */
public abstract class AbstractMavConnection : MavConnection {

    private val lock = SynchronizedObject()

    @Volatile
    private var state: State = State.Closed
        set(value) {
            synchronized(lock) {
                field = value
            }
        }

    /**
     * Opens and returns a new [MavConnection]. This [MavConnection] is a simple/unmanaged one, like
     * [BufferedMavConnection].
     *
     * Ideally, the inheritors of [AbstractMavConnection] will open a data stream (e.g. a TCP socket, a UDP channel and
     * a serial port) and return a [BufferedMavConnection] created using this. It is preferred that the connection is
     * created in a blocking manner so that the adapters can handle the threading.
     *
     * For implementation examples refer:
     * - [com.divpundir.mavlink.connection.tcp.TcpClientMavConnection]
     * - [com.divpundir.mavlink.connection.tcp.TcpServerMavConnection]
     * - [com.divpundir.mavlink.connection.udp.UdpServerMavConnection]
     */
    @Throws(IOException::class)
    protected abstract fun open(): MavConnection

    @Throws(IOException::class)
    final override fun connect() {
        when (state) {
            is State.Open -> throw IOException("The connection is already open")

            State.Closed -> {
                state = State.Open(open())
            }
        }
    }

    @Throws(IOException::class)
    final override fun close() {
        when (val s = state) {
            is State.Open -> {
                s.connection.close()
                state = State.Closed
            }

            State.Closed -> throw IOException("The connection is already closed")
        }
    }

    @Throws(IOException::class)
    final override fun next(): MavFrame<out MavMessage<*>> {
        return when (val s = state) {
            is State.Open -> s.connection.next()
            State.Closed -> throw IOException("The connection is closed")
        }
    }

    @Throws(IOException::class)
    final override fun <T : MavMessage<T>> sendV1(
        systemId: UByte,
        componentId: UByte,
        payload: T
    ) {
        when (val s = state) {
            is State.Open -> s.connection.sendV1(
                systemId,
                componentId,
                payload
            )

            State.Closed -> throw IOException("The connection is closed")
        }
    }

    @Throws(IOException::class)
    final override fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T
    ) {
        when (val s = state) {
            is State.Open -> s.connection.sendUnsignedV2(
                systemId,
                componentId,
                payload
            )

            State.Closed -> throw IOException("The connection is closed")
        }
    }

    @Throws(IOException::class)
    final override fun <T : MavMessage<T>> sendSignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T,
        linkId: UByte,
        timestamp: UInt,
        secretKey: ByteArray
    ) {
        when (val s = state) {
            is State.Open -> s.connection.sendSignedV2(
                systemId,
                componentId,
                payload,
                linkId,
                timestamp,
                secretKey
            )

            State.Closed -> throw IOException("The connection is closed")
        }
    }

    /**
     * The sealed hierarchy representing the [Open] or the [Closed] state of the connection. This interface is used by
     * the inheritors of [AbstractMavConnection] to manage the [state] variable.
     */
    private sealed interface State {

        class Open(val connection: MavConnection) : State

        data object Closed : State
    }
}
