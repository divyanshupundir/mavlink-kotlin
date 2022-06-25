package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeFloatArray
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeFloatArray
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.collections.List

/**
 * Global position/attitude estimate from a vision source.
 */
public data class GlobalVisionPositionEstimate(
  /**
   * Timestamp (UNIX time or since system boot)
   */
  public val usec: BigInteger = BigInteger.ZERO,
  /**
   * Global X position
   */
  public val x: Float = 0F,
  /**
   * Global Y position
   */
  public val y: Float = 0F,
  /**
   * Global Z position
   */
  public val z: Float = 0F,
  /**
   * Roll angle
   */
  public val roll: Float = 0F,
  /**
   * Pitch angle
   */
  public val pitch: Float = 0F,
  /**
   * Yaw angle
   */
  public val yaw: Float = 0F,
  /**
   * Row-major representation of pose 6x6 cross-covariance matrix upper right triangle (states:
   * x_global, y_global, z_global, roll, pitch, yaw; first six entries are the first ROW, next five
   * entries are the second ROW, etc.). If unknown, assign NaN value to first element in the array.
   */
  public val covariance: List<Float> = emptyList(),
  /**
   * Estimate reset counter. This should be incremented when the estimate resets in any of the
   * dimensions (position, velocity, attitude, angular speed). This is designed to be used when e.g an
   * external SLAM system detects a loop-closure and the estimate jumps.
   */
  public val resetCounter: Int = 0,
) : MavMessage<GlobalVisionPositionEstimate> {
  public override val instanceMetadata: MavMessage.Metadata<GlobalVisionPositionEstimate> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(117).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(usec)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloatArray(covariance, 84)
    outputBuffer.encodeUint8(resetCounter)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 101

    private const val CRC: Int = 102

    private val DESERIALIZER: MavDeserializer<GlobalVisionPositionEstimate> = MavDeserializer {
        bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val usec = inputBuffer.decodeUint64()
      val x = inputBuffer.decodeFloat()
      val y = inputBuffer.decodeFloat()
      val z = inputBuffer.decodeFloat()
      val roll = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val covariance = inputBuffer.decodeFloatArray(84)
      val resetCounter = inputBuffer.decodeUint8()
      GlobalVisionPositionEstimate(
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


    private val METADATA: MavMessage.Metadata<GlobalVisionPositionEstimate> =
        MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GlobalVisionPositionEstimate> = METADATA
  }
}
