package com.urbanmatrix.mavlink.generator.models

data class EnumEntryMod(
    val value: Int,
    val name: String,
    val params: List<ParamMod>,
    val deprecated: DeprecatedMod?,
    val description: String?
)
