package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Reports the current commanded vehicle position, velocity, and acceleration as specified by the
 * autopilot. This should match the commands sent in SET_POSITION_TARGET_GLOBAL_INT if the vehicle is
 * being controlled this way.
 *
 */
@GeneratedMavMessage(
  id = 87u,
  crcExtra = -106,
)
public data class PositionTargetGlobalInt(
  /**
   * Timestamp (time since system boot). The rationale for the timestamp in the setpoint is to allow
   * the system to compensate for the transport delay of the setpoint. This allows the system to
   * compensate processing latency.
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
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
   * Altitude (MSL, AGL or relative to home altitude, depending on frame)
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
) : MavMessage<PositionTargetGlobalInt> {
  override val instanceCompanion: MavMessage.MavCompanion<PositionTargetGlobalInt> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt32(latInt)
    encoder.encodeInt32(lonInt)
    encoder.encodeFloat(alt)
    encoder.encodeFloat(vx)
    encoder.encodeFloat(vy)
    encoder.encodeFloat(vz)
    encoder.encodeFloat(afx)
    encoder.encodeFloat(afy)
    encoder.encodeFloat(afz)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(yawRate)
    encoder.encodeBitmaskValue(typeMask.value, 2)
    encoder.encodeEnumValue(coordinateFrame.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt32(latInt)
    encoder.encodeInt32(lonInt)
    encoder.encodeFloat(alt)
    encoder.encodeFloat(vx)
    encoder.encodeFloat(vy)
    encoder.encodeFloat(vz)
    encoder.encodeFloat(afx)
    encoder.encodeFloat(afy)
    encoder.encodeFloat(afz)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(yawRate)
    encoder.encodeBitmaskValue(typeMask.value, 2)
    encoder.encodeEnumValue(coordinateFrame.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<PositionTargetGlobalInt> {
    private const val SIZE_V1: Int = 51

    private const val SIZE_V2: Int = 51

    override val id: UInt = 87u

    override val crcExtra: Byte = -106

    override fun deserialize(bytes: ByteArray): PositionTargetGlobalInt {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val latInt = decoder.safeDecodeInt32()
      val lonInt = decoder.safeDecodeInt32()
      val alt = decoder.safeDecodeFloat()
      val vx = decoder.safeDecodeFloat()
      val vy = decoder.safeDecodeFloat()
      val vz = decoder.safeDecodeFloat()
      val afx = decoder.safeDecodeFloat()
      val afy = decoder.safeDecodeFloat()
      val afz = decoder.safeDecodeFloat()
      val yaw = decoder.safeDecodeFloat()
      val yawRate = decoder.safeDecodeFloat()
      val typeMask = decoder.safeDecodeBitmaskValue(2).let { value ->
        val flags = PositionTargetTypemask.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val coordinateFrame = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return PositionTargetGlobalInt(
        timeBootMs = timeBootMs,
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

    public operator fun invoke(builderAction: Builder.() -> Unit): PositionTargetGlobalInt =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

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

    public fun build(): PositionTargetGlobalInt = PositionTargetGlobalInt(
      timeBootMs = timeBootMs,
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
