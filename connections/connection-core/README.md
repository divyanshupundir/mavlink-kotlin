# connection-core

![android](http://img.shields.io/badge/android-8A2BE2.svg)
![ios](http://img.shields.io/badge/ios-FFD700.svg)
![js](http://img.shields.io/badge/js-FFC107.svg)
![jvm](http://img.shields.io/badge/jvm-4169E1.svg)
![linux](http://img.shields.io/badge/linux-4B0082.svg)
![macos](http://img.shields.io/badge/macos-FF4500.svg)
![watchos](http://img.shields.io/badge/watchos-008080.svg)
![windows](http://img.shields.io/badge/windows-FF1493.svg)

## Overview

This module provides the basic constructs for handling the MAVLink streams and connections. Most users will not use this
module directly in their applications, rather they will use this indirectly by using the different connection mode
modules like the `connection-tcp` and wrap the connection in one of the `adapters`.

The central interface of this module is `MavConnection` that has the declarations of the basic read and write methods.
This interface is later used in the adapter modules to provide the adapter specific API.

This module depends on `Okio` to implement some of the core IO structures like the `BufferedMavConnection`.

## Usage

```kotlin
implementation("com.divpundir.mavlink:connection-core:$version")
```

Refer the `connection-tcp` module for examples on how to use the `connection-core` classes to implement your own
connection mode.
