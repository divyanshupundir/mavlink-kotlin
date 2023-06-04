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
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

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

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(command.value, 2)
    outputBuffer.encodeEnumValue(result.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(command.value, 2)
    outputBuffer.encodeEnumValue(result.value, 1)
    outputBuffer.encodeUInt8(progress)
    outputBuffer.encodeInt32(resultParam2)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CommandAck> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 10

    public override val id: UInt = 77u

    public override val crcExtra: Byte = -113

    public override fun deserialize(bytes: ByteArray): CommandAck {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val command = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val result = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavResult.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val progress = inputBuffer.decodeUInt8()
      val resultParam2 = inputBuffer.decodeInt32()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()

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
