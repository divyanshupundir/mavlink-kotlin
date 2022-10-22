package xyz.urbanmatrix.mavlink.adapters.coroutines

import kotlinx.coroutines.sync.Semaphore
import org.junit.jupiter.api.Test
import xyz.urbanmatrix.mavlink.adapters.rxjava2.asCoroutines
import xyz.urbanmatrix.mavlink.connection.tcp.TcpClientMavConnection
import xyz.urbanmatrix.mavlink.definitions.common.CommonDialect
import java.util.concurrent.TimeUnit

class CoroutinesMavConnectionImplTest {

    @Test
    suspend fun read() {
        val connection = TcpClientMavConnection("127.0.0.1", 5760, CommonDialect).asCoroutines()
        val semaphore = Semaphore(100)
        connection.connect()
        semaphore.acquire()
        connection.mavFrame
            .collect {
                println(it.message)
            }
        semaphore.release()
        connection.close()

        TimeUnit.SECONDS.sleep(5)

        connection.connect()
        semaphore.acquire()
        connection.mavFrame
            .collect {
                println(it.message)
            }
        semaphore.release()
        connection.close()
    }
}
