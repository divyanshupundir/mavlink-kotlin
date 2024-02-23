package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit

/**
 * The global position, as returned by the Global Positioning System (GPS). This is
 *                  NOT the global position estimate of the system, but rather a RAW sensor value.
 * See message GLOBAL_POSITION_INT for the global position estimate.
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param fixType 0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of
 * this field unless it is at least two, so always correctly fill in the fix.
 * @param lat Latitude (WGS84)
 * units = degE7
 * @param lon Longitude (WGS84)
 * units = degE7
 * @param alt Altitude (MSL). Positive for up.
 * units = mm
 * @param eph GPS HDOP horizontal dilution of position (unitless * 100). If unknown, set to:
 * UINT16_MAX
 * @param epv GPS VDOP vertical dilution of position (unitless * 100). If unknown, set to:
 * UINT16_MAX
 * @param vel GPS ground speed. If unknown, set to: UINT16_MAX
 * units = cm/s
 * @param vn GPS velocity in north direction in earth-fixed NED frame
 * units = cm/s
 * @param ve GPS velocity in east direction in earth-fixed NED frame
 * units = cm/s
 * @param vd GPS velocity in down direction in earth-fixed NED frame
 * units = cm/s
 * @param cog Course over ground (NOT heading, but direction of movement), 0.0..359.99 degrees. If
 * unknown, set to: UINT16_MAX
 * units = cdeg
 * @param satellitesVisible Number of satellites visible. If unknown, set to UINT8_MAX
 * @param id GPS ID (zero indexed). Used for multiple GPS inputs
 * @param yaw Yaw of vehicle relative to Earth's North, zero means not available, use 36000 for
 * north
 * units = cdeg
 */
@GeneratedMavMessage(
  id = 113u,
  crcExtra = 124,
)
public data class HilGps(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * 0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of this field
   * unless it is at least two, so always correctly fill in the fix.
   */
  @GeneratedMavField(type = "uint8_t")
  public val fixType: UByte = 0u,
  /**
   * Latitude (WGS84)
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude (WGS84)
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude (MSL). Positive for up.
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
   * GPS velocity in north direction in earth-fixed NED frame
   * units = cm/s
   */
  @GeneratedMavField(type = "int16_t")
  public val vn: Short = 0,
  /**
   * GPS velocity in east direction in earth-fixed NED frame
   * units = cm/s
   */
  @GeneratedMavField(type = "int16_t")
  public val ve: Short = 0,
  /**
   * GPS velocity in down direction in earth-fixed NED frame
   * units = cm/s
   */
  @GeneratedMavField(type = "int16_t")
  public val vd: Short = 0,
  /**
   * Course over ground (NOT heading, but direction of movement), 0.0..359.99 degrees. If unknown,
   * set to: UINT16_MAX
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
   * GPS ID (zero indexed). Used for multiple GPS inputs
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val id: UByte = 0u,
  /**
   * Yaw of vehicle relative to Earth's North, zero means not available, use 36000 for north
   * units = cdeg
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val yaw: UShort = 0u,
) : MavMessage<HilGps> {
  override val instanceCompanion: MavMessage.MavCompanion<HilGps> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeInt32(alt)
    encoder.encodeUInt16(eph)
    encoder.encodeUInt16(epv)
    encoder.encodeUInt16(vel)
    encoder.encodeInt16(vn)
    encoder.encodeInt16(ve)
    encoder.encodeInt16(vd)
    encoder.encodeUInt16(cog)
    encoder.encodeUInt8(fixType)
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
    encoder.encodeInt16(vn)
    encoder.encodeInt16(ve)
    encoder.encodeInt16(vd)
    encoder.encodeUInt16(cog)
    encoder.encodeUInt8(fixType)
    encoder.encodeUInt8(satellitesVisible)
    encoder.encodeUInt8(id)
    encoder.encodeUInt16(yaw)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HilGps> {
    private const val SIZE_V1: Int = 36

    private const val SIZE_V2: Int = 39

    override val id: UInt = 113u

    override val crcExtra: Byte = 124

    override fun deserialize(bytes: ByteArray): HilGps {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val lat = decoder.safeDecodeInt32()
      val lon = decoder.safeDecodeInt32()
      val alt = decoder.safeDecodeInt32()
      val eph = decoder.safeDecodeUInt16()
      val epv = decoder.safeDecodeUInt16()
      val vel = decoder.safeDecodeUInt16()
      val vn = decoder.safeDecodeInt16()
      val ve = decoder.safeDecodeInt16()
      val vd = decoder.safeDecodeInt16()
      val cog = decoder.safeDecodeUInt16()
      val fixType = decoder.safeDecodeUInt8()
      val satellitesVisible = decoder.safeDecodeUInt8()
      val id = decoder.safeDecodeUInt8()
      val yaw = decoder.safeDecodeUInt16()

      return HilGps(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): HilGps =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var fixType: UByte = 0u

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Int = 0

    public var eph: UShort = 0u

    public var epv: UShort = 0u

    public var vel: UShort = 0u

    public var vn: Short = 0

    public var ve: Short = 0

    public var vd: Short = 0

    public var cog: UShort = 0u

    public var satellitesVisible: UByte = 0u

    public var id: UByte = 0u

    public var yaw: UShort = 0u

    public fun build(): HilGps = HilGps(
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
}
