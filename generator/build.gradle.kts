plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.gradlepublish)
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
        testSourceDirs.plusAssign(file("build/generated/sources"))
        generatedSourceDirs.plusAssign(file("build/generated/sources"))
    }
}

@Suppress("UnstableApiUsage")
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

    implementation(libs.jackson.dataformatxml)
    implementation(libs.jackson.modulekotlin)
    implementation(libs.kotlinpoet)

    testImplementation(testlibs.jupiter.api)
    testRuntimeOnly(testlibs.jupiter.engine)
}
