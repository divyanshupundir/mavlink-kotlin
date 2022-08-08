package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Status of third AHRS filter if available. This is for ANU research group (Ali and Sean).
 */
@GeneratedMavMessage(
  id = 182,
  crc = 229,
)
public data class Ahrs3(
  /**
   * Roll angle.
   */
  public val roll: Float = 0F,
  /**
   * Pitch angle.
   */
  public val pitch: Float = 0F,
  /**
   * Yaw angle.
   */
  public val yaw: Float = 0F,
  /**
   * Altitude (MSL).
   */
  public val altitude: Float = 0F,
  /**
   * Latitude.
   */
  public val lat: Int = 0,
  /**
   * Longitude.
   */
  public val lng: Int = 0,
  /**
   * Test variable1.
   */
  public val v1: Float = 0F,
  /**
   * Test variable2.
   */
  public val v2: Float = 0F,
  /**
   * Test variable3.
   */
  public val v3: Float = 0F,
  /**
   * Test variable4.
   */
  public val v4: Float = 0F,
) : MavMessage<Ahrs3> {
  public override val instanceMetadata: MavMessage.Metadata<Ahrs3> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(altitude)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    outputBuffer.encodeFloat(v1)
    outputBuffer.encodeFloat(v2)
    outputBuffer.encodeFloat(v3)
    outputBuffer.encodeFloat(v4)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 182

    private const val CRC: Int = 229

    private const val SIZE: Int = 40

    private val DESERIALIZER: MavDeserializer<Ahrs3> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val roll = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val altitude = inputBuffer.decodeFloat()
      val lat = inputBuffer.decodeInt32()
      val lng = inputBuffer.decodeInt32()
      val v1 = inputBuffer.decodeFloat()
      val v2 = inputBuffer.decodeFloat()
      val v3 = inputBuffer.decodeFloat()
      val v4 = inputBuffer.decodeFloat()

      Ahrs3(
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        altitude = altitude,
        lat = lat,
        lng = lng,
        v1 = v1,
        v2 = v2,
        v3 = v3,
        v4 = v4,
      )
    }


    private val METADATA: MavMessage.Metadata<Ahrs3> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Ahrs3> = METADATA
  }
}
