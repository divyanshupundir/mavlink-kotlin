package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * The filtered global position (e.g. fused GPS and accelerometers). The position is in GPS-frame
 * (right-handed, Z-up). It
 *                is designed as scaled integer message since the resolution of float is not
 * sufficient.
 */
@GeneratedMavMessage(
  id = 33u,
  crcExtra = 104,
)
public data class GlobalPositionInt(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Latitude, expressed
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude, expressed
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude (MSL). Note that virtually all GPS modules provide both WGS84 and MSL.
   */
  @GeneratedMavField(type = "int32_t")
  public val alt: Int = 0,
  /**
   * Altitude above ground
   */
  @GeneratedMavField(type = "int32_t")
  public val relativeAlt: Int = 0,
  /**
   * Ground X Speed (Latitude, positive north)
   */
  @GeneratedMavField(type = "int16_t")
  public val vx: Short = 0,
  /**
   * Ground Y Speed (Longitude, positive east)
   */
  @GeneratedMavField(type = "int16_t")
  public val vy: Short = 0,
  /**
   * Ground Z Speed (Altitude, positive down)
   */
  @GeneratedMavField(type = "int16_t")
  public val vz: Short = 0,
  /**
   * Vehicle heading (yaw angle), 0.0..359.99 degrees. If unknown, set to: UINT16_MAX
   */
  @GeneratedMavField(type = "uint16_t")
  public val hdg: UShort = 0u,
) : MavMessage<GlobalPositionInt> {
  public override val instanceCompanion: MavMessage.MavCompanion<GlobalPositionInt> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeInt32(lat)
    output.encodeInt32(lon)
    output.encodeInt32(alt)
    output.encodeInt32(relativeAlt)
    output.encodeInt16(vx)
    output.encodeInt16(vy)
    output.encodeInt16(vz)
    output.encodeUInt16(hdg)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeInt32(lat)
    output.encodeInt32(lon)
    output.encodeInt32(alt)
    output.encodeInt32(relativeAlt)
    output.encodeInt16(vx)
    output.encodeInt16(vy)
    output.encodeInt16(vz)
    output.encodeUInt16(hdg)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<GlobalPositionInt> {
    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    public override val id: UInt = 33u

    public override val crcExtra: Byte = 104

    public override fun deserialize(source: BufferedSource): GlobalPositionInt {
      val timeBootMs = source.decodeUInt32()
      val lat = source.decodeInt32()
      val lon = source.decodeInt32()
      val alt = source.decodeInt32()
      val relativeAlt = source.decodeInt32()
      val vx = source.decodeInt16()
      val vy = source.decodeInt16()
      val vz = source.decodeInt16()
      val hdg = source.decodeUInt16()

      return GlobalPositionInt(
        timeBootMs = timeBootMs,
        lat = lat,
        lon = lon,
        alt = alt,
        relativeAlt = relativeAlt,
        vx = vx,
        vy = vy,
        vz = vz,
        hdg = hdg,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GlobalPositionInt =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Int = 0

    public var relativeAlt: Int = 0

    public var vx: Short = 0

    public var vy: Short = 0

    public var vz: Short = 0

    public var hdg: UShort = 0u

    public fun build(): GlobalPositionInt = GlobalPositionInt(
      timeBootMs = timeBootMs,
      lat = lat,
      lon = lon,
      alt = alt,
      relativeAlt = relativeAlt,
      vx = vx,
      vy = vy,
      vz = vz,
      hdg = hdg,
    )
  }
}
