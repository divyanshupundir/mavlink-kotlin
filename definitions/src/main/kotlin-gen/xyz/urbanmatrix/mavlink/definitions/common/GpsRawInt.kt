package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * The global position, as returned by the Global Positioning System (GPS). This is
 *                 NOT the global position estimate of the system, but rather a RAW sensor value.
 * See message GLOBAL_POSITION_INT for the global position estimate.
 */
@GeneratedMavMessage(
  id = 24,
  crc = 24,
)
public data class GpsRawInt(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * GPS fix type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val fixType: MavEnumValue<GpsFixType> = MavEnumValue.fromValue(0),
  /**
   * Latitude (WGS84, EGM96 ellipsoid)
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude (WGS84, EGM96 ellipsoid)
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude (MSL). Positive for up. Note that virtually all GPS modules provide the MSL altitude
   * in addition to the WGS84 altitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val alt: Int = 0,
  /**
   * GPS HDOP horizontal dilution of position (unitless * 100). If unknown, set to: UINT16_MAX
   */
  @GeneratedMavField(type = "uint16_t")
  public val eph: Int = 0,
  /**
   * GPS VDOP vertical dilution of position (unitless * 100). If unknown, set to: UINT16_MAX
   */
  @GeneratedMavField(type = "uint16_t")
  public val epv: Int = 0,
  /**
   * GPS ground speed. If unknown, set to: UINT16_MAX
   */
  @GeneratedMavField(type = "uint16_t")
  public val vel: Int = 0,
  /**
   * Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99
   * degrees. If unknown, set to: UINT16_MAX
   */
  @GeneratedMavField(type = "uint16_t")
  public val cog: Int = 0,
  /**
   * Number of satellites visible. If unknown, set to UINT8_MAX
   */
  @GeneratedMavField(type = "uint8_t")
  public val satellitesVisible: Int = 0,
  /**
   * Altitude (above WGS84, EGM96 ellipsoid). Positive for up.
   */
  @GeneratedMavField(
    type = "int32_t",
    extension = true,
  )
  public val altEllipsoid: Int = 0,
  /**
   * Position uncertainty.
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val hAcc: Long = 0L,
  /**
   * Altitude uncertainty.
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val vAcc: Long = 0L,
  /**
   * Speed uncertainty.
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val velAcc: Long = 0L,
  /**
   * Heading / track uncertainty
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val hdgAcc: Long = 0L,
  /**
   * Yaw in earth frame from north. Use 0 if this GPS does not provide yaw. Use UINT16_MAX if this
   * GPS is configured to provide yaw and is currently unable to provide it. Use 36000 for north.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val yaw: Int = 0,
) : MavMessage<GpsRawInt> {
  public override val instanceMetadata: MavMessage.Metadata<GpsRawInt> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeUint16(eph)
    outputBuffer.encodeUint16(epv)
    outputBuffer.encodeUint16(vel)
    outputBuffer.encodeUint16(cog)
    outputBuffer.encodeEnumValue(fixType.value, 1)
    outputBuffer.encodeUint8(satellitesVisible)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeUint16(eph)
    outputBuffer.encodeUint16(epv)
    outputBuffer.encodeUint16(vel)
    outputBuffer.encodeUint16(cog)
    outputBuffer.encodeEnumValue(fixType.value, 1)
    outputBuffer.encodeUint8(satellitesVisible)
    outputBuffer.encodeInt32(altEllipsoid)
    outputBuffer.encodeUint32(hAcc)
    outputBuffer.encodeUint32(vAcc)
    outputBuffer.encodeUint32(velAcc)
    outputBuffer.encodeUint32(hdgAcc)
    outputBuffer.encodeUint16(yaw)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 24

    private const val CRC: Int = 24

    private const val SIZE_V1: Int = 30

    private const val SIZE_V2: Int = 52

    private val DESERIALIZER: MavDeserializer<GpsRawInt> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeInt32()
      val eph = inputBuffer.decodeUint16()
      val epv = inputBuffer.decodeUint16()
      val vel = inputBuffer.decodeUint16()
      val cog = inputBuffer.decodeUint16()
      val fixType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GpsFixType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val satellitesVisible = inputBuffer.decodeUint8()
      val altEllipsoid = inputBuffer.decodeInt32()
      val hAcc = inputBuffer.decodeUint32()
      val vAcc = inputBuffer.decodeUint32()
      val velAcc = inputBuffer.decodeUint32()
      val hdgAcc = inputBuffer.decodeUint32()
      val yaw = inputBuffer.decodeUint16()

      GpsRawInt(
        timeUsec = timeUsec,
        fixType = fixType,
        lat = lat,
        lon = lon,
        alt = alt,
        eph = eph,
        epv = epv,
        vel = vel,
        cog = cog,
        satellitesVisible = satellitesVisible,
        altEllipsoid = altEllipsoid,
        hAcc = hAcc,
        vAcc = vAcc,
        velAcc = velAcc,
        hdgAcc = hdgAcc,
        yaw = yaw,
      )
    }


    private val METADATA: MavMessage.Metadata<GpsRawInt> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GpsRawInt> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: BigInteger = BigInteger.ZERO

    public var fixType: MavEnumValue<GpsFixType> = MavEnumValue.fromValue(0)

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Int = 0

    public var eph: Int = 0

    public var epv: Int = 0

    public var vel: Int = 0

    public var cog: Int = 0

    public var satellitesVisible: Int = 0

    public var altEllipsoid: Int = 0

    public var hAcc: Long = 0L

    public var vAcc: Long = 0L

    public var velAcc: Long = 0L

    public var hdgAcc: Long = 0L

    public var yaw: Int = 0

    public fun build(): GpsRawInt = GpsRawInt(
      timeUsec = timeUsec,
      fixType = fixType,
      lat = lat,
      lon = lon,
      alt = alt,
      eph = eph,
      epv = epv,
      vel = vel,
      cog = cog,
      satellitesVisible = satellitesVisible,
      altEllipsoid = altEllipsoid,
      hAcc = hAcc,
      vAcc = vAcc,
      velAcc = velAcc,
      hdgAcc = hdgAcc,
      yaw = yaw,
    )
  }
}
