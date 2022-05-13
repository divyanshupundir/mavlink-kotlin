package com.urbanmatrix.mavlink.generator.models

data class Mavlink(
    val name: String,
    val includes: List<String>,
    val version: Int,
    val dialect: Int,
    val enums: List<EnumXml>,
    val messages: List<Message>
)
