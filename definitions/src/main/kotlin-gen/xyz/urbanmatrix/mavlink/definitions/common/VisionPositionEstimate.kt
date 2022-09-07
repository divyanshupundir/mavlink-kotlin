package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
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
 * Local position/attitude estimate from a vision source.
 */
@GeneratedMavMessage(
  id = 102,
  crc = 158,
)
public data class VisionPositionEstimate(
  /**
   * Timestamp (UNIX time or time since system boot)
   */
  public val usec: BigInteger = BigInteger.ZERO,
  /**
   * Local X position
   */
  public val x: Float = 0F,
  /**
   * Local Y position
   */
  public val y: Float = 0F,
  /**
   * Local Z position
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
   * Row-major representation of pose 6x6 cross-covariance matrix upper right triangle (states: x,
   * y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the second ROW,
   * etc.). If unknown, assign NaN value to first element in the array.
   */
  public val covariance: List<Float> = emptyList(),
  /**
   * Estimate reset counter. This should be incremented when the estimate resets in any of the
   * dimensions (position, velocity, attitude, angular speed). This is designed to be used when e.g an
   * external SLAM system detects a loop-closure and the estimate jumps.
   */
  public val resetCounter: Int = 0,
) : MavMessage<VisionPositionEstimate> {
  public override val instanceMetadata: MavMessage.Metadata<VisionPositionEstimate> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
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
    private const val ID: Int = 102

    private const val CRC: Int = 158

    private const val SIZE: Int = 117

    private val DESERIALIZER: MavDeserializer<VisionPositionEstimate> = MavDeserializer { bytes ->
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

      VisionPositionEstimate(
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


    private val METADATA: MavMessage.Metadata<VisionPositionEstimate> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<VisionPositionEstimate> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var usec: BigInteger = BigInteger.ZERO

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var covariance: List<Float> = emptyList()

    public var resetCounter: Int = 0

    public fun build(): VisionPositionEstimate = VisionPositionEstimate(
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
