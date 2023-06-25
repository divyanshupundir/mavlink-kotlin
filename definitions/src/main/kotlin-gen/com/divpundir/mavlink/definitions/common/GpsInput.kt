package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
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
import okio.Buffer

/**
 * GPS sensor input message.  This is a raw sensor value sent by the GPS. This is NOT the global
 * position estimate of the system.
 */
@GeneratedMavMessage(
  id = 232u,
  crcExtra = -105,
)
public data class GpsInput(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
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
   */
  @GeneratedMavField(type = "float")
  public val vn: Float = 0F,
  /**
   * GPS velocity in east direction in earth-fixed NED frame
   */
  @GeneratedMavField(type = "float")
  public val ve: Float = 0F,
  /**
   * GPS velocity in down direction in earth-fixed NED frame
   */
  @GeneratedMavField(type = "float")
  public val vd: Float = 0F,
  /**
   * GPS speed accuracy
   */
  @GeneratedMavField(type = "float")
  public val speedAccuracy: Float = 0F,
  /**
   * GPS horizontal accuracy
   */
  @GeneratedMavField(type = "float")
  public val horizAccuracy: Float = 0F,
  /**
   * GPS vertical accuracy
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
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val yaw: UShort = 0u,
) : MavMessage<GpsInput> {
  public override val instanceCompanion: MavMessage.MavCompanion<GpsInput> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeUInt32(timeWeekMs)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeFloat(alt)
    buffer.encodeFloat(hdop)
    buffer.encodeFloat(vdop)
    buffer.encodeFloat(vn)
    buffer.encodeFloat(ve)
    buffer.encodeFloat(vd)
    buffer.encodeFloat(speedAccuracy)
    buffer.encodeFloat(horizAccuracy)
    buffer.encodeFloat(vertAccuracy)
    buffer.encodeBitmaskValue(ignoreFlags.value, 2)
    buffer.encodeUInt16(timeWeek)
    buffer.encodeUInt8(gpsId)
    buffer.encodeUInt8(fixType)
    buffer.encodeUInt8(satellitesVisible)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeUInt32(timeWeekMs)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeFloat(alt)
    buffer.encodeFloat(hdop)
    buffer.encodeFloat(vdop)
    buffer.encodeFloat(vn)
    buffer.encodeFloat(ve)
    buffer.encodeFloat(vd)
    buffer.encodeFloat(speedAccuracy)
    buffer.encodeFloat(horizAccuracy)
    buffer.encodeFloat(vertAccuracy)
    buffer.encodeBitmaskValue(ignoreFlags.value, 2)
    buffer.encodeUInt16(timeWeek)
    buffer.encodeUInt8(gpsId)
    buffer.encodeUInt8(fixType)
    buffer.encodeUInt8(satellitesVisible)
    buffer.encodeUInt16(yaw)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GpsInput> {
    public override val id: UInt = 232u

    public override val crcExtra: Byte = -105

    public override fun deserialize(bytes: ByteArray): GpsInput {
      val buffer = Buffer().write(bytes)

      val timeUsec = buffer.decodeUInt64()
      val timeWeekMs = buffer.decodeUInt32()
      val lat = buffer.decodeInt32()
      val lon = buffer.decodeInt32()
      val alt = buffer.decodeFloat()
      val hdop = buffer.decodeFloat()
      val vdop = buffer.decodeFloat()
      val vn = buffer.decodeFloat()
      val ve = buffer.decodeFloat()
      val vd = buffer.decodeFloat()
      val speedAccuracy = buffer.decodeFloat()
      val horizAccuracy = buffer.decodeFloat()
      val vertAccuracy = buffer.decodeFloat()
      val ignoreFlags = buffer.decodeBitmaskValue(2).let { value ->
        val flags = GpsInputIgnoreFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val timeWeek = buffer.decodeUInt16()
      val gpsId = buffer.decodeUInt8()
      val fixType = buffer.decodeUInt8()
      val satellitesVisible = buffer.decodeUInt8()
      val yaw = buffer.decodeUInt16()

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
