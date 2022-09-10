import com.vanniktech.maven.publish.KotlinJvm

plugins {
    kotlin("jvm")
    id("${Specs.group}.generator") version Specs.Plugin.releaseVersion
    idea
    id("com.vanniktech.maven.publish.base")
}

version = Specs.Lib.developmentVersion

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

val genSrcDir = file("src/main/kotlin-gen")

tasks.getByName<xyz.urbanmatrix.mavlink.generator.plugin.MavlinkGeneratorTask>("generateMavlink") {
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

sourceSets.getByName("main") {
    java.srcDir(genSrcDir)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(Deps.mavlinkKotlinApi)
    implementation(Deps.mavlinkKotlinSerialization)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinJvm())
}
