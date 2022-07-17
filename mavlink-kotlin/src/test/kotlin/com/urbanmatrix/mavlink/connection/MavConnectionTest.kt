package com.urbanmatrix.mavlink.connection

import com.urbanmatrix.mavlink.definitions.common.CommonDialect
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.net.InetSocketAddress
import java.net.Socket

class MavConnectionTest {

    @Test
    fun tcpConnection() {
        val socket = Socket()
        socket.connect(InetSocketAddress("127.0.0.1", 5760))

        val connection = MavConnection(
            socket.getInputStream(),
            socket.getOutputStream(),
            CommonDialect
        )

        while (true) {
            println(connection.next())
        }
    }
}
