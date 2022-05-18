package com.urbanmatrix.mavlink.generator.models

data class MavlinkMod(
    val name: String,
    val includes: List<String>,
    val version: Int,
    val dialect: Int,
    val enums: List<EnumMod>,
    val messages: List<MessageMod>
)
