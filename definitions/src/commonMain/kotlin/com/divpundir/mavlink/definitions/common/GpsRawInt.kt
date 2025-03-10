package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit

/**
 * The global position, as returned by the Global Positioning System (GPS). This is
 *                 NOT the global position estimate of the system, but rather a RAW sensor value.
 * See message GLOBAL_POSITION_INT for the global position estimate.
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param fixType GPS fix type.
 * @param lat Latitude (WGS84, EGM96 ellipsoid)
 * units = degE7
 * @param lon Longitude (WGS84, EGM96 ellipsoid)
 * units = degE7
 * @param alt Altitude (MSL). Positive for up. Note that virtually all GPS modules provide the MSL
 * altitude in addition to the WGS84 altitude.
 * units = mm
 * @param eph GPS HDOP horizontal dilution of position (unitless * 100). If unknown, set to:
 * UINT16_MAX
 * @param epv GPS VDOP vertical dilution of position (unitless * 100). If unknown, set to:
 * UINT16_MAX
 * @param vel GPS ground speed. If unknown, set to: UINT16_MAX
 * units = cm/s
 * @param cog Course over ground (NOT heading, but direction of movement) in degrees * 100,
 * 0.0..359.99 degrees. If unknown, set to: UINT16_MAX
 * units = cdeg
 * @param satellitesVisible Number of satellites visible. If unknown, set to UINT8_MAX
 * @param altEllipsoid Altitude (above WGS84, EGM96 ellipsoid). Positive for up.
 * units = mm
 * @param hAcc Position uncertainty.
 * units = mm
 * @param vAcc Altitude uncertainty.
 * units = mm
 * @param velAcc Speed uncertainty.
 * units = mm/s
 * @param hdgAcc Heading / track uncertainty
 * units = degE5
 * @param yaw Yaw in earth frame from north. Use 0 if this GPS does not provide yaw. Use UINT16_MAX
 * if this GPS is configured to provide yaw and is currently unable to provide it. Use 36000 for north.
 * units = cdeg
 */
@GeneratedMavMessage(
  id = 24u,
  crcExtra = 24,
)
public data class GpsRawInt(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * GPS fix type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val fixType: MavEnumValue<GpsFixType> = MavEnumValue.fromValue(0u),
  /**
   * Latitude (WGS84, EGM96 ellipsoid)
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude (WGS84, EGM96 ellipsoid)
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude (MSL). Positive for up. Note that virtually all GPS modules provide the MSL altitude
   * in addition to the WGS84 altitude.
   * units = mm
   */
  @GeneratedMavField(type = "int32_t")
  public val alt: Int = 0,
  /**
   * GPS HDOP horizontal dilution of position (unitless * 100). If unknown, set to: UINT16_MAX
   */
  @GeneratedMavField(type = "uint16_t")
  public val eph: UShort = 0u,
  /**
   * GPS VDOP vertical dilution of position (unitless * 100). If unknown, set to: UINT16_MAX
   */
  @GeneratedMavField(type = "uint16_t")
  public val epv: UShort = 0u,
  /**
   * GPS ground speed. If unknown, set to: UINT16_MAX
   * units = cm/s
   */
  @GeneratedMavField(type = "uint16_t")
  public val vel: UShort = 0u,
  /**
   * Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99
   * degrees. If unknown, set to: UINT16_MAX
   * units = cdeg
   */
  @GeneratedMavField(type = "uint16_t")
  public val cog: UShort = 0u,
  /**
   * Number of satellites visible. If unknown, set to UINT8_MAX
   */
  @GeneratedMavField(type = "uint8_t")
  public val satellitesVisible: UByte = 0u,
  /**
   * Altitude (above WGS84, EGM96 ellipsoid). Positive for up.
   * units = mm
   */
  @GeneratedMavField(
    type = "int32_t",
    extension = true,
  )
  public val altEllipsoid: Int = 0,
  /**
   * Position uncertainty.
   * units = mm
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val hAcc: UInt = 0u,
  /**
   * Altitude uncertainty.
   * units = mm
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val vAcc: UInt = 0u,
  /**
   * Speed uncertainty.
   * units = mm/s
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val velAcc: UInt = 0u,
  /**
   * Heading / track uncertainty
   * units = degE5
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val hdgAcc: UInt = 0u,
  /**
   * Yaw in earth frame from north. Use 0 if this GPS does not provide yaw. Use UINT16_MAX if this
   * GPS is configured to provide yaw and is currently unable to provide it. Use 36000 for north.
   * units = cdeg
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val yaw: UShort = 0u,
) : MavMessage<GpsRawInt> {
  override val instanceCompanion: MavMessage.MavCompanion<GpsRawInt> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeInt32(alt)
    encoder.encodeUInt16(eph)
    encoder.encodeUInt16(epv)
    encoder.encodeUInt16(vel)
    encoder.encodeUInt16(cog)
    encoder.encodeEnumValue(fixType.value, 1)
    encoder.encodeUInt8(satellitesVisible)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeInt32(alt)
    encoder.encodeUInt16(eph)
    encoder.encodeUInt16(epv)
    encoder.encodeUInt16(vel)
    encoder.encodeUInt16(cog)
    encoder.encodeEnumValue(fixType.value, 1)
    encoder.encodeUInt8(satellitesVisible)
    encoder.encodeInt32(altEllipsoid)
    encoder.encodeUInt32(hAcc)
    encoder.encodeUInt32(vAcc)
    encoder.encodeUInt32(velAcc)
    encoder.encodeUInt32(hdgAcc)
    encoder.encodeUInt16(yaw)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GpsRawInt> {
    private const val SIZE_V1: Int = 30

    private const val SIZE_V2: Int = 52

    override val id: UInt = 24u

    override val crcExtra: Byte = 24

    override fun deserialize(bytes: ByteArray): GpsRawInt {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val lat = decoder.safeDecodeInt32()
      val lon = decoder.safeDecodeInt32()
      val alt = decoder.safeDecodeInt32()
      val eph = decoder.safeDecodeUInt16()
      val epv = decoder.safeDecodeUInt16()
      val vel = decoder.safeDecodeUInt16()
      val cog = decoder.safeDecodeUInt16()
      val fixType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = GpsFixType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val satellitesVisible = decoder.safeDecodeUInt8()
      val altEllipsoid = decoder.safeDecodeInt32()
      val hAcc = decoder.safeDecodeUInt32()
      val vAcc = decoder.safeDecodeUInt32()
      val velAcc = decoder.safeDecodeUInt32()
      val hdgAcc = decoder.safeDecodeUInt32()
      val yaw = decoder.safeDecodeUInt16()

      return GpsRawInt(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): GpsRawInt =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var fixType: MavEnumValue<GpsFixType> = MavEnumValue.fromValue(0u)

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Int = 0

    public var eph: UShort = 0u

    public var epv: UShort = 0u

    public var vel: UShort = 0u

    public var cog: UShort = 0u

    public var satellitesVisible: UByte = 0u

    public var altEllipsoid: Int = 0

    public var hAcc: UInt = 0u

    public var vAcc: UInt = 0u

    public var velAcc: UInt = 0u

    public var hdgAcc: UInt = 0u

    public var yaw: UShort = 0u

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
