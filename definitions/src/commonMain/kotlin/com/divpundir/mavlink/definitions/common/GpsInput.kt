package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit

/**
 * GPS sensor input message.  This is a raw sensor value sent by the GPS. This is NOT the global
 * position estimate of the system.
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param gpsId ID of the GPS for multiple GPS inputs
 * @param ignoreFlags Bitmap indicating which GPS input flags fields to ignore.  All other fields
 * must be provided.
 * @param timeWeekMs GPS time (from start of GPS week)
 * units = ms
 * @param timeWeek GPS week number
 * @param fixType 0-1: no fix, 2: 2D fix, 3: 3D fix. 4: 3D with DGPS. 5: 3D with RTK
 * @param lat Latitude (WGS84)
 * units = degE7
 * @param lon Longitude (WGS84)
 * units = degE7
 * @param alt Altitude (MSL). Positive for up.
 * units = m
 * @param hdop GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX
 * @param vdop GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX
 * @param vn GPS velocity in north direction in earth-fixed NED frame
 * units = m/s
 * @param ve GPS velocity in east direction in earth-fixed NED frame
 * units = m/s
 * @param vd GPS velocity in down direction in earth-fixed NED frame
 * units = m/s
 * @param speedAccuracy GPS speed accuracy
 * units = m/s
 * @param horizAccuracy GPS horizontal accuracy
 * units = m
 * @param vertAccuracy GPS vertical accuracy
 * units = m
 * @param satellitesVisible Number of satellites visible.
 * @param yaw Yaw of vehicle relative to Earth's North, zero means not available, use 36000 for
 * north
 * units = cdeg
 */
