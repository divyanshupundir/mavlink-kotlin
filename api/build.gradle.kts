import com.vanniktech.maven.publish.KotlinJvm

version = Config.Plugin.developmentVersion

dependencies {
    implementation(libs.kotlinx.immutablecollections)

    testImplementation(testlibs.jupiter.api)
    testRuntimeOnly(testlibs.jupiter.engine)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinJvm())
}
