package com.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.generator.models.FieldModel
import com.urbanmatrix.mavlink.generator.models.MessageModel

fun MessageModel.generateMessageFile(packageName: String): FileSpec {
    val message = TypeSpec.classBuilder(CaseFormat.fromSnake(name).toUpperCamel())
        .addModifiers(KModifier.DATA)
        .addSuperinterface(MavMessage::class.asClassName().parameterizedBy(simpleClassName))
        .addType(generateCompanionObject())
        .apply {
            if (deprecated != null) addAnnotation(deprecated.generateAnnotation())
            if (description != null) addKdoc(description)
        }
        .addProperty(generateInstanceMetadata())
        .addFunction(generateSerialize())
        .build()

    return FileSpec.builder(packageName, CaseFormat.fromSnake(name).toUpperCamel())
        .addType(message)
        .build()
}

fun MessageModel.generateCompanionObject() = TypeSpec
    .companionObjectBuilder()
    .addProperty(generateIdProperty())
    .addProperty(generateCrcProperty())
    .addProperty(generateDeserializer())
    .addProperty(generateMetadataProperty())
    .addProperty(generateClassMetadata())
    .build()

fun MessageModel.generateIdProperty() = PropertySpec
    .builder("ID", Int::class, KModifier.PRIVATE, KModifier.CONST)
    .initializer("%L", id)
    .build()

fun MessageModel.generateCrcProperty() = PropertySpec
    .builder("CRC", Int::class, KModifier.PRIVATE, KModifier.CONST)
    .initializer("%L", crc)
    .build()

fun MessageModel.generateDeserializer() = PropertySpec
    .builder(
        "DESERIALIZER",
        MavDeserializer::class.asClassName().parameterizedBy(simpleClassName),
        KModifier.PRIVATE
    )
    .initializer("MavDeserializer { TODO() }")
    .build()

fun MessageModel.generateMetadataProperty() = PropertySpec
    .builder(
        "METADATA",
        MavMessage.Metadata::class.asClassName().parameterizedBy(simpleClassName),
        KModifier.PRIVATE
    )
    .initializer("%T(ID, CRC, DESERIALIZER)", MavMessage.Metadata::class)
    .build()

fun MessageModel.generateClassMetadata() = PropertySpec
    .builder(
        "classMetadata",
        MavMessage.Metadata::class.asClassName().parameterizedBy(simpleClassName)
    )
    .initializer("METADATA")
    .build()

fun MessageModel.generateInstanceMetadata() = PropertySpec
    .builder(
        "instanceMetadata",
        MavMessage.Metadata::class.asClassName().parameterizedBy(simpleClassName),
        KModifier.OVERRIDE
    )
    .initializer("METADATA")
    .build()

fun MessageModel.generateSerialize() = FunSpec
    .builder("serialize")
    .addModifiers(KModifier.OVERRIDE)
    .returns(ByteArray::class)
    .addCode("TODO()")
    .build()

val MessageModel.simpleClassName: ClassName
    get() = ClassName("", CaseFormat.fromSnake(name).toUpperCamel())

val MessageModel.crc: Int
    get() {
        val crc = CrcX25().apply {
            accumulate("$name ")
        }

        fields
            .asSequence()
            .sorted()
            .filter { !it.extension }
            .onEach { crc.accumulate(it.type + " ") }
            .onEach { crc.accumulate(it.name + " ") }
            .filterIsInstance<FieldModel.PrimitiveArray>()
            .toList()
            .forEach { crc.accumulate(it.arrayLength) }

        return crc.get() and 0xFF
    }
