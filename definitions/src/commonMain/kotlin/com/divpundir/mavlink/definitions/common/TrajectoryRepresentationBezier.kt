package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
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
 * Describe a trajectory using an array of up-to 5 bezier control points in the local frame
 * (MAV_FRAME_LOCAL_NED).
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param validPoints Number of valid control points (up-to 5 points are possible)
 * @param posX X-coordinate of bezier control points. Set to NaN if not being used
 * units = m
 * @param posY Y-coordinate of bezier control points. Set to NaN if not being used
 * units = m
 * @param posZ Z-coordinate of bezier control points. Set to NaN if not being used
 * units = m
 * @param delta Bezier time horizon. Set to NaN if velocity/acceleration should not be incorporated
 * units = s
 * @param posYaw Yaw. Set to NaN for unchanged
 * units = rad
 */
@GeneratedMavMessage(
  id = 333u,
  crcExtra = -25,
)
public data class TrajectoryRepresentationBezier(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Number of valid control points (up-to 5 points are possible)
   */
  @GeneratedMavField(type = "uint8_t")
  public val validPoints: UByte = 0u,
  /**
   * X-coordinate of bezier control points. Set to NaN if not being used
   * units = m
   */
  @GeneratedMavField(type = "float[5]")
  public val posX: List<Float> = emptyList(),
  /**
   * Y-coordinate of bezier control points. Set to NaN if not being used
   * units = m
   */
  @GeneratedMavField(type = "float[5]")
  public val posY: List<Float> = emptyList(),
  /**
   * Z-coordinate of bezier control points. Set to NaN if not being used
   * units = m
   */
  @GeneratedMavField(type = "float[5]")
  public val posZ: List<Float> = emptyList(),
  /**
   * Bezier time horizon. Set to NaN if velocity/acceleration should not be incorporated
   * units = s
   */
  @GeneratedMavField(type = "float[5]")
  public val delta: List<Float> = emptyList(),
  /**
   * Yaw. Set to NaN for unchanged
   * units = rad
   */
  @GeneratedMavField(type = "float[5]")
  public val posYaw: List<Float> = emptyList(),
) : MavMessage<TrajectoryRepresentationBezier> {
  override val instanceCompanion: MavMessage.MavCompanion<TrajectoryRepresentationBezier> =
      Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloatArray(posX, 20)
    encoder.encodeFloatArray(posY, 20)
    encoder.encodeFloatArray(posZ, 20)
    encoder.encodeFloatArray(delta, 20)
    encoder.encodeFloatArray(posYaw, 20)
    encoder.encodeUInt8(validPoints)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloatArray(posX, 20)
    encoder.encodeFloatArray(posY, 20)
    encoder.encodeFloatArray(posZ, 20)
    encoder.encodeFloatArray(delta, 20)
    encoder.encodeFloatArray(posYaw, 20)
    encoder.encodeUInt8(validPoints)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<TrajectoryRepresentationBezier> {
    private const val SIZE_V1: Int = 109

    private const val SIZE_V2: Int = 109

    override val id: UInt = 333u

    override val crcExtra: Byte = -25

    override fun deserialize(bytes: ByteArray): TrajectoryRepresentationBezier {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val posX = decoder.safeDecodeFloatArray(20)
      val posY = decoder.safeDecodeFloatArray(20)
      val posZ = decoder.safeDecodeFloatArray(20)
      val delta = decoder.safeDecodeFloatArray(20)
      val posYaw = decoder.safeDecodeFloatArray(20)
      val validPoints = decoder.safeDecodeUInt8()

      return TrajectoryRepresentationBezier(
        timeUsec = timeUsec,
        validPoints = validPoints,
        posX = posX,
        posY = posY,
        posZ = posZ,
        delta = delta,
        posYaw = posYaw,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): TrajectoryRepresentationBezier =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var validPoints: UByte = 0u

    public var posX: List<Float> = emptyList()

    public var posY: List<Float> = emptyList()

    public var posZ: List<Float> = emptyList()

    public var delta: List<Float> = emptyList()

    public var posYaw: List<Float> = emptyList()

    public fun build(): TrajectoryRepresentationBezier = TrajectoryRepresentationBezier(
      timeUsec = timeUsec,
      validPoints = validPoints,
      posX = posX,
      posY = posY,
      posZ = posZ,
      delta = delta,
      posYaw = posYaw,
    )
  }
}
