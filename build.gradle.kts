import com.vanniktech.maven.publish.MavenPublishBaseExtension
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import javax.inject.Inject

interface InjectedExecOps {
    @get:Inject val execOps: org.gradle.process.ExecOperations
}

plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlinx.atomicfu) apply false
    alias(libs.plugins.maven.publish) apply false
    alias(libs.plugins.dokka)
}

allprojects {
    tasks.withType<JavaCompile>().configureEach {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
    }

    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }

    plugins.withId("com.vanniktech.maven.publish.base") {
        configure<MavenPublishBaseExtension> {
            publishToMavenCentral(automaticRelease = true)
            signAllPublications()

            pom {
                name.set(project.name)
                description.set("A modern MAVLink library for the JVM written in Kotlin.")
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

tasks.register("publishPlugin") {
    dependsOn(
        ":api:publish",
        ":serialization:publish",
        ":generator:publishPlugins"
    )
}

tasks.register("publishLibrary") {
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

tasks.register("createGitTag") {
    val injected = project.objects.newInstance<InjectedExecOps>()
    doLast {
        val tagName = "v${Config.Plugin.releaseVersion}"
        injected.execOps.exec { commandLine("git", "tag", tagName) }
        injected.execOps.exec { commandLine("git", "push", "origin", tagName) }
    }
}
