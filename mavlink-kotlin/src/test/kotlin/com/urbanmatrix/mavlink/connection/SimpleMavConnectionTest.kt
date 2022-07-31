package com.urbanmatrix.mavlink.connection

import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.definitions.common.CommonDialect
import com.urbanmatrix.mavlink.definitions.minimal.Heartbeat
import com.urbanmatrix.mavlink.definitions.minimal.MavAutopilot
import com.urbanmatrix.mavlink.definitions.minimal.MavState
import com.urbanmatrix.mavlink.definitions.minimal.MavType
import com.urbanmatrix.mavlink.wrap
import org.junit.jupiter.api.Test
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket

class SimpleMavConnectionTest {

    @Test
    fun read() {
        val socket = Socket()
        socket.connect(InetSocketAddress("127.0.0.1", 5760))

        val connection = SimpleMavConnection(
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

        val connection = SimpleMavConnection(
            socket.getInputStream(),
            socket.getOutputStream(),
            socket,
            CommonDialect
        )

        repeat(20) {
            val heartbeat = Heartbeat(
                MavType.MAV_TYPE_FIXED_WING.wrap(),
                MavAutopilot.MAV_AUTOPILOT_PX4.wrap(),
                MavEnumValue.fromValue(200),
                52202,
                MavState.MAV_STATE_ACTIVE.wrap(),
                2
            )
            connection.sendV1(250, 1, heartbeat)

            Thread.sleep(500)
        }

        connection.close()
    }
}