package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Report status of a command. Includes feedback whether the command was executed. The command
 * microservice is documented at https://mavlink.io/en/services/command.html
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
   * Also used as result_param1, it can be set with an enum containing the errors reasons of why the
   * command was denied, or the progress percentage when result is MAV_RESULT_IN_PROGRESS (UINT8_MAX if
   * the progress is unknown).
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val progress: UByte = 0u,
  /**
   * Additional parameter of the result, example: which parameter of MAV_CMD_NAV_WAYPOINT caused it
   * to be denied.
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
  public override val instanceCompanion: MavMessage.MavCompanion<CommandAck> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeEnumValue(command.value, 2)
    output.encodeEnumValue(result.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeEnumValue(command.value, 2)
    output.encodeEnumValue(result.value, 1)
    output.encodeUInt8(progress)
    output.encodeInt32(resultParam2)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<CommandAck> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 10

    public override val id: UInt = 77u

    public override val crcExtra: Byte = -113

    public override fun deserialize(source: BufferedSource): CommandAck {
      val command = source.decodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val result = source.decodeEnumValue(1).let { value ->
        val entry = MavResult.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val progress = source.decodeUInt8()
      val resultParam2 = source.decodeInt32()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()

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
