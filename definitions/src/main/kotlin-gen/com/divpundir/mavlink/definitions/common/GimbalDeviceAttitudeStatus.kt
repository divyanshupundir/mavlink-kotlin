package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
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
 * Message reporting the status of a gimbal device. This message should be broadcasted by a gimbal
 * device component. The angles encoded in the quaternion are relative to absolute North if the flag
 * GIMBAL_DEVICE_FLAGS_YAW_LOCK is set (roll: positive is rolling to the right, pitch: positive is
 * pitching up, yaw is turn to the right) or relative to the vehicle heading if the flag is not set.
 * This message should be broadcast at a low regular rate (e.g. 10Hz).
 */
@WorkInProgress
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
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Current gimbal flags set.
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavBitmaskValue<GimbalDeviceFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation, the frame is depends on
   * whether the flag GIMBAL_DEVICE_FLAGS_YAW_LOCK is set)
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * X component of angular velocity (NaN if unknown)
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityX: Float = 0F,
  /**
   * Y component of angular velocity (NaN if unknown)
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityY: Float = 0F,
  /**
   * Z component of angular velocity (NaN if unknown)
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityZ: Float = 0F,
  /**
   * Failure flags (0 for no failure)
   */
  @GeneratedMavField(type = "uint32_t")
  public val failureFlags: MavBitmaskValue<GimbalDeviceErrorFlags> = MavBitmaskValue.fromValue(0u),
) : MavMessage<GimbalDeviceAttitudeStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<GimbalDeviceAttitudeStatus> =
      Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
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

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(angularVelocityX)
    encoder.encodeFloat(angularVelocityY)
    encoder.encodeFloat(angularVelocityZ)
    encoder.encodeBitmaskValue(failureFlags.value, 4)
    encoder.encodeBitmaskValue(flags.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalDeviceAttitudeStatus> {
    private const val SIZE_V1: Int = 40

    private const val SIZE_V2: Int = 40

    public override val id: UInt = 285u

    public override val crcExtra: Byte = -119

    public override fun deserialize(bytes: ByteArray): GimbalDeviceAttitudeStatus {
      val decoder = MavDataDecoder.wrap(bytes)

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
    )
  }
}
