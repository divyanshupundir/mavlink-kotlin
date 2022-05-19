package com.urbanmatrix.mavlink.generator.models

import org.junit.jupiter.api.Test

class FieldXmlTest {

    private val mapper = createXmlMapper()

    @Test
    fun fieldXml() {
        val inpList = listOf(
            "<field type=\"char\" name=\"lat\" units=\"degE7\">Latitude of SW corner of first grid</field>",
            "<field type=\"float\" name=\"lon\" units=\"degE7\">Longitude of SW corner of first grid</field>",
            "<field type=\"double\" name=\"grid_spacing\" units=\"m\">Grid spacing</field>",
            "<field type=\"uint8_t_mavlink_version\" name=\"mask\" display=\"bitmask\" print_format=\"0x%07x\">Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits)</field>",
            "<field type=\"uint8_t\" name=\"lat\" units=\"degE7\">Latitude of SW corner of first grid</field>",
            "<field type=\"uint16_t\" name=\"lon\" units=\"degE7\">Longitude of SW corner of first grid</field>",
            "<field type=\"uint32_t\" name=\"grid_spacing\" units=\"m\">Grid spacing</field>",
            "<field type=\"uint64_t\" name=\"gridbit\">bit within the terrain request mask</field>",
            "<field type=\"char[16]\" name=\"data\" units=\"m\">Terrain data MSL</field>",
            "<field type=\"float[16]\" name=\"id\" instance=\"true\">Battery ID</field>",
            "<field type=\"double[16]\" name=\"battery_function\" enum=\"MAV_BATTERY_FUNCTION\">Function of the battery</field>",
            "<field type=\"uint8_t_mavlink_version[16]\" name=\"type\" enum=\"MAV_BATTERY_TYPE\">Type (chemistry) of the battery</field>",
            "<field type=\"uint8_t[16]\" name=\"temperature\" units=\"cdegC\" invalid=\"INT16_MAX\">Temperature of the battery. INT16_MAX for unknown temperature.</field>",
            "<field type=\"uint16_t[16]\" name=\"voltages\" units=\"mV\" invalid=\"[UINT16_MAX]\">Battery voltage of cells 1 to 10 (see voltages_ext for cells 11-14). Cells in this field above the valid cell count for this battery should have the UINT16_MAX value. If individual cell voltages are unknown or not measured for this battery, then the overall battery voltage should be filled in cell 0, with all others set to UINT16_MAX. If the voltage of the battery is greater than (UINT16_MAX - 1), then cell 0 should be set to (UINT16_MAX - 1), and cell 1 to the remaining voltage. This can be extended to multiple cells if the total voltage is greater than 2 * (UINT16_MAX - 1).</field>",
            "<field type=\"uint32_t[16]\" name=\"current_battery\" units=\"cA\" invalid=\"-1\">Battery current, -1: autopilot does not measure the current</field>",
            "<field type=\"uint64_t[16]\" name=\"current_consumed\" units=\"mAh\" invalid=\"-1\">Consumed charge, -1: autopilot does not provide consumption estimate</field>",
        )

        for (inp in inpList) {
            val mod = mapper.readValue(inp, FieldXml::class.java).getTypeMod()
            println("${mod.name}\t${mod.unitLength}\t${if (mod is TypeMod.ArrayTypeMod) mod.arrayLength else null}")
        }
    }
}