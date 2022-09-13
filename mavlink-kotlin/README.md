# mavlink-kotlin

## Overview

Implementation of the `api` module for the handling of data streams and connections for different protocols. TCP is
ready for use, while UDP and serial are in development. It contains the interface `MavConnection` which acts as the base
for various connection types. It is later used by the different `adapters` to provide a simple end-user API.

The `mavlink-kotlin` module itself only handles the connections and provides reader and writer methods to and from byte
streams. Generally, we will be using this with the one of the `adapters`. Refer the root level documentation for a
normal use case.

Currently, the library only supports TCP client and server connections. Support for more connection interfaces is in the
pipeline.

## Usage

```kotlin
implementation("xyz.urbanmatrix.mavlink:mavlink-kotlin:$version")
```

The core interface of the `mavlink-kotlin` module is `MavConnection`. It has the declarations of the basic read and
write methods. This interface is later used in the `adapters` modules to provide adapter specific API.

`StreamMavConnection` is an implementation of `MavConnection` that can be used to read MAVLink messages form
`InputStreams` and write to `OutputStreams`.
