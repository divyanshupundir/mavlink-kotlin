import com.vanniktech.maven.publish.KotlinJvm

version = Config.Lib.developmentVersion

dependencies {
    api(Deps.ReactiveX.rxJava2)
    implementation(project(":connections:connection-core"))

    testImplementation(project(":definitions"))
    testImplementation(project(":connections:connection-tcp"))

    testImplementation(TestDeps.Jupiter.api)
    testRuntimeOnly(TestDeps.Jupiter.engine)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinJvm())
}
