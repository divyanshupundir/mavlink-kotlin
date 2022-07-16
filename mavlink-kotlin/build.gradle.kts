plugins {
    kotlin("jvm")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

dependencies {
    implementation(Deps.mavlinkKotlinApi)
    implementation(Deps.mavlinkKotlinSerialization)

    testImplementation(TestDeps.jupiterApi)
    testRuntimeOnly(TestDeps.jupiterEngine)
}
