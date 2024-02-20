package com.divpundir.mavlink.generator.models

import com.divpundir.mavlink.generator.createXmlMapper
import org.junit.jupiter.api.Test

class DialectXmlTest {

    private val mapper = createXmlMapper()

    @Test
    fun common() {
        val inp = Thread.currentThread().contextClassLoader.getResourceAsStream("common.xml")
        val model = mapper.readValue(inp, DialectXml::class.java).toModel("common")
        model.messages
            .flatMap { it.fields }
            .forEach {
                when (it) {
                    is FieldModel.Enum -> {}
                    is FieldModel.Primitive -> println(it.type)
                    is FieldModel.PrimitiveArray -> println(it.primitiveType)
                }
            }
    }

    @Test
    fun ardupilotmega() {
        val inp = Thread.currentThread().contextClassLoader.getResourceAsStream("ardupilotmega.xml")
        println(mapper.readValue(inp, DialectXml::class.java).toModel("ardupilotmega"))
    }
}
