package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Global position estimate from a Vicon motion system source.
 */
@GeneratedMavMessage(
  id = 104,
  crc = 56,
)
public data class ViconPositionEstimate(
  /**
   * Timestamp (UNIX time or time since system boot)
   */
  @GeneratedMavField(type = "uint64_t")
  public val usec: BigInteger = BigInteger.ZERO,
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
  public override val instanceMetadata: MavMessage.Metadata<ViconPositionEstimate> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(usec)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(usec)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloatArray(covariance, 84)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 104

    private const val CRC: Int = 56

    private const val SIZE: Int = 116

    private val DESERIALIZER: MavDeserializer<ViconPositionEstimate> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val usec = inputBuffer.decodeUint64()
      val x = inputBuffer.decodeFloat()
      val y = inputBuffer.decodeFloat()
      val z = inputBuffer.decodeFloat()
      val roll = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val covariance = inputBuffer.decodeFloatArray(84)

      ViconPositionEstimate(
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


    private val METADATA: MavMessage.Metadata<ViconPositionEstimate> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ViconPositionEstimate> = METADATA

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
