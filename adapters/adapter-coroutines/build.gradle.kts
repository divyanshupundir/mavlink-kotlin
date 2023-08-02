import com.vanniktech.maven.publish.KotlinJvm

version = Config.Lib.developmentVersion

dependencies {
    api(Deps.Kotlin.coroutines)
    implementation(project(":connections:connection-core"))

    testImplementation(project(":definitions"))
    testImplementation(project(":connections:connection-tcp"))
    testImplementation(project(":connections:connection-udp"))

    testImplementation(TestDeps.Jupiter.api)
    testRuntimeOnly(TestDeps.Jupiter.engine)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinJvm())
}
