package xyz.urbanmatrix.mavlink.definitions.asluav

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.definitions.common.MavCmd
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Send a command with up to seven parameters to the MAV and additional metadata
 */
@GeneratedMavMessage(
  id = 224,
  crc = 102,
)
public data class CommandLongStamped(
  /**
   * UTC time, seconds elapsed since 01.01.1970
   */
  public val utcTime: Long = 0L,
  /**
   * Microseconds elapsed since vehicle boot
   */
  public val vehicleTimestamp: BigInteger = BigInteger.ZERO,
  /**
   * System which should execute the command
   */
  public val targetSystem: Int = 0,
  /**
   * Component which should execute the command, 0 for all components
   */
  public val targetComponent: Int = 0,
  /**
   * Command ID, as defined by MAV_CMD enum.
   */
  public val command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0),
  /**
   * 0: First transmission of this command. 1-255: Confirmation transmissions (e.g. for kill
   * command)
   */
  public val confirmation: Int = 0,
  /**
   * Parameter 1, as defined by MAV_CMD enum.
   */
  public val param1: Float = 0F,
  /**
   * Parameter 2, as defined by MAV_CMD enum.
   */
  public val param2: Float = 0F,
  /**
   * Parameter 3, as defined by MAV_CMD enum.
   */
  public val param3: Float = 0F,
  /**
   * Parameter 4, as defined by MAV_CMD enum.
   */
  public val param4: Float = 0F,
  /**
   * Parameter 5, as defined by MAV_CMD enum.
   */
  public val param5: Float = 0F,
  /**
   * Parameter 6, as defined by MAV_CMD enum.
   */
  public val param6: Float = 0F,
  /**
   * Parameter 7, as defined by MAV_CMD enum.
   */
  public val param7: Float = 0F,
) : MavMessage<CommandLongStamped> {
  public override val instanceMetadata: MavMessage.Metadata<CommandLongStamped> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(vehicleTimestamp)
    outputBuffer.encodeUint32(utcTime)
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

  public companion object {
    private const val ID: Int = 224

    private const val CRC: Int = 102

    private const val SIZE: Int = 45

    private val DESERIALIZER: MavDeserializer<CommandLongStamped> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val vehicleTimestamp = inputBuffer.decodeUint64()
      val utcTime = inputBuffer.decodeUint32()
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

      CommandLongStamped(
        utcTime = utcTime,
        vehicleTimestamp = vehicleTimestamp,
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


    private val METADATA: MavMessage.Metadata<CommandLongStamped> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CommandLongStamped> = METADATA
  }
}
