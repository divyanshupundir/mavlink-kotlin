package com.urbanmatrix.mavlink.connection

import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.definitions.common.CommonDialect
import com.urbanmatrix.mavlink.definitions.minimal.Heartbeat
import com.urbanmatrix.mavlink.definitions.minimal.MavAutopilot
import com.urbanmatrix.mavlink.definitions.minimal.MavState
import com.urbanmatrix.mavlink.definitions.minimal.MavType
import org.junit.jupiter.api.Test
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket

class MavConnectionTest {

    @Test
    fun read() {
        val socket = Socket()
        socket.connect(InetSocketAddress("127.0.0.1", 5760))

        val connection = MavConnection(
            socket.getInputStream(),
            socket.getOutputStream(),
            CommonDialect
        )

        repeat(20) {
            println(connection.next())
        }
    }

    @Test
    fun write() {
        val server = ServerSocket(5760)
        val socket = server.accept()

        val connection = MavConnection(
            socket.getInputStream(),
            socket.getOutputStream(),
            CommonDialect
        )

        repeat(20) {
            val heartbeat = Heartbeat(
                MavEnumValue.of(MavType.MAV_TYPE_FIXED_WING),
                MavEnumValue.of(MavAutopilot.MAV_AUTOPILOT_PX4),
                MavEnumValue.fromValue(200),
                52202,
                MavEnumValue.of(MavState.MAV_STATE_ACTIVE),
                2
            )
            connection.sendV1(250, 1, heartbeat)

            Thread.sleep(500)
        }
    }
}
