package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
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
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
 */
@GeneratedMavMessage(
  id = 24u,
  crcExtra = 24,
)
public data class GpsRawInt(
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
   * Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99
   * degrees. If unknown, set to: UINT16_MAX
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
  /**
   * Yaw in earth frame from north. Use 0 if this GPS does not provide yaw. Use UINT16_MAX if this
   * GPS is configured to provide yaw and is currently unable to provide it. Use 36000 for north.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val yaw: UShort = 0u,
) : MavMessage<GpsRawInt> {
  public override val instanceMetadata: MavMessage.Metadata<GpsRawInt> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeUInt16(eph)
    outputBuffer.encodeUInt16(epv)
    outputBuffer.encodeUInt16(vel)
    outputBuffer.encodeUInt16(cog)
    outputBuffer.encodeEnumValue(fixType.value, 1)
    outputBuffer.encodeUInt8(satellitesVisible)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeUInt16(eph)
    outputBuffer.encodeUInt16(epv)
    outputBuffer.encodeUInt16(vel)
    outputBuffer.encodeUInt16(cog)
    outputBuffer.encodeEnumValue(fixType.value, 1)
    outputBuffer.encodeUInt8(satellitesVisible)
    outputBuffer.encodeInt32(altEllipsoid)
    outputBuffer.encodeUInt32(hAcc)
    outputBuffer.encodeUInt32(vAcc)
    outputBuffer.encodeUInt32(velAcc)
    outputBuffer.encodeUInt32(hdgAcc)
    outputBuffer.encodeUInt16(yaw)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 24u

    private const val CRC_EXTRA: Byte = 24

    private const val SIZE_V1: Int = 30

    private const val SIZE_V2: Int = 52

    private val DESERIALIZER: MavDeserializer<GpsRawInt> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeInt32()
      val eph = inputBuffer.decodeUInt16()
      val epv = inputBuffer.decodeUInt16()
      val vel = inputBuffer.decodeUInt16()
      val cog = inputBuffer.decodeUInt16()
      val fixType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GpsFixType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val satellitesVisible = inputBuffer.decodeUInt8()
      val altEllipsoid = inputBuffer.decodeInt32()
      val hAcc = inputBuffer.decodeUInt32()
      val vAcc = inputBuffer.decodeUInt32()
      val velAcc = inputBuffer.decodeUInt32()
      val hdgAcc = inputBuffer.decodeUInt32()
      val yaw = inputBuffer.decodeUInt16()

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


    private val METADATA: MavMessage.Metadata<GpsRawInt> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GpsRawInt> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GpsRawInt =
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
