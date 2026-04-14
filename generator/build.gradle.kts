plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.gradle.publish)
    alias(libs.plugins.dokka)
    idea
    `java-gradle-plugin`
    `maven-publish`
}

group = Config.group
version = Config.Plugin.developmentVersion

kotlin {
    explicitApi()
}

idea {
    module {
        testSources.from(file("build/generated/sources"))
        generatedSourceDirs.plusAssign(file("build/generated/sources"))
    }
}

gradlePlugin {
    website.set("https://github.com/divyanshupundir/mavlink-kotlin")
    vcsUrl.set("https://github.com/divyanshupundir/mavlink-kotlin")

    plugins {
        create("mavlinkGenerator") {
            id = "${Config.group}.generator"
            displayName = "MAVLink Kotlin Generator"
            description = "Plugin for generating Kotlin implementation of MAVLink dialects."
            tags.set(listOf("mavlink", "kotlin", "jvm", "generator"))
            implementationClass = "com.divpundir.mavlink.generator.plugin.MavlinkGeneratorPlugin"
        }
    }
}

dependencies {
    implementation(gradleApi())

    implementation(project(":api"))
    implementation(project(":serialization"))

    implementation(libs.jackson.dataformat.xml)
    implementation(libs.jackson.module.kotlin)
    implementation(libs.kotlinpoet)

    testImplementation(testlibs.jupiter.api)
    testRuntimeOnly(testlibs.jupiter.engine)
    testRuntimeOnly(testlibs.jupiter.launcher)
}
