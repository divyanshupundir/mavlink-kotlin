package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Send a command with up to seven parameters to the MAV. COMMAND_INT is generally preferred when
 * sending MAV_CMD commands that include positional information; it offers higher precision and allows
 * the MAV_FRAME to be specified (which may otherwise be ambiguous, particularly for altitude). The
 * command microservice is documented at https://mavlink.io/en/services/command.html
 *
 * @param targetSystem System which should execute the command
 * @param targetComponent Component which should execute the command, 0 for all components
 * @param command Command ID (of command to send).
 * @param confirmation 0: First transmission of this command. 1-255: Confirmation transmissions
 * (e.g. for kill command)
 * @param param1 Parameter 1 (for the specific command).
 * @param param2 Parameter 2 (for the specific command).
 * @param param3 Parameter 3 (for the specific command).
 * @param param4 Parameter 4 (for the specific command).
 * @param param5 Parameter 5 (for the specific command).
 * @param param6 Parameter 6 (for the specific command).
 * @param param7 Parameter 7 (for the specific command).
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
  override val instanceCompanion: MavMessage.MavCompanion<CommandLong> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(param1)
    encoder.encodeFloat(param2)
    encoder.encodeFloat(param3)
    encoder.encodeFloat(param4)
    encoder.encodeFloat(param5)
    encoder.encodeFloat(param6)
    encoder.encodeFloat(param7)
    encoder.encodeEnumValue(command.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(confirmation)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(param1)
    encoder.encodeFloat(param2)
    encoder.encodeFloat(param3)
    encoder.encodeFloat(param4)
    encoder.encodeFloat(param5)
    encoder.encodeFloat(param6)
    encoder.encodeFloat(param7)
    encoder.encodeEnumValue(command.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(confirmation)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CommandLong> {
    private const val SIZE_V1: Int = 33

    private const val SIZE_V2: Int = 33

    override val id: UInt = 76u

    override val crcExtra: Byte = -104

    override fun deserialize(bytes: ByteArray): CommandLong {
      val decoder = MavDataDecoder(bytes)

      val param1 = decoder.safeDecodeFloat()
      val param2 = decoder.safeDecodeFloat()
      val param3 = decoder.safeDecodeFloat()
      val param4 = decoder.safeDecodeFloat()
      val param5 = decoder.safeDecodeFloat()
      val param6 = decoder.safeDecodeFloat()
      val param7 = decoder.safeDecodeFloat()
      val command = decoder.safeDecodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val confirmation = decoder.safeDecodeUInt8()

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
