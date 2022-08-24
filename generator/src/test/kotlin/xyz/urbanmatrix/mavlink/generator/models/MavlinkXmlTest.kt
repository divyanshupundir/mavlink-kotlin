package xyz.urbanmatrix.mavlink.generator.models

import xyz.urbanmatrix.mavlink.generator.createXmlMapper
import org.junit.jupiter.api.Test

class MavlinkXmlTest {

    private val mapper = createXmlMapper()

    @Test
    fun common() {
        val inp = Thread.currentThread().contextClassLoader.getResourceAsStream("common.xml")
        val model = mapper.readValue(inp, MavlinkXml::class.java).toModel("common")
        model.messages
            .flatMap { it.fields }
            .forEach {
                when(it) {
                    is FieldModel.Enum -> {}
                    is FieldModel.Primitive -> println(it.type)
                    is FieldModel.PrimitiveArray -> println(it.primitiveType)
                }
            }
    }

    @Test
    fun ardupilotmega() {
        val inp = Thread.currentThread().contextClassLoader.getResourceAsStream("ardupilotmega.xml")
        println(mapper.readValue(inp, MavlinkXml::class.java).toModel("ardupilotmega"))
    }
}
