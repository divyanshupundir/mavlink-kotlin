plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

gradlePlugin {
    plugins {
        create("mavlinkGenerator") {
            id = "com.urbanmatrix.mavlink.generator"
            implementationClass = "com.urbanmatrix.mavlink.generator.MavlinkGeneratorPlugin"
        }
    }
}

dependencies {
    implementation(Deps.orgJson)

    testImplementation(TestDeps.jupiterApi)
    testRuntimeOnly(TestDeps.jupiterEngine)
}
