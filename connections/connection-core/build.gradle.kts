import com.vanniktech.maven.publish.KotlinMultiplatform

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.atomicfu)
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.dokka)
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
    watchosArm32()
    watchosArm64()
    watchosX64()
    watchosSimulatorArm64()
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

mavenPublishing {
    configure(KotlinMultiplatform())
}
