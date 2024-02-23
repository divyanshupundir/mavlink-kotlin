package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List

/**
 * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed as
 * quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0).
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param q Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation)
 * @param rollspeed Roll angular speed
 * units = rad/s
 * @param pitchspeed Pitch angular speed
 * units = rad/s
 * @param yawspeed Yaw angular speed
 * units = rad/s
 * @param covariance Row-major representation of a 3x3 attitude covariance matrix (states: roll,
 * pitch, yaw; first three entries are the first ROW, next three entries are the second row, etc.). If
 * unknown, assign NaN value to first element in the array.
 */
@GeneratedMavMessage(
  id = 61u,
  crcExtra = -89,
)
public data class AttitudeQuaternionCov(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation)
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
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
   * Row-major representation of a 3x3 attitude covariance matrix (states: roll, pitch, yaw; first
   * three entries are the first ROW, next three entries are the second row, etc.). If unknown, assign
   * NaN value to first element in the array.
   */
  @GeneratedMavField(type = "float[9]")
  public val covariance: List<Float> = emptyList(),
) : MavMessage<AttitudeQuaternionCov> {
  override val instanceCompanion: MavMessage.MavCompanion<AttitudeQuaternionCov> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(rollspeed)
    encoder.encodeFloat(pitchspeed)
    encoder.encodeFloat(yawspeed)
    encoder.encodeFloatArray(covariance, 36)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(rollspeed)
    encoder.encodeFloat(pitchspeed)
    encoder.encodeFloat(yawspeed)
    encoder.encodeFloatArray(covariance, 36)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AttitudeQuaternionCov> {
    private const val SIZE_V1: Int = 72

    private const val SIZE_V2: Int = 72

    override val id: UInt = 61u

    override val crcExtra: Byte = -89

    override fun deserialize(bytes: ByteArray): AttitudeQuaternionCov {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val q = decoder.safeDecodeFloatArray(16)
      val rollspeed = decoder.safeDecodeFloat()
      val pitchspeed = decoder.safeDecodeFloat()
      val yawspeed = decoder.safeDecodeFloat()
      val covariance = decoder.safeDecodeFloatArray(36)

      return AttitudeQuaternionCov(
        timeUsec = timeUsec,
        q = q,
        rollspeed = rollspeed,
        pitchspeed = pitchspeed,
        yawspeed = yawspeed,
        covariance = covariance,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AttitudeQuaternionCov =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var q: List<Float> = emptyList()

    public var rollspeed: Float = 0F

    public var pitchspeed: Float = 0F

    public var yawspeed: Float = 0F

    public var covariance: List<Float> = emptyList()

    public fun build(): AttitudeQuaternionCov = AttitudeQuaternionCov(
      timeUsec = timeUsec,
      q = q,
      rollspeed = rollspeed,
      pitchspeed = pitchspeed,
      yawspeed = yawspeed,
      covariance = covariance,
    )
  }
}
