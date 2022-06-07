package com.urbanmatrix.mavlink.generator.models

import org.junit.jupiter.api.Assertions.*
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

        println(mapper.readValue(inp, EnumXml::class.java).toMod())
    }
}