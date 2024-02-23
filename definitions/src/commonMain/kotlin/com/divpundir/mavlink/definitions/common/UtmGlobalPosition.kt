package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
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
import kotlin.collections.List

/**
 * The global position resulting from GPS and sensor fusion.
 *
 * @param time Time of applicability of position (microseconds since UNIX epoch).
 * units = us
 * @param uasId Unique UAS ID.
 * @param lat Latitude (WGS84)
 * units = degE7
 * @param lon Longitude (WGS84)
 * units = degE7
 * @param alt Altitude (WGS84)
 * units = mm
 * @param relativeAlt Altitude above ground
 * units = mm
 * @param vx Ground X speed (latitude, positive north)
 * units = cm/s
 * @param vy Ground Y speed (longitude, positive east)
 * units = cm/s
 * @param vz Ground Z speed (altitude, positive down)
 * units = cm/s
 * @param hAcc Horizontal position uncertainty (standard deviation)
 * units = mm
 * @param vAcc Altitude uncertainty (standard deviation)
 * units = mm
 * @param velAcc Speed uncertainty (standard deviation)
 * units = cm/s
 * @param nextLat Next waypoint, latitude (WGS84)
 * units = degE7
 * @param nextLon Next waypoint, longitude (WGS84)
 * units = degE7
 * @param nextAlt Next waypoint, altitude (WGS84)
 * units = mm
 * @param updateRate Time until next update. Set to 0 if unknown or in data driven mode.
 * units = cs
 * @param flightState Flight state
 * @param flags Bitwise OR combination of the data available flags.
 */
