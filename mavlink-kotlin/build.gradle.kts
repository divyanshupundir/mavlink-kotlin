import com.urbanmatrix.mavlink.generator.MavlinkGeneratorTask

buildscript {
    dependencies {
        classpath("com.urbanmatrix.mavlink:generator:0.0.1")
    }
}

plugins {
    kotlin("jvm")
    id("com.urbanmatrix.mavlink.generator") version "0.0.1"
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}


tasks.getByName<MavlinkGeneratorTask>("generateMavlink") {
    generatedSourcesDir = file("build/mavlink")
}

dependencies {
    testImplementation(TestDeps.jupiterApi)
    testRuntimeOnly(TestDeps.jupiterEngine)
}
