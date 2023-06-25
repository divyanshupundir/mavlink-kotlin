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
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeInt32(alt)
    buffer.encodeInt32(relativeAlt)
    buffer.encodeInt16(vx)
    buffer.encodeInt16(vy)
    buffer.encodeInt16(vz)
    buffer.encodeUInt16(hdg)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeInt32(alt)
    buffer.encodeInt32(relativeAlt)
    buffer.encodeInt16(vx)
    buffer.encodeInt16(vy)
    buffer.encodeInt16(vz)
    buffer.encodeUInt16(hdg)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GlobalPositionInt> {
    public override val id: UInt = 33u

    public override val crcExtra: Byte = 104

    public override fun deserialize(bytes: ByteArray): GlobalPositionInt {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val lat = buffer.decodeInt32()
      val lon = buffer.decodeInt32()
      val alt = buffer.decodeInt32()
      val relativeAlt = buffer.decodeInt32()
      val vx = buffer.decodeInt16()
      val vy = buffer.decodeInt16()
      val vz = buffer.decodeInt16()
      val hdg = buffer.decodeUInt16()

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
