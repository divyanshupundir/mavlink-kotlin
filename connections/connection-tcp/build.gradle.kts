import com.vanniktech.maven.publish.KotlinJvm

version = Config.Lib.developmentVersion

dependencies {
    api(Config.Plugin.releaseApi)
    api(project(":connections:connection-core"))

    testImplementation(project(":definitions"))
    testImplementation(testlibs.jupiter.api)
    testRuntimeOnly(testlibs.jupiter.engine)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinJvm())
}
