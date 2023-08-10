import com.vanniktech.maven.publish.KotlinJvm

plugins {
    id("com.divpundir.mavlink.generator") version Config.Plugin.releaseVersion
    idea
}

version = Config.Lib.developmentVersion

val genSrcDir = file("src/main/kotlin-gen")

tasks.getByName<com.divpundir.mavlink.generator.plugin.MavlinkGeneratorTask>("generateMavlink") {
    include(file("mavlink/message_definitions/v1.0/minimal.xml"))
    include(file("mavlink/message_definitions/v1.0/common.xml"))
    include(file("mavlink/message_definitions/v1.0/ASLUAV.xml"))
    include(file("mavlink/message_definitions/v1.0/AVSSUAS.xml"))
    include(file("mavlink/message_definitions/v1.0/icarous.xml"))
    include(file("mavlink/message_definitions/v1.0/matrixpilot.xml"))
    include(file("mavlink/message_definitions/v1.0/paparazzi.xml"))
    include(file("mavlink/message_definitions/v1.0/standard.xml"))
    include(file("mavlink/message_definitions/v1.0/ualberta.xml"))
    include(file("mavlink/message_definitions/v1.0/uAvionix.xml"))
    include(file("mavlink/message_definitions/v1.0/ardupilotmega.xml"))

    generatedSourcesDir = genSrcDir
}

sourceSets.getByName("main") {
    java.srcDir(genSrcDir)
}

dependencies {
    api(Config.Plugin.releaseApi)
    implementation(Config.Plugin.releaseSerialization)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinJvm())
}