@GeneratedMavMessage(
  id = 340u,
  crcExtra = 99,
)
public data class UtmGlobalPosition(
  /**
   * Time of applicability of position (microseconds since UNIX epoch).
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val time: ULong = 0uL,
  /**
   * Unique UAS ID.
   */
  @GeneratedMavField(type = "uint8_t[18]")
  public val uasId: List<UByte> = emptyList(),
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
   * Altitude (WGS84)
   * units = mm
   */
  @GeneratedMavField(type = "int32_t")
  public val alt: Int = 0,
  /**
   * Altitude above ground
   * units = mm
   */
  @GeneratedMavField(type = "int32_t")
  public val relativeAlt: Int = 0,
  /**
   * Ground X speed (latitude, positive north)
   * units = cm/s
   */
  @GeneratedMavField(type = "int16_t")
  public val vx: Short = 0,
  /**
   * Ground Y speed (longitude, positive east)
   * units = cm/s
   */
  @GeneratedMavField(type = "int16_t")
  public val vy: Short = 0,
  /**
   * Ground Z speed (altitude, positive down)
   * units = cm/s
   */
  @GeneratedMavField(type = "int16_t")
  public val vz: Short = 0,
  /**
   * Horizontal position uncertainty (standard deviation)
   * units = mm
   */
  @GeneratedMavField(type = "uint16_t")
  public val hAcc: UShort = 0u,
  /**
   * Altitude uncertainty (standard deviation)
   * units = mm
   */
  @GeneratedMavField(type = "uint16_t")
  public val vAcc: UShort = 0u,
  /**
   * Speed uncertainty (standard deviation)
   * units = cm/s
   */
  @GeneratedMavField(type = "uint16_t")
  public val velAcc: UShort = 0u,
  /**
   * Next waypoint, latitude (WGS84)
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val nextLat: Int = 0,
  /**
   * Next waypoint, longitude (WGS84)
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val nextLon: Int = 0,
  /**
   * Next waypoint, altitude (WGS84)
   * units = mm
   */
  @GeneratedMavField(type = "int32_t")
  public val nextAlt: Int = 0,
  /**
   * Time until next update. Set to 0 if unknown or in data driven mode.
   * units = cs
   */
  @GeneratedMavField(type = "uint16_t")
  public val updateRate: UShort = 0u,
  /**
   * Flight state
   */
  @GeneratedMavField(type = "uint8_t")
  public val flightState: MavEnumValue<UtmFlightState> = MavEnumValue.fromValue(0u),
  /**
   * Bitwise OR combination of the data available flags.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavBitmaskValue<UtmDataAvailFlags> = MavBitmaskValue.fromValue(0u),
) : MavMessage<UtmGlobalPosition> {
  override val instanceCompanion: MavMessage.MavCompanion<UtmGlobalPosition> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(time)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeInt32(alt)
    encoder.encodeInt32(relativeAlt)
    encoder.encodeInt32(nextLat)
    encoder.encodeInt32(nextLon)
    encoder.encodeInt32(nextAlt)
    encoder.encodeInt16(vx)
    encoder.encodeInt16(vy)
    encoder.encodeInt16(vz)
    encoder.encodeUInt16(hAcc)
    encoder.encodeUInt16(vAcc)
    encoder.encodeUInt16(velAcc)
    encoder.encodeUInt16(updateRate)
    encoder.encodeUInt8Array(uasId, 18)
    encoder.encodeEnumValue(flightState.value, 1)
    encoder.encodeBitmaskValue(flags.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(time)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeInt32(alt)
    encoder.encodeInt32(relativeAlt)
    encoder.encodeInt32(nextLat)
    encoder.encodeInt32(nextLon)
    encoder.encodeInt32(nextAlt)
    encoder.encodeInt16(vx)
    encoder.encodeInt16(vy)
    encoder.encodeInt16(vz)
    encoder.encodeUInt16(hAcc)
    encoder.encodeUInt16(vAcc)
    encoder.encodeUInt16(velAcc)
    encoder.encodeUInt16(updateRate)
    encoder.encodeUInt8Array(uasId, 18)
    encoder.encodeEnumValue(flightState.value, 1)
    encoder.encodeBitmaskValue(flags.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<UtmGlobalPosition> {
    private const val SIZE_V1: Int = 70

    private const val SIZE_V2: Int = 70

    override val id: UInt = 340u

    override val crcExtra: Byte = 99

    override fun deserialize(bytes: ByteArray): UtmGlobalPosition {
      val decoder = MavDataDecoder(bytes)

      val time = decoder.safeDecodeUInt64()
      val lat = decoder.safeDecodeInt32()
      val lon = decoder.safeDecodeInt32()
      val alt = decoder.safeDecodeInt32()
      val relativeAlt = decoder.safeDecodeInt32()
      val nextLat = decoder.safeDecodeInt32()
      val nextLon = decoder.safeDecodeInt32()
      val nextAlt = decoder.safeDecodeInt32()
      val vx = decoder.safeDecodeInt16()
      val vy = decoder.safeDecodeInt16()
      val vz = decoder.safeDecodeInt16()
      val hAcc = decoder.safeDecodeUInt16()
      val vAcc = decoder.safeDecodeUInt16()
      val velAcc = decoder.safeDecodeUInt16()
      val updateRate = decoder.safeDecodeUInt16()
      val uasId = decoder.safeDecodeUInt8Array(18)
      val flightState = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = UtmFlightState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val flags = decoder.safeDecodeBitmaskValue(1).let { value ->
        val flags = UtmDataAvailFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      return UtmGlobalPosition(
        time = time,
        uasId = uasId,
        lat = lat,
        lon = lon,
        alt = alt,
        relativeAlt = relativeAlt,
        vx = vx,
        vy = vy,
        vz = vz,
        hAcc = hAcc,
        vAcc = vAcc,
        velAcc = velAcc,
        nextLat = nextLat,
        nextLon = nextLon,
        nextAlt = nextAlt,
        updateRate = updateRate,
        flightState = flightState,
        flags = flags,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): UtmGlobalPosition =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var time: ULong = 0uL

    public var uasId: List<UByte> = emptyList()

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Int = 0

    public var relativeAlt: Int = 0

    public var vx: Short = 0

    public var vy: Short = 0

    public var vz: Short = 0

    public var hAcc: UShort = 0u

    public var vAcc: UShort = 0u

    public var velAcc: UShort = 0u

    public var nextLat: Int = 0

    public var nextLon: Int = 0

    public var nextAlt: Int = 0

    public var updateRate: UShort = 0u

    public var flightState: MavEnumValue<UtmFlightState> = MavEnumValue.fromValue(0u)

    public var flags: MavBitmaskValue<UtmDataAvailFlags> = MavBitmaskValue.fromValue(0u)

    public fun build(): UtmGlobalPosition = UtmGlobalPosition(
      time = time,
      uasId = uasId,
      lat = lat,
      lon = lon,
      alt = alt,
      relativeAlt = relativeAlt,
      vx = vx,
      vy = vy,
      vz = vz,
      hAcc = hAcc,
      vAcc = vAcc,
      velAcc = velAcc,
      nextLat = nextLat,
      nextLon = nextLon,
      nextAlt = nextAlt,
      updateRate = updateRate,
      flightState = flightState,
      flags = flags,
    )
  }
}
