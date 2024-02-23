package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
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
import kotlin.collections.List

/**
 * Message reporting the status of a gimbal device.
 * 	  This message should be broadcast by a gimbal device component at a low regular rate (e.g. 5
 * Hz).
 * 	  For the angles encoded in the quaternion and the angular velocities holds:
 * 	  If the flag GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME is set, then they are relative to the
 * vehicle heading (vehicle frame).
 * 	  If the flag GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME is set, then they are relative to absolute
 * North (earth frame).
 * 	  If neither of these flags are set, then (for backwards compatibility) it holds:
 * 	  If the flag GIMBAL_DEVICE_FLAGS_YAW_LOCK is set, then they are relative to absolute North
 * (earth frame),
 * 	  else they are relative to the vehicle heading (vehicle frame).
 * 	  Other conditions of the flags are not allowed.
 * 	  The quaternion and angular velocities in the other frame can be calculated from delta_yaw and
 * delta_yaw_velocity as
 * 	  q_earth = q_delta_yaw * q_vehicle and w_earth = w_delta_yaw_velocity + w_vehicle (if not NaN).
 * 	  If neither the GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME nor the
 * GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME flag is set,
 * 	  then (for backwards compatibility) the data in the delta_yaw and delta_yaw_velocity fields are
 * to be ignored.
 * 	  New implementations should always set either GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME or
 * GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME,
 * 	  and always should set delta_yaw and delta_yaw_velocity either to the proper value or NaN.
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param flags Current gimbal flags set.
 * @param q Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). The frame is described
 * in the message description.
 * @param angularVelocityX X component of angular velocity (positive: rolling to the right). The
 * frame is described in the message description. NaN if unknown.
 * units = rad/s
 * @param angularVelocityY Y component of angular velocity (positive: pitching up). The frame is
 * described in the message description. NaN if unknown.
 * units = rad/s
 * @param angularVelocityZ Z component of angular velocity (positive: yawing to the right). The
 * frame is described in the message description. NaN if unknown.
 * units = rad/s
 * @param failureFlags Failure flags (0 for no failure)
 * @param deltaYaw Yaw angle relating the quaternions in earth and body frames (see message
 * description). NaN if unknown.
 * units = rad
 * @param deltaYawVelocity Yaw angular velocity relating the angular velocities in earth and body
 * frames (see message description). NaN if unknown.
 * units = rad/s
 * @param gimbalDeviceId This field is to be used if the gimbal manager and the gimbal device are
 * the same component and hence have the same component ID. This field is then set a number between
 * 1-6. If the component ID is separate, this field is not required and must be set to 0.
 */
@GeneratedMavMessage(
  id = 285u,
  crcExtra = -119,
)
public data class GimbalDeviceAttitudeStatus(
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
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Current gimbal flags set.
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavBitmaskValue<GimbalDeviceFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). The frame is described in the
   * message description.
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * X component of angular velocity (positive: rolling to the right). The frame is described in the
   * message description. NaN if unknown.
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityX: Float = 0F,
  /**
   * Y component of angular velocity (positive: pitching up). The frame is described in the message
   * description. NaN if unknown.
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityY: Float = 0F,
  /**
   * Z component of angular velocity (positive: yawing to the right). The frame is described in the
   * message description. NaN if unknown.
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityZ: Float = 0F,
  /**
   * Failure flags (0 for no failure)
   */
  @GeneratedMavField(type = "uint32_t")
  public val failureFlags: MavBitmaskValue<GimbalDeviceErrorFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Yaw angle relating the quaternions in earth and body frames (see message description). NaN if
   * unknown.
   * units = rad
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val deltaYaw: Float = 0F,
  /**
   * Yaw angular velocity relating the angular velocities in earth and body frames (see message
   * description). NaN if unknown.
   * units = rad/s
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val deltaYawVelocity: Float = 0F,
  /**
   * This field is to be used if the gimbal manager and the gimbal device are the same component and
   * hence have the same component ID. This field is then set a number between 1-6. If the component ID
   * is separate, this field is not required and must be set to 0.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val gimbalDeviceId: UByte = 0u,
) : MavMessage<GimbalDeviceAttitudeStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<GimbalDeviceAttitudeStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(angularVelocityX)
    encoder.encodeFloat(angularVelocityY)
    encoder.encodeFloat(angularVelocityZ)
    encoder.encodeBitmaskValue(failureFlags.value, 4)
    encoder.encodeBitmaskValue(flags.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(angularVelocityX)
    encoder.encodeFloat(angularVelocityY)
    encoder.encodeFloat(angularVelocityZ)
    encoder.encodeBitmaskValue(failureFlags.value, 4)
    encoder.encodeBitmaskValue(flags.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeFloat(deltaYaw)
    encoder.encodeFloat(deltaYawVelocity)
    encoder.encodeUInt8(gimbalDeviceId)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalDeviceAttitudeStatus> {
    private const val SIZE_V1: Int = 40

    private const val SIZE_V2: Int = 49

    override val id: UInt = 285u

    override val crcExtra: Byte = -119

    override fun deserialize(bytes: ByteArray): GimbalDeviceAttitudeStatus {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val q = decoder.safeDecodeFloatArray(16)
      val angularVelocityX = decoder.safeDecodeFloat()
      val angularVelocityY = decoder.safeDecodeFloat()
      val angularVelocityZ = decoder.safeDecodeFloat()
      val failureFlags = decoder.safeDecodeBitmaskValue(4).let { value ->
        val flags = GimbalDeviceErrorFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val flags = decoder.safeDecodeBitmaskValue(2).let { value ->
        val flags = GimbalDeviceFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val deltaYaw = decoder.safeDecodeFloat()
      val deltaYawVelocity = decoder.safeDecodeFloat()
      val gimbalDeviceId = decoder.safeDecodeUInt8()

      return GimbalDeviceAttitudeStatus(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        timeBootMs = timeBootMs,
        flags = flags,
        q = q,
        angularVelocityX = angularVelocityX,
        angularVelocityY = angularVelocityY,
        angularVelocityZ = angularVelocityZ,
        failureFlags = failureFlags,
        deltaYaw = deltaYaw,
        deltaYawVelocity = deltaYawVelocity,
        gimbalDeviceId = gimbalDeviceId,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GimbalDeviceAttitudeStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var timeBootMs: UInt = 0u

    public var flags: MavBitmaskValue<GimbalDeviceFlags> = MavBitmaskValue.fromValue(0u)

    public var q: List<Float> = emptyList()

    public var angularVelocityX: Float = 0F

    public var angularVelocityY: Float = 0F

    public var angularVelocityZ: Float = 0F

    public var failureFlags: MavBitmaskValue<GimbalDeviceErrorFlags> = MavBitmaskValue.fromValue(0u)

    public var deltaYaw: Float = 0F

    public var deltaYawVelocity: Float = 0F

    public var gimbalDeviceId: UByte = 0u

    public fun build(): GimbalDeviceAttitudeStatus = GimbalDeviceAttitudeStatus(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      timeBootMs = timeBootMs,
      flags = flags,
      q = q,
      angularVelocityX = angularVelocityX,
      angularVelocityY = angularVelocityY,
      angularVelocityZ = angularVelocityZ,
      failureFlags = failureFlags,
      deltaYaw = deltaYaw,
      deltaYawVelocity = deltaYawVelocity,
      gimbalDeviceId = gimbalDeviceId,
    )
  }
}
