package xyz.urbanmatrix.mavlink.connection.tcp

import org.junit.jupiter.api.Test
import xyz.urbanmatrix.mavlink.definitions.common.CommonDialect

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