@GeneratedMavMessage(
  id = 232u,
  crcExtra = -105,
)
public data class GpsInput(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * ID of the GPS for multiple GPS inputs
   */
  @GeneratedMavField(type = "uint8_t")
  public val gpsId: UByte = 0u,
  /**
   * Bitmap indicating which GPS input flags fields to ignore.  All other fields must be provided.
   */
  @GeneratedMavField(type = "uint16_t")
  public val ignoreFlags: MavBitmaskValue<GpsInputIgnoreFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * GPS time (from start of GPS week)
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeWeekMs: UInt = 0u,
  /**
   * GPS week number
   */
  @GeneratedMavField(type = "uint16_t")
  public val timeWeek: UShort = 0u,
  /**
   * 0-1: no fix, 2: 2D fix, 3: 3D fix. 4: 3D with DGPS. 5: 3D with RTK
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
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val alt: Float = 0F,
  /**
   * GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX
   */
  @GeneratedMavField(type = "float")
  public val hdop: Float = 0F,
  /**
   * GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX
   */
  @GeneratedMavField(type = "float")
  public val vdop: Float = 0F,
  /**
   * GPS velocity in north direction in earth-fixed NED frame
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vn: Float = 0F,
  /**
   * GPS velocity in east direction in earth-fixed NED frame
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val ve: Float = 0F,
  /**
   * GPS velocity in down direction in earth-fixed NED frame
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vd: Float = 0F,
  /**
   * GPS speed accuracy
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val speedAccuracy: Float = 0F,
  /**
   * GPS horizontal accuracy
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val horizAccuracy: Float = 0F,
  /**
   * GPS vertical accuracy
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val vertAccuracy: Float = 0F,
  /**
   * Number of satellites visible.
   */
  @GeneratedMavField(type = "uint8_t")
  public val satellitesVisible: UByte = 0u,
  /**
   * Yaw of vehicle relative to Earth's North, zero means not available, use 36000 for north
   * units = cdeg
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val yaw: UShort = 0u,
) : MavMessage<GpsInput> {
  override val instanceCompanion: MavMessage.MavCompanion<GpsInput> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt32(timeWeekMs)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeFloat(alt)
    encoder.encodeFloat(hdop)
    encoder.encodeFloat(vdop)
    encoder.encodeFloat(vn)
    encoder.encodeFloat(ve)
    encoder.encodeFloat(vd)
    encoder.encodeFloat(speedAccuracy)
    encoder.encodeFloat(horizAccuracy)
    encoder.encodeFloat(vertAccuracy)
    encoder.encodeBitmaskValue(ignoreFlags.value, 2)
    encoder.encodeUInt16(timeWeek)
    encoder.encodeUInt8(gpsId)
    encoder.encodeUInt8(fixType)
    encoder.encodeUInt8(satellitesVisible)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt32(timeWeekMs)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeFloat(alt)
    encoder.encodeFloat(hdop)
    encoder.encodeFloat(vdop)
    encoder.encodeFloat(vn)
    encoder.encodeFloat(ve)
    encoder.encodeFloat(vd)
    encoder.encodeFloat(speedAccuracy)
    encoder.encodeFloat(horizAccuracy)
    encoder.encodeFloat(vertAccuracy)
    encoder.encodeBitmaskValue(ignoreFlags.value, 2)
    encoder.encodeUInt16(timeWeek)
    encoder.encodeUInt8(gpsId)
    encoder.encodeUInt8(fixType)
    encoder.encodeUInt8(satellitesVisible)
    encoder.encodeUInt16(yaw)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GpsInput> {
    private const val SIZE_V1: Int = 63

    private const val SIZE_V2: Int = 65

    override val id: UInt = 232u

    override val crcExtra: Byte = -105

    override fun deserialize(bytes: ByteArray): GpsInput {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val timeWeekMs = decoder.safeDecodeUInt32()
      val lat = decoder.safeDecodeInt32()
      val lon = decoder.safeDecodeInt32()
      val alt = decoder.safeDecodeFloat()
      val hdop = decoder.safeDecodeFloat()
      val vdop = decoder.safeDecodeFloat()
      val vn = decoder.safeDecodeFloat()
      val ve = decoder.safeDecodeFloat()
      val vd = decoder.safeDecodeFloat()
      val speedAccuracy = decoder.safeDecodeFloat()
      val horizAccuracy = decoder.safeDecodeFloat()
      val vertAccuracy = decoder.safeDecodeFloat()
      val ignoreFlags = decoder.safeDecodeBitmaskValue(2).let { value ->
        val flags = GpsInputIgnoreFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val timeWeek = decoder.safeDecodeUInt16()
      val gpsId = decoder.safeDecodeUInt8()
      val fixType = decoder.safeDecodeUInt8()
      val satellitesVisible = decoder.safeDecodeUInt8()
      val yaw = decoder.safeDecodeUInt16()

      return GpsInput(
        timeUsec = timeUsec,
        gpsId = gpsId,
        ignoreFlags = ignoreFlags,
        timeWeekMs = timeWeekMs,
        timeWeek = timeWeek,
        fixType = fixType,
        lat = lat,
        lon = lon,
        alt = alt,
        hdop = hdop,
        vdop = vdop,
        vn = vn,
        ve = ve,
        vd = vd,
        speedAccuracy = speedAccuracy,
        horizAccuracy = horizAccuracy,
        vertAccuracy = vertAccuracy,
        satellitesVisible = satellitesVisible,
        yaw = yaw,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GpsInput =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var gpsId: UByte = 0u

    public var ignoreFlags: MavBitmaskValue<GpsInputIgnoreFlags> = MavBitmaskValue.fromValue(0u)

    public var timeWeekMs: UInt = 0u

    public var timeWeek: UShort = 0u

    public var fixType: UByte = 0u

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Float = 0F

    public var hdop: Float = 0F

    public var vdop: Float = 0F

    public var vn: Float = 0F

    public var ve: Float = 0F

    public var vd: Float = 0F

    public var speedAccuracy: Float = 0F

    public var horizAccuracy: Float = 0F

    public var vertAccuracy: Float = 0F

    public var satellitesVisible: UByte = 0u

    public var yaw: UShort = 0u

    public fun build(): GpsInput = GpsInput(
      timeUsec = timeUsec,
      gpsId = gpsId,
      ignoreFlags = ignoreFlags,
      timeWeekMs = timeWeekMs,
      timeWeek = timeWeek,
      fixType = fixType,
      lat = lat,
      lon = lon,
      alt = alt,
      hdop = hdop,
      vdop = vdop,
      vn = vn,
      ve = ve,
      vd = vd,
      speedAccuracy = speedAccuracy,
      horizAccuracy = horizAccuracy,
      vertAccuracy = vertAccuracy,
      satellitesVisible = satellitesVisible,
      yaw = yaw,
    )
  }
}
