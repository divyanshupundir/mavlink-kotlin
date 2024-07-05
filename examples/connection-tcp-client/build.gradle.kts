plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = Config.group
version = Config.Lib.developmentVersion

dependencies {
    implementation(project(":definitions"))
    implementation(project(":connections:connection-tcp"))
    implementation(project(":adapters:adapter-coroutines"))
}
