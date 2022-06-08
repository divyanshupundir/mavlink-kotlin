package com.urbanmatrix.mavlink.generator

import com.urbanmatrix.mavlink.generator.models.EnumXml
import org.junit.jupiter.api.Test

class EnumGenTest {

    private val mapper = createXmlMapper()

    @Test
    fun basic() {
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

        val model = mapper.readValue(inp, EnumXml::class.java).toModel()
        val fileSpec = model.generateFileSpec("com.urbanmatrix.mavlink.test")

        val s = StringBuilder()
        fileSpec.writeTo(s)

        println(s)
    }

    @Test
    fun deprecated() {
        val inp = """
        <enum name="MAV_MOUNT_MODE">
            <deprecated since="2020-01" replaced_by="GIMBAL_MANAGER_FLAGS"/>
            <description>Enumeration of possible mount operation modes. This message is used by obsolete/deprecated gimbal messages.</description>
            <entry value="0" name="MAV_MOUNT_MODE_RETRACT">
                <description>Load and keep safe position (Roll,Pitch,Yaw) from permant memory and stop stabilization</description>
            </entry>
            <entry value="1" name="MAV_MOUNT_MODE_NEUTRAL">
                <description>Load and keep neutral position (Roll,Pitch,Yaw) from permanent memory.</description>
            </entry>
            <entry value="2" name="MAV_MOUNT_MODE_MAVLINK_TARGETING">
                <description>Load neutral position and start MAVLink Roll,Pitch,Yaw control with stabilization</description>
            </entry>
            <entry value="3" name="MAV_MOUNT_MODE_RC_TARGETING">
                <description>Load neutral position and start RC Roll,Pitch,Yaw control with stabilization</description>
            </entry>
            <entry value="4" name="MAV_MOUNT_MODE_GPS_POINT">
                <description>Load neutral position and start to point to Lat,Lon,Alt</description>
            </entry>
            <entry value="5" name="MAV_MOUNT_MODE_SYSID_TARGET">
                <description>Gimbal tracks system with specified system ID</description>
            </entry>
            <entry value="6" name="MAV_MOUNT_MODE_HOME_LOCATION">
                <description>Gimbal tracks home location</description>
            </entry>
        </enum>
        """.trimIndent()

        val model = mapper.readValue(inp, EnumXml::class.java).toModel()
        val fileSpec = model.generateFileSpec("com.urbanmatrix.mavlink.test")

        val s = StringBuilder()
        fileSpec.writeTo(s)

        println(s)
    }
}
