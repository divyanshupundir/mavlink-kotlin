package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt32
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
 * Sets a desired vehicle attitude. Used by an external controller to command the vehicle (manual
 * controller or other system).
 */
@GeneratedMavMessage(
  id = 82u,
  crcExtra = 49,
)
public data class SetAttitudeTarget(
  /**
   * Timestamp (time since system boot).
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
   * Bitmap to indicate which dimensions should be ignored by the vehicle.
   */
  @GeneratedMavField(type = "uint8_t")
  public val typeMask: MavBitmaskValue<AttitudeTargetTypemask> = MavBitmaskValue.fromValue(0u),
  /**
   * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0)
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * Body roll rate
   */
  @GeneratedMavField(type = "float")
  public val bodyRollRate: Float = 0F,
  /**
   * Body pitch rate
   */
  @GeneratedMavField(type = "float")
  public val bodyPitchRate: Float = 0F,
  /**
   * Body yaw rate
   */
  @GeneratedMavField(type = "float")
  public val bodyYawRate: Float = 0F,
  /**
   * Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust)
   */
  @GeneratedMavField(type = "float")
  public val thrust: Float = 0F,
  /**
   * 3D thrust setpoint in the body NED frame, normalized to -1 .. 1
   */
  @GeneratedMavField(
    type = "float[3]",
    extension = true,
  )
  public val thrustBody: List<Float> = emptyList(),
) : MavMessage<SetAttitudeTarget> {
  public override val instanceCompanion: MavMessage.MavCompanion<SetAttitudeTarget> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeFloatArray(q, 16)
    buffer.encodeFloat(bodyRollRate)
    buffer.encodeFloat(bodyPitchRate)
    buffer.encodeFloat(bodyYawRate)
    buffer.encodeFloat(thrust)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeBitmaskValue(typeMask.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeFloatArray(q, 16)
    buffer.encodeFloat(bodyRollRate)
    buffer.encodeFloat(bodyPitchRate)
    buffer.encodeFloat(bodyYawRate)
    buffer.encodeFloat(thrust)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeBitmaskValue(typeMask.value, 1)
    buffer.encodeFloatArray(thrustBody, 12)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SetAttitudeTarget> {
    public override val id: UInt = 82u

    public override val crcExtra: Byte = 49

    public override fun deserialize(bytes: ByteArray): SetAttitudeTarget {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val q = buffer.decodeFloatArray(16)
      val bodyRollRate = buffer.decodeFloat()
      val bodyPitchRate = buffer.decodeFloat()
      val bodyYawRate = buffer.decodeFloat()
      val thrust = buffer.decodeFloat()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val typeMask = buffer.decodeBitmaskValue(1).let { value ->
        val flags = AttitudeTargetTypemask.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val thrustBody = buffer.decodeFloatArray(12)

      return SetAttitudeTarget(
        timeBootMs = timeBootMs,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        typeMask = typeMask,
        q = q,
        bodyRollRate = bodyRollRate,
        bodyPitchRate = bodyPitchRate,
        bodyYawRate = bodyYawRate,
        thrust = thrust,
        thrustBody = thrustBody,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SetAttitudeTarget =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var typeMask: MavBitmaskValue<AttitudeTargetTypemask> = MavBitmaskValue.fromValue(0u)

    public var q: List<Float> = emptyList()

    public var bodyRollRate: Float = 0F

    public var bodyPitchRate: Float = 0F

    public var bodyYawRate: Float = 0F

    public var thrust: Float = 0F

    public var thrustBody: List<Float> = emptyList()

    public fun build(): SetAttitudeTarget = SetAttitudeTarget(
      timeBootMs = timeBootMs,
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      typeMask = typeMask,
      q = q,
      bodyRollRate = bodyRollRate,
      bodyPitchRate = bodyPitchRate,
      bodyYawRate = bodyYawRate,
      thrust = thrust,
      thrustBody = thrustBody,
    )
  }
}
