package com.divpundir.mavlink.definitions.avssuas

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 *  Drone position.
 *
 * @param timeBootMs Timestamp (time since FC boot).
 * units = ms
 * @param lat Latitude, expressed
 * units = degE7
 * @param lon Longitude, expressed
 * units = degE7
 * @param alt Altitude (MSL). Note that virtually all GPS modules provide both WGS84 and MSL.
 * units = mm
 * @param groundAlt Altitude above ground, This altitude is measured by a ultrasound, Laser
 * rangefinder or millimeter-wave radar
 * units = m
 * @param barometerAlt This altitude is measured by a barometer
 * units = m
 */
@GeneratedMavMessage(
  id = 60_051u,
  crcExtra = -11,
)
public data class AvssDronePosition(
  /**
   * Timestamp (time since FC boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Latitude, expressed
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude, expressed
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude (MSL). Note that virtually all GPS modules provide both WGS84 and MSL.
   * units = mm
   */
  @GeneratedMavField(type = "int32_t")
  public val alt: Int = 0,
  /**
   * Altitude above ground, This altitude is measured by a ultrasound, Laser rangefinder or
   * millimeter-wave radar
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val groundAlt: Float = 0F,
  /**
   * This altitude is measured by a barometer
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val barometerAlt: Float = 0F,
) : MavMessage<AvssDronePosition> {
  override val instanceCompanion: MavMessage.MavCompanion<AvssDronePosition> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeInt32(alt)
    encoder.encodeFloat(groundAlt)
    encoder.encodeFloat(barometerAlt)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeInt32(alt)
    encoder.encodeFloat(groundAlt)
    encoder.encodeFloat(barometerAlt)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AvssDronePosition> {
    private const val SIZE_V1: Int = 24

    private const val SIZE_V2: Int = 24

    override val id: UInt = 60_051u

    override val crcExtra: Byte = -11

    override fun deserialize(bytes: ByteArray): AvssDronePosition {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val lat = decoder.safeDecodeInt32()
      val lon = decoder.safeDecodeInt32()
      val alt = decoder.safeDecodeInt32()
      val groundAlt = decoder.safeDecodeFloat()
      val barometerAlt = decoder.safeDecodeFloat()

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
