package com.urbanmatrix.mavlink.avssuas

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeUint32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long

/**
 *  Drone position.
 */
public data class AvssDronePosition(
  /**
   * Timestamp (time since FC boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * Latitude, expressed
   */
  public val lat: Int = 0,
  /**
   * Longitude, expressed
   */
  public val lon: Int = 0,
  /**
   * Altitude (MSL). Note that virtually all GPS modules provide both WGS84 and MSL.
   */
  public val alt: Int = 0,
  /**
   * Altitude above ground, This altitude is measured by a ultrasound, Laser rangefinder or
   * millimeter-wave radar
   */
  public val groundAlt: Float = 0F,
  /**
   * This altitude is measured by a barometer
   */
  public val barometerAlt: Float = 0F,
) : MavMessage<AvssDronePosition> {
  public override val instanceMetadata: MavMessage.Metadata<AvssDronePosition> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeFloat(groundAlt)
    outputBuffer.encodeFloat(barometerAlt)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 60051

    private const val CRC: Int = 245

    private const val SIZE: Int = 24

    private val DESERIALIZER: MavDeserializer<AvssDronePosition> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for AvssDronePosition: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeInt32()
      val groundAlt = inputBuffer.decodeFloat()
      val barometerAlt = inputBuffer.decodeFloat()

      AvssDronePosition(
        timeBootMs = timeBootMs,
        lat = lat,
        lon = lon,
        alt = alt,
        groundAlt = groundAlt,
        barometerAlt = barometerAlt,
      )
    }


    private val METADATA: MavMessage.Metadata<AvssDronePosition> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AvssDronePosition> = METADATA
  }
}
