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
    api("com.divpundir.mavlink:api:$version")
    implementation("com.divpundir.mavlink:serialization:$version")
}
```

Configure the `generateMavlink` task by providing the dialect XML files using the `include` method and provide the path
to the generated sources directory using `generatedSourcesDir`. If your dialect depends on other dialect files, i.e. 
includes other dialects, then add them to the generation task as well and the standard dialects, messages and enums.

One thing to note is that the order in which the dialects are included is important. If a dialect depends on another,
add the dependent later. For example, if `customDialect.xml` depends on `common.xml`, then include `common.xml` first.
Similarly, since `common.xml` depends on `standard.xml`, include `standard.xml` before it, which in turn depends on
`minimal.xml`.

```kotlin
tasks.generateMavlink {
    include(file("mavlink/message_definitions/v1.0/minimal.xml"))
    include(file("mavlink/message_definitions/v1.0/standard.xml"))
    include(file("mavlink/message_definitions/v1.0/common.xml"))
    include(file("mavlink/message_definitions/v1.0/customDialect.xml"))
    
    generatedSourcesDir = file("src/main/kotlin")
}
```

The reason for this is that the generator will generate the classes in the order they are included. If a dialect depends
on another, the dependent dialect is included later so that the generator can resolve the classes it depends on.

You can now publish these definition files to your private maven repository and use them as a replacement for the
`definitions` module in your project.
