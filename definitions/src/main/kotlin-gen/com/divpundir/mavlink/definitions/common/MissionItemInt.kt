package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Message encoding a mission item. This message is emitted to announce
 *                 the presence of a mission item and to set a mission item on the system. The
 * mission item can be either in x, y, z meters (type: LOCAL) or x:lat, y:lon, z:altitude. Local frame
 * is Z-down, right handed (NED), global frame is Z-up, right handed (ENU). NaN or INT32_MAX may be
 * used in float/integer params (respectively) to indicate optional/default values (e.g. to use the
 * component's current latitude, yaw rather than a specific value). See also
 * https://mavlink.io/en/services/mission.html.
 */
@GeneratedMavMessage(
  id = 73u,
  crcExtra = 38,
)
public data class MissionItemInt(
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
   * Waypoint ID (sequence number). Starts at zero. Increases monotonically for each waypoint, no
   * gaps in the sequence (0,1,2,3,4).
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
   * PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7
   */
  @GeneratedMavField(type = "int32_t")
  public val x: Int = 0,
  /**
   * PARAM6 / y position: local: x position in meters * 1e4, global: longitude in degrees *10^7
   */
  @GeneratedMavField(type = "int32_t")
  public val y: Int = 0,
  /**
   * PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame.
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
) : MavMessage<MissionItemInt> {
  public override val instanceCompanion: MavMessage.MavCompanion<MissionItemInt> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(param1)
    buffer.encodeFloat(param2)
    buffer.encodeFloat(param3)
    buffer.encodeFloat(param4)
    buffer.encodeInt32(x)
    buffer.encodeInt32(y)
    buffer.encodeFloat(z)
    buffer.encodeUInt16(seq)
    buffer.encodeEnumValue(command.value, 2)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeEnumValue(frame.value, 1)
    buffer.encodeUInt8(current)
    buffer.encodeUInt8(autocontinue)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(param1)
    buffer.encodeFloat(param2)
    buffer.encodeFloat(param3)
    buffer.encodeFloat(param4)
    buffer.encodeInt32(x)
    buffer.encodeInt32(y)
    buffer.encodeFloat(z)
    buffer.encodeUInt16(seq)
    buffer.encodeEnumValue(command.value, 2)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeEnumValue(frame.value, 1)
    buffer.encodeUInt8(current)
    buffer.encodeUInt8(autocontinue)
    buffer.encodeEnumValue(missionType.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MissionItemInt> {
    public override val id: UInt = 73u

    public override val crcExtra: Byte = 38

    public override fun deserialize(bytes: ByteArray): MissionItemInt {
      val buffer = Buffer().write(bytes)

      val param1 = buffer.decodeFloat()
      val param2 = buffer.decodeFloat()
      val param3 = buffer.decodeFloat()
      val param4 = buffer.decodeFloat()
      val x = buffer.decodeInt32()
      val y = buffer.decodeInt32()
      val z = buffer.decodeFloat()
      val seq = buffer.decodeUInt16()
      val command = buffer.decodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val frame = buffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val current = buffer.decodeUInt8()
      val autocontinue = buffer.decodeUInt8()
      val missionType = buffer.decodeEnumValue(1).let { value ->
        val entry = MavMissionType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return MissionItemInt(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): MissionItemInt =
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

    public var x: Int = 0

    public var y: Int = 0

    public var z: Float = 0F

    public var missionType: MavEnumValue<MavMissionType> = MavEnumValue.fromValue(0u)

    public fun build(): MissionItemInt = MissionItemInt(
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
