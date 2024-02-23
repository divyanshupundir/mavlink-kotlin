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
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt32
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
 * Sets a desired vehicle position in a local north-east-down coordinate frame. Used by an external
 * controller to command the vehicle (manual controller or other system).
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param coordinateFrame Valid options are: MAV_FRAME_LOCAL_NED = 1, MAV_FRAME_LOCAL_OFFSET_NED =
 * 7, MAV_FRAME_BODY_NED = 8, MAV_FRAME_BODY_OFFSET_NED = 9
 * @param typeMask Bitmap to indicate which dimensions should be ignored by the vehicle.
 * @param x X Position in NED frame
 * units = m
 * @param y Y Position in NED frame
 * units = m
 * @param z Z Position in NED frame (note, altitude is negative in NED)
 * units = m
 * @param vx X velocity in NED frame
 * units = m/s
 * @param vy Y velocity in NED frame
 * units = m/s
 * @param vz Z velocity in NED frame
 * units = m/s
 * @param afx X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or
 * N
 * units = m/s/s
 * @param afy Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or
 * N
 * units = m/s/s
 * @param afz Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or
 * N
 * units = m/s/s
 * @param yaw yaw setpoint
 * units = rad
 * @param yawRate yaw rate setpoint
 * units = rad/s
 */
@GeneratedMavMessage(
  id = 84u,
  crcExtra = -113,
)
public data class SetPositionTargetLocalNed(
  /**
   * Timestamp (time since system boot).
   * units = ms
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
   * Valid options are: MAV_FRAME_LOCAL_NED = 1, MAV_FRAME_LOCAL_OFFSET_NED = 7, MAV_FRAME_BODY_NED
   * = 8, MAV_FRAME_BODY_OFFSET_NED = 9
   */
  @GeneratedMavField(type = "uint8_t")
  public val coordinateFrame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u),
  /**
   * Bitmap to indicate which dimensions should be ignored by the vehicle.
   */
  @GeneratedMavField(type = "uint16_t")
  public val typeMask: MavBitmaskValue<PositionTargetTypemask> = MavBitmaskValue.fromValue(0u),
  /**
   * X Position in NED frame
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * Y Position in NED frame
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * Z Position in NED frame (note, altitude is negative in NED)
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
  /**
   * X velocity in NED frame
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vx: Float = 0F,
  /**
   * Y velocity in NED frame
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vy: Float = 0F,
  /**
   * Z velocity in NED frame
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vz: Float = 0F,
  /**
   * X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val afx: Float = 0F,
  /**
   * Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val afy: Float = 0F,
  /**
   * Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N
   * units = m/s/s
   */
  @GeneratedMavField(type = "float")
  public val afz: Float = 0F,
  /**
   * yaw setpoint
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * yaw rate setpoint
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val yawRate: Float = 0F,
) : MavMessage<SetPositionTargetLocalNed> {
  override val instanceCompanion: MavMessage.MavCompanion<SetPositionTargetLocalNed> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloat(vx)
    encoder.encodeFloat(vy)
    encoder.encodeFloat(vz)
    encoder.encodeFloat(afx)
    encoder.encodeFloat(afy)
    encoder.encodeFloat(afz)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(yawRate)
    encoder.encodeBitmaskValue(typeMask.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(coordinateFrame.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloat(vx)
    encoder.encodeFloat(vy)
    encoder.encodeFloat(vz)
    encoder.encodeFloat(afx)
    encoder.encodeFloat(afy)
    encoder.encodeFloat(afz)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(yawRate)
    encoder.encodeBitmaskValue(typeMask.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(coordinateFrame.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SetPositionTargetLocalNed> {
    private const val SIZE_V1: Int = 53

    private const val SIZE_V2: Int = 53

    override val id: UInt = 84u

    override val crcExtra: Byte = -113

    override fun deserialize(bytes: ByteArray): SetPositionTargetLocalNed {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val x = decoder.safeDecodeFloat()
      val y = decoder.safeDecodeFloat()
      val z = decoder.safeDecodeFloat()
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
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val coordinateFrame = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return SetPositionTargetLocalNed(
        timeBootMs = timeBootMs,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        coordinateFrame = coordinateFrame,
        typeMask = typeMask,
        x = x,
        y = y,
        z = z,
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

    public operator fun invoke(builderAction: Builder.() -> Unit): SetPositionTargetLocalNed =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var coordinateFrame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u)

    public var typeMask: MavBitmaskValue<PositionTargetTypemask> = MavBitmaskValue.fromValue(0u)

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public var vx: Float = 0F

    public var vy: Float = 0F

    public var vz: Float = 0F

    public var afx: Float = 0F

    public var afy: Float = 0F

    public var afz: Float = 0F

    public var yaw: Float = 0F

    public var yawRate: Float = 0F

    public fun build(): SetPositionTargetLocalNed = SetPositionTargetLocalNed(
      timeBootMs = timeBootMs,
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      coordinateFrame = coordinateFrame,
      typeMask = typeMask,
      x = x,
      y = y,
      z = z,
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
