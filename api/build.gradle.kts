import com.vanniktech.maven.publish.KotlinJvm

version = Config.Plugin.developmentVersion

dependencies {
    implementation(Deps.Kotlin.immutableCollections)

    testImplementation(TestDeps.Jupiter.api)
    testRuntimeOnly(TestDeps.Jupiter.engine)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinJvm())
}
