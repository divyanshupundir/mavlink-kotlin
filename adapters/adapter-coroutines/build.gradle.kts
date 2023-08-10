import com.vanniktech.maven.publish.KotlinJvm

version = Config.Lib.developmentVersion

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
