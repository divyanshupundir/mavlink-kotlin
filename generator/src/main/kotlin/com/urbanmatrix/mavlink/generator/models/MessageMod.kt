package com.urbanmatrix.mavlink.generator.models

data class MessageMod(
    val id: Int,
    val name: String,
    val fields: List<FieldMod>,
    val workInProgress: Boolean,
    val deprecated: DeprecatedMod?,
    val description: String?
)
