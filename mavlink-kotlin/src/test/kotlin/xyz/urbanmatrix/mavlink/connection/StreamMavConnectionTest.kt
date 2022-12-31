package xyz.urbanmatrix.mavlink.connection

import org.junit.jupiter.api.Test
import xyz.urbanmatrix.mavlink.api.MavBitmaskValue
import xyz.urbanmatrix.mavlink.connection.stream.StreamMavConnection
import xyz.urbanmatrix.mavlink.definitions.common.CommonDialect
import xyz.urbanmatrix.mavlink.definitions.minimal.Heartbeat
import xyz.urbanmatrix.mavlink.definitions.minimal.MavAutopilot
import xyz.urbanmatrix.mavlink.definitions.minimal.MavState
import xyz.urbanmatrix.mavlink.definitions.minimal.MavType
import xyz.urbanmatrix.mavlink.wrap
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket

class StreamMavConnectionTest {

    @Test
    fun read() {
        val socket = Socket()
        socket.connect(InetSocketAddress("127.0.0.1", 5760))

        val connection = StreamMavConnection(
            socket.getInputStream(),
            socket.getOutputStream(),
            socket,
            CommonDialect
        )

        repeat(100) {
            println(connection.next())
        }

        connection.close()
    }

    @Test
    fun write() {
        val server = ServerSocket(5760)
        val socket = server.accept()
        server.close()

        val connection = StreamMavConnection(
            socket.getInputStream(),
            socket.getOutputStream(),
            socket,
            CommonDialect
        )

        repeat(20) {
            val heartbeat = Heartbeat(
                MavType.FIXED_WING.wrap(),
                MavAutopilot.PX4.wrap(),
                MavBitmaskValue.fromValue(200),
                52202,
                MavState.ACTIVE.wrap(),
                2
            )
            connection.sendV1(250, 1, heartbeat)

            Thread.sleep(500)
        }

        connection.close()
    }
}
