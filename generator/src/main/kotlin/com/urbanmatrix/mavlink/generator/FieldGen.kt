package com.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asClassName
import com.urbanmatrix.mavlink.generator.models.FieldModel
import com.urbanmatrix.mavlink.generator.models.TypeModel
import java.math.BigInteger

fun FieldModel.generateConstructorParameter(enumResolver: EnumResolver) {

}

fun FieldModel.resolveType(enumResolver: EnumResolver) {
    when (this) {
        is FieldModel.EnumFieldModel -> when(this.type) {
            is TypeModel.UnitTypeModel -> TODO()
            is TypeModel.ArrayTypeModel -> TODO()
        }

        is FieldModel.ValueFieldModel -> when(this.type) {
            is TypeModel.UnitTypeModel -> TODO()
            is TypeModel.ArrayTypeModel -> TODO()
        }
    }
}

val FieldModel.ValueFieldModel.kotlinType: TypeName
    get() {
        return when(type) {
            is TypeModel.UnitTypeModel -> primitiveType
            is TypeModel.ArrayTypeModel -> List::class.asClassName().parameterizedBy(primitiveType)
        }
    }

val FieldModel.ValueFieldModel.primitiveType: TypeName
    get() {
        return when (type.name) {
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
