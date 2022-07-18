package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeFloatArray
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeFloatArray
import com.urbanmatrix.mavlink.serialization.encodeInt32
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
 * Current motion information from a designated system
 */
public data class FollowTarget(
  /**
   * Timestamp (time since system boot).
   */
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   * bit positions for tracker reporting capabilities (POS = 0, VEL = 1, ACCEL = 2, ATT + RATES = 3)
   */
  public val estCapabilities: Int = 0,
  /**
   * Latitude (WGS84)
   */
  public val lat: Int = 0,
  /**
   * Longitude (WGS84)
   */
  public val lon: Int = 0,
  /**
   * Altitude (MSL)
   */
  public val alt: Float = 0F,
  /**
   * target velocity (0,0,0) for unknown
   */
  public val vel: List<Float> = emptyList(),
  /**
   * linear target acceleration (0,0,0) for unknown
   */
  public val acc: List<Float> = emptyList(),
  /**
   * (0 0 0 0 for unknown)
   */
  public val attitudeQ: List<Float> = emptyList(),
  /**
   * (0 0 0 for unknown)
   */
  public val rates: List<Float> = emptyList(),
  /**
   * eph epv
   */
  public val positionCov: List<Float> = emptyList(),
  /**
   * button states or switches of a tracker device
   */
  public val customState: BigInteger = BigInteger.ZERO,
) : MavMessage<FollowTarget> {
  public override val instanceMetadata: MavMessage.Metadata<FollowTarget> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeUint64(customState)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeFloat(alt)
    outputBuffer.encodeFloatArray(vel, 12)
    outputBuffer.encodeFloatArray(acc, 12)
    outputBuffer.encodeFloatArray(attitudeQ, 16)
    outputBuffer.encodeFloatArray(rates, 12)
    outputBuffer.encodeFloatArray(positionCov, 12)
    outputBuffer.encodeUint8(estCapabilities)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 144

    private const val CRC: Int = 71

    private const val SIZE: Int = 93

    private val DESERIALIZER: MavDeserializer<FollowTarget> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint64()
      val customState = inputBuffer.decodeUint64()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeFloat()
      val vel = inputBuffer.decodeFloatArray(12)
      val acc = inputBuffer.decodeFloatArray(12)
      val attitudeQ = inputBuffer.decodeFloatArray(16)
      val rates = inputBuffer.decodeFloatArray(12)
      val positionCov = inputBuffer.decodeFloatArray(12)
      val estCapabilities = inputBuffer.decodeUint8()

      FollowTarget(
        timestamp = timestamp,
        estCapabilities = estCapabilities,
        lat = lat,
        lon = lon,
        alt = alt,
        vel = vel,
        acc = acc,
        attitudeQ = attitudeQ,
        rates = rates,
        positionCov = positionCov,
        customState = customState,
      )
    }


    private val METADATA: MavMessage.Metadata<FollowTarget> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FollowTarget> = METADATA
  }
}
