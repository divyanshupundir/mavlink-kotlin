package com.divpundir.mavlink.generator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.generator.models.FieldModel
import com.divpundir.mavlink.generator.models.MessageModel
import com.divpundir.mavlink.generator.models.sortedByPosition
import com.divpundir.mavlink.serialization.CrcX25
import java.nio.ByteBuffer
import java.nio.ByteOrder

internal fun MessageModel.generateMessageFile(packageName: String, enumHelper: EnumHelper): FileSpec {
    val message = TypeSpec.classBuilder(formattedName)
        .addModifiers(KModifier.DATA)
        .addSuperinterface(MavMessage::class.asClassName().parameterizedBy(getClassName(packageName)))
        .primaryConstructor(generatePrimaryConstructor(enumHelper))
        .apply { fields.sortedByPosition().forEach { addProperty(it.generateProperty(enumHelper)) } }
        .apply {
            if (deprecated != null) addAnnotation(deprecated.generateAnnotation())
            if (workInProgress) addAnnotation(WorkInProgress::class)
            if (description != null) addKdoc(description.replace("%", "%%"))
        }
        .addAnnotation(generateGeneratedAnnotation())
        .addProperty(generateInstanceMetadata(packageName))
        .addFunction(generateSerializeV1(enumHelper))
        .addFunction(generateSerializeV2(enumHelper))
        .addType(generateCompanionObject(packageName, enumHelper))
        .addType(generateBuilderClass(packageName, enumHelper))
        .build()

    return FileSpec.builder(packageName, formattedName)
        .addType(message)
        .build()
}

private fun MessageModel.generatePrimaryConstructor(enumHelper: EnumHelper) = FunSpec
    .constructorBuilder()
    .apply { fields.sortedByPosition().forEach { addParameter(it.generateConstructorParameter(enumHelper)) } }
    .build()

private fun MessageModel.generateCompanionObject(packageName: String, enumHelper: EnumHelper) = TypeSpec
    .companionObjectBuilder()
    .addProperty(generateIdProperty())
    .addProperty(generateCrcExtraProperty())
    .addProperty(generateSizeV1Property())
    .addProperty(generateSizeV2Property())
    .addProperty(generateDeserializer(packageName, enumHelper))
    .addProperty(generateMetadataProperty(packageName))
    .addProperty(generateClassMetadata(packageName))
    .addFunction(generateBuilderFunction(packageName))
    .build()

private fun MessageModel.generateGeneratedAnnotation() = AnnotationSpec
    .builder(GeneratedMavMessage::class)
    .addMember("id = %Lu", id)
    .addMember("crcExtra = %L", crcExtra)
    .build()

private fun MessageModel.generateIdProperty() = PropertySpec
    .builder("ID", UInt::class, KModifier.PRIVATE, KModifier.CONST)
    .initializer("%Lu", id)
    .build()

private fun MessageModel.generateCrcExtraProperty() = PropertySpec
    .builder("CRC_EXTRA", Byte::class, KModifier.PRIVATE, KModifier.CONST)
    .initializer("%L", crcExtra)
    .build()

private fun MessageModel.generateSizeV1Property() = PropertySpec
    .builder("SIZE_V1", Int::class, KModifier.PRIVATE, KModifier.CONST)
    .initializer("%L", sizeV1)
    .build()

private fun MessageModel.generateSizeV2Property() = PropertySpec
    .builder("SIZE_V2", Int::class, KModifier.PRIVATE, KModifier.CONST)
    .initializer("%L", sizeV2)
    .build()

private fun MessageModel.generateDeserializer(packageName: String, enumHelper: EnumHelper) = PropertySpec
    .builder(
        "DESERIALIZER",
        MavDeserializer::class.asClassName().parameterizedBy(getClassName(packageName)),
        KModifier.PRIVATE
    )
    .initializer(
        buildCodeBlock {
            beginControlFlow("%T·{ bytes ->", MavDeserializer::class)

            addStatement(
                "val inputBuffer = %T.wrap(bytes).order(%T.LITTLE_ENDIAN)",
                ByteBuffer::class,
                ByteOrder::class
            )
            fields.sorted().forEach { add(it.generateDeserializeStatement("inputBuffer", enumHelper)) }

            addStatement("")

            addStatement("%T(", getClassName(packageName))
            indent()
            fields.sortedByPosition().forEach { add("${it.formattedName} = ${it.formattedName},\n") }
            unindent()
            addStatement(")")

            endControlFlow()
        }
    )
    .build()

