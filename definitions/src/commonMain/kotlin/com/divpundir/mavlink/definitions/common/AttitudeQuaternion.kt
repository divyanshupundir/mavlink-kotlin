package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt32
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
 * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed as
 * quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0).
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param q1 Quaternion component 1, w (1 in null-rotation)
 * @param q2 Quaternion component 2, x (0 in null-rotation)
 * @param q3 Quaternion component 3, y (0 in null-rotation)
 * @param q4 Quaternion component 4, z (0 in null-rotation)
 * @param rollspeed Roll angular speed
 * units = rad/s
 * @param pitchspeed Pitch angular speed
 * units = rad/s
 * @param yawspeed Yaw angular speed
 * units = rad/s
 * @param reprOffsetQ Rotation offset by which the attitude quaternion and angular speed vector
 * should be rotated for user display (quaternion with [w, x, y, z] order, zero-rotation is [1, 0, 0,
 * 0], send [0, 0, 0, 0] if field not supported). This field is intended for systems in which the
 * reference attitude may change during flight. For example, tailsitters VTOLs rotate their reference
 * attitude by 90 degrees between hover mode and fixed wing mode, thus repr_offset_q is equal to [1, 0,
 * 0, 0] in hover mode and equal to [0.7071, 0, 0.7071, 0] in fixed wing mode.
 */
@GeneratedMavMessage(
  id = 31u,
  crcExtra = -10,
)
public data class AttitudeQuaternion(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Quaternion component 1, w (1 in null-rotation)
   */
  @GeneratedMavField(type = "float")
  public val q1: Float = 0F,
  /**
   * Quaternion component 2, x (0 in null-rotation)
   */
  @GeneratedMavField(type = "float")
  public val q2: Float = 0F,
  /**
   * Quaternion component 3, y (0 in null-rotation)
   */
  @GeneratedMavField(type = "float")
  public val q3: Float = 0F,
  /**
   * Quaternion component 4, z (0 in null-rotation)
   */
  @GeneratedMavField(type = "float")
  public val q4: Float = 0F,
  /**
   * Roll angular speed
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val rollspeed: Float = 0F,
  /**
   * Pitch angular speed
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val pitchspeed: Float = 0F,
  /**
   * Yaw angular speed
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val yawspeed: Float = 0F,
  /**
   * Rotation offset by which the attitude quaternion and angular speed vector should be rotated for
   * user display (quaternion with [w, x, y, z] order, zero-rotation is [1, 0, 0, 0], send [0, 0, 0, 0]
   * if field not supported). This field is intended for systems in which the reference attitude may
   * change during flight. For example, tailsitters VTOLs rotate their reference attitude by 90 degrees
   * between hover mode and fixed wing mode, thus repr_offset_q is equal to [1, 0, 0, 0] in hover mode
   * and equal to [0.7071, 0, 0.7071, 0] in fixed wing mode.
   */
  @GeneratedMavField(
    type = "float[4]",
    extension = true,
  )
  public val reprOffsetQ: List<Float> = emptyList(),
) : MavMessage<AttitudeQuaternion> {
  override val instanceCompanion: MavMessage.MavCompanion<AttitudeQuaternion> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(q1)
    encoder.encodeFloat(q2)
    encoder.encodeFloat(q3)
    encoder.encodeFloat(q4)
    encoder.encodeFloat(rollspeed)
    encoder.encodeFloat(pitchspeed)
    encoder.encodeFloat(yawspeed)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(q1)
    encoder.encodeFloat(q2)
    encoder.encodeFloat(q3)
    encoder.encodeFloat(q4)
    encoder.encodeFloat(rollspeed)
    encoder.encodeFloat(pitchspeed)
    encoder.encodeFloat(yawspeed)
    encoder.encodeFloatArray(reprOffsetQ, 16)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AttitudeQuaternion> {
    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 48

    override val id: UInt = 31u

    override val crcExtra: Byte = -10

    override fun deserialize(bytes: ByteArray): AttitudeQuaternion {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val q1 = decoder.safeDecodeFloat()
      val q2 = decoder.safeDecodeFloat()
      val q3 = decoder.safeDecodeFloat()
      val q4 = decoder.safeDecodeFloat()
      val rollspeed = decoder.safeDecodeFloat()
      val pitchspeed = decoder.safeDecodeFloat()
      val yawspeed = decoder.safeDecodeFloat()
      val reprOffsetQ = decoder.safeDecodeFloatArray(16)

      return AttitudeQuaternion(
        timeBootMs = timeBootMs,
        q1 = q1,
        q2 = q2,
        q3 = q3,
        q4 = q4,
        rollspeed = rollspeed,
        pitchspeed = pitchspeed,
        yawspeed = yawspeed,
        reprOffsetQ = reprOffsetQ,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AttitudeQuaternion =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var q1: Float = 0F

    public var q2: Float = 0F

    public var q3: Float = 0F

    public var q4: Float = 0F

    public var rollspeed: Float = 0F

    public var pitchspeed: Float = 0F

    public var yawspeed: Float = 0F

    public var reprOffsetQ: List<Float> = emptyList()

    public fun build(): AttitudeQuaternion = AttitudeQuaternion(
      timeBootMs = timeBootMs,
      q1 = q1,
      q2 = q2,
      q3 = q3,
      q4 = q4,
      rollspeed = rollspeed,
      pitchspeed = pitchspeed,
      yawspeed = yawspeed,
      reprOffsetQ = reprOffsetQ,
    )
  }
}
