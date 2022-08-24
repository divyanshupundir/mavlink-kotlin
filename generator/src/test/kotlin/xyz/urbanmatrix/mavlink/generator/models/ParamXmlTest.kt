package xyz.urbanmatrix.mavlink.generator.models

import xyz.urbanmatrix.mavlink.generator.createXmlMapper
import org.junit.jupiter.api.Test

class ParamXmlTest {

    private val mapper = createXmlMapper()

    @Test
    fun withContent() {
        val inp = "<param index=\"7\" label=\"Engine Cut-off\" units=\"ds\" minValue=\"0\" increment=\"1\">Main engine cut-off time before camera trigger. (0 means no cut-off)</param>"
        println(mapper.readValue(inp, ParamXml::class.java).toModel())
    }

    @Test
    fun withoutLabel() {
        val inp = "<param index=\"7\" units=\"ds\" minValue=\"0\" increment=\"1\">Main engine cut-off time before camera trigger. (0 means no cut-off)</param>"
        println(mapper.readValue(inp, ParamXml::class.java).toModel())
    }
}
