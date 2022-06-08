package com.urbanmatrix.mavlink.generator.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class MavlinkGeneratorTask : DefaultTask() {

    @OutputDirectory
    lateinit var generatedSourcesDir: File

    private val definitions = mutableSetOf<File>()

    fun include(file: File){
        definitions.add(file)
    }

    @TaskAction
    fun generate() {
        if (definitions.isEmpty())
            throw IllegalStateException("No XML definition provided.")

        for (def in definitions) if (!def.isFile)
            throw IllegalStateException("$def is not a file.")

        if (!this::generatedSourcesDir.isInitialized)
            throw IllegalStateException("No generated source directory provided.")

        if (!generatedSourcesDir.isDirectory)
            throw IllegalStateException("Generated sources directory should be a directory.")

        if (generatedSourcesDir.exists() && !generatedSourcesDir.deleteRecursively())
            throw IllegalStateException("Cannot delete generated sources directory.")

        if (!generatedSourcesDir.mkdirs())
            throw IllegalStateException("Cannot create generated sources directory.")

        val mavlinkModels = definitions.map { MavlinkDefinitionParser.parse(it) }
    }
}
