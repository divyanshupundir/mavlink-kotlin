package com.urbanmatrix.mavlink.generator.models

sealed class Type(name: String, unitLength: Int) {

    data class UnitType(val name: String, val unitLength: Int) : Type(name, unitLength)

    data class ArrayType(val name: String, val unitLength: Int, val arrayLength: Int) : Type(name, unitLength)
}
