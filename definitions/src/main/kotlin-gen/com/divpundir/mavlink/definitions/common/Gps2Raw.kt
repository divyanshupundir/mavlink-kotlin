package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Second GPS data.
 */
@GeneratedMavMessage(
  id = 124u,
  crcExtra = 87,
)
public data class Gps2Raw(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * GPS fix type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val fixType: MavEnumValue<GpsFixType> = MavEnumValue.fromValue(0u),
  /**
   * Latitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude (MSL). Positive for up.
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
   */
  @GeneratedMavField(type = "uint16_t")
  public val vel: UShort = 0u,
  /**
   * Course over ground (NOT heading, but direction of movement): 0.0..359.99 degrees. If unknown,
   * set to: UINT16_MAX
   */
  @GeneratedMavField(type = "uint16_t")
  public val cog: UShort = 0u,
  /**
   * Number of satellites visible. If unknown, set to UINT8_MAX
   */
  @GeneratedMavField(type = "uint8_t")
  public val satellitesVisible: UByte = 0u,
  /**
   * Number of DGPS satellites
   */
  @GeneratedMavField(type = "uint8_t")
  public val dgpsNumch: UByte = 0u,
  /**
   * Age of DGPS info
   */
  @GeneratedMavField(type = "uint32_t")
  public val dgpsAge: UInt = 0u,
  /**
   * Yaw in earth frame from north. Use 0 if this GPS does not provide yaw. Use UINT16_MAX if this
   * GPS is configured to provide yaw and is currently unable to provide it. Use 36000 for north.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val yaw: UShort = 0u,
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
  public val hAcc: UInt = 0u,
  /**
   * Altitude uncertainty.
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val vAcc: UInt = 0u,
  /**
   * Speed uncertainty.
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val velAcc: UInt = 0u,
  /**
   * Heading / track uncertainty
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val hdgAcc: UInt = 0u,
) : MavMessage<Gps2Raw> {
  public override val instanceCompanion: MavMessage.MavCompanion<Gps2Raw> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeInt32(lat)
    output.encodeInt32(lon)
    output.encodeInt32(alt)
    output.encodeUInt32(dgpsAge)
    output.encodeUInt16(eph)
    output.encodeUInt16(epv)
    output.encodeUInt16(vel)
    output.encodeUInt16(cog)
    output.encodeEnumValue(fixType.value, 1)
    output.encodeUInt8(satellitesVisible)
    output.encodeUInt8(dgpsNumch)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeInt32(lat)
    output.encodeInt32(lon)
    output.encodeInt32(alt)
    output.encodeUInt32(dgpsAge)
    output.encodeUInt16(eph)
    output.encodeUInt16(epv)
    output.encodeUInt16(vel)
    output.encodeUInt16(cog)
    output.encodeEnumValue(fixType.value, 1)
    output.encodeUInt8(satellitesVisible)
    output.encodeUInt8(dgpsNumch)
    output.encodeUInt16(yaw)
    output.encodeInt32(altEllipsoid)
    output.encodeUInt32(hAcc)
    output.encodeUInt32(vAcc)
    output.encodeUInt32(velAcc)
    output.encodeUInt32(hdgAcc)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<Gps2Raw> {
    private const val SIZE_V1: Int = 35

    private const val SIZE_V2: Int = 57

    public override val id: UInt = 124u

    public override val crcExtra: Byte = 87

    public override fun deserialize(source: BufferedSource): Gps2Raw {
      val timeUsec = source.decodeUInt64()
      val lat = source.decodeInt32()
      val lon = source.decodeInt32()
      val alt = source.decodeInt32()
      val dgpsAge = source.decodeUInt32()
      val eph = source.decodeUInt16()
      val epv = source.decodeUInt16()
      val vel = source.decodeUInt16()
      val cog = source.decodeUInt16()
      val fixType = source.decodeEnumValue(1).let { value ->
        val entry = GpsFixType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val satellitesVisible = source.decodeUInt8()
      val dgpsNumch = source.decodeUInt8()
      val yaw = source.decodeUInt16()
      val altEllipsoid = source.decodeInt32()
      val hAcc = source.decodeUInt32()
      val vAcc = source.decodeUInt32()
      val velAcc = source.decodeUInt32()
      val hdgAcc = source.decodeUInt32()

      return Gps2Raw(
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
        dgpsNumch = dgpsNumch,
        dgpsAge = dgpsAge,
        yaw = yaw,
        altEllipsoid = altEllipsoid,
        hAcc = hAcc,
        vAcc = vAcc,
        velAcc = velAcc,
        hdgAcc = hdgAcc,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Gps2Raw =
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

    public var dgpsNumch: UByte = 0u

    public var dgpsAge: UInt = 0u

    public var yaw: UShort = 0u

    public var altEllipsoid: Int = 0

    public var hAcc: UInt = 0u

    public var vAcc: UInt = 0u

    public var velAcc: UInt = 0u

    public var hdgAcc: UInt = 0u

    public fun build(): Gps2Raw = Gps2Raw(
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
      dgpsNumch = dgpsNumch,
      dgpsAge = dgpsAge,
      yaw = yaw,
      altEllipsoid = altEllipsoid,
      hAcc = hAcc,
      vAcc = vAcc,
      velAcc = velAcc,
      hdgAcc = hdgAcc,
    )
  }
}
