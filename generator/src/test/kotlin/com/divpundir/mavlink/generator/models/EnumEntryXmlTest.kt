package com.divpundir.mavlink.generator.models

import org.junit.jupiter.api.Test
import com.divpundir.mavlink.generator.createXmlMapper
import org.gradle.internal.impldep.org.junit.Assert.assertEquals

class EnumEntryXmlTest {

    private val mapper = createXmlMapper()

    @Test
    fun withParam() {
        val inp = """
        <entry value="80" name="MAV_CMD_NAV_ROI" hasLocation="true" isDestination="false">
            <deprecated since="2018-01" replaced_by="MAV_CMD_DO_SET_ROI_*"/>
            <description>Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used by the vehicle's control system to control the vehicle attitude and the attitude of various sensors such as cameras.</description>
            <param index="1" label="ROI Mode" enum="MAV_ROI">Region of interest mode.</param>
            <param index="2" label="WP Index" minValue="0" increment="1">Waypoint index/ target ID. (see MAV_ROI enum)</param>
            <param index="3" label="ROI Index" minValue="0" increment="1">ROI index (allows a vehicle to manage multiple ROI's)</param>
            <param index="4">Empty</param>
            <param index="5" label="X">x the location of the fixed ROI (see MAV_FRAME)</param>
            <param index="6" label="Y">y</param>
            <param index="7" label="Z">z</param>
        </entry>
        """.trimIndent()

        val expected = EnumEntryModel(
            value = 80,
            name = "MAV_CMD_NAV_ROI",
            params = listOf(
                ParamModel(
                    index = 1,
                    label = "ROI Mode",
                    units = null,
                    content = "Region of interest mode."
                ),
                ParamModel(
                    index = 2,
                    label = "WP Index",
                    units = null,
                    content = "Waypoint index/ target ID. (see MAV_ROI enum)"
                ),
                ParamModel(
                    index = 3,
                    label = "ROI Index",
                    units = null,
                    content = "ROI index (allows a vehicle to manage multiple ROI's)"
                ),
                ParamModel(
                    index = 4,
                    label = null,
                    units = null,
                    content = "Empty"
                ),
                ParamModel(
                    index = 5,
                    label = "X",
                    units = null,
                    content = "x the location of the fixed ROI (see MAV_FRAME)"
                ),
                ParamModel(
                    index = 6,
                    label = "Y",
                    units = null,
                    content = "y"
                ),
                ParamModel(
                    index = 7,
                    label = "Z",
                    units = null,
                    content = "z"
                )
            ),
            workInProgress = false,
            deprecated = DeprecatedModel(
                since = "2018-01",
                replacedBy = "MAV_CMD_DO_SET_ROI_*",
                content = null
            ),
            description = "Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used by the vehicle's control system to control the vehicle attitude and the attitude of various sensors such as cameras."
        )

        val actual = mapper.readValue(inp, EnumEntryXml::class.java).toModel()

        assertEquals(expected, actual)
    }

    @Test
    fun withoutParam() {
        val inp = """
        <entry value="1" name="HL_FAILURE_FLAG_GPS">
            <description>GPS failure.</description>
        </entry>
        """.trimIndent()

        val expected = EnumEntryModel(
            value = 1,
            name = "HL_FAILURE_FLAG_GPS",
            params = emptyList(),
            workInProgress = false,
            deprecated = null,
            description = "GPS failure."
        )

        val actual = mapper.readValue(inp, EnumEntryXml::class.java).toModel()

        assertEquals(expected, actual)
    }
}