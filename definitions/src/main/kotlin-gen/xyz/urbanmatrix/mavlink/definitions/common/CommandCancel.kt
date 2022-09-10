package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Cancel a long running command. The target system should respond with a COMMAND_ACK to the
 * original command with result=MAV_RESULT_CANCELLED if the long running process was cancelled. If it
 * has already completed, the cancel action can be ignored. The cancel action can be retried until some
 * sort of acknowledgement to the original command has been received. The command microservice is
 * documented at https://mavlink.io/en/services/command.html
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 80,
  crc = 14,
)
public data class CommandCancel(
  /**
   * System executing long running command. Should not be broadcast (0).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component executing long running command.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * Command ID (of command to cancel).
   */
  @GeneratedMavField(type = "uint16_t")
  public val command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0),
) : MavMessage<CommandCancel> {
  public override val instanceMetadata: MavMessage.Metadata<CommandCancel> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(command.value, 2)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(command.value, 2)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 80

    private const val CRC: Int = 14

    private const val SIZE: Int = 4

    private val DESERIALIZER: MavDeserializer<CommandCancel> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val command = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      CommandCancel(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        command = command,
      )
    }


    private val METADATA: MavMessage.Metadata<CommandCancel> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CommandCancel> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0)

    public fun build(): CommandCancel = CommandCancel(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      command = command,
    )
  }
}
