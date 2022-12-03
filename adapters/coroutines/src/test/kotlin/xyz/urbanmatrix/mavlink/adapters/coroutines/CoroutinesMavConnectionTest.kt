package xyz.urbanmatrix.mavlink.adapters.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import xyz.urbanmatrix.mavlink.connection.tcp.TcpClientMavConnection
import xyz.urbanmatrix.mavlink.definitions.common.CommandLong
import xyz.urbanmatrix.mavlink.definitions.common.CommonDialect
import xyz.urbanmatrix.mavlink.definitions.common.MavCmd
import xyz.urbanmatrix.mavlink.wrap

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

    @Test
    fun write(): Unit = runBlocking {
        val connection = TcpClientMavConnection("127.0.0.1", 5760, CommonDialect).asCoroutine()

        launch {
            connection.connect(this)
            connection.sendUnsignedV2(
                100, 1,
                CommandLong(
                    1,
                    1,
                    MavCmd.MAV_CMD_COMPONENT_ARM_DISARM.wrap(),
                    param1 = 1f
                )
            )
            connection.trySendUnsignedV2(
                100, 1,
                CommandLong(
                    1,
                    1,
                    MavCmd.MAV_CMD_NAV_LAND.wrap()
                )
            )
        }
    }

    @Test
    fun reconnect(): Unit = runBlocking {
        val connection = TcpClientMavConnection("127.0.0.1", 5760, CommonDialect).asCoroutine {
            launch {
                while (!tryConnect(this)) {
                    delay(2000)
                }
            }
        }

        launch {
            while (!connection.tryConnect(this)) {
                delay(2000)
            }
        }

        launch {
            connection.mavFrame.collect { println(it.message) }
        }
    }
}
