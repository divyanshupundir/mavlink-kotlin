package com.divpundir.mavlink.generator.models

import com.divpundir.mavlink.generator.createXmlMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeprecatedXmlTest {

    private val mapper = createXmlMapper()

    @Test
    fun withContent() {
        val inp = "<deprecated since=\"2020-01\" replaced_by=\"MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE\">This message has been superseded by MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE. The message can still be used to communicate with legacy gimbals implementing it.</deprecated>"

        val expected = DeprecatedModel(
            since = "2020-01",
            replacedBy = "MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE",
            content = "This message has been superseded by MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE. The message can still be used to communicate with legacy gimbals implementing it."
        )

        val actual = mapper.readValue(inp, DeprecatedXml::class.java).toModel()

        assertEquals(expected, actual)
    }

    @Test
    fun emptyContent() {
        val inp = "<deprecated since=\"2020-01\" replaced_by=\"MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE\"></deprecated>"

        val expected = DeprecatedModel(
            since = "2020-01",
            replacedBy = "MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE",
            content = null
        )

        val actual = mapper.readValue(inp, DeprecatedXml::class.java).toModel()

        assertEquals(expected, actual)

    }

    @Test
    fun withoutContent() {
        val inp = "<deprecated since=\"2020-01\" replaced_by=\"MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE\"/>"

        val expected = DeprecatedModel(
            since = "2020-01",
            replacedBy = "MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE",
            content = null
        )

        val actual = mapper.readValue(inp, DeprecatedXml::class.java).toModel()

        assertEquals(expected, actual)
    }
}
