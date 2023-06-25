package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

/**
 * Describe a trajectory using an array of up-to 5 bezier control points in the local frame
 * (MAV_FRAME_LOCAL_NED).
 */
@GeneratedMavMessage(
  id = 333u,
  crcExtra = -25,
)
public data class TrajectoryRepresentationBezier(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
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
   */
  @GeneratedMavField(type = "float[5]")
  public val posX: List<Float> = emptyList(),
  /**
   * Y-coordinate of bezier control points. Set to NaN if not being used
   */
  @GeneratedMavField(type = "float[5]")
  public val posY: List<Float> = emptyList(),
  /**
   * Z-coordinate of bezier control points. Set to NaN if not being used
   */
  @GeneratedMavField(type = "float[5]")
  public val posZ: List<Float> = emptyList(),
  /**
   * Bezier time horizon. Set to NaN if velocity/acceleration should not be incorporated
   */
  @GeneratedMavField(type = "float[5]")
  public val delta: List<Float> = emptyList(),
  /**
   * Yaw. Set to NaN for unchanged
   */
  @GeneratedMavField(type = "float[5]")
  public val posYaw: List<Float> = emptyList(),
) : MavMessage<TrajectoryRepresentationBezier> {
  public override val instanceCompanion: MavMessage.MavCompanion<TrajectoryRepresentationBezier> =
      Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloatArray(posX, 20)
    buffer.encodeFloatArray(posY, 20)
    buffer.encodeFloatArray(posZ, 20)
    buffer.encodeFloatArray(delta, 20)
    buffer.encodeFloatArray(posYaw, 20)
    buffer.encodeUInt8(validPoints)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloatArray(posX, 20)
    buffer.encodeFloatArray(posY, 20)
    buffer.encodeFloatArray(posZ, 20)
    buffer.encodeFloatArray(delta, 20)
    buffer.encodeFloatArray(posYaw, 20)
    buffer.encodeUInt8(validPoints)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<TrajectoryRepresentationBezier> {
    public override val id: UInt = 333u

    public override val crcExtra: Byte = -25

    public override fun deserialize(bytes: ByteArray): TrajectoryRepresentationBezier {
      val buffer = Buffer().write(bytes)

      val timeUsec = buffer.decodeUInt64()
      val posX = buffer.decodeFloatArray(20)
      val posY = buffer.decodeFloatArray(20)
      val posZ = buffer.decodeFloatArray(20)
      val delta = buffer.decodeFloatArray(20)
      val posYaw = buffer.decodeFloatArray(20)
      val validPoints = buffer.decodeUInt8()

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
