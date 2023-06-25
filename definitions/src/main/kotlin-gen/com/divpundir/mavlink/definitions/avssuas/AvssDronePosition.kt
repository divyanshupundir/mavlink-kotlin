package com.divpundir.mavlink.definitions.avssuas

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 *  Drone position.
 */
@GeneratedMavMessage(
  id = 60_051u,
  crcExtra = -11,
)
public data class AvssDronePosition(
  /**
   * Timestamp (time since FC boot).
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
   * Altitude above ground, This altitude is measured by a ultrasound, Laser rangefinder or
   * millimeter-wave radar
   */
  @GeneratedMavField(type = "float")
  public val groundAlt: Float = 0F,
  /**
   * This altitude is measured by a barometer
   */
  @GeneratedMavField(type = "float")
  public val barometerAlt: Float = 0F,
) : MavMessage<AvssDronePosition> {
  public override val instanceCompanion: MavMessage.MavCompanion<AvssDronePosition> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeInt32(alt)
    buffer.encodeFloat(groundAlt)
    buffer.encodeFloat(barometerAlt)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeInt32(alt)
    buffer.encodeFloat(groundAlt)
    buffer.encodeFloat(barometerAlt)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AvssDronePosition> {
    public override val id: UInt = 60_051u

    public override val crcExtra: Byte = -11

    public override fun deserialize(bytes: ByteArray): AvssDronePosition {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val lat = buffer.decodeInt32()
      val lon = buffer.decodeInt32()
      val alt = buffer.decodeInt32()
      val groundAlt = buffer.decodeFloat()
      val barometerAlt = buffer.decodeFloat()

      return AvssDronePosition(
        timeBootMs = timeBootMs,
        lat = lat,
        lon = lon,
        alt = alt,
        groundAlt = groundAlt,
        barometerAlt = barometerAlt,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AvssDronePosition =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Int = 0

    public var groundAlt: Float = 0F

    public var barometerAlt: Float = 0F

    public fun build(): AvssDronePosition = AvssDronePosition(
      timeBootMs = timeBootMs,
      lat = lat,
      lon = lon,
      alt = alt,
      groundAlt = groundAlt,
      barometerAlt = barometerAlt,
    )
  }
}