private fun MessageModel.generateMetadataProperty(packageName: String) = PropertySpec
    .builder(
        "METADATA",
        MavMessage.Metadata::class.asClassName().parameterizedBy(getClassName(packageName)),
        KModifier.PRIVATE
    )
    .initializer("%T(ID, CRC_EXTRA, DESERIALIZER)", MavMessage.Metadata::class)
    .build()

private fun MessageModel.generateClassMetadata(packageName: String) = PropertySpec
    .builder(
        "classMetadata",
        MavMessage.Metadata::class.asClassName().parameterizedBy(getClassName(packageName))
    )
    .initializer("METADATA")
    .build()

private fun MessageModel.generateInstanceMetadata(packageName: String) = PropertySpec
    .builder(
        "instanceMetadata",
        MavMessage.Metadata::class.asClassName().parameterizedBy(getClassName(packageName)),
        KModifier.OVERRIDE
    )
    .initializer("METADATA")
    .build()

private fun MessageModel.generateSerializeV1(enumHelper: EnumHelper) = FunSpec
    .builder("serializeV1")
    .addModifiers(KModifier.OVERRIDE)
    .returns(ByteArray::class)
    .addCode(
        buildCodeBlock {
            addStatement(
                "val outputBuffer = %T.allocate(SIZE_V1).order(%T.LITTLE_ENDIAN)",
                ByteBuffer::class,
                ByteOrder::class
            )
            fields.filter { !it.extension }.sorted().forEach { add(it.generateSerializeStatement("outputBuffer", enumHelper)) }
            addStatement("return outputBuffer.array()")
        }
    )
    .build()

private fun MessageModel.generateSerializeV2(enumHelper: EnumHelper) = FunSpec
    .builder("serializeV2")
    .addModifiers(KModifier.OVERRIDE)
    .returns(ByteArray::class)
    .addCode(
        buildCodeBlock {
            addStatement(
                "val outputBuffer = %T.allocate(SIZE_V2).order(%T.LITTLE_ENDIAN)",
                ByteBuffer::class,
                ByteOrder::class
            )
            fields.sorted().forEach { add(it.generateSerializeStatement("outputBuffer", enumHelper)) }
            addStatement("return outputBuffer.array().%M()", truncateZerosMemberName)
        }
    )
    .build()

private fun MessageModel.generateBuilderClass(packageName: String, enumHelper: EnumHelper) = TypeSpec.classBuilder("Builder")
    .apply { fields.sortedByPosition().forEach { addProperty(it.generateBuilderProperty(enumHelper)) } }
    .addFunction(generateBuildMethod(packageName))
    .build()

private fun MessageModel.generateBuildMethod(packageName: String) = FunSpec.builder("build")
    .returns(getClassName(packageName))
    .addCode(
        buildCodeBlock {
            add("return %T(\n", getClassName(packageName))
            indent()
            fields.sortedByPosition().forEach { add("${it.formattedName} = ${it.formattedName},\n") }
            unindent()
            add(")")
        }
    )
    .build()

private fun MessageModel.generateBuilderFunction(packageName: String) = FunSpec.builder("builder")
    .returns(getClassName(packageName))
    .addParameter(ParameterSpec("builderAction", LambdaTypeName.get(getClassName(packageName).nestedClass("Builder"), emptyList(), Unit::class.asTypeName())))
    .addCode("return %T().apply(builderAction).build()", getClassName(packageName).nestedClass("Builder"))
    .build()

private val MessageModel.sizeV1: Int
    get() = fields.filter { !it.extension }.sumOf { it.size }

private val MessageModel.sizeV2: Int
    get() = fields.sumOf { it.size }

private val truncateZerosMemberName = MemberName("com.divpundir.mavlink.serialization", "truncateZeros")

private fun MessageModel.getClassName(packageName: String): ClassName =
    ClassName(packageName, formattedName)

internal val MessageModel.crcExtra: Byte
    get() {
        val crc = CrcX25().apply {
            accumulate("$name ")
        }

        fields
            .asSequence()
            .sorted()
            .filter { !it.extension }
            .onEach {
                crc.accumulate(
                    it.type
                        .substringBeforeLast("_mavlink_version")
                        .substringBeforeLast("[") +
                        " "
                )
            }
            .onEach { crc.accumulate(it.name + " ") }
            .filterIsInstance<FieldModel.PrimitiveArray>()
            .forEach { crc.accumulate(it.arrayLength.toByte()) }

        val sum = crc.get().toInt()
        return ((sum and 0xFF) xor (sum shr 8)).toByte()
    }
