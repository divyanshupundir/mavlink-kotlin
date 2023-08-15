import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.mavenpublish) apply false
    alias(libs.plugins.dokka)
}

allprojects {

    tasks.withType<JavaCompile>().configureEach {
        sourceCompatibility = Config.javaVersion.toString()
        targetCompatibility = Config.javaVersion.toString()
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = Config.javaVersion.toString()
        }
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
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
                url.set("https://github.com/divyanshupundir/mavlink-kotlin/")

                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("repo")
                    }
                }

                scm {
                    url.set("https://github.com/divyanshupundir/mavlink-kotlin/")
                    connection.set("scm:git:git://github.com/divyanshupundir/mavlink-kotlin.git")
                    developerConnection.set("scm:git:ssh://git@github.com/divyanshupundir/mavlink-kotlin.git")
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
        ":definitions:publish",
        ":connections:connection-core:publish",
        ":connections:connection-tcp:publish",
        ":connections:connection-udp:publish",
        ":adapters:adapter-rxjava2:publish",
        ":adapters:adapter-rxjava3:publish",
        ":adapters:adapter-coroutines:publish"
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
        ":definitions:closeAndReleaseRepository",
        ":connections:connection-core:closeAndReleaseRepository",
        ":connections:connection-tcp:closeAndReleaseRepository",
        ":connections:connection-udp:closeAndReleaseRepository",
        ":adapters:adapter-rxjava2:closeAndReleaseRepository",
        ":adapters:adapter-rxjava3:closeAndReleaseRepository",
        ":adapters:adapter-coroutines:closeAndReleaseRepository"
    )
}

task("createGitTag") {
    doLast {
        val tagName = "v${Config.Plugin.releaseVersion}"
        exec { commandLine("git", "tag", tagName) }
        exec { commandLine("git", "push", "origin", tagName) }
    }
}
