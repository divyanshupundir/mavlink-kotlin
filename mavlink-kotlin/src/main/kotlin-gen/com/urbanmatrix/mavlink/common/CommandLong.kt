package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Send a command with up to seven parameters to the MAV. The command microservice is documented at
 * https://mavlink.io/en/services/command.html
 */
public data class CommandLong(
  /**
   * Parameter 1 (for the specific command).
   */
  public val param1: Float = 0F,
  /**
   * Parameter 2 (for the specific command).
   */
  public val param2: Float = 0F,
  /**
   * Parameter 3 (for the specific command).
   */
  public val param3: Float = 0F,
  /**
   * Parameter 4 (for the specific command).
   */
  public val param4: Float = 0F,
  /**
   * Parameter 5 (for the specific command).
   */
  public val param5: Float = 0F,
  /**
   * Parameter 6 (for the specific command).
   */
  public val param6: Float = 0F,
  /**
   * Parameter 7 (for the specific command).
   */
  public val param7: Float = 0F,
  /**
   * Command ID (of command to send).
   */
  public val command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0),
  /**
   * System which should execute the command
   */
  public val targetSystem: Int = 0,
  /**
   * Component which should execute the command, 0 for all components
   */
  public val targetComponent: Int = 0,
  /**
   * 0: First transmission of this command. 1-255: Confirmation transmissions (e.g. for kill
   * command)
   */
  public val confirmation: Int = 0,
) : MavMessage<CommandLong> {
  public override val instanceMetadata: MavMessage.Metadata<CommandLong> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(33).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(param1)
    outputBuffer.encodeFloat(param2)
    outputBuffer.encodeFloat(param3)
    outputBuffer.encodeFloat(param4)
    outputBuffer.encodeFloat(param5)
    outputBuffer.encodeFloat(param6)
    outputBuffer.encodeFloat(param7)
    outputBuffer.encodeEnumValue(command.value, 2)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(confirmation)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 76

    private const val CRC: Int = 152

    private val DESERIALIZER: MavDeserializer<CommandLong> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val param1 = inputBuffer.decodeFloat()
      val param2 = inputBuffer.decodeFloat()
      val param3 = inputBuffer.decodeFloat()
      val param4 = inputBuffer.decodeFloat()
      val param5 = inputBuffer.decodeFloat()
      val param6 = inputBuffer.decodeFloat()
      val param7 = inputBuffer.decodeFloat()
      val command = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val confirmation = inputBuffer.decodeUint8()
      CommandLong(
        param1 = param1,
        param2 = param2,
        param3 = param3,
        param4 = param4,
        param5 = param5,
        param6 = param6,
        param7 = param7,
        command = command,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        confirmation = confirmation,
      )
    }


    private val METADATA: MavMessage.Metadata<CommandLong> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CommandLong> = METADATA
  }
}
