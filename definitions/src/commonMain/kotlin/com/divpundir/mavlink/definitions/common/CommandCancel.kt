package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Cancel a long running command. The target system should respond with a COMMAND_ACK to the
 * original command with result=MAV_RESULT_CANCELLED if the long running process was cancelled. If it
 * has already completed, the cancel action can be ignored. The cancel action can be retried until some
 * sort of acknowledgement to the original command has been received. The command microservice is
 * documented at https://mavlink.io/en/services/command.html
 *
 * @param targetSystem System executing long running command. Should not be broadcast (0).
 * @param targetComponent Component executing long running command.
 * @param command Command ID (of command to cancel).
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 80u,
  crcExtra = 14,
)
public data class CommandCancel(
  /**
   * System executing long running command. Should not be broadcast (0).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component executing long running command.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Command ID (of command to cancel).
   */
  @GeneratedMavField(type = "uint16_t")
  public val command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0u),
) : MavMessage<CommandCancel> {
  override val instanceCompanion: MavMessage.MavCompanion<CommandCancel> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeEnumValue(command.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeEnumValue(command.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CommandCancel> {
    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 4

    override val id: UInt = 80u

    override val crcExtra: Byte = 14

    override fun deserialize(bytes: ByteArray): CommandCancel {
      val decoder = MavDataDecoder(bytes)

      val command = decoder.safeDecodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return CommandCancel(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        command = command,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CommandCancel =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0u)

    public fun build(): CommandCancel = CommandCancel(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      command = command,
    )
  }
}
