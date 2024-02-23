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
 * Motion capture attitude and position
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param q Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0)
 * @param x X position (NED)
 * units = m
 * @param y Y position (NED)
 * units = m
 * @param z Z position (NED)
 * units = m
 * @param covariance Row-major representation of a pose 6x6 cross-covariance matrix upper right
 * triangle (states: x, y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries
 * are the second ROW, etc.). If unknown, assign NaN value to first element in the array.
 */
@GeneratedMavMessage(
  id = 138u,
  crcExtra = 109,
)
public data class AttPosMocap(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0)
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * X position (NED)
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * Y position (NED)
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * Z position (NED)
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
  /**
   * Row-major representation of a pose 6x6 cross-covariance matrix upper right triangle (states: x,
   * y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the second ROW,
   * etc.). If unknown, assign NaN value to first element in the array.
   */
  @GeneratedMavField(
    type = "float[21]",
    extension = true,
  )
  public val covariance: List<Float> = emptyList(),
) : MavMessage<AttPosMocap> {
  override val instanceCompanion: MavMessage.MavCompanion<AttPosMocap> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloatArray(covariance, 84)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AttPosMocap> {
    private const val SIZE_V1: Int = 36

    private const val SIZE_V2: Int = 120

    override val id: UInt = 138u

    override val crcExtra: Byte = 109

    override fun deserialize(bytes: ByteArray): AttPosMocap {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val q = decoder.safeDecodeFloatArray(16)
      val x = decoder.safeDecodeFloat()
      val y = decoder.safeDecodeFloat()
      val z = decoder.safeDecodeFloat()
      val covariance = decoder.safeDecodeFloatArray(84)

      return AttPosMocap(
        timeUsec = timeUsec,
        q = q,
        x = x,
        y = y,
        z = z,
        covariance = covariance,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AttPosMocap =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var q: List<Float> = emptyList()

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public var covariance: List<Float> = emptyList()

    public fun build(): AttPosMocap = AttPosMocap(
      timeUsec = timeUsec,
      q = q,
      x = x,
      y = y,
      z = z,
      covariance = covariance,
    )
  }
}
