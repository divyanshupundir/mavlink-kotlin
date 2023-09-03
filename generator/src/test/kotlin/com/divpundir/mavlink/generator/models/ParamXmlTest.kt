package com.divpundir.mavlink.generator.models

import com.divpundir.mavlink.generator.createXmlMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ParamXmlTest {

    private val mapper = createXmlMapper()

    @Test
    fun withContent() {
        val inp = "<param index=\"7\" label=\"Engine Cut-off\" units=\"ds\" minValue=\"0\" increment=\"1\">Main engine cut-off time before camera trigger. (0 means no cut-off)</param>"

        val expected = ParamModel(
            index = 7,
            label = "Engine Cut-off",
            units = "ds",
            content = "Main engine cut-off time before camera trigger. (0 means no cut-off)"
        )

        val actual = mapper.readValue(inp, ParamXml::class.java).toModel()

        assertEquals(expected, actual)
    }

    @Test
    fun withoutLabel() {
        val inp = "<param index=\"7\" units=\"ds\" minValue=\"0\" increment=\"1\">Main engine cut-off time before camera trigger. (0 means no cut-off)</param>"

        val expected = ParamModel(
            index = 7,
            label = null,
            units = "ds",
            content = "Main engine cut-off time before camera trigger. (0 means no cut-off)"
        )

        val actual = mapper.readValue(inp, ParamXml::class.java).toModel()

        assertEquals(expected, actual)
    }
}
