package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List

/**
 * Speed estimate from a vision source.
 *
 * @param usec Timestamp (UNIX time or time since system boot)
 * units = us
 * @param x Global X speed
 * units = m/s
 * @param y Global Y speed
 * units = m/s
 * @param z Global Z speed
 * units = m/s
 * @param covariance Row-major representation of 3x3 linear velocity covariance matrix (states: vx,
 * vy, vz; 1st three entries - 1st row, etc.). If unknown, assign NaN value to first element in the
 * array.
 * @param resetCounter Estimate reset counter. This should be incremented when the estimate resets
 * in any of the dimensions (position, velocity, attitude, angular speed). This is designed to be used
 * when e.g an external SLAM system detects a loop-closure and the estimate jumps.
 */
@GeneratedMavMessage(
  id = 103u,
  crcExtra = -48,
)
public data class VisionSpeedEstimate(
  /**
   * Timestamp (UNIX time or time since system boot)
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val usec: ULong = 0uL,
  /**
   * Global X speed
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * Global Y speed
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * Global Z speed
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
  /**
   * Row-major representation of 3x3 linear velocity covariance matrix (states: vx, vy, vz; 1st
   * three entries - 1st row, etc.). If unknown, assign NaN value to first element in the array.
   */
  @GeneratedMavField(
    type = "float[9]",
    extension = true,
  )
  public val covariance: List<Float> = emptyList(),
  /**
   * Estimate reset counter. This should be incremented when the estimate resets in any of the
   * dimensions (position, velocity, attitude, angular speed). This is designed to be used when e.g an
   * external SLAM system detects a loop-closure and the estimate jumps.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val resetCounter: UByte = 0u,
) : MavMessage<VisionSpeedEstimate> {
  override val instanceCompanion: MavMessage.MavCompanion<VisionSpeedEstimate> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(usec)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(usec)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloatArray(covariance, 36)
    encoder.encodeUInt8(resetCounter)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<VisionSpeedEstimate> {
    private const val SIZE_V1: Int = 20

    private const val SIZE_V2: Int = 57

    override val id: UInt = 103u

    override val crcExtra: Byte = -48

    override fun deserialize(bytes: ByteArray): VisionSpeedEstimate {
      val decoder = MavDataDecoder(bytes)

      val usec = decoder.safeDecodeUInt64()
      val x = decoder.safeDecodeFloat()
      val y = decoder.safeDecodeFloat()
      val z = decoder.safeDecodeFloat()
      val covariance = decoder.safeDecodeFloatArray(36)
      val resetCounter = decoder.safeDecodeUInt8()

      return VisionSpeedEstimate(
        usec = usec,
        x = x,
        y = y,
        z = z,
        covariance = covariance,
        resetCounter = resetCounter,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): VisionSpeedEstimate =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var usec: ULong = 0uL

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public var covariance: List<Float> = emptyList()

    public var resetCounter: UByte = 0u

    public fun build(): VisionSpeedEstimate = VisionSpeedEstimate(
      usec = usec,
      x = x,
      y = y,
      z = z,
      covariance = covariance,
      resetCounter = resetCounter,
    )
  }
}
