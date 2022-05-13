package com.urbanmatrix.mavlink.generator.models

data class EnumXml(
    val name: String,
    val entries: List<EnumEntry>,
    val deprecated: Deprecated?,
    val description: String?
)
