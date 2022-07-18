buildscript {
    dependencies {
        classpath("${Specs.group}:generator:${Specs.Plugin.releaseVersion}")
    }
}

plugins {
    kotlin("jvm")
    id("${Specs.group}.generator") version Specs.Plugin.releaseVersion
    idea
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

val genSrcDir = file("src/main/kotlin-gen")

tasks.getByName<com.urbanmatrix.mavlink.generator.plugin.MavlinkGeneratorTask>("generateMavlink") {
    include(file("mavlink/message_definitions/v1.0/minimal.xml"))
    include(file("mavlink/message_definitions/v1.0/common.xml"))
    include(file("mavlink/message_definitions/v1.0/ardupilotmega.xml"))
    include(file("mavlink/message_definitions/v1.0/ASLUAV.xml"))
    include(file("mavlink/message_definitions/v1.0/AVSSUAS.xml"))
    include(file("mavlink/message_definitions/v1.0/icarous.xml"))
    include(file("mavlink/message_definitions/v1.0/matrixpilot.xml"))
    include(file("mavlink/message_definitions/v1.0/paparazzi.xml"))
    include(file("mavlink/message_definitions/v1.0/standard.xml"))
    include(file("mavlink/message_definitions/v1.0/ualberta.xml"))
    include(file("mavlink/message_definitions/v1.0/uAvionix.xml"))

    generatedSourcesDir = genSrcDir
}

idea {
    module {
        sourceDirs.plus(genSrcDir)
        generatedSourceDirs.plus(genSrcDir)
    }
}

dependencies {
    implementation(Deps.mavlinkKotlinApi)
    implementation(Deps.mavlinkKotlinSerialization)
    implementation(Deps.mavlinkKotlinDefinitions)

    testImplementation(TestDeps.jupiterApi)
    testRuntimeOnly(TestDeps.jupiterEngine)
}
