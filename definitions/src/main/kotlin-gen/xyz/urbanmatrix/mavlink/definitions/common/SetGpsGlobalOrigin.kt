package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Sets the GPS co-ordinates of the vehicle local origin (0,0,0) position. Vehicle should emit
 * GPS_GLOBAL_ORIGIN irrespective of whether the origin is changed. This enables transform between the
 * local coordinate frame and the global (GPS) coordinate frame, which may be necessary when (for
 * example) indoor and outdoor settings are connected and the MAV should move from in- to outdoor.
 */
@GeneratedMavMessage(
  id = 48,
  crc = 41,
)
public data class SetGpsGlobalOrigin(
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Latitude (WGS84)
   */
  public val latitude: Int = 0,
  /**
   * Longitude (WGS84)
   */
  public val longitude: Int = 0,
  /**
   * Altitude (MSL). Positive for up.
   */
  public val altitude: Int = 0,
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
) : MavMessage<SetGpsGlobalOrigin> {
  public override val instanceMetadata: MavMessage.Metadata<SetGpsGlobalOrigin> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(latitude)
    outputBuffer.encodeInt32(longitude)
    outputBuffer.encodeInt32(altitude)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint64(timeUsec)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 48

    private const val CRC: Int = 41

    private const val SIZE: Int = 21

    private val DESERIALIZER: MavDeserializer<SetGpsGlobalOrigin> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val latitude = inputBuffer.decodeInt32()
      val longitude = inputBuffer.decodeInt32()
      val altitude = inputBuffer.decodeInt32()
      val targetSystem = inputBuffer.decodeUint8()
      val timeUsec = inputBuffer.decodeUint64()

      SetGpsGlobalOrigin(
        targetSystem = targetSystem,
        latitude = latitude,
        longitude = longitude,
        altitude = altitude,
        timeUsec = timeUsec,
      )
    }


    private val METADATA: MavMessage.Metadata<SetGpsGlobalOrigin> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SetGpsGlobalOrigin> = METADATA
  }
}
