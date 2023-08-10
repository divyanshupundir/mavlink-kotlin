import com.vanniktech.maven.publish.KotlinJvm

version = Config.Lib.developmentVersion

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
