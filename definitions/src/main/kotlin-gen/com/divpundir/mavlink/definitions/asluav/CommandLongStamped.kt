package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.common.MavCmd
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
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
  public override val instanceCompanion: MavMessage.MavCompanion<CommandLongStamped> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt64(vehicleTimestamp)
    encoder.encodeUInt32(utcTime)
    encoder.encodeFloat(param1)
    encoder.encodeFloat(param2)
    encoder.encodeFloat(param3)
    encoder.encodeFloat(param4)
    encoder.encodeFloat(param5)
    encoder.encodeFloat(param6)
    encoder.encodeFloat(param7)
    encoder.encodeEnumValue(command.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(confirmation)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt64(vehicleTimestamp)
    encoder.encodeUInt32(utcTime)
    encoder.encodeFloat(param1)
    encoder.encodeFloat(param2)
    encoder.encodeFloat(param3)
    encoder.encodeFloat(param4)
    encoder.encodeFloat(param5)
    encoder.encodeFloat(param6)
    encoder.encodeFloat(param7)
    encoder.encodeEnumValue(command.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(confirmation)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CommandLongStamped> {
    private const val SIZE_V1: Int = 45

    private const val SIZE_V2: Int = 45

    public override val id: UInt = 224u

    public override val crcExtra: Byte = 102

    public override fun deserialize(bytes: ByteArray): CommandLongStamped {
      val decoder = MavDataDecoder.wrap(bytes)

      val vehicleTimestamp = decoder.safeDecodeUInt64()
      val utcTime = decoder.safeDecodeUInt32()
      val param1 = decoder.safeDecodeFloat()
      val param2 = decoder.safeDecodeFloat()
      val param3 = decoder.safeDecodeFloat()
      val param4 = decoder.safeDecodeFloat()
      val param5 = decoder.safeDecodeFloat()
      val param6 = decoder.safeDecodeFloat()
      val param7 = decoder.safeDecodeFloat()
      val command = decoder.safeDecodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val confirmation = decoder.safeDecodeUInt8()

      return CommandLongStamped(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): CommandLongStamped =
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
