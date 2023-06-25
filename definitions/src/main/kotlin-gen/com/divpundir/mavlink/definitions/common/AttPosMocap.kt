package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

/**
 * Motion capture attitude and position
 */
@GeneratedMavMessage(
  id = 138u,
  crcExtra = 109,
)
public data class AttPosMocap(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
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
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * Y position (NED)
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * Z position (NED)
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
  public override val instanceCompanion: MavMessage.MavCompanion<AttPosMocap> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloatArray(q, 16)
    buffer.encodeFloat(x)
    buffer.encodeFloat(y)
    buffer.encodeFloat(z)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloatArray(q, 16)
    buffer.encodeFloat(x)
    buffer.encodeFloat(y)
    buffer.encodeFloat(z)
    buffer.encodeFloatArray(covariance, 84)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AttPosMocap> {
    public override val id: UInt = 138u

    public override val crcExtra: Byte = 109

    public override fun deserialize(bytes: ByteArray): AttPosMocap {
      val buffer = Buffer().write(bytes)

      val timeUsec = buffer.decodeUInt64()
      val q = buffer.decodeFloatArray(16)
      val x = buffer.decodeFloat()
      val y = buffer.decodeFloat()
      val z = buffer.decodeFloat()
      val covariance = buffer.decodeFloatArray(84)

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
