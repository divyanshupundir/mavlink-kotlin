package com.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.urbanmatrix.mavlink.generator.models.MessageModel
import com.urbanmatrix.mavlink.generator.models.TypeModel

fun MessageModel.generateFileSpec(packageName: String): FileSpec {
    val message = TypeSpec.classBuilder(CaseFormat.fromSnake(name).toUpperCamel())
        .addModifiers(KModifier.DATA)
        .addType(generateCompanionObject())
        .apply {
            if (deprecated != null) addAnnotation(deprecated.generateAnnotationSpec())
            if (description != null) addKdoc(description)
        }
        .build()

    return FileSpec.builder(packageName, CaseFormat.fromSnake(name).toUpperCamel())
        .addType(message)
        .build()
}

fun MessageModel.generateCompanionObject(): TypeSpec {
    return TypeSpec.companionObjectBuilder()
        .addProperty(
            PropertySpec.builder("CRC", Int::class, KModifier.PRIVATE, KModifier.CONST)
                .initializer("%L", crc)
                .build()
        )
        .build()
}

val MessageModel.crc: Int
    get() {
        val crc = CrcX25().apply {
            accumulate("$name ")
        }

        fields
            .asSequence()
            .sorted()
            .filter { !it.extension }
            .onEach { crc.accumulate(it.type.name + " ") }
            .onEach { crc.accumulate(it.name + " ") }
            .map { it.type }
            .filterIsInstance<TypeModel.ArrayTypeModel>()
            .toList()
            .forEach { crc.accumulate(it.arrayLength) }

        return crc.get() and 0xFF
    }
