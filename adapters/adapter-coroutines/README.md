# adapter-coroutines

![android](http://img.shields.io/badge/android-8A2BE2.svg)
![ios](http://img.shields.io/badge/ios-FFD700.svg)
![js](http://img.shields.io/badge/js-FFC107.svg)
![jvm](http://img.shields.io/badge/jvm-4169E1.svg)
![linux](http://img.shields.io/badge/linux-4B0082.svg)
![macos](http://img.shields.io/badge/macos-FF4500.svg)
![watchos](http://img.shields.io/badge/watchos-008080.svg)
![windows](http://img.shields.io/badge/windows-FF1493.svg)

## Overview

Kotlin Coroutines adapter for `MavConnection`.

## Usage

Add the required dependencies to your `build.gradle.kts`. This example uses the `definitions` module for the messages
and the `connection-tcp` for the base connection.

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("com.divpundir.mavlink:definitions:$version")
    implementation("com.divpundir.mavlink:connection-tcp:$version")
    implementation("com.divpundir.mavlink:adapter-coroutines:$version")
}
```

### Connecting

Create a `MavConnection` object and wrap it with the coroutines adapter using the `asCoroutine` extension function.

```kotlin
val connection = TcpClientMavConnection("127.0.0.1", 5760, CommonDialect).asCoroutine()
```

All the methods of the `CoroutinesMavConnection` are suspending functions that operate in the `IO` context and can throw
`IOException`. Use them in a `try-catch` block or use the safe alternatives (`tryConnect()`, `trySendV1()` etc.)
extension functions that return a `Boolean` result (`true` if success `false` otherwise).

Use the connect method to establish the connection.

```kotlin
viewModelScope.launch {
    connection.connect()
    println("Connected")
}
```

### Reading

The connection starts reading the MAVLink frames on a background thread. They are available via the  `mavFrame`
`SharedFlow`.

```kotlin
connection
    .mavFrame
    .map { it.message }
    .filterIsInstance<Heartbeat>()
    .onEach { println("autopilot: ${it.autopilot}, type: ${it.type}") }
    .launchIn(viewModelScope)
```

### Creating MavMessage objects

To send a message, create the `MavMessage` object that you want to send.

```kotlin
// Using the constructor
val heartbeat = Heartbeat(
    type = MavType.FIXED_WING.wrap(),                            // The wrap() extension function wraps a MavEnum in a MavEnumValue
    autopilot = MavEnumValue.of(MavAutopilot.MAV_AUTOPILOT_PX4), // Or use the MavEnumValue.of() function
    baseMode = MavBitmaskValue.of(                               // Use the MavBitmaskValue.of() to create a bitmask
        MavModeFlag.AUTO_ENABLED,
        MavModeFlag.SAFETY_ARMED
    ),
    systemStatus = MavEnumValue.fromValue(4),                    // Use the MavEnumValue.fromValue() to specify your own value that is not in the enum
    mavlinkVersion = 2
) // Default values will be set for the unspecified parameters

// Using the builder function
val heartbeat = Heartbeat {
    type = MavType.FIXED_WING.wrap()
    autopilot = MavAutopilot.PX4.wrap()
    baseMode = MavEnumValue.fromValue(200)
    mavlinkVersion = 2
}

// Using the Builder class
val builder = Heartbeat.Builder()
builder.type = MavType.FIXED_WING.wrap()
builder.autopilot = MavAutopilot.PX4.wrap()
builder.mavlinkVersion = 2
val heartbeat = builder.build()
```

### Writing

The library provides three methods to write messages to the byte streams.

```kotlin
viewModelScope.launch {
    // MAVLink v1 packet
    connection.sendV1(
        systemId = 250,
        componentId = 1,
        payload = heartbeat
    )

    // Unsigned MAVLink v2 packet
    connection.sendUnsignedV2(
        systemId = 250,
        componentId = 1,
        payload = heartbeat
    )

    // Signed MAVLink v2 packet
    connection.sendSignedV2(
        systemId = 250,
        componentId = 1,
        payload = heartbeat,
        linkId = linkId,       // Integer link ID
        timestamp = timestamp, // Long microseconds
        secretKey = secretKey  // ByteArray passcode
    )
}
```

### Closing

Use the `close` method to close the connection.

```kotlin
viewModelScope.launch {
    connection.close()
    println("Closed")
}
```

### Managing the state

Use the `streamState` `StateFlow` to get the current state of the connection.

```kotlin
connection
    .streamState
    .onEach {
        when (it) {
            StreamState.Active -> {
                // The connection is active.
            }

            StreamState.Inactive.Stopped -> {
                // The connection is stopped.
            }

            is StreamState.Inactive.Failed -> {
                // The connection failed with the given exception. Use this block to reconnect.
            }
        }
    }
    .launchIn(viewModelScope)
```
