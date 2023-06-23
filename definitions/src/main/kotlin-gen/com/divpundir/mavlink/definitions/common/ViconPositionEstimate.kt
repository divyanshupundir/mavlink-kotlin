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
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * Global position estimate from a Vicon motion system source.
 */
@GeneratedMavMessage(
  id = 104u,
  crcExtra = 56,
)
public data class ViconPositionEstimate(
  /**
   * Timestamp (UNIX time or time since system boot)
   */
  @GeneratedMavField(type = "uint64_t")
  public val usec: ULong = 0uL,
  /**
   * Global X position
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * Global Y position
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * Global Z position
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
  /**
   * Roll angle
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Pitch angle
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw angle
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * Row-major representation of 6x6 pose cross-covariance matrix upper right triangle (states: x,
   * y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the second ROW,
   * etc.). If unknown, assign NaN value to first element in the array.
   */
  @GeneratedMavField(
    type = "float[21]",
    extension = true,
  )
  public val covariance: List<Float> = emptyList(),
) : MavMessage<ViconPositionEstimate> {
  public override val instanceCompanion: MavMessage.MavCompanion<ViconPositionEstimate> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(usec)
    output.encodeFloat(x)
    output.encodeFloat(y)
    output.encodeFloat(z)
    output.encodeFloat(roll)
    output.encodeFloat(pitch)
    output.encodeFloat(yaw)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(usec)
    output.encodeFloat(x)
    output.encodeFloat(y)
    output.encodeFloat(z)
    output.encodeFloat(roll)
    output.encodeFloat(pitch)
    output.encodeFloat(yaw)
    output.encodeFloatArray(covariance, 84)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<ViconPositionEstimate> {
    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 116

    public override val id: UInt = 104u

    public override val crcExtra: Byte = 56

    public override fun deserialize(source: BufferedSource): ViconPositionEstimate {
      val usec = source.decodeUInt64()
      val x = source.decodeFloat()
      val y = source.decodeFloat()
      val z = source.decodeFloat()
      val roll = source.decodeFloat()
      val pitch = source.decodeFloat()
      val yaw = source.decodeFloat()
      val covariance = source.decodeFloatArray(84)

      return ViconPositionEstimate(
        usec = usec,
        x = x,
        y = y,
        z = z,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        covariance = covariance,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ViconPositionEstimate =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var usec: ULong = 0uL

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var covariance: List<Float> = emptyList()

    public fun build(): ViconPositionEstimate = ViconPositionEstimate(
      usec = usec,
      x = x,
      y = y,
      z = z,
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      covariance = covariance,
    )
  }
}
