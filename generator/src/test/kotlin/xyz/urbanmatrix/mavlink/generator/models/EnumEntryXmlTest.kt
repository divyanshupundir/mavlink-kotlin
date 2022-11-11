package xyz.urbanmatrix.mavlink.generator.models

import org.junit.jupiter.api.Test
import xyz.urbanmatrix.mavlink.generator.createXmlMapper

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

        println(mapper.readValue(inp, EnumEntryXml::class.java).toModel())
    }

    @Test
    fun withoutParam() {
        val inp = """
        <entry value="1" name="HL_FAILURE_FLAG_GPS">
            <description>GPS failure.</description>
        </entry>
        """.trimIndent()

        println(mapper.readValue(inp, EnumEntryXml::class.java).toModel())
    }
}