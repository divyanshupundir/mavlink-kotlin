package com.urbanmatrix.mavlink.generator.models

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.junit.jupiter.api.Test

class DeprecatedXmlTest {

    private val mapper = XmlMapper.builder()
        .defaultUseWrapper(false)
        .build()
        .registerKotlinModule()

    @Test
    fun withContent() {
        val inp = "<deprecated since=\"2020-01\" replaced_by=\"MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE\">This message has been superseded by MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE. The message can still be used to communicate with legacy gimbals implementing it.</deprecated>"
        println(mapper.readValue(inp, DeprecatedXml::class.java).toMod())
    }

    @Test
    fun emptyContent() {
        val inp = "<deprecated since=\"2020-01\" replaced_by=\"MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE\"></deprecated>"
        println(mapper.readValue(inp, DeprecatedXml::class.java).toMod())
    }

    @Test
    fun withoutContent() {
        val inp = "<deprecated since=\"2020-01\" replaced_by=\"MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE\"/>"
        println(mapper.readValue(inp, DeprecatedXml::class.java).toMod())
    }
}
