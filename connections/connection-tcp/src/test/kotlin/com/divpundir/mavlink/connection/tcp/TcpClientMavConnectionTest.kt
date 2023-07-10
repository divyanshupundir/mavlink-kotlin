package com.divpundir.mavlink.connection.tcp

import com.divpundir.mavlink.definitions.common.CommonDialect
import org.junit.jupiter.api.Test

class TcpClientMavConnectionTest {

    @Test
    fun read() {
        val connection = TcpClientMavConnection("127.0.0.1", 5760, CommonDialect)
        connection.connect()

        repeat(100) {
            println(connection.next())
        }

        connection.close()
    }
}
