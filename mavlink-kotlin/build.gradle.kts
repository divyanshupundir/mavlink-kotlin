import com.vanniktech.maven.publish.KotlinJvm

plugins {
    kotlin("jvm")
    id("com.vanniktech.maven.publish.base")
}

version = Config.Lib.developmentVersion

kotlin {
    explicitApi()
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    api(Deps.MavlinkKotlin.api)
    api(Deps.MavlinkKotlin.serialization)

    implementation("com.squareup.okio:okio:3.3.0")

    testImplementation(project(":definitions"))
    testImplementation(TestDeps.DroneFleet.mavlink)

    testImplementation(TestDeps.Jupiter.api)
    testRuntimeOnly(TestDeps.Jupiter.engine)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinJvm())
}
