package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Deprecated
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Message encoding a mission item. This message is emitted to announce
 *                 the presence of a mission item and to set a mission item on the system. The
 * mission item can be either in x, y, z meters (type: LOCAL) or x:lat, y:lon, z:altitude. Local frame
 * is Z-down, right handed (NED), global frame is Z-up, right handed (ENU). NaN may be used to indicate
 * an optional/default value (e.g. to use the system's current latitude or yaw rather than a specific
 * value). See also https://mavlink.io/en/services/mission.html.
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 39u,
  crcExtra = -2,
)
public data class MissionItem(
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
   * Sequence
   */
  @GeneratedMavField(type = "uint16_t")
  public val seq: UShort = 0u,
  /**
   * The coordinate system of the waypoint.
   */
  @GeneratedMavField(type = "uint8_t")
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u),
  /**
   * The scheduled action for the waypoint.
   */
  @GeneratedMavField(type = "uint16_t")
  public val command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0u),
  /**
   * false:0, true:1
   */
  @GeneratedMavField(type = "uint8_t")
  public val current: UByte = 0u,
  /**
   * Autocontinue to next waypoint
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
   * PARAM5 / local: X coordinate, global: latitude
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * PARAM6 / local: Y coordinate, global: longitude
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * PARAM7 / local: Z coordinate, global: altitude (relative or absolute, depending on frame).
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
  /**
   * Mission type.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val missionType: MavEnumValue<MavMissionType> = MavEnumValue.fromValue(0u),
) : MavMessage<MissionItem> {
  public override val instanceCompanion: MavMessage.MavCompanion<MissionItem> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(param1)
    output.encodeFloat(param2)
    output.encodeFloat(param3)
    output.encodeFloat(param4)
    output.encodeFloat(x)
    output.encodeFloat(y)
    output.encodeFloat(z)
    output.encodeUInt16(seq)
    output.encodeEnumValue(command.value, 2)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeEnumValue(frame.value, 1)
    output.encodeUInt8(current)
    output.encodeUInt8(autocontinue)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(param1)
    output.encodeFloat(param2)
    output.encodeFloat(param3)
    output.encodeFloat(param4)
    output.encodeFloat(x)
    output.encodeFloat(y)
    output.encodeFloat(z)
    output.encodeUInt16(seq)
    output.encodeEnumValue(command.value, 2)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeEnumValue(frame.value, 1)
    output.encodeUInt8(current)
    output.encodeUInt8(autocontinue)
    output.encodeEnumValue(missionType.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<MissionItem> {
    private const val SIZE_V1: Int = 37

    private const val SIZE_V2: Int = 38

    public override val id: UInt = 39u

    public override val crcExtra: Byte = -2

    public override fun deserialize(source: BufferedSource): MissionItem {
      val param1 = source.decodeFloat()
      val param2 = source.decodeFloat()
      val param3 = source.decodeFloat()
      val param4 = source.decodeFloat()
      val x = source.decodeFloat()
      val y = source.decodeFloat()
      val z = source.decodeFloat()
      val seq = source.decodeUInt16()
      val command = source.decodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val frame = source.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val current = source.decodeUInt8()
      val autocontinue = source.decodeUInt8()
      val missionType = source.decodeEnumValue(1).let { value ->
        val entry = MavMissionType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return MissionItem(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        seq = seq,
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
        missionType = missionType,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MissionItem =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var seq: UShort = 0u

    public var frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u)

    public var command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0u)

    public var current: UByte = 0u

    public var autocontinue: UByte = 0u

    public var param1: Float = 0F

    public var param2: Float = 0F

    public var param3: Float = 0F

    public var param4: Float = 0F

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public var missionType: MavEnumValue<MavMissionType> = MavEnumValue.fromValue(0u)

    public fun build(): MissionItem = MissionItem(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      seq = seq,
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
      missionType = missionType,
    )
  }
}
