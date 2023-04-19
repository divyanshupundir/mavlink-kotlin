package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.common.MavCmd
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * Send a command with up to seven parameters to the MAV and additional metadata
 */
@GeneratedMavMessage(
  id = 224u,
  crcExtra = 102,
)
public data class CommandLongStamped(
  /**
   * UTC time, seconds elapsed since 01.01.1970
   */
  @GeneratedMavField(type = "uint32_t")
  public val utcTime: UInt = 0u,
  /**
   * Microseconds elapsed since vehicle boot
   */
  @GeneratedMavField(type = "uint64_t")
  public val vehicleTimestamp: ULong = 0uL,
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
   * Command ID, as defined by MAV_CMD enum.
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
   * Parameter 1, as defined by MAV_CMD enum.
   */
  @GeneratedMavField(type = "float")
  public val param1: Float = 0F,
  /**
   * Parameter 2, as defined by MAV_CMD enum.
   */
  @GeneratedMavField(type = "float")
  public val param2: Float = 0F,
  /**
   * Parameter 3, as defined by MAV_CMD enum.
   */
  @GeneratedMavField(type = "float")
  public val param3: Float = 0F,
  /**
   * Parameter 4, as defined by MAV_CMD enum.
   */
  @GeneratedMavField(type = "float")
  public val param4: Float = 0F,
  /**
   * Parameter 5, as defined by MAV_CMD enum.
   */
  @GeneratedMavField(type = "float")
  public val param5: Float = 0F,
  /**
   * Parameter 6, as defined by MAV_CMD enum.
   */
  @GeneratedMavField(type = "float")
  public val param6: Float = 0F,
  /**
   * Parameter 7, as defined by MAV_CMD enum.
   */
  @GeneratedMavField(type = "float")
  public val param7: Float = 0F,
) : MavMessage<CommandLongStamped> {
  public override val instanceMetadata: MavMessage.Metadata<CommandLongStamped> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(vehicleTimestamp)
    outputBuffer.encodeUInt32(utcTime)
    outputBuffer.encodeFloat(param1)
    outputBuffer.encodeFloat(param2)
    outputBuffer.encodeFloat(param3)
    outputBuffer.encodeFloat(param4)
    outputBuffer.encodeFloat(param5)
    outputBuffer.encodeFloat(param6)
    outputBuffer.encodeFloat(param7)
    outputBuffer.encodeEnumValue(command.value, 2)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(confirmation)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(vehicleTimestamp)
    outputBuffer.encodeUInt32(utcTime)
    outputBuffer.encodeFloat(param1)
    outputBuffer.encodeFloat(param2)
    outputBuffer.encodeFloat(param3)
    outputBuffer.encodeFloat(param4)
    outputBuffer.encodeFloat(param5)
    outputBuffer.encodeFloat(param6)
    outputBuffer.encodeFloat(param7)
    outputBuffer.encodeEnumValue(command.value, 2)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(confirmation)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 224u

    private const val CRC_EXTRA: Byte = 102

    private const val SIZE_V1: Int = 45

    private const val SIZE_V2: Int = 45

    private val DESERIALIZER: MavDeserializer<CommandLongStamped> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val vehicleTimestamp = inputBuffer.decodeUInt64()
      val utcTime = inputBuffer.decodeUInt32()
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
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val confirmation = inputBuffer.decodeUInt8()

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


    private val METADATA: MavMessage.Metadata<CommandLongStamped> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CommandLongStamped> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): CommandLongStamped =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var utcTime: UInt = 0u

    public var vehicleTimestamp: ULong = 0uL

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

    public fun build(): CommandLongStamped = CommandLongStamped(
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
}
