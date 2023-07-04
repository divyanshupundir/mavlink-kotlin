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
    api(Deps.okio)

    implementation(Deps.MavlinkKotlin.serialization)

    testImplementation(project(":definitions"))
    testImplementation(TestDeps.DroneFleet.mavlink)

    testImplementation(TestDeps.Jupiter.api)
    testRuntimeOnly(TestDeps.Jupiter.engine)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinJvm())
}
