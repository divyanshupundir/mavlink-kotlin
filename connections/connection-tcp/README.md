# connection-tcp

![android](http://img.shields.io/badge/android-8A2BE2.svg)
![jvm](http://img.shields.io/badge/jvm-4169E1.svg)

## Overview

This module provides the `MavConnection` implementations to handle the TCP client and TCP server connections.

## Usage

```kotlin
implementation("com.divpundir.mavlink:connection-tcp:$version")
```

### TCP Server

```kotlin
val connection = TcpServerMavConnection(5760, CommonDialect)
```

### TCP Client

```kotlin
val connection = TcpClientMavConnection("127.0.0.1", 5760, CommonDialect)
```
