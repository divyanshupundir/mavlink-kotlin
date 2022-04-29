package com.urbanmatrix.mavlink.generator.models

data class EnumEntry(
    val value: Int,
    val name: String,
    val params: List<Param>,
    val deprecated: Deprecated?,
    val description: String?
)
