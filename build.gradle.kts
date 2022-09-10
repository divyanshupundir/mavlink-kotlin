import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("com.vanniktech:gradle-maven-publish-plugin:0.22.0")
    }
}

plugins {
    kotlin("jvm")
}

apply(plugin = "com.vanniktech.maven.publish.base")

allprojects {
    group = Specs.group

    repositories {
        mavenCentral()
    }

    @Suppress("UnstableApiUsage")
    plugins.withId("com.vanniktech.maven.publish.base") {
        configure<com.vanniktech.maven.publish.MavenPublishBaseExtension> {
            publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.S01)
            signAllPublications()

            pom {
                description.set("A modern MAVLink library for the JVM written in Kotlin.")
                name.set(project.name)
                inceptionYear.set("2022")
                url.set("https://github.com/urbanmatrix/mavlink-kotlin/")
                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("repo")
                    }
                }
                scm {
                    url.set("https://github.com/urbanmatrix/mavlink-kotlin/")
                    connection.set("scm:git:git://github.com/urbanmatrix/mavlink-kotlin.git")
                    developerConnection.set("scm:git:ssh://git@github.com/urbanmatrix/mavlink-kotlin.git")
                }
                developers {
                    developer {
                        id.set("divyanshu1234")
                        name.set("Divyanshu Pundir")
                        url.set("https://github.com/divyanshu1234/")
                    }
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
        ":generator:publishPlugins"

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

task("closeAndReleasePlugin") {
    dependsOn(
        ":api:closeAndReleaseRepository",
        ":serialization:closeAndReleaseRepository"
    )
}

task("closeAndReleaseLibrary") {
    dependsOn(
        ":mavlink-kotlin:closeAndReleaseRepository",
        ":definitions:closeAndReleaseRepository",
        ":adapters:rxjava2:closeAndReleaseRepository",
        ":adapters:rxjava3:closeAndReleaseRepository"
    )
}