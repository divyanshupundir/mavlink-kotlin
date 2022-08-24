import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

allprojects {
    group = Specs.group
    version = Specs.Lib.devlopmentVersion

    repositories {
        mavenCentral()
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/urbanmatrix/mavlink-kotlin")
                credentials {
                    username = System.getenv("GITHUB_ACTOR")
                    password = System.getenv("GITHUB_TOKEN")
                }
            }
        }
    }
}

subprojects {
    tasks.withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_1_8.toString()
        targetCompatibility = JavaVersion.VERSION_1_8.toString()
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}

task("publishPlugin") {
    dependsOn(
        ":api:publish",
        ":serialization:publish",
        ":generator:publish",
    )
}

task("publishLibrary") {
    dependsOn(
        ":mavlink-kotlin:publish",
        ":definitions:publish",
        ":adapters:rxjava2:publish",
        ":adapters:rxjava3:publish"
    )
}
