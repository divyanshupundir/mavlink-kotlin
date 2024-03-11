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

    /**
     * Interrupts the blocking calls in the [open] method.
     *
     * For example, if the [open] method is blocked on a server socket accept call, then this method can be used to
     * interrupt the call by closing the server socket.
     *
     * This method should be called before the [open] method returns.
     */
    @Throws(IOException::class)
    protected open fun interruptOpen() { }

    @Throws(IOException::class)
    final override fun connect() {
        when (state) {
            State.Closed -> {
                state = State.Opening

                try {
                    state = State.Open(open())
                } catch (e: IOException) {
                    state = State.Closed
                    throw e
                }
            }

            State.Opening -> {
                throw IOException("The connection is already opening")
            }

            is State.Open -> {
                throw IOException("The connection is already open")
            }
        }
    }

    @Throws(IOException::class)
    final override fun close() {
        when (val s = state) {
            State.Closed -> {
                throw IOException("The connection is already closed")
            }

            State.Opening -> {
                try {
                    interruptOpen()
                } finally {
                    state = State.Closed
                }
            }

            is State.Open -> {
                try {
                    s.connection.close()
                } finally {
                    state = State.Closed
                }
            }
        }
    }

    @Throws(IOException::class)
    final override fun next(): MavFrame<out MavMessage<*>> {
        return when (val s = state) {
            State.Closed -> {
                throw IOException("The connection is closed")
            }

            State.Opening -> {
                throw IOException("The connection is opening")
            }

            is State.Open -> {
                s.connection.next()
            }
        }
    }

    @Throws(IOException::class)
    final override fun <T : MavMessage<T>> sendV1(
        systemId: UByte,
        componentId: UByte,
        payload: T
    ) {
        when (val s = state) {
            State.Closed -> {
                throw IOException("The connection is closed")
            }

            State.Opening -> {
                throw IOException("The connection is opening")
            }

            is State.Open -> s.connection.sendV1(
                systemId,
                componentId,
                payload
            )
        }
    }

    @Throws(IOException::class)
    final override fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T
    ) {
        when (val s = state) {
            State.Closed -> {
                throw IOException("The connection is closed")
            }

            State.Opening -> {
                throw IOException("The connection is opening")
            }

            is State.Open -> s.connection.sendUnsignedV2(
                systemId,
                componentId,
                payload
            )
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
            State.Closed -> {
                throw IOException("The connection is closed")
            }

            State.Opening -> {
                throw IOException("The connection is opening")
            }

            is State.Open -> s.connection.sendSignedV2(
                systemId,
                componentId,
                payload,
                linkId,
                timestamp,
                secretKey
            )
        }
    }

    /**
     * The sealed hierarchy representing the [Open] or the [Closed] state of the connection. This interface is used by
     * the inheritors of [AbstractMavConnection] to manage the [state] variable.
     */
    private sealed interface State {

        data object Closed : State

        data object Opening : State

        class Open(val connection: MavConnection) : State
    }
}
