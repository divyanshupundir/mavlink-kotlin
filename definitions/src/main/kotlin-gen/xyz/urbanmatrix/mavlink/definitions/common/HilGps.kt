package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * The global position, as returned by the Global Positioning System (GPS). This is
 *                  NOT the global position estimate of the sytem, but rather a RAW sensor value.
 * See message GLOBAL_POSITION_INT for the global position estimate.
 */
@GeneratedMavMessage(
  id = 113,
  crc = 124,
)
public data class HilGps(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * 0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of this field
   * unless it is at least two, so always correctly fill in the fix.
   */
  public val fixType: Int = 0,
  /**
   * Latitude (WGS84)
   */
  public val lat: Int = 0,
  /**
   * Longitude (WGS84)
   */
  public val lon: Int = 0,
  /**
   * Altitude (MSL). Positive for up.
   */
  public val alt: Int = 0,
  /**
   * GPS HDOP horizontal dilution of position (unitless * 100). If unknown, set to: UINT16_MAX
   */
  public val eph: Int = 0,
  /**
   * GPS VDOP vertical dilution of position (unitless * 100). If unknown, set to: UINT16_MAX
   */
  public val epv: Int = 0,
  /**
   * GPS ground speed. If unknown, set to: UINT16_MAX
   */
  public val vel: Int = 0,
  /**
   * GPS velocity in north direction in earth-fixed NED frame
   */
  public val vn: Int = 0,
  /**
   * GPS velocity in east direction in earth-fixed NED frame
   */
  public val ve: Int = 0,
  /**
   * GPS velocity in down direction in earth-fixed NED frame
   */
  public val vd: Int = 0,
  /**
   * Course over ground (NOT heading, but direction of movement), 0.0..359.99 degrees. If unknown,
   * set to: UINT16_MAX
   */
  public val cog: Int = 0,
  /**
   * Number of satellites visible. If unknown, set to UINT8_MAX
   */
  public val satellitesVisible: Int = 0,
  /**
   * GPS ID (zero indexed). Used for multiple GPS inputs
   */
  public val id: Int = 0,
  /**
   * Yaw of vehicle relative to Earth's North, zero means not available, use 36000 for north
   */
  public val yaw: Int = 0,
) : MavMessage<HilGps> {
  public override val instanceMetadata: MavMessage.Metadata<HilGps> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeUint16(eph)
    outputBuffer.encodeUint16(epv)
    outputBuffer.encodeUint16(vel)
    outputBuffer.encodeInt16(vn)
    outputBuffer.encodeInt16(ve)
    outputBuffer.encodeInt16(vd)
    outputBuffer.encodeUint16(cog)
    outputBuffer.encodeUint8(fixType)
    outputBuffer.encodeUint8(satellitesVisible)
    outputBuffer.encodeUint8(id)
    outputBuffer.encodeUint16(yaw)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 113

    private const val CRC: Int = 124

    private const val SIZE: Int = 39

    private val DESERIALIZER: MavDeserializer<HilGps> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeInt32()
      val eph = inputBuffer.decodeUint16()
      val epv = inputBuffer.decodeUint16()
      val vel = inputBuffer.decodeUint16()
      val vn = inputBuffer.decodeInt16()
      val ve = inputBuffer.decodeInt16()
      val vd = inputBuffer.decodeInt16()
      val cog = inputBuffer.decodeUint16()
      val fixType = inputBuffer.decodeUint8()
      val satellitesVisible = inputBuffer.decodeUint8()
      val id = inputBuffer.decodeUint8()
      val yaw = inputBuffer.decodeUint16()

      HilGps(
        timeUsec = timeUsec,
        fixType = fixType,
        lat = lat,
        lon = lon,
        alt = alt,
        eph = eph,
        epv = epv,
        vel = vel,
        vn = vn,
        ve = ve,
        vd = vd,
        cog = cog,
        satellitesVisible = satellitesVisible,
        id = id,
        yaw = yaw,
      )
    }


    private val METADATA: MavMessage.Metadata<HilGps> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HilGps> = METADATA
  }
}
