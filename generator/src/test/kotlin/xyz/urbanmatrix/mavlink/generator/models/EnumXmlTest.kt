package xyz.urbanmatrix.mavlink.generator.models

import org.junit.jupiter.api.Test
import xyz.urbanmatrix.mavlink.generator.createXmlMapper

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

        println(mapper.readValue(inp, EnumXml::class.java).toModel())
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

        println(mapper.readValue(inp, EnumXml::class.java).toModel())
    }
}
