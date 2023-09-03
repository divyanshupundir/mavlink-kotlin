package com.divpundir.mavlink.generator

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.generator.models.DialectModel
import com.squareup.kotlinpoet.*

internal fun DialectModel.generateDialectFile(basePackageName: String): FileSpec {
    val packageName = "$basePackageName.$subPackageName"
    val dialect = TypeSpec.objectBuilder(dialectObjectName)
        .addModifiers(KModifier.DATA)
        .superclass(AbstractMavDialect::class)
        .addSuperclassConstructorParameter(generateDependencySet(basePackageName))
        .addSuperclassConstructorParameter(generateMessageMap(basePackageName))
        .addAnnotation(GeneratedMavDialect::class)
        .build()

    return FileSpec.builder(packageName, dialectObjectName)
        .addType(dialect)
        .build()
}

private fun DialectModel.generateDependencySet(basePackageName: String) = buildCodeBlock {
    addStatement("")
    indent()

    if (includes.isEmpty()) {
        add("emptySet()")
        unindent()
        return@buildCodeBlock
    }

    addStatement("setOf(")
    indent()
    includes
        .map { it.removeSuffix(".xml") }
        .map {
            ClassName(
                "$basePackageName.${it.lowercase()}",
                "${CaseFormat.fromSnake(it).toUpperCamel()}Dialect"
            )
        }
        .forEach { addStatement("%T,", it) }
    unindent()
    add(")")

    unindent()
}

private fun DialectModel.generateMessageMap(basePackageName: String) = buildCodeBlock {
    addStatement("")
    indent()

    if (messages.isEmpty()) {
        add("emptyMap()")
        unindent()
        return@buildCodeBlock
    }

    addStatement("mapOf(")
    indent()
    messages
        .map {
            ClassName(
                "$basePackageName.$subPackageName",
                it.formattedName
            )
        }
        .forEach { addStatement("%1T.id to %1T,", it) }
    unindent()
    addStatement(")")

    unindent()
}
