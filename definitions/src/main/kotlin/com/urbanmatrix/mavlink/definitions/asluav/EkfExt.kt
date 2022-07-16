package com.urbanmatrix.mavlink.definitions.asluav

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint64
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Extended EKF state estimates for ASLUAVs
 */
public data class EkfExt(
  /**
   *  Time since system start
   */
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   *  Magnitude of wind velocity (in lateral inertial plane)
   */
  public val windspeed: Float = 0F,
  /**
   *  Wind heading angle from North
   */
  public val winddir: Float = 0F,
  /**
   *  Z (Down) component of inertial wind velocity
   */
  public val windz: Float = 0F,
  /**
   *  Magnitude of air velocity
   */
  public val airspeed: Float = 0F,
  /**
   *  Sideslip angle
   */
  public val beta: Float = 0F,
  /**
   *  Angle of attack
   */
  public val alpha: Float = 0F,
) : MavMessage<EkfExt> {
  public override val instanceMetadata: MavMessage.Metadata<EkfExt> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeFloat(windspeed)
    outputBuffer.encodeFloat(winddir)
    outputBuffer.encodeFloat(windz)
    outputBuffer.encodeFloat(airspeed)
    outputBuffer.encodeFloat(beta)
    outputBuffer.encodeFloat(alpha)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 8007

    private const val CRC: Int = 64

    private const val SIZE: Int = 32

    private val DESERIALIZER: MavDeserializer<EkfExt> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for EkfExt: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint64()
      val windspeed = inputBuffer.decodeFloat()
      val winddir = inputBuffer.decodeFloat()
      val windz = inputBuffer.decodeFloat()
      val airspeed = inputBuffer.decodeFloat()
      val beta = inputBuffer.decodeFloat()
      val alpha = inputBuffer.decodeFloat()

      EkfExt(
        timestamp = timestamp,
        windspeed = windspeed,
        winddir = winddir,
        windz = windz,
        airspeed = airspeed,
        beta = beta,
        alpha = alpha,
      )
    }


    private val METADATA: MavMessage.Metadata<EkfExt> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<EkfExt> = METADATA
  }
}
