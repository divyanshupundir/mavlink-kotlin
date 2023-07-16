# connection-udp

## Overview

This module provides the `MavConnection` implementations to handle the UDP connections.

## Usage

```kotlin
implementation("com.divpundir.mavlink:connection-udp:$version")
```

### UDP Server

```kotlin
val connection = UdpServerMavConnection(14550, CommonDialect)
```
