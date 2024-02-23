package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Metrics typically displayed on a HUD for fixed wing aircraft.
 *
 * @param airspeed Vehicle speed in form appropriate for vehicle type. For standard aircraft this is
 * typically calibrated airspeed (CAS) or indicated airspeed (IAS) - either of which can be used by a
 * pilot to estimate stall speed.
 * units = m/s
 * @param groundspeed Current ground speed.
 * units = m/s
 * @param heading Current heading in compass units (0-360, 0=north).
 * units = deg
 * @param throttle Current throttle setting (0 to 100).
 * units = %
 * @param alt Current altitude (MSL).
 * units = m
 * @param climb Current climb rate.
 * units = m/s
 */
@GeneratedMavMessage(
  id = 74u,
  crcExtra = 20,
)
public data class VfrHud(
  /**
   * Vehicle speed in form appropriate for vehicle type. For standard aircraft this is typically
   * calibrated airspeed (CAS) or indicated airspeed (IAS) - either of which can be used by a pilot to
   * estimate stall speed.
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val airspeed: Float = 0F,
  /**
   * Current ground speed.
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val groundspeed: Float = 0F,
  /**
   * Current heading in compass units (0-360, 0=north).
   * units = deg
   */
  @GeneratedMavField(type = "int16_t")
  public val heading: Short = 0,
  /**
   * Current throttle setting (0 to 100).
   * units = %
   */
  @GeneratedMavField(type = "uint16_t")
  public val throttle: UShort = 0u,
  /**
   * Current altitude (MSL).
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val alt: Float = 0F,
  /**
   * Current climb rate.
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val climb: Float = 0F,
) : MavMessage<VfrHud> {
  override val instanceCompanion: MavMessage.MavCompanion<VfrHud> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(airspeed)
    encoder.encodeFloat(groundspeed)
    encoder.encodeFloat(alt)
    encoder.encodeFloat(climb)
    encoder.encodeInt16(heading)
    encoder.encodeUInt16(throttle)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(airspeed)
    encoder.encodeFloat(groundspeed)
    encoder.encodeFloat(alt)
    encoder.encodeFloat(climb)
    encoder.encodeInt16(heading)
    encoder.encodeUInt16(throttle)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<VfrHud> {
    private const val SIZE_V1: Int = 20

    private const val SIZE_V2: Int = 20

    override val id: UInt = 74u

    override val crcExtra: Byte = 20

    override fun deserialize(bytes: ByteArray): VfrHud {
      val decoder = MavDataDecoder(bytes)

      val airspeed = decoder.safeDecodeFloat()
      val groundspeed = decoder.safeDecodeFloat()
      val alt = decoder.safeDecodeFloat()
      val climb = decoder.safeDecodeFloat()
      val heading = decoder.safeDecodeInt16()
      val throttle = decoder.safeDecodeUInt16()

      return VfrHud(
        airspeed = airspeed,
        groundspeed = groundspeed,
        heading = heading,
        throttle = throttle,
        alt = alt,
        climb = climb,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): VfrHud =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var airspeed: Float = 0F

    public var groundspeed: Float = 0F

    public var heading: Short = 0

    public var throttle: UShort = 0u

    public var alt: Float = 0F

    public var climb: Float = 0F

    public fun build(): VfrHud = VfrHud(
      airspeed = airspeed,
      groundspeed = groundspeed,
      heading = heading,
      throttle = throttle,
      alt = alt,
      climb = climb,
    )
  }
}
