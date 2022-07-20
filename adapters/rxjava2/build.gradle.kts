plugins {
    kotlin("jvm")
    `maven-publish`
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

dependencies {
    testImplementation(TestDeps.jupiterApi)
    testRuntimeOnly(TestDeps.jupiterEngine)
}
