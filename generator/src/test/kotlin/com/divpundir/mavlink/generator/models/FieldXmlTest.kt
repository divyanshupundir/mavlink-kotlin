package com.divpundir.mavlink.generator.models

import com.divpundir.mavlink.generator.createXmlMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FieldXmlTest {

    private val mapper = createXmlMapper()

    @Test
    fun primitive() {
        val inpList = listOf(
            "<field type=\"char\" name=\"lat\" units=\"degE7\">Latitude of SW corner of first grid</field>",
            "<field type=\"float\" name=\"lon\" units=\"degE7\">Longitude of SW corner of first grid</field>",
            "<field type=\"double\" name=\"grid_spacing\" units=\"m\">Grid spacing</field>",
            "<field type=\"uint8_t_mavlink_version\" name=\"mask\" display=\"bitmask\" print_format=\"0x%07x\">Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits)</field>",
            "<field type=\"uint8_t\" name=\"lat\" units=\"degE7\">Latitude of SW corner of first grid</field>",
            "<field type=\"uint16_t\" name=\"lon\" units=\"degE7\">Longitude of SW corner of first grid</field>",
            "<field type=\"uint32_t\" name=\"grid_spacing\" units=\"m\">Grid spacing</field>",
            "<field type=\"uint64_t\" name=\"gridbit\">bit within the terrain request mask</field>",
        )

        val expectedList = listOf(
            FieldModel.Primitive(
                position = 0,
                type = "char",
                name = "lat",
                extension = false,
                display = null,
                units = "degE7",
                invalid = null,
                printFormat = null,
                content = "Latitude of SW corner of first grid",
            ),
            FieldModel.Primitive(
                position = 0,
                type = "float",
                name = "lon",
                extension = false,
                display = null,
                units = "degE7",
                invalid = null,
                printFormat = null,
                content = "Longitude of SW corner of first grid",
            ),
            FieldModel.Primitive(
                position = 0,
                type = "double",
                name = "grid_spacing",
                extension = false,
                display = null,
                units = "m",
                invalid = null,
                printFormat = null,
                content = "Grid spacing",
            ),
            FieldModel.Primitive(
                position = 0,
                type = "uint8_t_mavlink_version",
                name = "mask",
                extension = false,
                display = "bitmask",
                units = null,
                invalid = null,
                printFormat = "0x%07x",
                content = "Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits)",
            ),
            FieldModel.Primitive(
                position = 0,
                type = "uint8_t",
                name = "lat",
                extension = false,
                display = null,
                units = "degE7",
                invalid = null,
                printFormat = null,
                content = "Latitude of SW corner of first grid",
            ),
            FieldModel.Primitive(
                position = 0,
                type = "uint16_t",
                name = "lon",
                extension = false,
                display = null,
                units = "degE7",
                invalid = null,
                printFormat = null,
                content = "Longitude of SW corner of first grid",
            ),
            FieldModel.Primitive(
                position = 0,
                type = "uint32_t",
                name = "grid_spacing",
                extension = false,
                display = null,
                units = "m",
                invalid = null,
                printFormat = null,
                content = "Grid spacing",
            ),
            FieldModel.Primitive(
                position = 0,
                type = "uint64_t",
                name = "gridbit",
                extension = false,
                display = null,
                units = null,
                invalid = null,
                printFormat = null,
                content = "bit within the terrain request mask",
            ),
        )

        val actualList = inpList.map { mapper.readValue(it, FieldXml::class.java).toModel() }

        assertEquals(expectedList, actualList)
    }

    @Test
    fun primitiveArray() {
        val inpList = listOf(
            "<field type=\"char[16]\" name=\"data\" units=\"m\">Terrain data MSL</field>",
            "<field type=\"float[16]\" name=\"id\" instance=\"true\">Battery ID</field>",
            "<field type=\"double[16]\" name=\"battery_function\" enum=\"MAV_BATTERY_FUNCTION\">Function of the battery</field>",
            "<field type=\"uint8_t_mavlink_version[16]\" name=\"type\" enum=\"MAV_BATTERY_TYPE\">Type (chemistry) of the battery</field>",
            "<field type=\"uint8_t[16]\" name=\"temperature\" units=\"cdegC\" invalid=\"INT16_MAX\">Temperature of the battery. INT16_MAX for unknown temperature.</field>",
            "<field type=\"uint16_t[16]\" name=\"voltages\" units=\"mV\" invalid=\"[UINT16_MAX]\">Battery voltage of cells 1 to 10 (see voltages_ext for cells 11-14). Cells in this field above the valid cell count for this battery should have the UINT16_MAX value. If individual cell voltages are unknown or not measured for this battery, then the overall battery voltage should be filled in cell 0, with all others set to UINT16_MAX. If the voltage of the battery is greater than (UINT16_MAX - 1), then cell 0 should be set to (UINT16_MAX - 1), and cell 1 to the remaining voltage. This can be extended to multiple cells if the total voltage is greater than 2 * (UINT16_MAX - 1).</field>",
            "<field type=\"uint32_t[16]\" name=\"current_battery\" units=\"cA\" invalid=\"-1\">Battery current, -1: autopilot does not measure the current</field>",
            "<field type=\"uint64_t[16]\" name=\"current_consumed\" units=\"mAh\" invalid=\"-1\">Consumed charge, -1: autopilot does not provide consumption estimate</field>",
        )

        val expectedList = listOf(
            FieldModel.PrimitiveArray(
                primitiveType = "char",
                arrayLength = 16,
                position = 0,
                type = "char[16]",
                name = "data",
                extension = false,
                display = null,
                units = "m",
                invalid = null,
                printFormat = null,
                content = "Terrain data MSL",
            ),
            FieldModel.PrimitiveArray(
                primitiveType = "float",
                arrayLength = 16,
                position = 0,
                type = "float[16]",
                name = "id",
                extension = false,
                display = null,
                units = null,
                invalid = null,
                printFormat = null,
                content = "Battery ID",
            ),
            FieldModel.PrimitiveArray(
                primitiveType = "double",
                arrayLength = 16,
                position = 0,
                type = "double[16]",
                name = "battery_function",
                extension = false,
                display = null,
                units = null,
                invalid = null,
                printFormat = null,
                content = "Function of the battery",
            ),
            FieldModel.PrimitiveArray(
                primitiveType = "uint8_t_mavlink_version",
                arrayLength = 16,
                position = 0,
                type = "uint8_t_mavlink_version[16]",
                name = "type",
                extension = false,
                display = null,
                units = null,
                invalid = null,
                printFormat = null,
                content = "Type (chemistry) of the battery",
            ),
            FieldModel.PrimitiveArray(
                primitiveType = "uint8_t",
                arrayLength = 16,
                position = 0,
                type = "uint8_t[16]",
                name = "temperature",
                extension = false,
                display = null,
                units = "cdegC",
                invalid = "INT16_MAX",
                printFormat = null,
                content = "Temperature of the battery. INT16_MAX for unknown temperature.",
            ),
            FieldModel.PrimitiveArray(
                primitiveType = "uint16_t",
                arrayLength = 16,
                position = 0,
                type = "uint16_t[16]",
                name = "voltages",
                extension = false,
                display = null,
                units = "mV",
                invalid = "[UINT16_MAX]",
                printFormat = null,
                content = "Battery voltage of cells 1 to 10 (see voltages_ext for cells 11-14). Cells in this field above the valid cell count for this battery should have the UINT16_MAX value. If individual cell voltages are unknown or not measured for this battery, then the overall battery voltage should be filled in cell 0, with all others set to UINT16_MAX. If the voltage of the battery is greater than (UINT16_MAX - 1), then cell 0 should be set to (UINT16_MAX - 1), and cell 1 to the remaining voltage. This can be extended to multiple cells if the total voltage is greater than 2 * (UINT16_MAX - 1).",
            ),
            FieldModel.PrimitiveArray(
                primitiveType = "uint32_t",
                arrayLength = 16,
                position = 0,
                type = "uint32_t[16]",
                name = "current_battery",
                extension = false,
                display = null,
                units = "cA",
                invalid = "-1",
                printFormat = null,
                content = "Battery current, -1: autopilot does not measure the current",
            ),
            FieldModel.PrimitiveArray(
                primitiveType = "uint64_t",
                arrayLength = 16,
                position = 0,
                type = "uint64_t[16]",
                name = "current_consumed",
                extension = false,
                display = null,
                units = "mAh",
                invalid = "-1",
                printFormat = null,
                content = "Consumed charge, -1: autopilot does not provide consumption estimate",
            ),
        )

        val actualList = inpList.map { mapper.readValue(it, FieldXml::class.java).toModel() }

        assertEquals(expectedList, actualList)
    }

    @Test
    fun enum() {
        val inpList = listOf(
            "<field type=\"uint8_t\" name=\"type\" enum=\"MAV_TYPE\">Vehicle or component type. For a flight controller component the vehicle type (quadrotor, helicopter, etc.). For other components the component type (e.g. camera, gimbal, etc.). This should be used in preference to component id for identifying the component type.</field>",
            "<field type=\"uint8_t\" name=\"autopilot\" enum=\"MAV_AUTOPILOT\">Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight controllers.</field>",
            "<field type=\"uint8_t\" name=\"base_mode\" enum=\"MAV_MODE_FLAG\" display=\"bitmask\">System mode bitmap.</field>",
            "<field type=\"uint8_t\" name=\"system_status\" enum=\"MAV_STATE\">System status flag.</field>",
        )

        val expectedList = listOf(
            FieldModel.Enum(
                enumType = "MAV_TYPE",
                position = 0,
                type = "uint8_t",
                name = "type",
                extension = false,
                display = null,
                units = null,
                invalid = null,
                printFormat = null,
                content = "Vehicle or component type. For a flight controller component the vehicle type (quadrotor, helicopter, etc.). For other components the component type (e.g. camera, gimbal, etc.). This should be used in preference to component id for identifying the component type.",
            ),
            FieldModel.Enum(
                enumType = "MAV_AUTOPILOT",
                position = 0,
                type = "uint8_t",
                name = "autopilot",
                extension = false,
                display = null,
                units = null,
                invalid = null,
                printFormat = null,
                content = "Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight controllers.",
            ),
            FieldModel.Enum(
                enumType = "MAV_MODE_FLAG",
                position = 0,
                type = "uint8_t",
                name = "base_mode",
                extension = false,
                display = "bitmask",
                units = null,
                invalid = null,
                printFormat = null,
                content = "System mode bitmap.",
            ),
            FieldModel.Enum(
                enumType = "MAV_STATE",
                position = 0,
                type = "uint8_t",
                name = "system_status",
                extension = false,
                display = null,
                units = null,
                invalid = null,
                printFormat = null,
                content = "System status flag.",
            )
        )

        val actualList = inpList.map { mapper.readValue(it, FieldXml::class.java).toModel() }

        assertEquals(expectedList, actualList)
    }
}
