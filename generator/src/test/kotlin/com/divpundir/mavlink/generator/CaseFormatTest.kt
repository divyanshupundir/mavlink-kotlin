package com.divpundir.mavlink.generator

import org.junit.jupiter.api.Test

class CaseFormatTest {

    @Test
    fun fromWords() {
        assert(CaseFormat.fromWords("mavlink", "kotlin").words == listOf("mavlink", "kotlin"))
        assert(CaseFormat.fromWords("Mavlink", "Kotlin").words == listOf("mavlink", "kotlin"))
    }

    @Test
    fun fromDelimited() {
        assert(CaseFormat.fromDelimited("mavlink.kotlin", ".").words == listOf("mavlink", "kotlin"))
        assert(CaseFormat.fromDelimited("Mavlink.Kotlin", ".").words == listOf("mavlink", "kotlin"))
    }

    @Test
    fun fromSnake() {
        assert(CaseFormat.fromSnake("mavlink_kotlin").words == listOf("mavlink", "kotlin"))
        assert(CaseFormat.fromSnake("Mavlink_Kotlin").words == listOf("mavlink", "kotlin"))
    }

    @Test
    fun fromKebab() {
        assert(CaseFormat.fromKebab("mavlink-kotlin").words == listOf("mavlink", "kotlin"))
        assert(CaseFormat.fromKebab("Mavlink-Kotlin").words == listOf("mavlink", "kotlin"))
    }

    @Test
    fun fromCamel() {
        assert(CaseFormat.fromCamel("mavlinkKotlin").words == listOf("mavlink", "kotlin"))
        assert(CaseFormat.fromCamel("MavlinkKotlin").words == listOf("mavlink", "kotlin"))
    }

    @Test
    fun toTitle() {
        assert(CaseFormat.fromWords("mavlink", "kotlin").toTitle() == "Mavlink Kotlin")
    }

    @Test
    fun toLowerSnake() {
        assert(CaseFormat.fromWords("mavlink", "kotlin").toLowerSnake() == "mavlink_kotlin")
    }

    @Test
    fun toUpperSnake() {
        assert(CaseFormat.fromWords("mavlink", "kotlin").toUpperSnake() == "MAVLINK_KOTLIN")
    }

    @Test
    fun toLowerKebab() {
        assert(CaseFormat.fromWords("mavlink", "kotlin").toLowerKebab() == "mavlink-kotlin")
    }

    @Test
    fun toUpperKebab() {
        assert(CaseFormat.fromWords("mavlink", "kotlin").toUpperKebab() == "MAVLINK-KOTLIN")
    }

    @Test
    fun toLowerCamel() {
        assert(CaseFormat.fromWords("mavlink", "kotlin").toLowerCamel() == "mavlinkKotlin")
    }

    @Test
    fun toUpperCamel() {
        assert(CaseFormat.fromWords("mavlink", "kotlin").toUpperCamel() == "MavlinkKotlin")
    }
}
