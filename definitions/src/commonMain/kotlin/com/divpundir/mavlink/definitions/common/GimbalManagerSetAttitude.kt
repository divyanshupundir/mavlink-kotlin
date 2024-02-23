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
 * High level message to control a gimbal's attitude. This message is to be sent to the gimbal
 * manager (e.g. from a ground station). Angles and rates can be set to NaN according to use case.
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param flags High level gimbal manager flags to use.
 * @param gimbalDeviceId Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0
 * for all gimbal device components. Send command multiple times for more than one gimbal (but not all
 * gimbals).
 * @param q Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation, the frame is depends on
 * whether the flag GIMBAL_MANAGER_FLAGS_YAW_LOCK is set)
 * @param angularVelocityX X component of angular velocity, positive is rolling to the right, NaN to
 * be ignored.
 * units = rad/s
 * @param angularVelocityY Y component of angular velocity, positive is pitching up, NaN to be
 * ignored.
 * units = rad/s
 * @param angularVelocityZ Z component of angular velocity, positive is yawing to the right, NaN to
 * be ignored.
 * units = rad/s
 */
@GeneratedMavMessage(
  id = 282u,
  crcExtra = 123,
)
public data class GimbalManagerSetAttitude(
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
   * High level gimbal manager flags to use.
   */
  @GeneratedMavField(type = "uint32_t")
  public val flags: MavBitmaskValue<GimbalManagerFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal
   * device components. Send command multiple times for more than one gimbal (but not all gimbals).
   */
  @GeneratedMavField(type = "uint8_t")
  public val gimbalDeviceId: UByte = 0u,
  /**
   * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation, the frame is depends on
   * whether the flag GIMBAL_MANAGER_FLAGS_YAW_LOCK is set)
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * X component of angular velocity, positive is rolling to the right, NaN to be ignored.
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityX: Float = 0F,
  /**
   * Y component of angular velocity, positive is pitching up, NaN to be ignored.
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityY: Float = 0F,
  /**
   * Z component of angular velocity, positive is yawing to the right, NaN to be ignored.
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityZ: Float = 0F,
) : MavMessage<GimbalManagerSetAttitude> {
  override val instanceCompanion: MavMessage.MavCompanion<GimbalManagerSetAttitude> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeBitmaskValue(flags.value, 4)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(angularVelocityX)
    encoder.encodeFloat(angularVelocityY)
    encoder.encodeFloat(angularVelocityZ)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(gimbalDeviceId)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeBitmaskValue(flags.value, 4)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(angularVelocityX)
    encoder.encodeFloat(angularVelocityY)
    encoder.encodeFloat(angularVelocityZ)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(gimbalDeviceId)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalManagerSetAttitude> {
    private const val SIZE_V1: Int = 35

    private const val SIZE_V2: Int = 35

    override val id: UInt = 282u

    override val crcExtra: Byte = 123

    override fun deserialize(bytes: ByteArray): GimbalManagerSetAttitude {
      val decoder = MavDataDecoder(bytes)

      val flags = decoder.safeDecodeBitmaskValue(4).let { value ->
        val flags = GimbalManagerFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val q = decoder.safeDecodeFloatArray(16)
      val angularVelocityX = decoder.safeDecodeFloat()
      val angularVelocityY = decoder.safeDecodeFloat()
      val angularVelocityZ = decoder.safeDecodeFloat()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val gimbalDeviceId = decoder.safeDecodeUInt8()

      return GimbalManagerSetAttitude(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        flags = flags,
        gimbalDeviceId = gimbalDeviceId,
        q = q,
        angularVelocityX = angularVelocityX,
        angularVelocityY = angularVelocityY,
        angularVelocityZ = angularVelocityZ,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GimbalManagerSetAttitude =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var flags: MavBitmaskValue<GimbalManagerFlags> = MavBitmaskValue.fromValue(0u)

    public var gimbalDeviceId: UByte = 0u

    public var q: List<Float> = emptyList()

    public var angularVelocityX: Float = 0F

    public var angularVelocityY: Float = 0F

    public var angularVelocityZ: Float = 0F

    public fun build(): GimbalManagerSetAttitude = GimbalManagerSetAttitude(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      flags = flags,
      gimbalDeviceId = gimbalDeviceId,
      q = q,
      angularVelocityX = angularVelocityX,
      angularVelocityY = angularVelocityY,
      angularVelocityZ = angularVelocityZ,
    )
  }
}
