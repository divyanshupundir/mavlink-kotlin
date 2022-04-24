import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
}

buildscript {
    repositories {
        mavenCentral()
    }
}

allprojects {
    group = "com.urbanmatrix.mavlink"
    version = "0.0.1"

    repositories {
        mavenCentral()
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

    dependencies {
        testImplementation(TestDeps.jupiterApi)
        testRuntimeOnly(TestDeps.jupiterEngine)
    }
}
