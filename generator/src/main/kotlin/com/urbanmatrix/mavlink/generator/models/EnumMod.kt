package com.urbanmatrix.mavlink.generator.models

data class EnumMod(
    val name: String,
    val entries: List<EnumEntryMod>,
    val deprecated: DeprecatedMod?,
    val description: String?
)
