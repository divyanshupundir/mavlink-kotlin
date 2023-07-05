package com.divpundir.mavlink.connection

import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import okio.IOException

/**
 * A connection state aware abstract implementation of [MavConnection]. The inheritors of this class only need to
 * implement the [connect] method.
 *
 * All operations that don't explicitly happen in the correct state maintained by the user throw [IOException]. For
 * example, calling [connect] again while the previous connection is active results in an [IOException] being thrown.
 */
public abstract class AbstractMavConnection : MavConnection {

    @Volatile
    protected var state: State = State.Closed
        @Synchronized set

    @Throws(IOException::class)
    final override fun close() {
        when (val s = state) {
            is State.Open -> {
                s.connection.close()
                state = State.Closed
            }

            State.Closed -> throw IOException("Already closed")
        }
    }

    @Throws(IOException::class)
    final override fun next(): MavFrame<out MavMessage<*>> {
        return when (val s = state) {
            is State.Open -> s.connection.next()
            State.Closed -> throw IOException("Closed")
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

            State.Closed -> throw IOException("Closed")
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

            State.Closed -> throw IOException("Closed")
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

            State.Closed -> throw IOException("Closed")
        }
    }

    protected sealed interface State {
        public class Open(public val connection: MavConnection) : State
        public object Closed : State
    }
}
