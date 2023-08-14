import com.vanniktech.maven.publish.KotlinJvm

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.mavenpublish)
}

group = Config.group
version = Config.Lib.developmentVersion

kotlin {
    explicitApi()
}

dependencies {
    api(Config.Plugin.releaseApi)
    api(libs.okio)

    implementation(Config.Plugin.releaseSerialization)

    testImplementation(project(":definitions"))
    testImplementation(testlibs.dronefleet.mavlink)

    testImplementation(testlibs.jupiter.api)
    testRuntimeOnly(testlibs.jupiter.engine)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinJvm())
}
