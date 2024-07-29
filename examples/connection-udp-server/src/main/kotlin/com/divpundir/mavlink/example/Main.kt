package com.divpundir.mavlink.example

import com.divpundir.mavlink.adapters.coroutines.asCoroutine
import com.divpundir.mavlink.adapters.coroutines.tryConnect
import com.divpundir.mavlink.adapters.coroutines.trySendUnsignedV2
import com.divpundir.mavlink.api.contains
import com.divpundir.mavlink.api.wrap
import com.divpundir.mavlink.connection.StreamState
import com.divpundir.mavlink.connection.udp.UdpServerMavConnection
import com.divpundir.mavlink.definitions.common.CommonDialect
import com.divpundir.mavlink.definitions.minimal.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val connection = UdpServerMavConnection(14550, CommonDialect).asCoroutine()

    // Send a heartbeat every second in a new coroutine
    launch {
        val heartbeat = Heartbeat(
            type = MavType.GCS.wrap(),
            autopilot = MavAutopilot.INVALID.wrap(),
            baseMode = listOf(MavModeFlag.SAFETY_ARMED, MavModeFlag.MANUAL_INPUT_ENABLED).wrap(),
            customMode = 0u,
            systemStatus = MavState.ACTIVE.wrap(),
            mavlinkVersion = 3u
        )

        while (true) {
            delay(1000)
            connection.trySendUnsignedV2(200u, 1u, heartbeat)
        }
    }

    // Read the FCU armed state from its heartbeat in a new coroutine
    launch {
        connection
            .mavFrame
            .filter { it.systemId == 1.toUByte() && it.componentId == 1.toUByte() }
            .map { it.message }
            .filterIsInstance<Heartbeat>()
            .collect {
                val armed = MavModeFlag.SAFETY_ARMED in it.baseMode
                println("FCU armed: $armed")
            }
    }

    // Observe the connection state in a new coroutine and attempt to reconnect on failure
    launch {
        connection
            .streamState
            .filterIsInstance<StreamState.Inactive.Failed>()
            .collectLatest {
                println("Failed: ${it.cause}")
                println("Attempting to reconnect")

                // Block the current coroutine till the connection gets re-established
                while (!connection.tryConnect(this@runBlocking)) {
                    delay(1000)
                }

                println("Reconnected")
            }
    }

    println("Attempting to connect")

    // Block the current coroutine till the connection is made for the first time
    while (!connection.tryConnect(this@runBlocking)) {
        delay(1000)
    }

    println("Connected")
}
