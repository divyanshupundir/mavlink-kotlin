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
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(airspeed)
    outputBuffer.encodeFloat(groundspeed)
    outputBuffer.encodeFloat(alt)
    outputBuffer.encodeFloat(climb)
    outputBuffer.encodeInt16(heading)
    outputBuffer.encodeUInt16(throttle)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(airspeed)
    outputBuffer.encodeFloat(groundspeed)
    outputBuffer.encodeFloat(alt)
    outputBuffer.encodeFloat(climb)
    outputBuffer.encodeInt16(heading)
    outputBuffer.encodeUInt16(throttle)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<VfrHud> {
    private const val SIZE_V1: Int = 20

    private const val SIZE_V2: Int = 20

    public override val id: UInt = 74u

    public override val crcExtra: Byte = 20

    public override fun deserialize(bytes: ByteArray): VfrHud {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val airspeed = inputBuffer.decodeFloat()
      val groundspeed = inputBuffer.decodeFloat()
      val alt = inputBuffer.decodeFloat()
      val climb = inputBuffer.decodeFloat()
      val heading = inputBuffer.decodeInt16()
      val throttle = inputBuffer.decodeUInt16()

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
