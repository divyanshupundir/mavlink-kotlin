package com.divpundir.mavlink.generator.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

public class MavlinkGeneratorPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.tasks.register(
            "generateMavlink",
            MavlinkGeneratorTask::class.java
        )
    }
}
