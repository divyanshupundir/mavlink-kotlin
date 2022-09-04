# generator

## Overview

MAVLink generator Gradle Plugin that uses the api and serialization modules to generate the MAVLink classes. This plugin
is available at Gradle Plugin Portal with ID `xyz.urbanmatrix.mavlink.generator`. It can be used by anyone to generate
MAVLink classes from their own XML files. No need to fork this project.

## Usage

Include the mavlink-kotlin artifact as a dependency so that the generated code has access to the API classes and the
standard dialects, messages and enums.

<details open>
<summary>Gradle Kotlin</summary>

```kotlin
plugins {
  id("xyz.urbanmatrix.mavlink.generator") version "0.4.5"
}
```
</details>

<details>
<summary>Gradle Groovy</summary>

```groovy
plugins {
  id "xyz.urbanmatrix.mavlink.generator" version "0.4.5"
}
```
</details>

