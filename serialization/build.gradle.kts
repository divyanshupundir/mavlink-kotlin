import com.vanniktech.maven.publish.KotlinMultiplatform

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.mavenpublish)
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
    linuxX64()
    linuxArm64()
    mingwX64()

    applyDefaultHierarchyTemplate()

    sourceSets {
        val nonJvmMain by creating {
            dependsOn(commonMain.get())
        }

        jsMain {
            dependsOn(nonJvmMain)
        }

        nativeMain {
            dependsOn(nonJvmMain)
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinMultiplatform())
}
