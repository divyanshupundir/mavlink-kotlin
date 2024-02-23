package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Send a command with up to seven parameters to the MAV, where params 5 and 6 are integers and the
 * other values are floats. This is preferred over COMMAND_LONG as it allows the MAV_FRAME to be
 * specified for interpreting positional information, such as altitude. COMMAND_INT is also preferred
 * when sending latitude and longitude data in params 5 and 6, as it allows for greater precision.
 * Param 5 and 6 encode positional data as scaled integers, where the scaling depends on the actual
 * command value. NaN or INT32_MAX may be used in float/integer params (respectively) to indicate
 * optional/default values (e.g. to use the component's current latitude, yaw rather than a specific
 * value). The command microservice is documented at https://mavlink.io/en/services/command.html
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param frame The coordinate system of the COMMAND.
 * @param command The scheduled action for the mission item.
 * @param current Not used.
 * @param autocontinue Not used (set 0).
 * @param param1 PARAM1, see MAV_CMD enum
 * @param param2 PARAM2, see MAV_CMD enum
 * @param param3 PARAM3, see MAV_CMD enum
 * @param param4 PARAM4, see MAV_CMD enum
 * @param x PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7
 * @param y PARAM6 / local: y position in meters * 1e4, global: longitude in degrees * 10^7
 * @param z PARAM7 / z position: global: altitude in meters (relative or absolute, depending on
 * frame).
 */
@GeneratedMavMessage(
  id = 75u,
  crcExtra = -98,
)
public data class CommandInt(
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
   * The coordinate system of the COMMAND.
   */
  @GeneratedMavField(type = "uint8_t")
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u),
  /**
   * The scheduled action for the mission item.
   */
  @GeneratedMavField(type = "uint16_t")
  public val command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0u),
  /**
   * Not used.
   */
  @GeneratedMavField(type = "uint8_t")
  public val current: UByte = 0u,
  /**
   * Not used (set 0).
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
   * PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame).
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
) : MavMessage<CommandInt> {
  override val instanceCompanion: MavMessage.MavCompanion<CommandInt> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(param1)
    encoder.encodeFloat(param2)
    encoder.encodeFloat(param3)
    encoder.encodeFloat(param4)
    encoder.encodeInt32(x)
    encoder.encodeInt32(y)
    encoder.encodeFloat(z)
    encoder.encodeEnumValue(command.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(frame.value, 1)
    encoder.encodeUInt8(current)
    encoder.encodeUInt8(autocontinue)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(param1)
    encoder.encodeFloat(param2)
    encoder.encodeFloat(param3)
    encoder.encodeFloat(param4)
    encoder.encodeInt32(x)
    encoder.encodeInt32(y)
    encoder.encodeFloat(z)
    encoder.encodeEnumValue(command.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(frame.value, 1)
    encoder.encodeUInt8(current)
    encoder.encodeUInt8(autocontinue)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CommandInt> {
    private const val SIZE_V1: Int = 35

    private const val SIZE_V2: Int = 35

    override val id: UInt = 75u

    override val crcExtra: Byte = -98

    override fun deserialize(bytes: ByteArray): CommandInt {
      val decoder = MavDataDecoder(bytes)

      val param1 = decoder.safeDecodeFloat()
      val param2 = decoder.safeDecodeFloat()
      val param3 = decoder.safeDecodeFloat()
      val param4 = decoder.safeDecodeFloat()
      val x = decoder.safeDecodeInt32()
      val y = decoder.safeDecodeInt32()
      val z = decoder.safeDecodeFloat()
      val command = decoder.safeDecodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val frame = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val current = decoder.safeDecodeUInt8()
      val autocontinue = decoder.safeDecodeUInt8()

      return CommandInt(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): CommandInt =
        Builder().apply(builderAction).build()
  }

  public class Builder {
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

    public fun build(): CommandInt = CommandInt(
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
