import com.vanniktech.maven.publish.KotlinJvm

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.mavenpublish)
}

group = Config.group
version = Config.Plugin.developmentVersion

kotlin {
    explicitApi()
}

dependencies {
    testImplementation(testlibs.jupiter.api)
    testRuntimeOnly(testlibs.jupiter.engine)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinJvm())
}
