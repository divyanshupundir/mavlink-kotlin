package com.urbanmatrix.mavlink.generator

import com.urbanmatrix.mavlink.generator.models.MessageXml
import org.junit.jupiter.api.Test

class MessageGenKtTest {

    private val mapper = createXmlMapper()

    @Test
    fun basic() {
        val inp = """
        <message id="123" name="GPS_INJECT_DATA">
            <description>Data for injecting into the onboard GPS (used for DGPS)</description>
            <field type="uint8_t" name="target_system">System ID</field>
            <field type="uint8_t" name="target_component">Component ID</field>
            <field type="uint8_t" name="len" units="bytes">Data length</field>
            <field type="uint8_t[110]" name="data">Raw data (110 is enough for 12 satellites of RTCMv2)</field>
        </message>
        """.trimIndent()

        val model = mapper.readValue(inp, MessageXml::class.java).toModel()
        val fileSpec = model.generateMessageFile("com.urbanmatrix.mavlink.test")

        val s = StringBuilder()
        fileSpec.writeTo(s)

        println(s)
    }
}
