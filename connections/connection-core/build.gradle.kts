import com.vanniktech.maven.publish.KotlinJvm

version = Config.Lib.developmentVersion

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
