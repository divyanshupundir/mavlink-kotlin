package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
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
 * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed as
 * quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0).
 */
public data class AttitudeQuaternionCov(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation)
   */
  public val q: List<Float> = emptyList(),
  /**
   * Roll angular speed
   */
  public val rollspeed: Float = 0F,
  /**
   * Pitch angular speed
   */
  public val pitchspeed: Float = 0F,
  /**
   * Yaw angular speed
   */
  public val yawspeed: Float = 0F,
  /**
   * Row-major representation of a 3x3 attitude covariance matrix (states: roll, pitch, yaw; first
   * three entries are the first ROW, next three entries are the second row, etc.). If unknown, assign
   * NaN value to first element in the array.
   */
  public val covariance: List<Float> = emptyList(),
) : MavMessage<AttitudeQuaternionCov> {
  public override val instanceMetadata: MavMessage.Metadata<AttitudeQuaternionCov> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(rollspeed)
    outputBuffer.encodeFloat(pitchspeed)
    outputBuffer.encodeFloat(yawspeed)
    outputBuffer.encodeFloatArray(covariance, 36)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 61

    private const val CRC: Int = 250

    private const val SIZE: Int = 72

    private val DESERIALIZER: MavDeserializer<AttitudeQuaternionCov> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for AttitudeQuaternionCov: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val q = inputBuffer.decodeFloatArray(16)
      val rollspeed = inputBuffer.decodeFloat()
      val pitchspeed = inputBuffer.decodeFloat()
      val yawspeed = inputBuffer.decodeFloat()
      val covariance = inputBuffer.decodeFloatArray(36)

      AttitudeQuaternionCov(
        timeUsec = timeUsec,
        q = q,
        rollspeed = rollspeed,
        pitchspeed = pitchspeed,
        yawspeed = yawspeed,
        covariance = covariance,
      )
    }


    private val METADATA: MavMessage.Metadata<AttitudeQuaternionCov> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AttitudeQuaternionCov> = METADATA
  }
}
