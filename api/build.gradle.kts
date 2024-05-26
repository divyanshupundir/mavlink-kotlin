import com.vanniktech.maven.publish.KotlinMultiplatform

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.dokka)
}

group = Config.group
version = Config.Plugin.developmentVersion

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
                implementation(libs.kotlinx.collections.immutable)
            }
        }
    }
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinMultiplatform())
}
