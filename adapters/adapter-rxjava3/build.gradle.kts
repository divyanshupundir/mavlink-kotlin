import com.vanniktech.maven.publish.KotlinJvm

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.dokka)
}

group = Config.group
version = Config.Lib.developmentVersion

kotlin {
    explicitApi()
}

dependencies {
    api(libs.reactivex.rxjava3)
    implementation(project(":connections:connection-core"))

    testImplementation(project(":definitions"))
    testImplementation(project(":connections:connection-tcp"))

    testImplementation(testlibs.jupiter.api)
    testRuntimeOnly(testlibs.jupiter.engine)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinJvm())
}
