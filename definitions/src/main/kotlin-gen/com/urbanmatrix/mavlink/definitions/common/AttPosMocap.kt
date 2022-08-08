package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeFloatArray
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeFloatArray
import com.urbanmatrix.mavlink.serialization.encodeUint64
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.collections.List

/**
 * Motion capture attitude and position
 */
@GeneratedMavMessage(
  id = 138,
  crc = 109,
)
public data class AttPosMocap(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0)
   */
  public val q: List<Float> = emptyList(),
  /**
   * X position (NED)
   */
  public val x: Float = 0F,
  /**
   * Y position (NED)
   */
  public val y: Float = 0F,
  /**
   * Z position (NED)
   */
  public val z: Float = 0F,
  /**
   * Row-major representation of a pose 6x6 cross-covariance matrix upper right triangle (states: x,
   * y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the second ROW,
   * etc.). If unknown, assign NaN value to first element in the array.
   */
  public val covariance: List<Float> = emptyList(),
) : MavMessage<AttPosMocap> {
  public override val instanceMetadata: MavMessage.Metadata<AttPosMocap> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloatArray(covariance, 84)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 138

    private const val CRC: Int = 109

    private const val SIZE: Int = 120

    private val DESERIALIZER: MavDeserializer<AttPosMocap> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val q = inputBuffer.decodeFloatArray(16)
      val x = inputBuffer.decodeFloat()
      val y = inputBuffer.decodeFloat()
      val z = inputBuffer.decodeFloat()
      val covariance = inputBuffer.decodeFloatArray(84)

      AttPosMocap(
        timeUsec = timeUsec,
        q = q,
        x = x,
        y = y,
        z = z,
        covariance = covariance,
      )
    }


    private val METADATA: MavMessage.Metadata<AttPosMocap> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AttPosMocap> = METADATA
  }
}
