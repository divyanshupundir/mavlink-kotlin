import com.vanniktech.maven.publish.KotlinMultiplatform

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.dokka)
}

group = Config.group
version = Config.Lib.developmentVersion

kotlin {
    explicitApi()

    jvm()

    sourceSets {
        commonMain {
            dependencies {
                api(Config.Plugin.releaseApi)
                api(project(":connections:connection-core"))
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(project(":definitions"))
            }
        }
    }
}

mavenPublishing {
    configure(KotlinMultiplatform())
}
