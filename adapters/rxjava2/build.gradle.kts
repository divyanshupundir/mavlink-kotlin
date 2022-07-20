plugins {
    kotlin("jvm")
    `maven-publish`
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

dependencies {
    implementation(project(":mavlink-kotlin"))
    api(Deps.rxJava2)

    testImplementation(TestDeps.jupiterApi)
    testRuntimeOnly(TestDeps.jupiterEngine)
}
