package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

/**
 * High level message to control a gimbal's attitude. This message is to be sent to the gimbal
 * manager (e.g. from a ground station). Angles and rates can be set to NaN according to use case.
 */
@WorkInProgress
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
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityX: Float = 0F,
  /**
   * Y component of angular velocity, positive is pitching up, NaN to be ignored.
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityY: Float = 0F,
  /**
   * Z component of angular velocity, positive is yawing to the right, NaN to be ignored.
   */
  @GeneratedMavField(type = "float")
  public val angularVelocityZ: Float = 0F,
) : MavMessage<GimbalManagerSetAttitude> {
  public override val instanceCompanion: MavMessage.MavCompanion<GimbalManagerSetAttitude> =
      Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeBitmaskValue(flags.value, 4)
    buffer.encodeFloatArray(q, 16)
    buffer.encodeFloat(angularVelocityX)
    buffer.encodeFloat(angularVelocityY)
    buffer.encodeFloat(angularVelocityZ)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(gimbalDeviceId)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeBitmaskValue(flags.value, 4)
    buffer.encodeFloatArray(q, 16)
    buffer.encodeFloat(angularVelocityX)
    buffer.encodeFloat(angularVelocityY)
    buffer.encodeFloat(angularVelocityZ)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(gimbalDeviceId)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalManagerSetAttitude> {
    public override val id: UInt = 282u

    public override val crcExtra: Byte = 123

    public override fun deserialize(bytes: ByteArray): GimbalManagerSetAttitude {
      val buffer = Buffer().write(bytes)

      val flags = buffer.decodeBitmaskValue(4).let { value ->
        val flags = GimbalManagerFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val q = buffer.decodeFloatArray(16)
      val angularVelocityX = buffer.decodeFloat()
      val angularVelocityY = buffer.decodeFloat()
      val angularVelocityZ = buffer.decodeFloat()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val gimbalDeviceId = buffer.decodeUInt8()

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
