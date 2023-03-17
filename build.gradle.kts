import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("com.vanniktech:gradle-maven-publish-plugin:0.24.0")
    }
}

plugins {
    kotlin("jvm")
}

apply(plugin = "com.vanniktech.maven.publish.base")

allprojects {
    group = Config.group

    tasks.withType<JavaCompile> {
        sourceCompatibility = Config.javaVersion.toString()
        targetCompatibility = Config.javaVersion.toString()
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = Config.javaVersion.toString()
        }
    }

    @Suppress("UnstableApiUsage")
    plugins.withId("com.vanniktech.maven.publish.base") {
        configure<MavenPublishBaseExtension> {
            publishToMavenCentral(SonatypeHost.S01)
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
                        id.set("divyanshupundir")
                        name.set("Divyanshu Pundir")
                        url.set("https://github.com/divyanshupundir/")
                    }
                }
            }
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
        ":adapters:rxjava3:publish",
        ":adapters:coroutines:publish"
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
        ":adapters:rxjava3:closeAndReleaseRepository",
        ":adapters:coroutines:closeAndReleaseRepository"
    )
}

task("createGitTag") {
    doLast {
        val tagName = "v${Config.Plugin.releaseVersion}"
        exec { commandLine("git", "tag", tagName) }
        exec { commandLine("git", "push", "origin", tagName) }
    }
}
