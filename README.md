# mavlink-kotlin

[![License](https://img.shields.io/badge/license-Apache%20License%202.0-lightgrey.svg?maxAge=2592000)](https://github.com/divyanshupundir/mavlink-kotlin/blob/main/LICENSE.md)
[![Kotlin](https://img.shields.io/badge/kotlin-1.9.21-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Maven Central](https://img.shields.io/maven-central/v/com.divpundir.mavlink/api)](https://central.sonatype.com/namespace/com.divpundir.mavlink)
[![Gradle Plugin Portal](https://img.shields.io/gradle-plugin-portal/v/com.divpundir.mavlink.generator)](https://plugins.gradle.org/plugin/com.divpundir.mavlink.generator)

A modern MAVLink library for Kotlin Multiplatform.

## Overview

mavlink-kotlin was created out of the need for a type-safe, high-performance and flexible MAVLink library for targeting
multiple platforms.

We had realized several problems with existing JVM MAVLink implementations. These include:
- Performance problems at very high message rates
- Hassle to generate and maintain MAVLink message objects from custom XML definitions
- Difficulties in understanding and fixing reflection-based code
- Difficulties in extending existing code-base due to lack of modularity
- No support for multiplatform projects

Through mavlink-kotlin we want to address the problems that we had faced while adopting and understanding MAVLink
libraries not only for the JVM but also C/C++, Golang, Rust and Python. This library takes inspiration from several
great features of these libraries. We want to make the adoption of this library as easy as possible by being flexible in
terms of creating a modular and easy-to-extend API that allows the users to use the same base MAVLink and connection
classes to create adapters of their own to fit whatever pub-sub library they want to use. Apart from this, the MAVLink
generator plugin is designed to fit well with stand-alone Kotlin Multiplatform projects while keeping the setup quick
and hassle-free.

## Key Design Considerations

### Code generation instead of reflection

Reflection-based code is prone to errors, difficult to understand and difficult for compilers to optimize.

On the other hand, generated code is much easier for the users to go through and understand. And apart from the obvious
possibilities of compile-time and run-time optimizations, it is free from the fragility that reflection brings in.
mavlink-kotlin heavily uses code generation to avoid reflection and provide compile-time safety.

### Interface-based API and modular design

Don't think the in-built implementation is good enough? No issues. Write your own code generators for the messages,
enums, dialects etc. and the rest of the modules will work without requiring a reimplementation.

### Message generator Gradle plugin

You can provide your own dialect files and the Gradle plugin will take care of generating the messages. Use it to
generate and maintain your own private MAVLink message implementations for your drone systems by simply providing the
MAVLink XMLs.

### Support for Kotlin Multiplatform

Target Android, iOS, JS, JVM, Linux, macOS, watchOS and Windows applications using the same codebase.

## Project Structure

### api

Core interfaces, classes and annotations for the MAVLink protocol.

### serialization

Tools for serializing and deserializing MAVLink messages/frames to and from `ByteArrays`.

### generator

MAVLink generator Gradle Plugin that uses the `api` and the `serialization` modules to generate the MAVLink classes. 
This plugin is available at Gradle Plugin Portal with ID `com.divpundir.mavlink.generator`. It can be used by anyone
to generate MAVLink classes from their own XML files. No need to fork this project.

### definitions

Implementation of the standard MAVLink messages from the official [MAVLink repository](https://github.com/mavlink/mavlink)
generated using the Gradle plugin.

### connections

Defines the interfaces and classes to handle the MAVLink connection modes and streams. Users can create `MavConnection`
implementations of their own or use the ready-made ones.

### adapters

The different connection classes only handle the underlying connection interfaces and provides reader and writer methods
to and from byte streams. The `adapters` module wraps the connection classes to provide an abstraction layer that makes
the handling of the connections easy.

Users can create an adapter of their own or use the ready-made adapters which are:
- RxJava2
- RxJava3
- Kotlin Coroutines

## Usage

### Dependencies

The latest artifacts are available on [Maven Central](https://central.sonatype.com/namespace/com.divpundir.mavlink).

You can either use the standard `definitions` artifact available for standard messages, or you can use the `generator`
to generate your own. The details on how to do that is available in the `generator` module.

```kotlin
implementation("com.divpundir.mavlink:definitions:$version")
```

Pick one or more connection modules. For example, the TCP connection module.

```kotlin
implementation("com.divpundir.mavlink:connection-tcp:$version")
```

Pick an adapter of your choice to wrap the `MavConnection`. For example, the coroutines adapter.

```kotlin
implementation("com.divpundir.mavlink:adapter-coroutines:$version")
```

The `build.gradle.kts` should look like this:

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

### Connection handling

Refer the different adapter modules for details on how to use them.

### API Docs

For the API docs, please refer the [KDoc](https://divyanshupundir.github.io/mavlink-kotlin/).

---

## Supported By

### [JetBrains Open Source Support](https://jb.gg/OpenSourceSupport)

![JetBrains Open Source Support](https://resources.jetbrains.com/storage/products/company/brand/logos/jb_beam.svg)
