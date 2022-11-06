package xyz.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.MavBitmaskValue
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.generator.models.FieldModel
import java.math.BigInteger

fun FieldModel.generateConstructorParameter(enumHelper: EnumHelper) = ParameterSpec
    .builder(formattedName, resolveKotlinType(enumHelper))
    .defaultValue(defaultKotlinValue(enumHelper))
    .apply { if (content != null) addKdoc(content!!.replace("%", "%%")) }
    .build()

fun FieldModel.generateProperty(enumHelper: EnumHelper) = PropertySpec
    .builder(formattedName, resolveKotlinType(enumHelper))
    .initializer(formattedName)
    .addAnnotation(generateGeneratedAnnotation())
    .build()

fun FieldModel.generateBuilderProperty(enumHelper: EnumHelper) = PropertySpec
    .builder(formattedName, resolveKotlinType(enumHelper))
    .mutable()
    .initializer(defaultKotlinValue(enumHelper))
    .build()

private fun FieldModel.generateGeneratedAnnotation() = AnnotationSpec
    .builder(GeneratedMavField::class)
    .addMember("type = %S", type)
    .apply { if (extension) addMember("extension = %L", true) }
    .build()

private fun FieldModel.resolveKotlinType(enumHelper: EnumHelper): TypeName = when (this) {
    is FieldModel.Primitive -> {
        resolveKotlinPrimitiveType(this.type)
    }
    is FieldModel.PrimitiveArray -> {
        if (this.primitiveType == "char") String::class.asTypeName()
        else List::class.asTypeName().parameterizedBy(resolveKotlinPrimitiveType(this.primitiveType))
    }
    is FieldModel.Enum -> {
        val clazz = if (enumHelper.isBitmask(enumType)) MavBitmaskValue::class else MavEnumValue::class
        clazz.asTypeName().parameterizedBy(enumHelper.resolveClassName(this.enumType))
    }
}

fun FieldModel.generateSerializeStatement(outputName: String, enumHelper: EnumHelper): CodeBlock {
    val encode = CodeBlock.builder()
    when (this) {
        is FieldModel.Enum -> encode.addStatement("$outputName.%M($formattedName.value, $size)", encodeMethodName(enumHelper))
        is FieldModel.Primitive -> encode.addStatement("$outputName.%M($formattedName)", encodeMethodName(enumHelper))
        is FieldModel.PrimitiveArray -> encode.addStatement("$outputName.%M($formattedName, $size)", encodeMethodName(enumHelper))
    }
    return encode.build()
}

fun FieldModel.generateDeserializeStatement(inputName: String, enumHelper: EnumHelper): CodeBlock {
    val decode = CodeBlock.builder()
    when (this) {
        is FieldModel.Enum -> {
            decode.beginControlFlow(
                "val $formattedName = $inputName.%M($size).let { value ->",
                decodeMethodName(enumHelper)
            )
            decode.addStatement("val entry = ${CaseFormat.fromSnake(enumType).toUpperCamel()}.getEntryFromValueOrNull(value)")
            decode.addStatement("if (entry != null) %1T.of(entry) else %1T.fromValue(value)", MavEnumValue::class)
            decode.endControlFlow()
        }

        is FieldModel.Primitive -> decode.addStatement("val $formattedName = $inputName.%M()", decodeMethodName(enumHelper))

        is FieldModel.PrimitiveArray -> decode.addStatement("val $formattedName = $inputName.%M($size)", decodeMethodName(enumHelper))
    }
    return decode.build()
}

private fun resolveKotlinPrimitiveType(primitiveType: String): TypeName = when (primitiveType) {
    "uint8_t_mavlink_version", "uint8_t", "int8_t",
    "uint16_t", "int16_t", "int32_t" -> Int::class.asTypeName()
    "uint32_t", "int64_t" -> Long::class.asTypeName()
    "uint64_t" -> BigInteger::class.asTypeName()
    "float" -> Float::class.asTypeName()
    "double" -> Double::class.asTypeName()
    "char" -> Char::class.asTypeName()
    else -> throw IllegalArgumentException("Unknown field type: $primitiveType")
}

private fun FieldModel.defaultKotlinValue(enumHelper: EnumHelper): String = when (this) {
    is FieldModel.Primitive -> when (this.type) {
        "uint8_t_mavlink_version", "uint8_t", "int8_t",
        "uint16_t", "int16_t", "int32_t" -> "0"

        "uint32_t", "int64_t" -> "0L"
        "uint64_t" -> "${BigInteger::class.simpleName}.ZERO"
        "float" -> "0F"
        "double" -> "0.0"
        "char" -> "''"
        else -> throw IllegalArgumentException("Unknown field type: ${this.type}")
    }

    is FieldModel.PrimitiveArray -> if (this.primitiveType == "char") "\"\"" else "emptyList()"

    is FieldModel.Enum -> "${if (enumHelper.isBitmask(this.enumType)) MavBitmaskValue::class.simpleName else MavEnumValue::class.simpleName}.fromValue(0)"
}

