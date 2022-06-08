package com.urbanmatrix.mavlink.generator.models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MavlinkXmlTest {

    val mapper = createXmlMapper()

    @Test
    fun common() {
        val inp = Thread.currentThread().contextClassLoader.getResourceAsStream("common.xml")
        println(mapper.readValue(inp, MavlinkXml::class.java).toModel("common"))
    }

    @Test
    fun ardupilotmega() {
        val inp = Thread.currentThread().contextClassLoader.getResourceAsStream("ardupilotmega.xml")
        println(mapper.readValue(inp, MavlinkXml::class.java).toModel("ardupilotmega"))
    }
}
