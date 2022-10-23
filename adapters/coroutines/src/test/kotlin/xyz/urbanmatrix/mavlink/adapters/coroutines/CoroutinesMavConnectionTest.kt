package xyz.urbanmatrix.mavlink.adapters.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import xyz.urbanmatrix.mavlink.adapters.rxjava2.asCoroutine
import xyz.urbanmatrix.mavlink.connection.tcp.TcpClientMavConnection
import xyz.urbanmatrix.mavlink.definitions.common.CommonDialect

class CoroutinesMavConnectionTest {

    @Test
    fun read(): Unit = runBlocking {
        val connection = TcpClientMavConnection("127.0.0.1", 5760, CommonDialect).asCoroutine()

        launch {
            connection.connect(this)
            delay(5000)
            connection.close()

            delay(5000)

            connection.connect(this)
            delay(5000)
            connection.close()
        }

        launch {
            connection.mavFrame.collect { println(it.message) }
        }
    }
}
