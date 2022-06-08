package com.urbanmatrix.mavlink.generator.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class MavlinkGeneratorPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.tasks.create(
            "generateMavlink",
            MavlinkGeneratorTask::class.java
        )

        target.tasks
            .getByName("compileJava")
            .dependsOn("generateMavlink")
    }
}
