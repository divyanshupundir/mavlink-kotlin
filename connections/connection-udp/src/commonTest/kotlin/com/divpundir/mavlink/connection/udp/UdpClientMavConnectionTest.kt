package com.divpundir.mavlink.connection.udp

import com.divpundir.mavlink.definitions.common.CommonDialect
import org.junit.jupiter.api.Test

class UdpClientMavConnectionTest {

    @Test
    fun connectAndRead() {
        val connection = UdpClientMavConnection("127.0.0.1", 14555, CommonDialect)
        connection.connect()

        repeat(1000) {
            println(connection.next())
        }

        connection.close()
    }
}
