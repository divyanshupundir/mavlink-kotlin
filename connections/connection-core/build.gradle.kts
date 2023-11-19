import com.vanniktech.maven.publish.KotlinMultiplatform
import org.jetbrains.kotlin.gradle.tasks.CInteropProcess

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.mavenpublish)
    alias(libs.plugins.dokka)
    id("kotlinx-atomicfu")
}

group = Config.group
version = Config.Lib.developmentVersion

kotlin {
    explicitApi()

    jvm()
    js {
        browser()
        nodejs()
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    macosX64()
    macosArm64()
    linuxX64()
    linuxArm64()
    mingwX64()

    sourceSets {
        commonMain {
            dependencies {
                api(libs.okio)
                api(Config.Plugin.releaseApi)
                implementation(Config.Plugin.releaseSerialization)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(project(":definitions"))
            }
        }

        jvmTest {
            dependencies {
                implementation(testlibs.dronefleet.mavlink)
            }
        }
    }
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinMultiplatform())
}

// TODO: Remove this once the CInteropProcess bug is fixed in Kotlin 1.9.21
tasks.withType<CInteropProcess>().configureEach {
    val libraryVersionField = CInteropProcess::class.java.getDeclaredField("libraryVersion")
    libraryVersionField.isAccessible = true
    libraryVersionField.set(this, "unspecified")
}
