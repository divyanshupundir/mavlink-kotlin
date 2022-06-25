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


    generatedSourcesDir = file("src/main/kotlin-gen")
}

idea {
    module {
        sourceDirs.plusAssign(file("src/main/kotlin-gen"))
        generatedSourceDirs.plusAssign(file("src/main/kotlin-gen"))
    }
}

dependencies {
    implementation(Deps.mavlinkKotlinApi)
    implementation(Deps.mavlinkKotlinSerialization)

    testImplementation(TestDeps.jupiterApi)
    testRuntimeOnly(TestDeps.jupiterEngine)
}
