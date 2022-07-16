package com.urbanmatrix.mavlink.definitions.asluav

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Calibrated airflow angle measurements
 */
public data class SensorAirflowAngles(
  /**
   * Timestamp
   */
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   * Angle of attack
   */
  public val angleofattack: Float = 0F,
  /**
   * Angle of attack measurement valid
   */
  public val angleofattackValid: Int = 0,
  /**
   * Sideslip angle
   */
  public val sideslip: Float = 0F,
  /**
   * Sideslip angle measurement valid
   */
  public val sideslipValid: Int = 0,
) : MavMessage<SensorAirflowAngles> {
  public override val instanceMetadata: MavMessage.Metadata<SensorAirflowAngles> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeFloat(angleofattack)
    outputBuffer.encodeFloat(sideslip)
    outputBuffer.encodeUint8(angleofattackValid)
    outputBuffer.encodeUint8(sideslipValid)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 8016

    private const val CRC: Int = 149

    private const val SIZE: Int = 18

    private val DESERIALIZER: MavDeserializer<SensorAirflowAngles> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for SensorAirflowAngles: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint64()
      val angleofattack = inputBuffer.decodeFloat()
      val sideslip = inputBuffer.decodeFloat()
      val angleofattackValid = inputBuffer.decodeUint8()
      val sideslipValid = inputBuffer.decodeUint8()

      SensorAirflowAngles(
        timestamp = timestamp,
        angleofattack = angleofattack,
        angleofattackValid = angleofattackValid,
        sideslip = sideslip,
        sideslipValid = sideslipValid,
      )
    }


    private val METADATA: MavMessage.Metadata<SensorAirflowAngles> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SensorAirflowAngles> = METADATA
  }
}
