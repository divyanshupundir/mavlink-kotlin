package com.divpundir.mavlink.generator.models

import com.divpundir.mavlink.generator.createXmlMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EnumXmlTest {

    private val mapper = createXmlMapper()

    @Test
    fun enumXml() {
        val inp = """
        <enum name="HL_FAILURE_FLAG" bitmask="true">
            <description>Flags to report failure cases over the high latency telemtry.</description>
            <entry value="1" name="HL_FAILURE_FLAG_GPS">
                <description>GPS failure.</description>
            </entry>
            <entry value="2" name="HL_FAILURE_FLAG_DIFFERENTIAL_PRESSURE">
                <description>Differential pressure sensor failure.</description>
            </entry>
            <entry value="4" name="HL_FAILURE_FLAG_ABSOLUTE_PRESSURE">
                <description>Absolute pressure sensor failure.</description>
            </entry>
            <entry value="8" name="HL_FAILURE_FLAG_3D_ACCEL">
                <description>Accelerometer sensor failure.</description>
            </entry>
            <entry value="16" name="HL_FAILURE_FLAG_3D_GYRO">
                <description>Gyroscope sensor failure.</description>
            </entry>
            <entry value="32" name="HL_FAILURE_FLAG_3D_MAG">
                <description>Magnetometer sensor failure.</description>
            </entry>
            <entry value="64" name="HL_FAILURE_FLAG_TERRAIN">
                <description>Terrain subsystem failure.</description>
            </entry>
            <entry value="128" name="HL_FAILURE_FLAG_BATTERY">
                <description>Battery failure/critical low battery.</description>
            </entry>
            <entry value="256" name="HL_FAILURE_FLAG_RC_RECEIVER">
                <description>RC receiver failure/no rc connection.</description>
            </entry>
            <entry value="512" name="HL_FAILURE_FLAG_OFFBOARD_LINK">
                <description>Offboard link failure.</description>
            </entry>
            <entry value="1024" name="HL_FAILURE_FLAG_ENGINE">
                <description>Engine failure.</description>
            </entry>
            <entry value="2048" name="HL_FAILURE_FLAG_GEOFENCE">
                <description>Geofence violation.</description>
            </entry>
            <entry value="4096" name="HL_FAILURE_FLAG_ESTIMATOR">
                <description>Estimator failure, for example measurement rejection or large variances.</description>
            </entry>
            <entry value="8192" name="HL_FAILURE_FLAG_MISSION">
                <description>Mission failure.</description>
            </entry>
        </enum>
        """.trimIndent()

        val expected = EnumModel(
            name = "HL_FAILURE_FLAG",
            bitmask = true,
            entries = listOf(
                EnumEntryModel(
                    value = 1,
                    name = "HL_FAILURE_FLAG_GPS",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "GPS failure."
                ),
                EnumEntryModel(
                    value = 2,
                    name = "HL_FAILURE_FLAG_DIFFERENTIAL_PRESSURE",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Differential pressure sensor failure."
                ),
                EnumEntryModel(
                    value = 4,
                    name = "HL_FAILURE_FLAG_ABSOLUTE_PRESSURE",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Absolute pressure sensor failure."
                ),
                EnumEntryModel(
                    value = 8,
                    name = "HL_FAILURE_FLAG_3D_ACCEL",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Accelerometer sensor failure."
                ),
                EnumEntryModel(
                    value = 16,
                    name = "HL_FAILURE_FLAG_3D_GYRO",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Gyroscope sensor failure."
                ),
                EnumEntryModel(
                    value = 32,
                    name = "HL_FAILURE_FLAG_3D_MAG",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Magnetometer sensor failure."
                ),
                EnumEntryModel(
                    value = 64,
                    name = "HL_FAILURE_FLAG_TERRAIN",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Terrain subsystem failure."
                ),
                EnumEntryModel(
                    value = 128,
                    name = "HL_FAILURE_FLAG_BATTERY",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Battery failure/critical low battery."
                ),
                EnumEntryModel(
                    value = 256,
                    name = "HL_FAILURE_FLAG_RC_RECEIVER",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "RC receiver failure/no rc connection."
                ),
                EnumEntryModel(
                    value = 512,
                    name = "HL_FAILURE_FLAG_OFFBOARD_LINK",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Offboard link failure."
                ),
                EnumEntryModel(
                    value = 1024,
                    name = "HL_FAILURE_FLAG_ENGINE",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Engine failure."
                ),
                EnumEntryModel(
                    value = 2048,
                    name = "HL_FAILURE_FLAG_GEOFENCE",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Geofence violation."
                ),
                EnumEntryModel(
                    value = 4096,
                    name = "HL_FAILURE_FLAG_ESTIMATOR",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Estimator failure, for example measurement rejection or large variances."
                ),
                EnumEntryModel(
                    value = 8192,
                    name = "HL_FAILURE_FLAG_MISSION",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Mission failure."
                )
            ),
            deprecated = null,
            description = "Flags to report failure cases over the high latency telemtry."
        )

        val actual = mapper.readValue(inp, EnumXml::class.java).toModel()

        assertEquals(expected, actual)
    }


    @Test
    fun bitmask() {
        val inp = """
        <enum name="GIMBAL_MANAGER_CAP_FLAGS" bitmask="true">
            <description>Gimbal manager high level capability flags (bitmap). The first 16 bits are identical to the GIMBAL_DEVICE_CAP_FLAGS. However, the gimbal manager does not need to copy the flags from the gimbal but can also enhance the capabilities and thus add flags.</description>
            <entry value="1" name="GIMBAL_MANAGER_CAP_FLAGS_HAS_RETRACT">
                <description>Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_RETRACT.</description>
            </entry>
            <entry value="2" name="GIMBAL_MANAGER_CAP_FLAGS_HAS_NEUTRAL">
                <description>Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_NEUTRAL.</description>
            </entry>
            <entry value="4" name="GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_AXIS">
                <description>Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_AXIS.</description>
            </entry>
            <entry value="8" name="GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_FOLLOW">
                <description>Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_FOLLOW.</description>
            </entry>
            <entry value="16" name="GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_LOCK">
                <description>Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_LOCK.</description>
            </entry>
            <entry value="32" name="GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_AXIS">
                <description>Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_AXIS.</description>
            </entry>
            <entry value="64" name="GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_FOLLOW">
                <description>Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_FOLLOW.</description>
            </entry>
            <entry value="128" name="GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_LOCK">
                <description>Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_LOCK.</description>
            </entry>
            <entry value="256" name="GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_AXIS">
                <description>Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_AXIS.</description>
            </entry>
            <entry value="512" name="GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_FOLLOW">
                <description>Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_FOLLOW.</description>
            </entry>
            <entry value="1024" name="GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_LOCK">
                <description>Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_LOCK.</description>
            </entry>
            <entry value="2048" name="GIMBAL_MANAGER_CAP_FLAGS_SUPPORTS_INFINITE_YAW">
                <description>Based on GIMBAL_DEVICE_CAP_FLAGS_SUPPORTS_INFINITE_YAW.</description>
            </entry>
            <entry value="65536" name="GIMBAL_MANAGER_CAP_FLAGS_CAN_POINT_LOCATION_LOCAL">
                <description>Gimbal manager supports to point to a local position.</description>
            </entry>
            <entry value="131072" name="GIMBAL_MANAGER_CAP_FLAGS_CAN_POINT_LOCATION_GLOBAL">
                <description>Gimbal manager supports to point to a global latitude, longitude, altitude position.</description>
            </entry>
        </enum>
        """.trimIndent()

        val expected = EnumModel(
            name = "GIMBAL_MANAGER_CAP_FLAGS",
            bitmask = true,
            entries = listOf(
                EnumEntryModel(
                    value = 1,
                    name = "GIMBAL_MANAGER_CAP_FLAGS_HAS_RETRACT",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_RETRACT."
                ),
                EnumEntryModel(
                    value = 2,
                    name = "GIMBAL_MANAGER_CAP_FLAGS_HAS_NEUTRAL",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_NEUTRAL."
                ),
                EnumEntryModel(
                    value = 4,
                    name = "GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_AXIS",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_AXIS."
                ),
                EnumEntryModel(
                    value = 8,
                    name = "GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_FOLLOW",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_FOLLOW."
                ),
                EnumEntryModel(
                    value = 16,
                    name = "GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_LOCK",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_LOCK."
                ),
                EnumEntryModel(
                    value = 32,
                    name = "GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_AXIS",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_AXIS."
                ),
                EnumEntryModel(
                    value = 64,
                    name = "GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_FOLLOW",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_FOLLOW."
                ),
                EnumEntryModel(
                    value = 128,
                    name = "GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_LOCK",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_LOCK."
                ),
                EnumEntryModel(
                    value = 256,
                    name = "GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_AXIS",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_AXIS."
                ),
                EnumEntryModel(
                    value = 512,
                    name = "GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_FOLLOW",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_FOLLOW."
                ),
                EnumEntryModel(
                    value = 1024,
                    name = "GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_LOCK",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_LOCK."
                ),
                EnumEntryModel(
                    value = 2048,
                    name = "GIMBAL_MANAGER_CAP_FLAGS_SUPPORTS_INFINITE_YAW",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Based on GIMBAL_DEVICE_CAP_FLAGS_SUPPORTS_INFINITE_YAW."
                ),
                EnumEntryModel(
                    value = 65536,
                    name = "GIMBAL_MANAGER_CAP_FLAGS_CAN_POINT_LOCATION_LOCAL",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Gimbal manager supports to point to a local position."
                ),
                EnumEntryModel(
                    value = 131072,
                    name = "GIMBAL_MANAGER_CAP_FLAGS_CAN_POINT_LOCATION_GLOBAL",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Gimbal manager supports to point to a global latitude, longitude, altitude position."
                )
            ),
            deprecated = null,
            description = "Gimbal manager high level capability flags (bitmap). The first 16 bits are identical to the GIMBAL_DEVICE_CAP_FLAGS. However, the gimbal manager does not need to copy the flags from the gimbal but can also enhance the capabilities and thus add flags."
        )

        val actual = mapper.readValue(inp, EnumXml::class.java).toModel()

        assertEquals(expected, actual)
    }

    @Test
    fun withoutBitmask() {
        val inp = """
        <enum name="FENCE_BREACH">
            <entry value="0" name="FENCE_BREACH_NONE">
                <description>No last fence breach</description>
            </entry>
            <entry value="1" name="FENCE_BREACH_MINALT">
                <description>Breached minimum altitude</description>
            </entry>
            <entry value="2" name="FENCE_BREACH_MAXALT">
                <description>Breached maximum altitude</description>
            </entry>
            <entry value="3" name="FENCE_BREACH_BOUNDARY">
                <description>Breached fence boundary</description>
            </entry>
        </enum>
        """.trimIndent()

        val expected = EnumModel(
            name = "FENCE_BREACH",
            bitmask = false,
            entries = listOf(
                EnumEntryModel(
                    value = 0,
                    name = "FENCE_BREACH_NONE",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "No last fence breach"
                ),
                EnumEntryModel(
                    value = 1,
                    name = "FENCE_BREACH_MINALT",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Breached minimum altitude"
                ),
                EnumEntryModel(
                    value = 2,
                    name = "FENCE_BREACH_MAXALT",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Breached maximum altitude"
                ),
                EnumEntryModel(
                    value = 3,
                    name = "FENCE_BREACH_BOUNDARY",
                    params = emptyList(),
                    workInProgress = false,
                    deprecated = null,
                    description = "Breached fence boundary"
                )
            ),
            deprecated = null,
            description = null
        )

        val actual = mapper.readValue(inp, EnumXml::class.java).toModel()

        assertEquals(expected, actual)
    }
}