private const val SERIALIZATION_PACKAGE = "xyz.urbanmatrix.mavlink.serialization"

private fun FieldModel.encodeMethodName(enumHelper: EnumHelper): MemberName = when (this) {
    is FieldModel.Enum -> MemberName(
        SERIALIZATION_PACKAGE,
        if (enumHelper.isBitmask(enumType)) "encodeBitmaskValue" else "encodeEnumValue"
    )

    is FieldModel.Primitive -> when (type) {
        "int8_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeInt8")
        "uint8_t_mavlink_version", "uint8_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeUint8")
        "int16_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeInt16")
        "uint16_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeUint16")
        "int32_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeInt32")
        "uint32_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeUint32")
        "int64_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeInt64")
        "uint64_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeUint64")
        "float" -> MemberName(SERIALIZATION_PACKAGE, "encodeFloat")
        "double" -> MemberName(SERIALIZATION_PACKAGE, "encodeDouble")
        "char" -> MemberName(SERIALIZATION_PACKAGE, "encodeChar")
        else -> throw IllegalArgumentException("Unknown type: $type")
    }

    is FieldModel.PrimitiveArray -> when (primitiveType) {
        "int8_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeInt8Array")
        "uint8_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeUint8Array")
        "int16_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeInt16Array")
        "uint16_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeUint16Array")
        "int32_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeInt32Array")
        "uint32_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeUint32Array")
        "int64_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeInt64Array")
        "uint64_t" -> MemberName(SERIALIZATION_PACKAGE, "encodeUint64Array")
        "float" -> MemberName(SERIALIZATION_PACKAGE, "encodeFloatArray")
        "double" -> MemberName(SERIALIZATION_PACKAGE, "encodeDoubleArray")
        "char" -> MemberName(SERIALIZATION_PACKAGE, "encodeString")
        else -> throw IllegalArgumentException("Unknown type: $primitiveType")
    }
}

private fun FieldModel.decodeMethodName(enumHelper: EnumHelper): MemberName = when (this) {
    is FieldModel.Enum -> MemberName(
        SERIALIZATION_PACKAGE,
        if (enumHelper.isBitmask(enumType)) "decodeBitmaskValue" else "decodeEnumValue"
    )

    is FieldModel.Primitive -> when (type) {
        "int8_t" -> MemberName(SERIALIZATION_PACKAGE, "decodeInt8")
        "uint8_t_mavlink_version", "uint8_t" -> MemberName(SERIALIZATION_PACKAGE, "decodeUint8")
        "int16_t" -> MemberName(SERIALIZATION_PACKAGE, "decodeInt16")
        "uint16_t" -> MemberName(SERIALIZATION_PACKAGE, "decodeUint16")
        "int32_t" -> MemberName(SERIALIZATION_PACKAGE, "decodeInt32")
        "uint32_t" -> MemberName(SERIALIZATION_PACKAGE, "decodeUint32")
        "int64_t" -> MemberName(SERIALIZATION_PACKAGE, "decodeInt64")
        "uint64_t" -> MemberName(SERIALIZATION_PACKAGE, "decodeUint64")
        "float" -> MemberName(SERIALIZATION_PACKAGE, "decodeFloat")
        "double" -> MemberName(SERIALIZATION_PACKAGE, "decodeDouble")
        "char" -> MemberName(SERIALIZATION_PACKAGE, "decodeChar")
        else -> throw IllegalArgumentException("Unknown type: $type")
    }

    is FieldModel.PrimitiveArray -> when (primitiveType) {
        "int8_t" -> MemberName(SERIALIZATION_PACKAGE, "decodeInt8Array")
        "uint8_t" -> MemberName(SERIALIZATION_PACKAGE, "decodeUint8Array")
        "int16_t" -> MemberName(SERIALIZATION_PACKAGE, "decodeInt16Array")
        "uint16_t" -> MemberName(SERIALIZATION_PACKAGE, "decodeUint16Array")
        "int32_t" -> MemberName(SERIALIZATION_PACKAGE, "decodeInt32Array")
        "uint32_t" -> MemberName(SERIALIZATION_PACKAGE, "decodeUint32Array")
        "int64_t" -> MemberName(SERIALIZATION_PACKAGE, "decodeInt64Array")
        "uint64_t" -> MemberName(SERIALIZATION_PACKAGE, "decodeUint64Array")
        "float" -> MemberName(SERIALIZATION_PACKAGE, "decodeFloatArray")
        "double" -> MemberName(SERIALIZATION_PACKAGE, "decodeDoubleArray")
        "char" -> MemberName(SERIALIZATION_PACKAGE, "decodeString")
        else -> throw IllegalArgumentException("Unknown type: $primitiveType")
    }
}
