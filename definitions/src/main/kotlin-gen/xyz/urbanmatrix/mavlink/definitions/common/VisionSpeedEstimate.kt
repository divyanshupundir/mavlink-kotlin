package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Speed estimate from a vision source.
 */
@GeneratedMavMessage(
  id = 103,
  crc = 208,
)
public data class VisionSpeedEstimate(
  /**
   * Timestamp (UNIX time or time since system boot)
   */
  public val usec: BigInteger = BigInteger.ZERO,
  /**
   * Global X speed
   */
  public val x: Float = 0F,
  /**
   * Global Y speed
   */
  public val y: Float = 0F,
  /**
   * Global Z speed
   */
  public val z: Float = 0F,
  /**
   * Row-major representation of 3x3 linear velocity covariance matrix (states: vx, vy, vz; 1st
   * three entries - 1st row, etc.). If unknown, assign NaN value to first element in the array.
   */
  public val covariance: List<Float> = emptyList(),
  /**
   * Estimate reset counter. This should be incremented when the estimate resets in any of the
   * dimensions (position, velocity, attitude, angular speed). This is designed to be used when e.g an
   * external SLAM system detects a loop-closure and the estimate jumps.
   */
  public val resetCounter: Int = 0,
) : MavMessage<VisionSpeedEstimate> {
  public override val instanceMetadata: MavMessage.Metadata<VisionSpeedEstimate> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(usec)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloatArray(covariance, 36)
    outputBuffer.encodeUint8(resetCounter)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 103

    private const val CRC: Int = 208

    private const val SIZE: Int = 57

    private val DESERIALIZER: MavDeserializer<VisionSpeedEstimate> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val usec = inputBuffer.decodeUint64()
      val x = inputBuffer.decodeFloat()
      val y = inputBuffer.decodeFloat()
      val z = inputBuffer.decodeFloat()
      val covariance = inputBuffer.decodeFloatArray(36)
      val resetCounter = inputBuffer.decodeUint8()

      VisionSpeedEstimate(
        usec = usec,
        x = x,
        y = y,
        z = z,
        covariance = covariance,
        resetCounter = resetCounter,
      )
    }


    private val METADATA: MavMessage.Metadata<VisionSpeedEstimate> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<VisionSpeedEstimate> = METADATA
  }
}
