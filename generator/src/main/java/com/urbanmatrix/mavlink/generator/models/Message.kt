package com.urbanmatrix.mavlink.generator.models

data class Message(
    val id: Int,
    val name: String,
    val fields: List<Field>,
    val workInProgress: Boolean,
    val deprecated: Deprecated?,
    val description: String?
)
