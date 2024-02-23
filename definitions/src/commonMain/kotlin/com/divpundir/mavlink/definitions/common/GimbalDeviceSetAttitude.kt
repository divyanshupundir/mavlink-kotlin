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
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
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
 * Low level message to control a gimbal device's attitude.
 * 	  This message is to be sent from the gimbal manager to the gimbal device component.
 * 	  The quaternion and angular velocities can be set to NaN according to use case.
 * 	  For the angles encoded in the quaternion and the angular velocities holds:
 * 	  If the flag GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME is set, then they are relative to the
 * vehicle heading (vehicle frame).
 * 	  If the flag GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME is set, then they are relative to absolute
 * North (earth frame).
 * 	  If neither of these flags are set, then (for backwards compatibility) it holds:
 * 	  If the flag GIMBAL_DEVICE_FLAGS_YAW_LOCK is set, then they are relative to absolute North
 * (earth frame),
 * 	  else they are relative to the vehicle heading (vehicle frame).
 * 	  Setting both GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME and
 * GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME is not allowed.
 * 	  These rules are to ensure backwards compatibility.
 * 	  New implementations should always set either GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME or
 * GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME.
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param flags Low level gimbal flags.
 * @param q Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). The frame is described
 * in the message description. Set fields to NaN to be ignored.
 * @param angularVelocityX X component of angular velocity (positive: rolling to the right). The
 * frame is described in the message description. NaN to be ignored.
 * units = rad/s
 * @param angularVelocityY Y component of angular velocity (positive: pitching up). The frame is
 * described in the message description. NaN to be ignored.
 * units = rad/s
 * @param angularVelocityZ Z component of angular velocity (positive: yawing to the right). The
 * frame is described in the message description. NaN to be ignored.
 * units = rad/s
 */
@GeneratedMavMessage(
  id = 284u,
  crcExtra = 99,
)
public data class GimbalDeviceSetAttitude(
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
   * Low level gimbal flags.
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavBitmaskValue<GimbalDeviceFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). The frame is described in the
   * message description. Set fields to NaN to be ignored.
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * X component of angular velocity (positive: rolling to the right). The frame is described in the
   * message description. NaN to be ignored.
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityX: Float = 0F,
  /**
   * Y component of angular velocity (positive: pitching up). The frame is described in the message
   * description. NaN to be ignored.
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityY: Float = 0F,
  /**
   * Z component of angular velocity (positive: yawing to the right). The frame is described in the
   * message description. NaN to be ignored.
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityZ: Float = 0F,
) : MavMessage<GimbalDeviceSetAttitude> {
  override val instanceCompanion: MavMessage.MavCompanion<GimbalDeviceSetAttitude> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(angularVelocityX)
    encoder.encodeFloat(angularVelocityY)
    encoder.encodeFloat(angularVelocityZ)
    encoder.encodeBitmaskValue(flags.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(angularVelocityX)
    encoder.encodeFloat(angularVelocityY)
    encoder.encodeFloat(angularVelocityZ)
    encoder.encodeBitmaskValue(flags.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalDeviceSetAttitude> {
    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 32

    override val id: UInt = 284u

    override val crcExtra: Byte = 99

    override fun deserialize(bytes: ByteArray): GimbalDeviceSetAttitude {
      val decoder = MavDataDecoder(bytes)

      val q = decoder.safeDecodeFloatArray(16)
      val angularVelocityX = decoder.safeDecodeFloat()
      val angularVelocityY = decoder.safeDecodeFloat()
      val angularVelocityZ = decoder.safeDecodeFloat()
      val flags = decoder.safeDecodeBitmaskValue(2).let { value ->
        val flags = GimbalDeviceFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return GimbalDeviceSetAttitude(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        flags = flags,
        q = q,
        angularVelocityX = angularVelocityX,
        angularVelocityY = angularVelocityY,
        angularVelocityZ = angularVelocityZ,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GimbalDeviceSetAttitude =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var flags: MavBitmaskValue<GimbalDeviceFlags> = MavBitmaskValue.fromValue(0u)

    public var q: List<Float> = emptyList()

    public var angularVelocityX: Float = 0F

    public var angularVelocityY: Float = 0F

    public var angularVelocityZ: Float = 0F

    public fun build(): GimbalDeviceSetAttitude = GimbalDeviceSetAttitude(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      flags = flags,
      q = q,
      angularVelocityX = angularVelocityX,
      angularVelocityY = angularVelocityY,
      angularVelocityZ = angularVelocityZ,
    )
  }
}
