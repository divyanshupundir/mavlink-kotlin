package xyz.urbanmatrix.mavlink.connection.tcp

import xyz.urbanmatrix.mavlink.api.MavFrame
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.connection.MavConnection
import java.io.IOException

public abstract class TcpMavConnection : MavConnection {

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
        systemId: Int,
        componentId: Int,
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
        systemId: Int,
        componentId: Int,
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
        systemId: Int,
        componentId: Int,
        payload: T,
        linkId: Int,
        timestamp: Long,
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
