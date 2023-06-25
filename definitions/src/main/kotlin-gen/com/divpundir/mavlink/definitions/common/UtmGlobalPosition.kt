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
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(time)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeInt32(alt)
    buffer.encodeInt32(relativeAlt)
    buffer.encodeInt32(nextLat)
    buffer.encodeInt32(nextLon)
    buffer.encodeInt32(nextAlt)
    buffer.encodeInt16(vx)
    buffer.encodeInt16(vy)
    buffer.encodeInt16(vz)
    buffer.encodeUInt16(hAcc)
    buffer.encodeUInt16(vAcc)
    buffer.encodeUInt16(velAcc)
    buffer.encodeUInt16(updateRate)
    buffer.encodeUInt8Array(uasId, 18)
    buffer.encodeEnumValue(flightState.value, 1)
    buffer.encodeBitmaskValue(flags.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(time)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeInt32(alt)
    buffer.encodeInt32(relativeAlt)
    buffer.encodeInt32(nextLat)
    buffer.encodeInt32(nextLon)
    buffer.encodeInt32(nextAlt)
    buffer.encodeInt16(vx)
    buffer.encodeInt16(vy)
    buffer.encodeInt16(vz)
    buffer.encodeUInt16(hAcc)
    buffer.encodeUInt16(vAcc)
    buffer.encodeUInt16(velAcc)
    buffer.encodeUInt16(updateRate)
    buffer.encodeUInt8Array(uasId, 18)
    buffer.encodeEnumValue(flightState.value, 1)
    buffer.encodeBitmaskValue(flags.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<UtmGlobalPosition> {
    public override val id: UInt = 340u

    public override val crcExtra: Byte = 99

    public override fun deserialize(bytes: ByteArray): UtmGlobalPosition {
      val buffer = Buffer().write(bytes)

      val time = buffer.decodeUInt64()
      val lat = buffer.decodeInt32()
      val lon = buffer.decodeInt32()
      val alt = buffer.decodeInt32()
      val relativeAlt = buffer.decodeInt32()
      val nextLat = buffer.decodeInt32()
      val nextLon = buffer.decodeInt32()
      val nextAlt = buffer.decodeInt32()
      val vx = buffer.decodeInt16()
      val vy = buffer.decodeInt16()
      val vz = buffer.decodeInt16()
      val hAcc = buffer.decodeUInt16()
      val vAcc = buffer.decodeUInt16()
      val velAcc = buffer.decodeUInt16()
      val updateRate = buffer.decodeUInt16()
      val uasId = buffer.decodeUInt8Array(18)
      val flightState = buffer.decodeEnumValue(1).let { value ->
        val entry = UtmFlightState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val flags = buffer.decodeBitmaskValue(1).let { value ->
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
