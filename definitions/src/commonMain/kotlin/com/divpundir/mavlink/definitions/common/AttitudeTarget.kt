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
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Reports the current commanded attitude of the vehicle as specified by the autopilot. This should
 * match the commands sent in a SET_ATTITUDE_TARGET message if the vehicle is being controlled this
 * way.
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param typeMask Bitmap to indicate which dimensions should be ignored by the vehicle.
 * @param q Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0)
 * @param bodyRollRate Body roll rate
 * units = rad/s
 * @param bodyPitchRate Body pitch rate
 * units = rad/s
 * @param bodyYawRate Body yaw rate
 * units = rad/s
 * @param thrust Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse
 * trust)
 */
@GeneratedMavMessage(
  id = 83u,
  crcExtra = 22,
)
public data class AttitudeTarget(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
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
) : MavMessage<AttitudeTarget> {
  override val instanceCompanion: MavMessage.MavCompanion<AttitudeTarget> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(bodyRollRate)
    encoder.encodeFloat(bodyPitchRate)
    encoder.encodeFloat(bodyYawRate)
    encoder.encodeFloat(thrust)
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
    encoder.encodeBitmaskValue(typeMask.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AttitudeTarget> {
    private const val SIZE_V1: Int = 37

    private const val SIZE_V2: Int = 37

    override val id: UInt = 83u

    override val crcExtra: Byte = 22

    override fun deserialize(bytes: ByteArray): AttitudeTarget {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val q = decoder.safeDecodeFloatArray(16)
      val bodyRollRate = decoder.safeDecodeFloat()
      val bodyPitchRate = decoder.safeDecodeFloat()
      val bodyYawRate = decoder.safeDecodeFloat()
      val thrust = decoder.safeDecodeFloat()
      val typeMask = decoder.safeDecodeBitmaskValue(1).let { value ->
        val flags = AttitudeTargetTypemask.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      return AttitudeTarget(
        timeBootMs = timeBootMs,
        typeMask = typeMask,
        q = q,
        bodyRollRate = bodyRollRate,
        bodyPitchRate = bodyPitchRate,
        bodyYawRate = bodyYawRate,
        thrust = thrust,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AttitudeTarget =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var typeMask: MavBitmaskValue<AttitudeTargetTypemask> = MavBitmaskValue.fromValue(0u)

    public var q: List<Float> = emptyList()

    public var bodyRollRate: Float = 0F

    public var bodyPitchRate: Float = 0F

    public var bodyYawRate: Float = 0F

    public var thrust: Float = 0F

    public fun build(): AttitudeTarget = AttitudeTarget(
      timeBootMs = timeBootMs,
      typeMask = typeMask,
      q = q,
      bodyRollRate = bodyRollRate,
      bodyPitchRate = bodyPitchRate,
      bodyYawRate = bodyYawRate,
      thrust = thrust,
    )
  }
}
