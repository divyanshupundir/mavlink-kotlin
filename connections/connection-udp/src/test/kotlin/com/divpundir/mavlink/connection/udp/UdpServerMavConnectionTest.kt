package com.divpundir.mavlink.connection.udp

import com.divpundir.mavlink.definitions.common.CommonDialect
import org.junit.jupiter.api.Test

class UdpServerMavConnectionTest {

    @Test
    fun connectAndRead() {
        val connection = UdpServerMavConnection(14555, CommonDialect)
        connection.connect()

        repeat(1000) {
            println(connection.next())
        }

        connection.close()
    }
}
