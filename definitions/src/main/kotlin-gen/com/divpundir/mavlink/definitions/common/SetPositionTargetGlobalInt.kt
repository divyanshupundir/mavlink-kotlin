package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Sets a desired vehicle position, velocity, and/or acceleration in a global coordinate system
 * (WGS84). Used by an external controller to command the vehicle (manual controller or other system).
 */
@GeneratedMavMessage(
  id = 86u,
  crcExtra = 5,
)
public data class SetPositionTargetGlobalInt(
  /**
   * Timestamp (time since system boot). The rationale for the timestamp in the setpoint is to allow
   * the system to compensate for the transport delay of the setpoint. This allows the system to
   * compensate processing latency.
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
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
   * Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6,
   * MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11
   */
  @GeneratedMavField(type = "uint8_t")
  public val coordinateFrame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u),
  /**
   * Bitmap to indicate which dimensions should be ignored by the vehicle.
   */
  @GeneratedMavField(type = "uint16_t")
  public val typeMask: MavBitmaskValue<PositionTargetTypemask> = MavBitmaskValue.fromValue(0u),
  /**
   * X Position in WGS84 frame
   */
  @GeneratedMavField(type = "int32_t")
  public val latInt: Int = 0,
  /**
   * Y Position in WGS84 frame
   */
  @GeneratedMavField(type = "int32_t")
  public val lonInt: Int = 0,
  /**
   * Altitude (MSL, Relative to home, or AGL - depending on frame)
   */
  @GeneratedMavField(type = "float")
  public val alt: Float = 0F,
  /**
   * X velocity in NED frame
   */
  @GeneratedMavField(type = "float")
  public val vx: Float = 0F,
  /**
   * Y velocity in NED frame
   */
  @GeneratedMavField(type = "float")
  public val vy: Float = 0F,
  /**
   * Z velocity in NED frame
   */
  @GeneratedMavField(type = "float")
  public val vz: Float = 0F,
  /**
   * X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N
   */
  @GeneratedMavField(type = "float")
  public val afx: Float = 0F,
  /**
   * Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N
   */
  @GeneratedMavField(type = "float")
  public val afy: Float = 0F,
  /**
   * Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N
   */
  @GeneratedMavField(type = "float")
  public val afz: Float = 0F,
  /**
   * yaw setpoint
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * yaw rate setpoint
   */
  @GeneratedMavField(type = "float")
  public val yawRate: Float = 0F,
) : MavMessage<SetPositionTargetGlobalInt> {
  public override val instanceCompanion: MavMessage.MavCompanion<SetPositionTargetGlobalInt> =
      Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeInt32(latInt)
    output.encodeInt32(lonInt)
    output.encodeFloat(alt)
    output.encodeFloat(vx)
    output.encodeFloat(vy)
    output.encodeFloat(vz)
    output.encodeFloat(afx)
    output.encodeFloat(afy)
    output.encodeFloat(afz)
    output.encodeFloat(yaw)
    output.encodeFloat(yawRate)
    output.encodeBitmaskValue(typeMask.value, 2)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeEnumValue(coordinateFrame.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeInt32(latInt)
    output.encodeInt32(lonInt)
    output.encodeFloat(alt)
    output.encodeFloat(vx)
    output.encodeFloat(vy)
    output.encodeFloat(vz)
    output.encodeFloat(afx)
    output.encodeFloat(afy)
    output.encodeFloat(afz)
    output.encodeFloat(yaw)
    output.encodeFloat(yawRate)
    output.encodeBitmaskValue(typeMask.value, 2)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeEnumValue(coordinateFrame.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SetPositionTargetGlobalInt> {
    private const val SIZE_V1: Int = 53

    private const val SIZE_V2: Int = 53

    public override val id: UInt = 86u

    public override val crcExtra: Byte = 5

    public override fun deserialize(source: BufferedSource): SetPositionTargetGlobalInt {
      val timeBootMs = source.decodeUInt32()
      val latInt = source.decodeInt32()
      val lonInt = source.decodeInt32()
      val alt = source.decodeFloat()
      val vx = source.decodeFloat()
      val vy = source.decodeFloat()
      val vz = source.decodeFloat()
      val afx = source.decodeFloat()
      val afy = source.decodeFloat()
      val afz = source.decodeFloat()
      val yaw = source.decodeFloat()
      val yawRate = source.decodeFloat()
      val typeMask = source.decodeBitmaskValue(2).let { value ->
        val flags = PositionTargetTypemask.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val coordinateFrame = source.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return SetPositionTargetGlobalInt(
        timeBootMs = timeBootMs,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        coordinateFrame = coordinateFrame,
        typeMask = typeMask,
        latInt = latInt,
        lonInt = lonInt,
        alt = alt,
        vx = vx,
        vy = vy,
        vz = vz,
        afx = afx,
        afy = afy,
        afz = afz,
        yaw = yaw,
        yawRate = yawRate,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SetPositionTargetGlobalInt =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var coordinateFrame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u)

    public var typeMask: MavBitmaskValue<PositionTargetTypemask> = MavBitmaskValue.fromValue(0u)

    public var latInt: Int = 0

    public var lonInt: Int = 0

    public var alt: Float = 0F

    public var vx: Float = 0F

    public var vy: Float = 0F

    public var vz: Float = 0F

    public var afx: Float = 0F

    public var afy: Float = 0F

    public var afz: Float = 0F

    public var yaw: Float = 0F

    public var yawRate: Float = 0F

    public fun build(): SetPositionTargetGlobalInt = SetPositionTargetGlobalInt(
      timeBootMs = timeBootMs,
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      coordinateFrame = coordinateFrame,
      typeMask = typeMask,
      latInt = latInt,
      lonInt = lonInt,
      alt = alt,
      vx = vx,
      vy = vy,
      vz = vz,
      afx = afx,
      afy = afy,
      afz = afz,
      yaw = yaw,
      yawRate = yawRate,
    )
  }
}
