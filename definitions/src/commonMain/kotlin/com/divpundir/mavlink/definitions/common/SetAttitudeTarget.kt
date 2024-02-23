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
 * Sets a desired vehicle attitude. Used by an external controller to command the vehicle (manual
 * controller or other system).
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param typeMask Bitmap to indicate which dimensions should be ignored by the vehicle.
 * @param q Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) from
 * MAV_FRAME_LOCAL_NED to MAV_FRAME_BODY_FRD
 * @param bodyRollRate Body roll rate
 * units = rad/s
 * @param bodyPitchRate Body pitch rate
 * units = rad/s
 * @param bodyYawRate Body yaw rate
 * units = rad/s
 * @param thrust Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse
 * trust)
 * @param thrustBody 3D thrust setpoint in the body NED frame, normalized to -1 .. 1
 */
@GeneratedMavMessage(
  id = 82u,
  crcExtra = 49,
)
public data class SetAttitudeTarget(
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
   * Bitmap to indicate which dimensions should be ignored by the vehicle.
   */
  @GeneratedMavField(type = "uint8_t")
  public val typeMask: MavBitmaskValue<AttitudeTargetTypemask> = MavBitmaskValue.fromValue(0u),
  /**
   * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) from MAV_FRAME_LOCAL_NED to
   * MAV_FRAME_BODY_FRD
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * Body roll rate
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val bodyRollRate: Float = 0F,
  /**
   * Body pitch rate
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val bodyPitchRate: Float = 0F,
  /**
   * Body yaw rate
   * units = rad/s
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
  override val instanceCompanion: MavMessage.MavCompanion<SetAttitudeTarget> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(bodyRollRate)
    encoder.encodeFloat(bodyPitchRate)
    encoder.encodeFloat(bodyYawRate)
    encoder.encodeFloat(thrust)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeBitmaskValue(typeMask.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(bodyRollRate)
    encoder.encodeFloat(bodyPitchRate)
    encoder.encodeFloat(bodyYawRate)
    encoder.encodeFloat(thrust)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeBitmaskValue(typeMask.value, 1)
    encoder.encodeFloatArray(thrustBody, 12)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SetAttitudeTarget> {
    private const val SIZE_V1: Int = 39

    private const val SIZE_V2: Int = 51

    override val id: UInt = 82u

    override val crcExtra: Byte = 49

    override fun deserialize(bytes: ByteArray): SetAttitudeTarget {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val q = decoder.safeDecodeFloatArray(16)
      val bodyRollRate = decoder.safeDecodeFloat()
      val bodyPitchRate = decoder.safeDecodeFloat()
      val bodyYawRate = decoder.safeDecodeFloat()
      val thrust = decoder.safeDecodeFloat()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val typeMask = decoder.safeDecodeBitmaskValue(1).let { value ->
        val flags = AttitudeTargetTypemask.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val thrustBody = decoder.safeDecodeFloatArray(12)

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
