package com.urbanmatrix.mavlink.definitions.matrixpilot

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * The airspeed measured by sensors and IMU
 */
public data class Airspeeds(
  /**
   * Timestamp (milliseconds since system boot)
   */
  public val timeBootMs: Long = 0L,
  /**
   * Airspeed estimate from IMU, cm/s
   */
  public val airspeedImu: Int = 0,
  /**
   * Pitot measured forward airpseed, cm/s
   */
  public val airspeedPitot: Int = 0,
  /**
   * Hot wire anenometer measured airspeed, cm/s
   */
  public val airspeedHotWire: Int = 0,
  /**
   * Ultrasonic measured airspeed, cm/s
   */
  public val airspeedUltrasonic: Int = 0,
  /**
   * Angle of attack sensor, degrees * 10
   */
  public val aoa: Int = 0,
  /**
   * Yaw angle sensor, degrees * 10
   */
  public val aoy: Int = 0,
) : MavMessage<Airspeeds> {
  public override val instanceMetadata: MavMessage.Metadata<Airspeeds> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt16(airspeedImu)
    outputBuffer.encodeInt16(airspeedPitot)
    outputBuffer.encodeInt16(airspeedHotWire)
    outputBuffer.encodeInt16(airspeedUltrasonic)
    outputBuffer.encodeInt16(aoa)
    outputBuffer.encodeInt16(aoy)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 182

    private const val CRC: Int = 154

    private const val SIZE: Int = 16

    private val DESERIALIZER: MavDeserializer<Airspeeds> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val airspeedImu = inputBuffer.decodeInt16()
      val airspeedPitot = inputBuffer.decodeInt16()
      val airspeedHotWire = inputBuffer.decodeInt16()
      val airspeedUltrasonic = inputBuffer.decodeInt16()
      val aoa = inputBuffer.decodeInt16()
      val aoy = inputBuffer.decodeInt16()

      Airspeeds(
        timeBootMs = timeBootMs,
        airspeedImu = airspeedImu,
        airspeedPitot = airspeedPitot,
        airspeedHotWire = airspeedHotWire,
        airspeedUltrasonic = airspeedUltrasonic,
        aoa = aoa,
        aoy = aoy,
      )
    }


    private val METADATA: MavMessage.Metadata<Airspeeds> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Airspeeds> = METADATA
  }
}
