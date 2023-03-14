package xyz.urbanmatrix.mavlink.adapters.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import xyz.urbanmatrix.mavlink.connection.tcp.TcpClientMavConnection
import xyz.urbanmatrix.mavlink.definitions.ardupilotmega.ArdupilotmegaDialect
import xyz.urbanmatrix.mavlink.definitions.ardupilotmega.Meminfo
import xyz.urbanmatrix.mavlink.definitions.common.*
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
                100u, 1u,
                CommandLong(
                    1u,
                    1u,
                    MavCmd.COMPONENT_ARM_DISARM.wrap(),
                    param1 = 1f
                )
            )
            connection.trySendUnsignedV2(
                100u, 1u,
                CommandLong(
                    1u,
                    1u,
                    MavCmd.NAV_LAND.wrap()
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

    @Test
    fun readMessage(): Unit = runBlocking {
        val connection = TcpClientMavConnection("127.0.0.1", 5790, ArdupilotmegaDialect).asCoroutine()
        connection.connect(this)

        connection.mavFrame.map { it.message }.filterIsInstance<ScaledImu2>().collect {
            println(it)
        }
    }
}
