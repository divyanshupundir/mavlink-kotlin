package com.divpundir.mavlink.generator.models

import com.divpundir.mavlink.generator.createXmlMapper
import org.junit.jupiter.api.Assertions.assertEquals
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

        val expected = MessageModel(
            id = 80,
            name = "COMMAND_CANCEL",
            fields = listOf(
                FieldModel.Primitive(
                    position = 1,
                    type = "uint8_t",
                    name = "target_system",
                    extension = false,
                    display = null,
                    units = null,
                    invalid = null,
                    printFormat = null,
                    content = "System executing long running command. Should not be broadcast (0)."
                ),
                FieldModel.Primitive(
                    position = 2,
                    type = "uint8_t",
                    name = "target_component",
                    extension = false,
                    display = null,
                    units = null,
                    invalid = null,
                    printFormat = null,
                    content = "Component executing long running command."
                ),
                FieldModel.Enum(
                    enumType = "MAV_CMD",
                    position = 3,
                    type = "uint16_t",
                    name = "command",
                    extension = false,
                    display = null,
                    units = null,
                    invalid = null,
                    printFormat = null,
                    content = "Command ID (of command to cancel)."
                )
            ),
            workInProgress = true,
            deprecated = null,
            description = "Cancel a long running command. The target system should respond with a COMMAND_ACK to the original command with result=MAV_RESULT_CANCELLED if the long running process was cancelled. If it has already completed, the cancel action can be ignored. The cancel action can be retried until some sort of acknowledgement to the original command has been received. The command microservice is documented at https://mavlink.io/en/services/command.html"
        )

        val actual = mapper.readValue(inp, MessageXml::class.java).toModel()

        assertEquals(expected, actual)
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

        val expected = MessageModel(
            id = 81,
            name = "MANUAL_SETPOINT",
            fields = listOf(
                FieldModel.Primitive(
                    position = 1,
                    type = "uint32_t",
                    name = "time_boot_ms",
                    extension = false,
                    display = null,
                    units = "ms",
                    invalid = null,
                    printFormat = null,
                    content = "Timestamp (time since system boot)."
                ),
                FieldModel.Primitive(
                    position = 2,
                    type = "float",
                    name = "roll",
                    extension = false,
                    display = null,
                    units = "rad/s",
                    invalid = null,
                    printFormat = null,
                    content = "Desired roll rate"
                ),
                FieldModel.Primitive(
                    position = 3,
                    type = "float",
                    name = "pitch",
                    extension = false,
                    display = null,
                    units = "rad/s",
                    invalid = null,
                    printFormat = null,
                    content = "Desired pitch rate"
                ),
                FieldModel.Primitive(
                    position = 4,
                    type = "float",
                    name = "yaw",
                    extension = false,
                    display = null,
                    units = "rad/s",
                    invalid = null,
                    printFormat = null,
                    content = "Desired yaw rate"
                ),
                FieldModel.Primitive(
                    position = 5,
                    type = "float",
                    name = "thrust",
                    extension = false,
                    display = null,
                    units = null,
                    invalid = null,
                    printFormat = null,
                    content = "Collective thrust, normalized to 0 .. 1"
                ),
                FieldModel.Primitive(
                    position = 6,
                    type = "uint8_t",
                    name = "mode_switch",
                    extension = false,
                    display = null,
                    units = null,
                    invalid = null,
                    printFormat = null,
                    content = "Flight mode switch position, 0.. 255"
                ),
                FieldModel.Primitive(
                    position = 7,
                    type = "uint8_t",
                    name = "manual_override_switch",
                    extension = false,
                    display = null,
                    units = null,
                    invalid = null,
                    printFormat = null,
                    content = "Override mode switch position, 0.. 255"
                )
            ),
            workInProgress = false,
            deprecated = null,
            description = "Setpoint in roll, pitch, yaw and thrust from the operator"
        )

        val actual = mapper.readValue(inp, MessageXml::class.java).toModel()

        assertEquals(expected, actual)
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

        val expected = MessageModel(
            id = 101,
            name = "GLOBAL_VISION_POSITION_ESTIMATE",
            fields = listOf(
                FieldModel.Primitive(
                    position = 1,
                    type = "uint64_t",
                    name = "usec",
                    extension = false,
                    display = null,
                    units = "us",
                    invalid = null,
                    printFormat = null,
                    content = "Timestamp (UNIX time or since system boot)"
                ),
                FieldModel.Primitive(
                    position = 2,
                    type = "float",
                    name = "x",
                    extension = false,
                    display = null,
                    units = "m",
                    invalid = null,
                    printFormat = null,
                    content = "Global X position"
                ),
                FieldModel.Primitive(
                    position = 3,
                    type = "float",
                    name = "y",
                    extension = false,
                    display = null,
                    units = "m",
                    invalid = null,
                    printFormat = null,
                    content = "Global Y position"
                ),
                FieldModel.Primitive(
                    position = 4,
                    type = "float",
                    name = "z",
                    extension = false,
                    display = null,
                    units = "m",
                    invalid = null,
                    printFormat = null,
                    content = "Global Z position"
                ),
                FieldModel.Primitive(
                    position = 5,
                    type = "float",
                    name = "roll",
                    extension = false,
                    display = null,
                    units = "rad",
                    invalid = null,
                    printFormat = null,
                    content = "Roll angle"
                ),
                FieldModel.Primitive(
                    position = 6,
                    type = "float",
                    name = "pitch",
                    extension = false,
                    display = null,
                    units = "rad",
                    invalid = null,
                    printFormat = null,
                    content = "Pitch angle"
                ),
                FieldModel.Primitive(
                    position = 7,
                    type = "float",
                    name = "yaw",
                    extension = false,
                    display = null,
                    units = "rad",
                    invalid = null,
                    printFormat = null,
                    content = "Yaw angle"
                ),
                FieldModel.PrimitiveArray(
                    position = 8,
                    primitiveType = "float",
                    arrayLength = 21,
                    type = "float[21]",
                    name = "covariance",
                    extension = true,
                    display = null,
                    units = null,
                    invalid = "[NaN:]",
                    printFormat = null,
                    content = "Row-major representation of pose 6x6 cross-covariance matrix upper right triangle (states: x_global, y_global, z_global, roll, pitch, yaw; first six entries are the first ROW, next five entries are the second ROW, etc.). If unknown, assign NaN value to first element in the array."
                ),
                FieldModel.Primitive(
                    position = 9,
                    type = "uint8_t",
                    name = "reset_counter",
                    extension = true,
                    display = null,
                    units = null,
                    invalid = null,
                    printFormat = null,
                    content = "Estimate reset counter. This should be incremented when the estimate resets in any of the dimensions (position, velocity, attitude, angular speed). This is designed to be used when e.g an external SLAM system detects a loop-closure and the estimate jumps."
                )
            ),
            workInProgress = false,
            deprecated = null,
            description = "Global position/attitude estimate from a vision source."
        )

        val actual = mapper.readValue(inp, MessageXml::class.java).toModel()

        assertEquals(expected, actual)
    }
}
