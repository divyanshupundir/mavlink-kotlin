package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
 */
@GeneratedMavMessage(
  id = 83u,
  crcExtra = 22,
)
public data class AttitudeTarget(
  /**
   * Timestamp (time since system boot).
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
) : MavMessage<AttitudeTarget> {
  public override val instanceCompanion: MavMessage.MavCompanion<AttitudeTarget> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(bodyRollRate)
    outputBuffer.encodeFloat(bodyPitchRate)
    outputBuffer.encodeFloat(bodyYawRate)
    outputBuffer.encodeFloat(thrust)
    outputBuffer.encodeBitmaskValue(typeMask.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(bodyRollRate)
    outputBuffer.encodeFloat(bodyPitchRate)
    outputBuffer.encodeFloat(bodyYawRate)
    outputBuffer.encodeFloat(thrust)
    outputBuffer.encodeBitmaskValue(typeMask.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AttitudeTarget> {
    private const val SIZE_V1: Int = 37

    private const val SIZE_V2: Int = 37

    public override val id: UInt = 83u

    public override val crcExtra: Byte = 22

    public override fun deserialize(bytes: ByteArray): AttitudeTarget {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val q = inputBuffer.decodeFloatArray(16)
      val bodyRollRate = inputBuffer.decodeFloat()
      val bodyPitchRate = inputBuffer.decodeFloat()
      val bodyYawRate = inputBuffer.decodeFloat()
      val thrust = inputBuffer.decodeFloat()
      val typeMask = inputBuffer.decodeBitmaskValue(1).let { value ->
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
