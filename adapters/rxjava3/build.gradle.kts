import com.vanniktech.maven.publish.KotlinJvm

plugins {
    kotlin("jvm")
    id("com.vanniktech.maven.publish.base")
}

version = Config.Lib.developmentVersion

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

dependencies {
    implementation(project(":mavlink-kotlin"))
    api(Deps.ReactiveX.rxJava3)

    testImplementation(project(":definitions"))
    testImplementation(TestDeps.Jupiter.api)
    testRuntimeOnly(TestDeps.Jupiter.engine)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinJvm())
}
