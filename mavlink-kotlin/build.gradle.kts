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

    implementation(Deps.MavlinkKotlin.serialization)
    implementation(Deps.okio)

    testImplementation(project(":definitions"))
    testImplementation(TestDeps.DroneFleet.mavlink)

    testImplementation(TestDeps.Jupiter.api)
    testRuntimeOnly(TestDeps.Jupiter.engine)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinJvm())
}
