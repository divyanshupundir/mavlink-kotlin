package com.urbanmatrix.mavlink.generator.plugin

import com.urbanmatrix.mavlink.generator.EnumResolver
import com.urbanmatrix.mavlink.generator.generateDialectFile
import com.urbanmatrix.mavlink.generator.generateEnumFile
import com.urbanmatrix.mavlink.generator.generateMessageFile
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.io.IOException

abstract class MavlinkGeneratorTask : DefaultTask() {

    companion object {
        private const val BASE_PACKAGE = "com.urbanmatrix.mavlink"
    }

    @OutputDirectory
    lateinit var generatedSourcesDir: File

    private val definitions = mutableSetOf<File>()

    fun include(file: File) {
        definitions += file
    }

    fun includeDir(dir: File) {
        definitions += dir.listFiles()!!.toSet()
    }

    @TaskAction
    fun generate() {
        if (definitions.isEmpty())
            throw IllegalArgumentException("No XML definition provided.")

        for (def in definitions) if (!def.isFile)
            throw IllegalArgumentException("Not a file: $def")

        for (def in definitions) if (def.extension != "xml")
            throw IllegalArgumentException("Not a mavlink definition file: $def")

        if (!this::generatedSourcesDir.isInitialized)
            throw IllegalArgumentException("No generated source directory provided.")

        if (!generatedSourcesDir.isDirectory)
            throw IllegalArgumentException("Generated sources directory should be a directory.")

        if (generatedSourcesDir.exists() && !generatedSourcesDir.deleteRecursively())
            throw IllegalArgumentException("Cannot delete generated sources directory.")

        if (!generatedSourcesDir.mkdirs())
            throw IllegalArgumentException("Cannot create generated sources directory.")

        val mavlinkModels = definitions.map {
            try {
                MavlinkDefinitionParser.parse(it)
            } catch (e: IOException) {
                throw IllegalArgumentException("Invalid mavlink schema: $it")
            }
        }

        val enumResolver = EnumResolver(BASE_PACKAGE, mavlinkModels)

        for (model in mavlinkModels) {
            model
                .generateDialectFile(BASE_PACKAGE)
                .writeTo(generatedSourcesDir)

            for (enum in model.enums) {
                enum
                    .generateEnumFile("$BASE_PACKAGE.${model.name}")
                    .writeTo(generatedSourcesDir)
            }

            for (message in model.messages) {
                message
                    .generateMessageFile("$BASE_PACKAGE.${model.name}", enumResolver)
                    .writeTo(generatedSourcesDir)
            }
        }
    }
}
