package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Message encoding a command with parameters as scaled integers. Scaling depends on the actual
 * command value. NaN or INT32_MAX may be used in float/integer params (respectively) to indicate
 * optional/default values (e.g. to use the component's current latitude, yaw rather than a specific
 * value). The command microservice is documented at https://mavlink.io/en/services/command.html
 */
public data class CommandInt(
  /**
   * PARAM1, see MAV_CMD enum
   */
  public val param1: Float = 0F,
  /**
   * PARAM2, see MAV_CMD enum
   */
  public val param2: Float = 0F,
  /**
   * PARAM3, see MAV_CMD enum
   */
  public val param3: Float = 0F,
  /**
   * PARAM4, see MAV_CMD enum
   */
  public val param4: Float = 0F,
  /**
   * PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7
   */
  public val x: Int = 0,
  /**
   * PARAM6 / local: y position in meters * 1e4, global: longitude in degrees * 10^7
   */
  public val y: Int = 0,
  /**
   * PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame).
   */
  public val z: Float = 0F,
  /**
   * The scheduled action for the mission item.
   */
  public val command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0),
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * The coordinate system of the COMMAND.
   */
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0),
  /**
   * Not used.
   */
  public val current: Int = 0,
  /**
   * Not used (set 0).
   */
  public val autocontinue: Int = 0,
) : MavMessage<CommandInt> {
  public override val instanceMetadata: MavMessage.Metadata<CommandInt> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(35).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(param1)
    outputBuffer.encodeFloat(param2)
    outputBuffer.encodeFloat(param3)
    outputBuffer.encodeFloat(param4)
    outputBuffer.encodeInt32(x)
    outputBuffer.encodeInt32(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeEnumValue(command.value, 2)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(frame.value, 1)
    outputBuffer.encodeUint8(current)
    outputBuffer.encodeUint8(autocontinue)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 75

    private const val CRC: Int = 158

    private val DESERIALIZER: MavDeserializer<CommandInt> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val param1 = inputBuffer.decodeFloat()
      val param2 = inputBuffer.decodeFloat()
      val param3 = inputBuffer.decodeFloat()
      val param4 = inputBuffer.decodeFloat()
      val x = inputBuffer.decodeInt32()
      val y = inputBuffer.decodeInt32()
      val z = inputBuffer.decodeFloat()
      val command = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val frame = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val current = inputBuffer.decodeUint8()
      val autocontinue = inputBuffer.decodeUint8()
      CommandInt(
        param1 = param1,
        param2 = param2,
        param3 = param3,
        param4 = param4,
        x = x,
        y = y,
        z = z,
        command = command,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        frame = frame,
        current = current,
        autocontinue = autocontinue,
      )
    }


    private val METADATA: MavMessage.Metadata<CommandInt> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CommandInt> = METADATA
  }
}
