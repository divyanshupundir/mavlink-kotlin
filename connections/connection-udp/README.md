# connection-udp

![android](http://img.shields.io/badge/android-8A2BE2.svg)
![jvm](http://img.shields.io/badge/jvm-4169E1.svg)

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

### UDP Client

```kotlin
val connection = UdpClientMavConnection("127.0.0.1", 14550, CommonDialect)
```
