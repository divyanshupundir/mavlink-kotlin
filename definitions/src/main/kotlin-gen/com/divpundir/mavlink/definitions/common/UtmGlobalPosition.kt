package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * The global position resulting from GPS and sensor fusion.
 */
@GeneratedMavMessage(
  id = 340u,
  crcExtra = 99,
)
public data class UtmGlobalPosition(
  /**
   * Time of applicability of position (microseconds since UNIX epoch).
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
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val alt: Int = 0,
  /**
   * Altitude above ground
   */
  @GeneratedMavField(type = "int32_t")
  public val relativeAlt: Int = 0,
  /**
   * Ground X speed (latitude, positive north)
   */
  @GeneratedMavField(type = "int16_t")
  public val vx: Short = 0,
  /**
   * Ground Y speed (longitude, positive east)
   */
  @GeneratedMavField(type = "int16_t")
  public val vy: Short = 0,
  /**
   * Ground Z speed (altitude, positive down)
   */
  @GeneratedMavField(type = "int16_t")
  public val vz: Short = 0,
  /**
   * Horizontal position uncertainty (standard deviation)
   */
  @GeneratedMavField(type = "uint16_t")
  public val hAcc: UShort = 0u,
  /**
   * Altitude uncertainty (standard deviation)
   */
  @GeneratedMavField(type = "uint16_t")
  public val vAcc: UShort = 0u,
  /**
   * Speed uncertainty (standard deviation)
   */
  @GeneratedMavField(type = "uint16_t")
  public val velAcc: UShort = 0u,
  /**
   * Next waypoint, latitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val nextLat: Int = 0,
  /**
   * Next waypoint, longitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val nextLon: Int = 0,
  /**
   * Next waypoint, altitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val nextAlt: Int = 0,
  /**
   * Time until next update. Set to 0 if unknown or in data driven mode.
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
  public override val instanceCompanion: MavMessage.MavCompanion<UtmGlobalPosition> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(time)
    output.encodeInt32(lat)
    output.encodeInt32(lon)
    output.encodeInt32(alt)
    output.encodeInt32(relativeAlt)
    output.encodeInt32(nextLat)
    output.encodeInt32(nextLon)
    output.encodeInt32(nextAlt)
    output.encodeInt16(vx)
    output.encodeInt16(vy)
    output.encodeInt16(vz)
    output.encodeUInt16(hAcc)
    output.encodeUInt16(vAcc)
    output.encodeUInt16(velAcc)
    output.encodeUInt16(updateRate)
    output.encodeUInt8Array(uasId, 18)
    output.encodeEnumValue(flightState.value, 1)
    output.encodeBitmaskValue(flags.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(time)
    output.encodeInt32(lat)
    output.encodeInt32(lon)
    output.encodeInt32(alt)
    output.encodeInt32(relativeAlt)
    output.encodeInt32(nextLat)
    output.encodeInt32(nextLon)
    output.encodeInt32(nextAlt)
    output.encodeInt16(vx)
    output.encodeInt16(vy)
    output.encodeInt16(vz)
    output.encodeUInt16(hAcc)
    output.encodeUInt16(vAcc)
    output.encodeUInt16(velAcc)
    output.encodeUInt16(updateRate)
    output.encodeUInt8Array(uasId, 18)
    output.encodeEnumValue(flightState.value, 1)
    output.encodeBitmaskValue(flags.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<UtmGlobalPosition> {
    private const val SIZE_V1: Int = 70

    private const val SIZE_V2: Int = 70

    public override val id: UInt = 340u

    public override val crcExtra: Byte = 99

    public override fun deserialize(source: BufferedSource): UtmGlobalPosition {
      val time = source.decodeUInt64()
      val lat = source.decodeInt32()
      val lon = source.decodeInt32()
      val alt = source.decodeInt32()
      val relativeAlt = source.decodeInt32()
      val nextLat = source.decodeInt32()
      val nextLon = source.decodeInt32()
      val nextAlt = source.decodeInt32()
      val vx = source.decodeInt16()
      val vy = source.decodeInt16()
      val vz = source.decodeInt16()
      val hAcc = source.decodeUInt16()
      val vAcc = source.decodeUInt16()
      val velAcc = source.decodeUInt16()
      val updateRate = source.decodeUInt16()
      val uasId = source.decodeUInt8Array(18)
      val flightState = source.decodeEnumValue(1).let { value ->
        val entry = UtmFlightState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val flags = source.decodeBitmaskValue(1).let { value ->
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
