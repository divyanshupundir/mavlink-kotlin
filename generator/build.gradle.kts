plugins {
    kotlin("jvm")
    `java-gradle-plugin`
    idea
    id("maven-publish")
    id("com.gradle.plugin-publish") version "1.0.0-rc-1"
}

version = Specs.Plugin.developmentVersion

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

idea {
    module {
        testSourceDirs.plusAssign(file("build/generated/sources"))
        generatedSourceDirs.plusAssign(file("build/generated/sources"))
    }
}

pluginBundle {
    website = "https://github.com/urbanmatrix/mavlink-kotlin"
    vcsUrl = "https://github.com/urbanmatrix/mavlink-kotlin"
    tags = listOf("mavlink", "kotlin", "jvm", "generator")
}

gradlePlugin {
    plugins {
        create("mavlinkGenerator") {
            id = "${Specs.group}.generator"
            displayName = "MAVLink Kotlin Generator"
            description = "Plugin for generating Kotlin implementation of MAVLink dialects."
            implementationClass = "xyz.urbanmatrix.mavlink.generator.plugin.MavlinkGeneratorPlugin"
        }
    }
}

dependencies {
    implementation(gradleApi())
    implementation(project(":api"))
    implementation(project(":serialization"))

    implementation(Deps.jacksonDataFormatXml)
    implementation(Deps.jacksonModuleKotlin)
    implementation(Deps.kotlinPoet)

    testImplementation(TestDeps.jupiterApi)
    testRuntimeOnly(TestDeps.jupiterEngine)
}
