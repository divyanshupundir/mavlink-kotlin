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
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
 */
@GeneratedMavMessage(
  id = 103u,
  crcExtra = -48,
)
public data class VisionSpeedEstimate(
  /**
   * Timestamp (UNIX time or time since system boot)
   */
  @GeneratedMavField(type = "uint64_t")
  public val usec: ULong = 0uL,
  /**
   * Global X speed
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * Global Y speed
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * Global Z speed
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
  public override val instanceCompanion: MavMessage.MavCompanion<VisionSpeedEstimate> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(usec)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(usec)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloatArray(covariance, 36)
    outputBuffer.encodeUInt8(resetCounter)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<VisionSpeedEstimate> {
    private const val SIZE_V1: Int = 20

    private const val SIZE_V2: Int = 57

    public override val id: UInt = 103u

    public override val crcExtra: Byte = -48

    public override fun deserialize(bytes: ByteArray): VisionSpeedEstimate {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val usec = inputBuffer.decodeUInt64()
      val x = inputBuffer.decodeFloat()
      val y = inputBuffer.decodeFloat()
      val z = inputBuffer.decodeFloat()
      val covariance = inputBuffer.decodeFloatArray(36)
      val resetCounter = inputBuffer.decodeUInt8()

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
