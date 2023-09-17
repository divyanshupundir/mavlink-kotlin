# generator

## Overview

MAVLink generator Gradle Plugin that uses the `api` and `serialization` modules to generate the MAVLink classes. This
plugin is available at Gradle Plugin Portal with ID `com.divpundir.mavlink.generator`. It can be used by anyone to
generate MAVLink classes from their own XML files. No need to fork this project.

## Usage

Declare the plugin.

```kotlin
plugins {
    id("com.divpundir.mavlink.generator") version version
}
```

Include the `api` and `serialization` artifacts as a dependencies so that the generated code has access to the API
classes.

```kotlin
dependencies {
    implementation("com.divpundir.mavlink:api:$version")
    implementation("com.divpundir.mavlink:serialization:$version")
}
```

Define the `generateMavlink` task by providing the dialect XML files using the `include` method and provide the path to
the generated sources directory using `generatedSourcesDir`. If your dialect depends on other dialect files, i.e. 
includes other dialects, then add them to the generation task as well and the standard dialects, messages and enums.

```kotlin
tasks.getByName<com.divpundir.mavlink.generator.plugin.MavlinkGeneratorTask>("generateMavlink") {
    include(file("mavlink/message_definitions/v1.0/minimal.xml"))
    include(file("mavlink/message_definitions/v1.0/common.xml"))
    include(file("mavlink/message_definitions/v1.0/customDialect.xml"))
    
    generatedSourcesDir = "src/main/kotlin-gen"
}
```

Add the generated sources to the build path and build the project.

```kotlin
sourceSets.getByName("main") {
    java.srcDir("src/main/kotlin-gen")
}
```

You can now publish these definition files to your private maven repository and use them as a replacement for the
`definitions` module in your project.
