package com.divpundir.mavlink.generator

import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.generator.models.FieldModel
import com.divpundir.mavlink.generator.models.MessageModel
import com.divpundir.mavlink.generator.models.sortedByPosition
import com.divpundir.mavlink.serialization.CrcX25
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy

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
        .addProperty(generateInstanceCompanion(packageName))
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
    .addSuperinterface(MavMessage.MavCompanion::class.asClassName().parameterizedBy(getClassName(packageName)))
    .addProperty(generateSizeV1Property())
    .addProperty(generateSizeV2Property())
    .addProperty(generateIdProperty())
    .addProperty(generateCrcExtraProperty())
    .addFunction(generateDeserializeMethod(packageName, enumHelper))
    .addFunction(generateBuilderFunction(packageName))
    .build()

private fun MessageModel.generateGeneratedAnnotation() = AnnotationSpec
    .builder(GeneratedMavMessage::class)
    .addMember("id = %Lu", id)
    .addMember("crcExtra = %L", crcExtra)
    .build()

private fun MessageModel.generateSizeV1Property() = PropertySpec
    .builder("SIZE_V1", Int::class, KModifier.PRIVATE, KModifier.CONST)
    .initializer("%L", sizeV1)
    .build()

private fun MessageModel.generateSizeV2Property() = PropertySpec
    .builder("SIZE_V2", Int::class, KModifier.PRIVATE, KModifier.CONST)
    .initializer("%L", sizeV2)
    .build()

private fun MessageModel.generateIdProperty() = PropertySpec
    .builder("id", UInt::class, KModifier.OVERRIDE)
    .initializer("%Lu", id)
    .build()

private fun MessageModel.generateCrcExtraProperty() = PropertySpec
    .builder("crcExtra", Byte::class, KModifier.OVERRIDE)
    .initializer("%L", crcExtra)
    .build()

private fun MessageModel.generateDeserializeMethod(packageName: String, enumHelper: EnumHelper) = FunSpec
    .builder("deserialize")
    .addModifiers(KModifier.OVERRIDE)
    .addParameter(ParameterSpec("bytes", ByteArray::class.asTypeName()))
    .returns(getClassName(packageName))
    .addCode(
        buildCodeBlock {
            val decoderName = if (fields.none { it.name == "decoder" }) "decoder" else "_decoder"
            addStatement("val $decoderName = %T.wrap(bytes)", MavDataDecoder::class)
            addStatement("")
            fields.sorted().forEach { add(it.generateDeserializeStatement(decoderName, enumHelper)) }
            addStatement("")
            addStatement("return %T(", getClassName(packageName))
            indent()
            fields.sortedByPosition().forEach { add("${it.formattedName} = ${it.formattedName},\n") }
            unindent()
            addStatement(")")
        }
    )
    .build()

private fun MessageModel.generateInstanceCompanion(packageName: String) = PropertySpec
    .builder(
        "instanceCompanion",
        MavMessage.MavCompanion::class.asClassName().parameterizedBy(getClassName(packageName)),
        KModifier.OVERRIDE
    )
    .initializer("Companion")
    .build()

private fun MessageModel.generateSerializeV1(enumHelper: EnumHelper) = FunSpec
    .builder("serializeV1")
    .addModifiers(KModifier.OVERRIDE)
    .returns(ByteArray::class)
    .addCode(
        buildCodeBlock {
            val encoderName = if (fields.none { it.name == "encoder" }) "encoder" else "_encoder"
            addStatement("val $encoderName = %T.allocate(SIZE_V1)", MavDataEncoder::class)
            fields.filter { !it.extension }.sorted().forEach { add(it.generateSerializeStatement(encoderName, enumHelper)) }
            addStatement("return $encoderName.bytes")
        }
    )
    .build()

private fun MessageModel.generateSerializeV2(enumHelper: EnumHelper) = FunSpec
    .builder("serializeV2")
    .addModifiers(KModifier.OVERRIDE)
    .returns(ByteArray::class)
    .addCode(
        buildCodeBlock {
            val encoderName = if (fields.none { it.name == "encoder" }) "encoder" else "_encoder"
            addStatement("val $encoderName = %T.allocate(SIZE_V2)", MavDataEncoder::class)
            fields.sorted().forEach { add(it.generateSerializeStatement(encoderName, enumHelper)) }
            addStatement("return $encoderName.bytes.%M()", truncateZerosMemberName)
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

private fun MessageModel.generateBuilderFunction(packageName: String) = FunSpec.builder("invoke")
    .addModifiers(KModifier.OPERATOR)
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
