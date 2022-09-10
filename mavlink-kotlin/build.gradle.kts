plugins {
    kotlin("jvm")
    id("com.vanniktech.maven.publish.base")
}

version = Specs.Lib.developmentVersion

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

dependencies {
    api(Deps.mavlinkKotlinApi)
    api(Deps.mavlinkKotlinSerialization)

    testImplementation(project(":definitions"))
    testImplementation(TestDeps.droneFleetMavlink)

    testImplementation(TestDeps.jupiterApi)
    testRuntimeOnly(TestDeps.jupiterEngine)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(com.vanniktech.maven.publish.KotlinJvm())
}
