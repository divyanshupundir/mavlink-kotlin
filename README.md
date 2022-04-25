# mavlink-kotlin
A MAVLink library for the JVM written in Kotlin.

## Project Structure
- `api`: Interfaces and classes for the MAVLink protocol
- `generator`: MAVLink generator Gradle Plugin
- `serialization`: Tools for serializing and deserializing
- `mavlink-kotlin`:
  - Implementation of `api`
  - Generated sources for common MAVLink messages
  - Handling of data streams and connections for different protocols like TCP, UDP, Serial
- `adapters`: Adapters `mavlink-kotlin` data streams using RxJava, Kotlin Coroutines, etc

## Motivation
This library takes inspiration from the amazing [dronefleet/mavlink](https://github.com/dronefleet/mavlink) library.
Some additions that this library would like to address are:
- Interface-based API
- Reflection-less serialization and deserialization
- Message generator gradle plugin
- Flexible module-based design
- Eventual support for Kotlin Multiplatform
