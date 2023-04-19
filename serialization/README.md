# serialization

## Overview

Tools for serializing and deserializing MAVLink message/frame Kotlin objects to and from a byte stream. More
specifically, it contains extension functions on `ByteArray` and `ByteBuffer` to encode and decode different sizes of
int, uint, float, strings/characters, arrays, etc.

## Usage

```kotlin
implementation("com.divpundir.mavlink:serialization:$version")
```
