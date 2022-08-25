package xyz.urbanmatrix.mavlink.connection.tcp

import org.junit.jupiter.api.Test
import xyz.urbanmatrix.mavlink.definitions.common.CommonDialect

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
