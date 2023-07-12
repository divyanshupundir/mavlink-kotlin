package com.divpundir.mavlink.connection.udp

import com.divpundir.mavlink.definitions.common.CommonDialect
import org.junit.jupiter.api.Test

class UdpServerMavConnectionTest {

    @Test
    fun gen() {
        val connection = UdpServerMavConnection(14550, CommonDialect)
        connection.connect()

        repeat(1000) {
            println(connection.next())
        }

        connection.close()
    }
}
