package com.divpundir.mavlink.connection

import org.junit.jupiter.api.Test
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.definitions.common.CommonDialect
import com.divpundir.mavlink.definitions.minimal.Heartbeat
import com.divpundir.mavlink.definitions.minimal.MavAutopilot
import com.divpundir.mavlink.definitions.minimal.MavState
import com.divpundir.mavlink.definitions.minimal.MavType
import com.divpundir.mavlink.wrap
import okio.buffer
import okio.sink
import okio.source
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket

class StreamMavConnectionTest {

    @Test
    fun read() {
        val socket = Socket()
        socket.connect(InetSocketAddress("127.0.0.1", 5760))

        val connection = StreamMavConnection(
            socket.getInputStream().source().buffer(),
            socket.getOutputStream().sink().buffer(),
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
            socket.getInputStream().source().buffer(),
            socket.getOutputStream().sink().buffer(),
            socket,
            CommonDialect
        )

        repeat(20) {
            val heartbeat = Heartbeat(
                MavType.FIXED_WING.wrap(),
                MavAutopilot.PX4.wrap(),
                MavBitmaskValue.fromValue(200u),
                52202u,
                MavState.ACTIVE.wrap(),
                2u
            )
            connection.sendV1(250u, 1u, heartbeat)

            Thread.sleep(500)
        }

        connection.close()
    }
}
