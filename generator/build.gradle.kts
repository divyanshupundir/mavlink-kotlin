plugins {
    kotlin("jvm")
    `java-gradle-plugin`
    idea
    id("maven-publish")
    id("com.gradle.plugin-publish") version "0.18.0"
}

version = Specs.version

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

idea {
    module {
        testSourceDirs.plusAssign(file("build/generated"))
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
            id = "com.urbanmatrix.mavlink.generator"
            displayName = "Mavlink Kotlin Generator"
            description = "This plugin is in the development stage. Feel free to contribute."
            implementationClass = "com.urbanmatrix.mavlink.generator.plugin.MavlinkGeneratorPlugin"
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
    implementation(Deps.mavlinkKotlinApi)
    implementation(Deps.mavlinkKotlinSerialization)

    implementation(Deps.jacksonDataFormatXml)
    implementation(Deps.jacksonModuleKotlin)
    implementation(Deps.kotlinPoet)

    testImplementation(TestDeps.jupiterApi)
    testRuntimeOnly(TestDeps.jupiterEngine)
}
