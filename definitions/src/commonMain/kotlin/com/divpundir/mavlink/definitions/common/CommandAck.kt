package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Report status of a command. Includes feedback whether the command was executed. The command
 * microservice is documented at https://mavlink.io/en/services/command.html
 *
 * @param command Command ID (of acknowledged command).
 * @param result Result of command.
 * @param progress The progress percentage when result is MAV_RESULT_IN_PROGRESS. Values: [0-100],
 * or UINT8_MAX if the progress is unknown.
 * units = %
 * @param resultParam2 Additional result information. Can be set with a command-specific enum
 * containing command-specific error reasons for why the command might be denied. If used, the
 * associated enum must be documented in the corresponding MAV_CMD (this enum should have a 0 value to
 * indicate "unused" or "unknown").
 * @param targetSystem System ID of the target recipient. This is the ID of the system that sent the
 * command for which this COMMAND_ACK is an acknowledgement.
 * @param targetComponent Component ID of the target recipient. This is the ID of the system that
 * sent the command for which this COMMAND_ACK is an acknowledgement.
 */
@GeneratedMavMessage(
  id = 77u,
  crcExtra = -113,
)
public data class CommandAck(
  /**
   * Command ID (of acknowledged command).
   */
  @GeneratedMavField(type = "uint16_t")
  public val command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0u),
  /**
   * Result of command.
   */
  @GeneratedMavField(type = "uint8_t")
  public val result: MavEnumValue<MavResult> = MavEnumValue.fromValue(0u),
  /**
   * The progress percentage when result is MAV_RESULT_IN_PROGRESS. Values: [0-100], or UINT8_MAX if
   * the progress is unknown.
   * units = %
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val progress: UByte = 0u,
  /**
   * Additional result information. Can be set with a command-specific enum containing
   * command-specific error reasons for why the command might be denied. If used, the associated enum
   * must be documented in the corresponding MAV_CMD (this enum should have a 0 value to indicate
   * "unused" or "unknown").
   */
  @GeneratedMavField(
    type = "int32_t",
    extension = true,
  )
  public val resultParam2: Int = 0,
  /**
   * System ID of the target recipient. This is the ID of the system that sent the command for which
   * this COMMAND_ACK is an acknowledgement.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val targetSystem: UByte = 0u,
  /**
   * Component ID of the target recipient. This is the ID of the system that sent the command for
   * which this COMMAND_ACK is an acknowledgement.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val targetComponent: UByte = 0u,
) : MavMessage<CommandAck> {
  override val instanceCompanion: MavMessage.MavCompanion<CommandAck> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeEnumValue(command.value, 2)
    encoder.encodeEnumValue(result.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeEnumValue(command.value, 2)
    encoder.encodeEnumValue(result.value, 1)
    encoder.encodeUInt8(progress)
    encoder.encodeInt32(resultParam2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CommandAck> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 10

    override val id: UInt = 77u

    override val crcExtra: Byte = -113

    override fun deserialize(bytes: ByteArray): CommandAck {
      val decoder = MavDataDecoder(bytes)

      val command = decoder.safeDecodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val result = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavResult.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val progress = decoder.safeDecodeUInt8()
      val resultParam2 = decoder.safeDecodeInt32()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return CommandAck(
        command = command,
        result = result,
        progress = progress,
        resultParam2 = resultParam2,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CommandAck =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0u)

    public var result: MavEnumValue<MavResult> = MavEnumValue.fromValue(0u)

    public var progress: UByte = 0u

    public var resultParam2: Int = 0

    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public fun build(): CommandAck = CommandAck(
      command = command,
      result = result,
      progress = progress,
      resultParam2 = resultParam2,
      targetSystem = targetSystem,
      targetComponent = targetComponent,
    )
  }
}
