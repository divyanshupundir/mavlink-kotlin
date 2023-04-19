package com.divpundir.mavlink.connection.tcp

import com.divpundir.mavlink.connection.tcp.TcpServerMavConnection
import org.junit.jupiter.api.Test
import com.divpundir.mavlink.definitions.common.CommonDialect

class TcpServerMavConnectionTest {

    @Test
    fun read() {
        val connection = TcpServerMavConnection(5760, CommonDialect)
        connection.connect()

        repeat(100) {
            println(connection.next())
        }

        connection.close()
    }
}
