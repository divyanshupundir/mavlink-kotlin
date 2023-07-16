import com.vanniktech.maven.publish.KotlinJvm

version = Config.Plugin.developmentVersion

dependencies {
    testImplementation(TestDeps.Jupiter.api)
    testRuntimeOnly(TestDeps.Jupiter.engine)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinJvm())
}
