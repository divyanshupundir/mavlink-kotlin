package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long

/**
 * Water depth
 */
public data class WaterDepth(
  /**
   * Timestamp (time since system boot)
   */
  public val timeBootMs: Long = 0L,
  /**
   * Onboard ID of the sensor
   */
  public val id: Int = 0,
  /**
   * Sensor data healthy (0=unhealthy, 1=healthy)
   */
  public val healthy: Int = 0,
  /**
   * Latitude
   */
  public val lat: Int = 0,
  /**
   * Longitude
   */
  public val lng: Int = 0,
  /**
   * Altitude (MSL) of vehicle
   */
  public val alt: Float = 0F,
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
   * Distance (uncorrected)
   */
  public val distance: Float = 0F,
  /**
   * Water temperature
   */
  public val temperature: Float = 0F,
) : MavMessage<WaterDepth> {
  public override val instanceMetadata: MavMessage.Metadata<WaterDepth> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(38).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    outputBuffer.encodeFloat(alt)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(distance)
    outputBuffer.encodeFloat(temperature)
    outputBuffer.encodeUint8(id)
    outputBuffer.encodeUint8(healthy)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 11038

    private const val CRC: Int = 47

    private val DESERIALIZER: MavDeserializer<WaterDepth> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val lat = inputBuffer.decodeInt32()
      val lng = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeFloat()
      val roll = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val distance = inputBuffer.decodeFloat()
      val temperature = inputBuffer.decodeFloat()
      val id = inputBuffer.decodeUint8()
      val healthy = inputBuffer.decodeUint8()
      WaterDepth(
        timeBootMs = timeBootMs,
        id = id,
        healthy = healthy,
        lat = lat,
        lng = lng,
        alt = alt,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        distance = distance,
        temperature = temperature,
      )
    }


    private val METADATA: MavMessage.Metadata<WaterDepth> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<WaterDepth> = METADATA
  }
}
