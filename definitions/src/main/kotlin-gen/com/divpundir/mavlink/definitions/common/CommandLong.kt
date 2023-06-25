package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Send a command with up to seven parameters to the MAV. The command microservice is documented at
 * https://mavlink.io/en/services/command.html
 */
@GeneratedMavMessage(
  id = 76u,
  crcExtra = -104,
)
public data class CommandLong(
  /**
   * System which should execute the command
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component which should execute the command, 0 for all components
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Command ID (of command to send).
   */
  @GeneratedMavField(type = "uint16_t")
  public val command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0u),
  /**
   * 0: First transmission of this command. 1-255: Confirmation transmissions (e.g. for kill
   * command)
   */
  @GeneratedMavField(type = "uint8_t")
  public val confirmation: UByte = 0u,
  /**
   * Parameter 1 (for the specific command).
   */
  @GeneratedMavField(type = "float")
  public val param1: Float = 0F,
  /**
   * Parameter 2 (for the specific command).
   */
  @GeneratedMavField(type = "float")
  public val param2: Float = 0F,
  /**
   * Parameter 3 (for the specific command).
   */
  @GeneratedMavField(type = "float")
  public val param3: Float = 0F,
  /**
   * Parameter 4 (for the specific command).
   */
  @GeneratedMavField(type = "float")
  public val param4: Float = 0F,
  /**
   * Parameter 5 (for the specific command).
   */
  @GeneratedMavField(type = "float")
  public val param5: Float = 0F,
  /**
   * Parameter 6 (for the specific command).
   */
  @GeneratedMavField(type = "float")
  public val param6: Float = 0F,
  /**
   * Parameter 7 (for the specific command).
   */
  @GeneratedMavField(type = "float")
  public val param7: Float = 0F,
) : MavMessage<CommandLong> {
  public override val instanceCompanion: MavMessage.MavCompanion<CommandLong> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(param1)
    buffer.encodeFloat(param2)
    buffer.encodeFloat(param3)
    buffer.encodeFloat(param4)
    buffer.encodeFloat(param5)
    buffer.encodeFloat(param6)
    buffer.encodeFloat(param7)
    buffer.encodeEnumValue(command.value, 2)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(confirmation)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(param1)
    buffer.encodeFloat(param2)
    buffer.encodeFloat(param3)
    buffer.encodeFloat(param4)
    buffer.encodeFloat(param5)
    buffer.encodeFloat(param6)
    buffer.encodeFloat(param7)
    buffer.encodeEnumValue(command.value, 2)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(confirmation)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CommandLong> {
    public override val id: UInt = 76u

    public override val crcExtra: Byte = -104

    public override fun deserialize(bytes: ByteArray): CommandLong {
      val buffer = Buffer().write(bytes)

      val param1 = buffer.decodeFloat()
      val param2 = buffer.decodeFloat()
      val param3 = buffer.decodeFloat()
      val param4 = buffer.decodeFloat()
      val param5 = buffer.decodeFloat()
      val param6 = buffer.decodeFloat()
      val param7 = buffer.decodeFloat()
      val command = buffer.decodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val confirmation = buffer.decodeUInt8()

      return CommandLong(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        command = command,
        confirmation = confirmation,
        param1 = param1,
        param2 = param2,
        param3 = param3,
        param4 = param4,
        param5 = param5,
        param6 = param6,
        param7 = param7,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CommandLong =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0u)

    public var confirmation: UByte = 0u

    public var param1: Float = 0F

    public var param2: Float = 0F

    public var param3: Float = 0F

    public var param4: Float = 0F

    public var param5: Float = 0F

    public var param6: Float = 0F

    public var param7: Float = 0F

    public fun build(): CommandLong = CommandLong(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      command = command,
      confirmation = confirmation,
      param1 = param1,
      param2 = param2,
      param3 = param3,
      param4 = param4,
      param5 = param5,
      param6 = param6,
      param7 = param7,
    )
  }
}
