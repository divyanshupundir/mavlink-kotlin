package com.urbanmatrix.mavlink.generator.models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MessageXmlTest {

    private val mapper = createXmlMapper()

    @Test
    fun withWip() {
        val inp = """
        <message id="80" name="COMMAND_CANCEL">
            <wip/>
            <!-- This message is work-in-progress and it can therefore change. It should NOT be used in stable production environments. -->
            <description>Cancel a long running command. The target system should respond with a COMMAND_ACK to the original command with result=MAV_RESULT_CANCELLED if the long running process was cancelled. If it has already completed, the cancel action can be ignored. The cancel action can be retried until some sort of acknowledgement to the original command has been received. The command microservice is documented at https://mavlink.io/en/services/command.html</description>
            <field type="uint8_t" name="target_system">System executing long running command. Should not be broadcast (0).</field>
            <field type="uint8_t" name="target_component">Component executing long running command.</field>
            <field type="uint16_t" name="command" enum="MAV_CMD">Command ID (of command to cancel).</field>
        </message>
        """.trimIndent()

        val model = mapper.readValue(inp, MessageXml::class.java).toMod()
        println(model)

        assertTrue(model.workInProgress)

        val targetSystem = model.fields[0]
        assertEquals(targetSystem.name, "target_system")
        assertFalse(targetSystem.extension)

        val targetComponent = model.fields[1]
        assertEquals(targetComponent.name, "target_component")
        assertFalse(targetComponent.extension)

        val command = model.fields[2]
        assertEquals(command.name, "command")
        assertFalse(command.extension)
    }

    @Test
    fun withoutWip() {
        val inp = """
        <message id="81" name="MANUAL_SETPOINT">
            <description>Setpoint in roll, pitch, yaw and thrust from the operator</description>
            <field type="uint32_t" name="time_boot_ms" units="ms">Timestamp (time since system boot).</field>
            <field type="float" name="roll" units="rad/s">Desired roll rate</field>
            <field type="float" name="pitch" units="rad/s">Desired pitch rate</field>
            <field type="float" name="yaw" units="rad/s">Desired yaw rate</field>
            <field type="float" name="thrust">Collective thrust, normalized to 0 .. 1</field>
            <field type="uint8_t" name="mode_switch">Flight mode switch position, 0.. 255</field>
            <field type="uint8_t" name="manual_override_switch">Override mode switch position, 0.. 255</field>
        </message>
        """.trimIndent()

        val model = mapper.readValue(inp, MessageXml::class.java).toMod()
        println(model)

        assertFalse(model.workInProgress)

        val timeBootMs = model.fields[0]
        assertEquals(timeBootMs.name, "time_boot_ms")
        assertFalse(timeBootMs.extension)

        val roll = model.fields[1]
        assertEquals(roll.name, "roll")
        assertFalse(roll.extension)

        val pitch = model.fields[2]
        assertEquals(pitch.name, "pitch")
        assertFalse(pitch.extension)

        val yaw = model.fields[3]
        assertEquals(yaw.name, "yaw")
        assertFalse(yaw.extension)

        val thrust = model.fields[4]
        assertEquals(thrust.name, "thrust")
        assertFalse(thrust.extension)

        val modeSwitch = model.fields[5]
        assertEquals(modeSwitch.name, "mode_switch")
        assertFalse(modeSwitch.extension)

        val manualOverrideSwitch = model.fields[6]
        assertEquals(manualOverrideSwitch.name, "manual_override_switch")
        assertFalse(manualOverrideSwitch.extension)
    }

    @Test
    fun withExtensions() {
        val inp = """
        <message id="101" name="GLOBAL_VISION_POSITION_ESTIMATE">
            <description>Global position/attitude estimate from a vision source.</description>
            <field type="uint64_t" name="usec" units="us">Timestamp (UNIX time or since system boot)</field>
            <field type="float" name="x" units="m">Global X position</field>
            <field type="float" name="y" units="m">Global Y position</field>
            <field type="float" name="z" units="m">Global Z position</field>
            <field type="float" name="roll" units="rad">Roll angle</field>
            <field type="float" name="pitch" units="rad">Pitch angle</field>
            <field type="float" name="yaw" units="rad">Yaw angle</field>
            <extensions/>
            <field type="float[21]" name="covariance" invalid="[NaN:]">Row-major representation of pose 6x6 cross-covariance matrix upper right triangle (states: x_global, y_global, z_global, roll, pitch, yaw; first six entries are the first ROW, next five entries are the second ROW, etc.). If unknown, assign NaN value to first element in the array.</field>
            <field type="uint8_t" name="reset_counter">Estimate reset counter. This should be incremented when the estimate resets in any of the dimensions (position, velocity, attitude, angular speed). This is designed to be used when e.g an external SLAM system detects a loop-closure and the estimate jumps.</field>
        </message>
        """.trimIndent()

        val model = mapper.readValue(inp, MessageXml::class.java).toMod()
        println(model)

        assertFalse(model.workInProgress)

        val usec = model.fields[0]
        assertEquals(usec.name, "usec")
        assertFalse(usec.extension)

        val x = model.fields[1]
        assertEquals(x.name, "x")
        assertFalse(x.extension)

        val y = model.fields[2]
        assertEquals(y.name, "y")
        assertFalse(y.extension)

        val z = model.fields[3]
        assertEquals(z.name, "z")
        assertFalse(z.extension)

        val roll = model.fields[4]
        assertEquals(roll.name, "roll")
        assertFalse(roll.extension)

        val pitch = model.fields[5]
        assertEquals(pitch.name, "pitch")
        assertFalse(pitch.extension)

        val yaw = model.fields[6]
        assertEquals(yaw.name, "yaw")
        assertFalse(yaw.extension)

        val covariance = model.fields[7]
        assertEquals(covariance.name, "covariance")
        assertTrue(covariance.extension)

        val resetCounter = model.fields[8]
        assertEquals(resetCounter.name, "reset_counter")
        assertTrue(resetCounter.extension)
    }
}
