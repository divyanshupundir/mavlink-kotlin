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
    api(libs.kotlinx.coroutines)
    implementation(project(":connections:connection-core"))

    testImplementation(project(":definitions"))
    testImplementation(project(":connections:connection-tcp"))
    testImplementation(project(":connections:connection-udp"))

    testImplementation(testlibs.jupiter.api)
    testRuntimeOnly(testlibs.jupiter.engine)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinJvm())
}
