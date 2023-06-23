package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * Global position/attitude estimate from a vision source.
 */
@GeneratedMavMessage(
  id = 101u,
  crcExtra = 102,
)
public data class GlobalVisionPositionEstimate(
  /**
   * Timestamp (UNIX time or since system boot)
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
   * Row-major representation of pose 6x6 cross-covariance matrix upper right triangle (states:
   * x_global, y_global, z_global, roll, pitch, yaw; first six entries are the first ROW, next five
   * entries are the second ROW, etc.). If unknown, assign NaN value to first element in the array.
   */
  @GeneratedMavField(
    type = "float[21]",
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
) : MavMessage<GlobalVisionPositionEstimate> {
  public override val instanceCompanion: MavMessage.MavCompanion<GlobalVisionPositionEstimate> =
      Companion

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
    output.encodeUInt8(resetCounter)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<GlobalVisionPositionEstimate> {
    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 117

    public override val id: UInt = 101u

    public override val crcExtra: Byte = 102

    public override fun deserialize(source: BufferedSource): GlobalVisionPositionEstimate {
      val usec = source.decodeUInt64()
      val x = source.decodeFloat()
      val y = source.decodeFloat()
      val z = source.decodeFloat()
      val roll = source.decodeFloat()
      val pitch = source.decodeFloat()
      val yaw = source.decodeFloat()
      val covariance = source.decodeFloatArray(84)
      val resetCounter = source.decodeUInt8()

      return GlobalVisionPositionEstimate(
        usec = usec,
        x = x,
        y = y,
        z = z,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        covariance = covariance,
        resetCounter = resetCounter,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GlobalVisionPositionEstimate =
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

    public var resetCounter: UByte = 0u

    public fun build(): GlobalVisionPositionEstimate = GlobalVisionPositionEstimate(
      usec = usec,
      x = x,
      y = y,
      z = z,
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      covariance = covariance,
      resetCounter = resetCounter,
    )
  }
}
