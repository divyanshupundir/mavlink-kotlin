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

    @Test
    fun deprecatedEntry() {
        val inp = """
        <enum name="MAV_CMD">
            <description>Commands to be executed by the MAV. They can be executed on user request, or as part of a mission script. If the action is used in a mission, the parameter mapping to the waypoint/mission message is as follows: Param 1, Param 2, Param 3, Param 4, X: Param 5, Y:Param 6, Z:Param 7. This command list is similar what ARINC 424 is for commercial aircraft: A data format how to interpret waypoint/mission data. NaN and INT32_MAX may be used in float/integer params (respectively) to indicate optional/default values (e.g. to use the component's current yaw or latitude rather than a specific value). See https://mavlink.io/en/guide/xml_schema.html#MAV_CMD for information about the structure of the MAV_CMD entries</description>
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
        </enum>
        """.trimIndent()

        val model = mapper.readValue(inp, EnumXml::class.java).toModel()
        val fileSpec = model.generateFileSpec("com.urbanmatrix.mavlink.test")

        val s = StringBuilder()
        fileSpec.writeTo(s)

        println(s)
    }

    @Test
    fun workInProgressEntry() {
        val inp = """
        <enum name="MAV_CMD">
            <description>Commands to be executed by the MAV. They can be executed on user request, or as part of a mission script. If the action is used in a mission, the parameter mapping to the waypoint/mission message is as follows: Param 1, Param 2, Param 3, Param 4, X: Param 5, Y:Param 6, Z:Param 7. This command list is similar what ARINC 424 is for commercial aircraft: A data format how to interpret waypoint/mission data. NaN and INT32_MAX may be used in float/integer params (respectively) to indicate optional/default values (e.g. to use the component's current yaw or latitude rather than a specific value). See https://mavlink.io/en/guide/xml_schema.html#MAV_CMD for information about the structure of the MAV_CMD entries</description>
            <entry value="34" name="MAV_CMD_DO_ORBIT" hasLocation="true" isDestination="true">
                <wip/>
                <!-- This message is work-in-progress and it can therefore change. It should NOT be used in stable production environments. -->
                <description>Start orbiting on the circumference of a circle defined by the parameters. Setting values to NaN/INT32_MAX (as appropriate) results in using defaults.</description>
                <param index="1" label="Radius" units="m">Radius of the circle. Positive: orbit clockwise. Negative: orbit counter-clockwise. NaN: Use vehicle default radius, or current radius if already orbiting.</param>
                <param index="2" label="Velocity" units="m/s">Tangential Velocity. NaN: Use vehicle default velocity, or current velocity if already orbiting.</param>
                <param index="3" label="Yaw Behavior" enum="ORBIT_YAW_BEHAVIOUR">Yaw behavior of the vehicle.</param>
                <param index="4" label="Orbits" units="rad" minValue="0" default="0">Orbit around the centre point for this many radians (i.e. for a three-quarter orbit set 270*Pi/180). 0: Orbit forever. NaN: Use vehicle default, or current value if already orbiting.</param>
                <param index="5" label="Latitude/X">Center point latitude (if no MAV_FRAME specified) / X coordinate according to MAV_FRAME. INT32_MAX (or NaN if sent in COMMAND_LONG): Use current vehicle position, or current center if already orbiting.</param>
                <param index="6" label="Longitude/Y">Center point longitude (if no MAV_FRAME specified) / Y coordinate according to MAV_FRAME. INT32_MAX (or NaN if sent in COMMAND_LONG): Use current vehicle position, or current center if already orbiting.</param>
                <param index="7" label="Altitude/Z">Center point altitude (MSL) (if no MAV_FRAME specified) / Z coordinate according to MAV_FRAME. NaN: Use current vehicle altitude.</param>
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
