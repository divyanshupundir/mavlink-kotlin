package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.common.MavCmd
import com.divpundir.mavlink.definitions.common.MavFrame
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
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
 * Message encoding a command with parameters as scaled integers and additional metadata. Scaling
 * depends on the actual command value.
 */
@GeneratedMavMessage(
  id = 223u,
  crcExtra = 119,
)
public data class CommandIntStamped(
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
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * The coordinate system of the COMMAND, as defined by MAV_FRAME enum
   */
  @GeneratedMavField(type = "uint8_t")
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u),
  /**
   * The scheduled action for the mission item, as defined by MAV_CMD enum
   */
  @GeneratedMavField(type = "uint16_t")
  public val command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0u),
  /**
   * false:0, true:1
   */
  @GeneratedMavField(type = "uint8_t")
  public val current: UByte = 0u,
  /**
   * autocontinue to next wp
   */
  @GeneratedMavField(type = "uint8_t")
  public val autocontinue: UByte = 0u,
  /**
   * PARAM1, see MAV_CMD enum
   */
  @GeneratedMavField(type = "float")
  public val param1: Float = 0F,
  /**
   * PARAM2, see MAV_CMD enum
   */
  @GeneratedMavField(type = "float")
  public val param2: Float = 0F,
  /**
   * PARAM3, see MAV_CMD enum
   */
  @GeneratedMavField(type = "float")
  public val param3: Float = 0F,
  /**
   * PARAM4, see MAV_CMD enum
   */
  @GeneratedMavField(type = "float")
  public val param4: Float = 0F,
  /**
   * PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7
   */
  @GeneratedMavField(type = "int32_t")
  public val x: Int = 0,
  /**
   * PARAM6 / local: y position in meters * 1e4, global: longitude in degrees * 10^7
   */
  @GeneratedMavField(type = "int32_t")
  public val y: Int = 0,
  /**
   * PARAM7 / z position: global: altitude in meters (MSL, WGS84, AGL or relative to home -
   * depending on frame).
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
) : MavMessage<CommandIntStamped> {
  public override val instanceCompanion: MavMessage.MavCompanion<CommandIntStamped> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(vehicleTimestamp)
    outputBuffer.encodeUInt32(utcTime)
    outputBuffer.encodeFloat(param1)
    outputBuffer.encodeFloat(param2)
    outputBuffer.encodeFloat(param3)
    outputBuffer.encodeFloat(param4)
    outputBuffer.encodeInt32(x)
    outputBuffer.encodeInt32(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeEnumValue(command.value, 2)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeEnumValue(frame.value, 1)
    outputBuffer.encodeUInt8(current)
    outputBuffer.encodeUInt8(autocontinue)
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
    outputBuffer.encodeInt32(x)
    outputBuffer.encodeInt32(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeEnumValue(command.value, 2)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeEnumValue(frame.value, 1)
    outputBuffer.encodeUInt8(current)
    outputBuffer.encodeUInt8(autocontinue)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CommandIntStamped> {
    private const val SIZE_V1: Int = 47

    private const val SIZE_V2: Int = 47

    public override val id: UInt = 223u

    public override val crcExtra: Byte = 119

    public override fun deserialize(bytes: ByteArray): CommandIntStamped {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val vehicleTimestamp = inputBuffer.decodeUInt64()
      val utcTime = inputBuffer.decodeUInt32()
      val param1 = inputBuffer.decodeFloat()
      val param2 = inputBuffer.decodeFloat()
      val param3 = inputBuffer.decodeFloat()
      val param4 = inputBuffer.decodeFloat()
      val x = inputBuffer.decodeInt32()
      val y = inputBuffer.decodeInt32()
      val z = inputBuffer.decodeFloat()
      val command = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val frame = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val current = inputBuffer.decodeUInt8()
      val autocontinue = inputBuffer.decodeUInt8()

      return CommandIntStamped(
        utcTime = utcTime,
        vehicleTimestamp = vehicleTimestamp,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        frame = frame,
        command = command,
        current = current,
        autocontinue = autocontinue,
        param1 = param1,
        param2 = param2,
        param3 = param3,
        param4 = param4,
        x = x,
        y = y,
        z = z,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CommandIntStamped =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var utcTime: UInt = 0u

    public var vehicleTimestamp: ULong = 0uL

    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u)

    public var command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0u)

    public var current: UByte = 0u

    public var autocontinue: UByte = 0u

    public var param1: Float = 0F

    public var param2: Float = 0F

    public var param3: Float = 0F

    public var param4: Float = 0F

    public var x: Int = 0

    public var y: Int = 0

    public var z: Float = 0F

    public fun build(): CommandIntStamped = CommandIntStamped(
      utcTime = utcTime,
      vehicleTimestamp = vehicleTimestamp,
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      frame = frame,
      command = command,
      current = current,
      autocontinue = autocontinue,
      param1 = param1,
      param2 = param2,
      param3 = param3,
      param4 = param4,
      x = x,
      y = y,
      z = z,
    )
  }
}
