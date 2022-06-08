package com.urbanmatrix.mavlink.generator.models

import com.urbanmatrix.mavlink.generator.createXmlMapper
import org.junit.jupiter.api.Test

class MavlinkXmlTest {

    private val mapper = createXmlMapper()

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
