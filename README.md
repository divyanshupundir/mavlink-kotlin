# mavlink-kotlin
A modern MAVLink handling library for the JVM written in Kotlin.

## Key Design Considerations

### Reflection-less serialization and deserialization

Reflection-based code can be prone to errors, difficult to understand and difficult for compiler to optimize.
Mavlink-Kotlin heavily uses code-gen to avoid reflection and provide compile-time safety.

In-fact, we've even tested it against other available MAVLink implementations for the JVM, and this library is
**20,000x to 45,000x** faster in terms of serialization and deserialization speeds and provides a much better memory
footprint. Don't believe us? try out the comparison tests in the `mavlink-kotlin` module.

### Interface-based API and modular design

Don't think the in-built implementation is good enough? No issues. Write your own code generators for the messages,
enums, dialects etc. and the rest of the modules will work without requiring a reimplementation.

### Message generator Gradle plugin:

You can provide your own dialect files and the Gradle plugin will take care of generating the messages. We use it to
generate and maintain your own private MAVLink message implementations for your drone systems, as we do ourselves.

### Support for Kotlin Multiplatform (future):

Target Android, Native, iOS and Desktop applications using the same codebase.

## Project Structure

- `api`: Interfaces and classes for the MAVLink protocol.
- `serialization`: Tools for serializing and deserializing MAVLink message Kotlin objects to and from a byte stream.
- `generator`: MAVLink generator Gradle Plugin.
- `definitions`: Implementation of the standard MAVLink messages form the official MAVLink repository generated using the Gradle plugin.
- `mavlink-kotlin`:
  - Implementation of `api`.
  - Handling of data streams and connections for different protocols like TCP, UDP and serial.
- `adapters`: RxJava2, RxJava3 and Kotlin Coroutines adapters for `mavlink-kotlin` data streams. 
