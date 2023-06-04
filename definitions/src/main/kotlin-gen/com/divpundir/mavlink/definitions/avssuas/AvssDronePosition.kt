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
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

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
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeFloat(groundAlt)
    outputBuffer.encodeFloat(barometerAlt)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeFloat(groundAlt)
    outputBuffer.encodeFloat(barometerAlt)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AvssDronePosition> {
    private const val SIZE_V1: Int = 24

    private const val SIZE_V2: Int = 24

    public override val id: UInt = 60_051u

    public override val crcExtra: Byte = -11

    public override fun deserialize(bytes: ByteArray): AvssDronePosition {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeInt32()
      val groundAlt = inputBuffer.decodeFloat()
      val barometerAlt = inputBuffer.decodeFloat()

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
