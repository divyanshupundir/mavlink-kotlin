package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt32

/**
 * Status of secondary AHRS filter if available.
 */
@GeneratedMavMessage(
  id = 178,
  crc = 47,
)
public data class Ahrs2(
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
) : MavMessage<Ahrs2> {
  public override val instanceMetadata: MavMessage.Metadata<Ahrs2> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(altitude)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 178

    private const val CRC: Int = 47

    private const val SIZE: Int = 24

    private val DESERIALIZER: MavDeserializer<Ahrs2> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val roll = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val altitude = inputBuffer.decodeFloat()
      val lat = inputBuffer.decodeInt32()
      val lng = inputBuffer.decodeInt32()

      Ahrs2(
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        altitude = altitude,
        lat = lat,
        lng = lng,
      )
    }


    private val METADATA: MavMessage.Metadata<Ahrs2> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Ahrs2> = METADATA
  }
}
