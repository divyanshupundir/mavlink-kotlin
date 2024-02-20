package com.divpundir.mavlink.adapters.coroutines

import com.divpundir.mavlink.api.wrap
import com.divpundir.mavlink.connection.StreamState
import com.divpundir.mavlink.connection.tcp.TcpClientMavConnection
import com.divpundir.mavlink.connection.tcp.TcpServerMavConnection
import com.divpundir.mavlink.connection.udp.UdpClientMavConnection
import com.divpundir.mavlink.connection.udp.UdpServerMavConnection
import com.divpundir.mavlink.definitions.ardupilotmega.ArdupilotmegaDialect
import com.divpundir.mavlink.definitions.common.CommandLong
import com.divpundir.mavlink.definitions.common.CommonDialect
import com.divpundir.mavlink.definitions.common.MavCmd
import com.divpundir.mavlink.definitions.common.ScaledImu2
import com.divpundir.mavlink.definitions.minimal.Heartbeat
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class CoroutinesMavConnectionTest {

    @Test
    fun read(): Unit = runBlocking {
        val connection = UdpClientMavConnection("127.0.0.1", 5760, CommonDialect).asCoroutine()

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
        val connection = UdpServerMavConnection(14551, CommonDialect).asCoroutine()

        launch {
            connection.streamState.filterIsInstance<StreamState.Inactive.Failed>().collect {
                println(it)

                while (true) {
                    try {
                        connection.connect(this)
                        break
                    } catch (e: Exception) {
                        e.printStackTrace()
                        delay(2000)
                    }
                }
            }
        }

        launch {
            while (!connection.tryConnect(this)) {
                delay(2000)
            }
        }

        launch {
            connection.mavFrame.map { it.message }.filterIsInstance<Heartbeat>().collect { println(it) }
        }

        launch {
            while (true) {
                delay(1000)
                connection.trySendUnsignedV2(220u, 1u, Heartbeat())
            }
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

    @Test
    fun interruptOpen(): Unit = runBlocking {
        val connection = UdpServerMavConnection(5790, CommonDialect).asCoroutine()
        launch {
            println("Connecting")
            try {
                connection.connect(this)
                println("Connected")
            } catch (e: Exception) {
                println("Interrupted")
            }
        }

        launch {
            delay(5000)
            println("Closing")
            connection.tryClose()
            println("Closed")
        }

        launch {
            connection.streamState.collect {
                println(it)
            }
        }
    }
}
