buildscript {
    dependencies {
//        classpath("${Specs.group}:generator:${Specs.releaseVersion}")
    }
}

plugins {
    kotlin("jvm")
//    id("${Specs.group}.generator") version Specs.releaseVersion
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

//tasks.getByName<com.urbanmatrix.mavlink.generator.plugin.MavlinkGeneratorTask>("generateMavlink") {
//    generatedSourcesDir = file("build/mavlink")
//}

dependencies {
    implementation(Deps.mavlinkKotlinApi)
    implementation(Deps.mavlinkKotlinSerialization)

    testImplementation(TestDeps.jupiterApi)
    testRuntimeOnly(TestDeps.jupiterEngine)
}
