package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Cancel a long running command. The target system should respond with a COMMAND_ACK to the
 * original command with result=MAV_RESULT_CANCELLED if the long running process was cancelled. If it
 * has already completed, the cancel action can be ignored. The cancel action can be retried until some
 * sort of acknowledgement to the original command has been received. The command microservice is
 * documented at https://mavlink.io/en/services/command.html
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
  public override val instanceCompanion: MavMessage.MavCompanion<CommandCancel> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeEnumValue(command.value, 2)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeEnumValue(command.value, 2)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CommandCancel> {
    public override val id: UInt = 80u

    public override val crcExtra: Byte = 14

    public override fun deserialize(bytes: ByteArray): CommandCancel {
      val buffer = Buffer().write(bytes)

      val command = buffer.decodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()

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
