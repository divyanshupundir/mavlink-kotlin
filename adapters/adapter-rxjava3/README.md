# adapter-rxjava3

![android](http://img.shields.io/badge/android-8A2BE2.svg)
![jvm](http://img.shields.io/badge/jvm-4169E1.svg)

## Overview

RxJava3 adapter for `MavConnection`.

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
    implementation("com.divpundir.mavlink:adapter-rxjava3:$version")
}
```

### Connecting

Create a `MavConnection` object and wrap it with the RxJava3 adapter using the `asRx3` extension function.

```kotlin
val connection = TcpClientMavConnection("127.0.0.1", 5760, CommonDialect).asRx3()
```

Use the connect method to establish the connection.

```kotlin
// Blocking
connection.connect().blockingAwait()
println("Connected")

// Non-blocking
connection
    .connect()
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(
        { println("connected") },
        Throwable::printStackTrace
    )
```

### Reading

The connection starts reading the MAVLink frames on a background thread. They are available via the  `mavFrame`
`Flowable`.

```kotlin
// Blocking
connection
    .mavFrame
    .map { it.message }
    .ofType(Heartbeat::class.java)
    .blockingSubscribe { println("autopilot: ${it.autopilot}, type: ${it.type}") }

// Non-blocking
connection
    .mavFrame
    .map { it.message }
    .ofType(Heartbeat::class.java)
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(
        { println("autopilot: ${it.autopilot}, type: ${it.type}") },
        Throwable::printStackTrace
    )
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
// MAVLink v1 packet
val completable = connection.sendV1(
    systemId = 250,
    componentId = 1,
    payload = heartbeat
)

// Unsigned MAVLink v2 packet
val completable = connection.sendUnsignedV2(
    systemId = 250,
    componentId = 1,
    payload = heartbeat
)

// Signed MAVLink v2 packet
val completable = connection.sendSignedV2(
    systemId = 250,
    componentId = 1,
    payload = heartbeat,
    linkId = linkId,       // Integer link ID
    timestamp = timestamp, // Long microseconds
    secretKey = secretKey  // ByteArray passcode
)
```

Just as other RxJava3 `Completable` objects, call the `subscribe` or `blockingAwait` method to execute the command.

```kotlin
// Blocking
completable.blockingAwait()
println("Heartbeat sent")

// Non-blocking
completable
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(
        { println("Heartbeat sent") },
        Throwable::printStackTrace
    )
```

### Closing

Use the `close` method to close the connection.

```kotlin
// Blocking
connection.close().blockingAwait()
println("Closed")

// Non-blocking
connection
    .close()
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(
        { println("Closed") },
        Throwable::printStackTrace
    )
```

### Managing the state

Use the `streamState` `Flowable` to get the current state of the connection.

```kotlin
connection
    .streamState
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe {
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
```
