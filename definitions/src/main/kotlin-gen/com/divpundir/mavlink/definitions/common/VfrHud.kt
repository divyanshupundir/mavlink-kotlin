package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Short
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Metrics typically displayed on a HUD for fixed wing aircraft.
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
   */
  @GeneratedMavField(type = "float")
  public val airspeed: Float = 0F,
  /**
   * Current ground speed.
   */
  @GeneratedMavField(type = "float")
  public val groundspeed: Float = 0F,
  /**
   * Current heading in compass units (0-360, 0=north).
   */
  @GeneratedMavField(type = "int16_t")
  public val heading: Short = 0,
  /**
   * Current throttle setting (0 to 100).
   */
  @GeneratedMavField(type = "uint16_t")
  public val throttle: UShort = 0u,
  /**
   * Current altitude (MSL).
   */
  @GeneratedMavField(type = "float")
  public val alt: Float = 0F,
  /**
   * Current climb rate.
   */
  @GeneratedMavField(type = "float")
  public val climb: Float = 0F,
) : MavMessage<VfrHud> {
  public override val instanceCompanion: MavMessage.MavCompanion<VfrHud> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(airspeed)
    buffer.encodeFloat(groundspeed)
    buffer.encodeFloat(alt)
    buffer.encodeFloat(climb)
    buffer.encodeInt16(heading)
    buffer.encodeUInt16(throttle)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(airspeed)
    buffer.encodeFloat(groundspeed)
    buffer.encodeFloat(alt)
    buffer.encodeFloat(climb)
    buffer.encodeInt16(heading)
    buffer.encodeUInt16(throttle)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<VfrHud> {
    public override val id: UInt = 74u

    public override val crcExtra: Byte = 20

    public override fun deserialize(bytes: ByteArray): VfrHud {
      val buffer = Buffer().write(bytes)

      val airspeed = buffer.decodeFloat()
      val groundspeed = buffer.decodeFloat()
      val alt = buffer.decodeFloat()
      val climb = buffer.decodeFloat()
      val heading = buffer.decodeInt16()
      val throttle = buffer.decodeUInt16()

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
