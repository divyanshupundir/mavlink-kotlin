plugins {
    kotlin("jvm")
    `java-gradle-plugin`
    id("maven-publish")
    id("com.gradle.plugin-publish") version "0.18.0"
}

version = Specs.Plugin.version

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

pluginBundle {
    website = "https://github.com/urbanmatrix/mavlink-kotlin"
    vcsUrl = "https://github.com/urbanmatrix/mavlink-kotlin"
    tags = listOf("mavlink", "kotlin", "jvm", "generator")
}

gradlePlugin {
    plugins {
        create("mavlinkGenerator") {
            id = "com.urbanmatrix.mavlink.generator"
            displayName = "Mavlink Kotlin Generator"
            description = "This plugin is in the development stage. Feel free to contribute."
            implementationClass = "com.urbanmatrix.mavlink.generator.MavlinkGeneratorPlugin"
        }
    }
}

publishing {
    repositories {
        maven {
            name = "localPluginRepository"
            url = uri("../build/localPluginRepository")
        }
    }
}

dependencies {
    implementation(gradleApi())

    implementation(Deps.jacksonDataFormatXml)
    implementation(Deps.jacksonModuleKotlin)

    testImplementation(TestDeps.jupiterApi)
    testRuntimeOnly(TestDeps.jupiterEngine)
}
