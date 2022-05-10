plugins {
    kotlin("jvm")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

dependencies {
    implementation(Deps.orgJson)
    
    testImplementation(TestDeps.jupiterApi)
    testRuntimeOnly(TestDeps.jupiterEngine)
}
