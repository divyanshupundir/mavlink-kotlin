buildscript {
    dependencies {
        classpath("${Specs.group}:generator:${Specs.version}")
    }
}

plugins {
    kotlin("jvm")
    id("${Specs.group}.generator") version Specs.version
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.getByName<com.urbanmatrix.mavlink.generator.MavlinkGeneratorTask>("generateMavlink") {
    generatedSourcesDir = file("build/mavlink")
}

dependencies {
    testImplementation(TestDeps.jupiterApi)
    testRuntimeOnly(TestDeps.jupiterEngine)
}
