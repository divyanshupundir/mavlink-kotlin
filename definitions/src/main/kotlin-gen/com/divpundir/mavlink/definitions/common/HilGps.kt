package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
 *                  NOT the global position estimate of the sytem, but rather a RAW sensor value.
 * See message GLOBAL_POSITION_INT for the global position estimate.
 */
@GeneratedMavMessage(
  id = 113u,
  crcExtra = 124,
)
public data class HilGps(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
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
   * GPS velocity in north direction in earth-fixed NED frame
   */
  @GeneratedMavField(type = "int16_t")
  public val vn: Short = 0,
  /**
   * GPS velocity in east direction in earth-fixed NED frame
   */
  @GeneratedMavField(type = "int16_t")
  public val ve: Short = 0,
  /**
   * GPS velocity in down direction in earth-fixed NED frame
   */
  @GeneratedMavField(type = "int16_t")
  public val vd: Short = 0,
  /**
   * Course over ground (NOT heading, but direction of movement), 0.0..359.99 degrees. If unknown,
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
   * GPS ID (zero indexed). Used for multiple GPS inputs
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val id: UByte = 0u,
  /**
   * Yaw of vehicle relative to Earth's North, zero means not available, use 36000 for north
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val yaw: UShort = 0u,
) : MavMessage<HilGps> {
  public override val instanceMetadata: MavMessage.Metadata<HilGps> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeUInt16(eph)
    outputBuffer.encodeUInt16(epv)
    outputBuffer.encodeUInt16(vel)
    outputBuffer.encodeInt16(vn)
    outputBuffer.encodeInt16(ve)
    outputBuffer.encodeInt16(vd)
    outputBuffer.encodeUInt16(cog)
    outputBuffer.encodeUInt8(fixType)
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
    outputBuffer.encodeInt16(vn)
    outputBuffer.encodeInt16(ve)
    outputBuffer.encodeInt16(vd)
    outputBuffer.encodeUInt16(cog)
    outputBuffer.encodeUInt8(fixType)
    outputBuffer.encodeUInt8(satellitesVisible)
    outputBuffer.encodeUInt8(id)
    outputBuffer.encodeUInt16(yaw)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 113u

    private const val CRC_EXTRA: Byte = 124

    private const val SIZE_V1: Int = 36

    private const val SIZE_V2: Int = 39

    private val DESERIALIZER: MavDeserializer<HilGps> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeInt32()
      val eph = inputBuffer.decodeUInt16()
      val epv = inputBuffer.decodeUInt16()
      val vel = inputBuffer.decodeUInt16()
      val vn = inputBuffer.decodeInt16()
      val ve = inputBuffer.decodeInt16()
      val vd = inputBuffer.decodeInt16()
      val cog = inputBuffer.decodeUInt16()
      val fixType = inputBuffer.decodeUInt8()
      val satellitesVisible = inputBuffer.decodeUInt8()
      val id = inputBuffer.decodeUInt8()
      val yaw = inputBuffer.decodeUInt16()

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


    private val METADATA: MavMessage.Metadata<HilGps> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HilGps> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): HilGps =
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
