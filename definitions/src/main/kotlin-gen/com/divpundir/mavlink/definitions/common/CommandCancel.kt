package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
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
  public override val instanceMetadata: MavMessage.Metadata<CommandCancel> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(command.value, 2)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(command.value, 2)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 80u

    private const val CRC_EXTRA: Byte = 14

    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 4

    private val DESERIALIZER: MavDeserializer<CommandCancel> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val command = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()

      CommandCancel(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        command = command,
      )
    }


    private val METADATA: MavMessage.Metadata<CommandCancel> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CommandCancel> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): CommandCancel =
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
