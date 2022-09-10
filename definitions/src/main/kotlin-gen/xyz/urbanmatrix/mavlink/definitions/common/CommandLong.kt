package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Send a command with up to seven parameters to the MAV. The command microservice is documented at
 * https://mavlink.io/en/services/command.html
 */
@GeneratedMavMessage(
  id = 76,
  crc = 152,
)
public data class CommandLong(
  /**
   * System which should execute the command
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component which should execute the command, 0 for all components
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * Command ID (of command to send).
   */
  @GeneratedMavField(type = "uint16_t")
  public val command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0),
  /**
   * 0: First transmission of this command. 1-255: Confirmation transmissions (e.g. for kill
   * command)
   */
  @GeneratedMavField(type = "uint8_t")
  public val confirmation: Int = 0,
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
  public override val instanceMetadata: MavMessage.Metadata<CommandLong> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
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

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
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
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 76

    private const val CRC: Int = 152

    private const val SIZE: Int = 33

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


    private val METADATA: MavMessage.Metadata<CommandLong> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CommandLong> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0)

    public var confirmation: Int = 0

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
