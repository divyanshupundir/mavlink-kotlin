package com.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asClassName
import com.urbanmatrix.mavlink.generator.models.FieldModel
import java.math.BigInteger

fun FieldModel.generateConstructorParameter(enumResolver: EnumResolver) {

}

fun FieldModel.resolveType(enumResolver: EnumResolver) {
    when (this) {
        is FieldModel.Enum -> TODO()
        is FieldModel.Primitive -> TODO()
        is FieldModel.PrimitiveArray -> TODO()
    }
}

val FieldModel.Primitive.primitiveType: TypeName
    get() {
        return when (name) {
            "uint8_t", "int8_t", "uint16_t",
            "int16_t", "int32_t" -> Int::class.asClassName()
            "uint32_t", "int64_t" -> Long::class.asClassName()
            "uint64_t" -> BigInteger::class.asClassName()
            "float" -> Float::class.asClassName()
            "double" -> Double::class.asClassName()
            "char" -> Char::class.asClassName()
            else -> Int::class.asClassName()
        }
    }
