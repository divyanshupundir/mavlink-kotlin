package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * The current system altitude.
 */
@GeneratedMavMessage(
  id = 141u,
  crcExtra = 47,
)
public data class Altitude(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * This altitude measure is initialized on system boot and monotonic (it is never reset, but
   * represents the local altitude change). The only guarantee on this field is that it will never be
   * reset and is consistent within a flight. The recommended value for this field is the uncorrected
   * barometric altitude at boot time. This altitude will also drift and vary between flights.
   */
  @GeneratedMavField(type = "float")
  public val altitudeMonotonic: Float = 0F,
  /**
   * This altitude measure is strictly above mean sea level and might be non-monotonic (it might
   * reset on events like GPS lock or when a new QNH value is set). It should be the altitude to which
   * global altitude waypoints are compared to. Note that it is *not* the GPS altitude, however, most
   * GPS modules already output MSL by default and not the WGS84 altitude.
   */
  @GeneratedMavField(type = "float")
  public val altitudeAmsl: Float = 0F,
  /**
   * This is the local altitude in the local coordinate frame. It is not the altitude above home,
   * but in reference to the coordinate origin (0, 0, 0). It is up-positive.
   */
  @GeneratedMavField(type = "float")
  public val altitudeLocal: Float = 0F,
  /**
   * This is the altitude above the home position. It resets on each change of the current home
   * position.
   */
  @GeneratedMavField(type = "float")
  public val altitudeRelative: Float = 0F,
  /**
   * This is the altitude above terrain. It might be fed by a terrain database or an altimeter.
   * Values smaller than -1000 should be interpreted as unknown.
   */
  @GeneratedMavField(type = "float")
  public val altitudeTerrain: Float = 0F,
  /**
   * This is not the altitude, but the clear space below the system according to the fused clearance
   * estimate. It generally should max out at the maximum range of e.g. the laser altimeter. It is
   * generally a moving target. A negative value indicates no measurement available.
   */
  @GeneratedMavField(type = "float")
  public val bottomClearance: Float = 0F,
) : MavMessage<Altitude> {
  public override val instanceCompanion: MavMessage.MavCompanion<Altitude> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(altitudeMonotonic)
    output.encodeFloat(altitudeAmsl)
    output.encodeFloat(altitudeLocal)
    output.encodeFloat(altitudeRelative)
    output.encodeFloat(altitudeTerrain)
    output.encodeFloat(bottomClearance)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(altitudeMonotonic)
    output.encodeFloat(altitudeAmsl)
    output.encodeFloat(altitudeLocal)
    output.encodeFloat(altitudeRelative)
    output.encodeFloat(altitudeTerrain)
    output.encodeFloat(bottomClearance)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<Altitude> {
    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 32

    public override val id: UInt = 141u

    public override val crcExtra: Byte = 47

    public override fun deserialize(source: BufferedSource): Altitude {
      val timeUsec = source.decodeUInt64()
      val altitudeMonotonic = source.decodeFloat()
      val altitudeAmsl = source.decodeFloat()
      val altitudeLocal = source.decodeFloat()
      val altitudeRelative = source.decodeFloat()
      val altitudeTerrain = source.decodeFloat()
      val bottomClearance = source.decodeFloat()

      return Altitude(
        timeUsec = timeUsec,
        altitudeMonotonic = altitudeMonotonic,
        altitudeAmsl = altitudeAmsl,
        altitudeLocal = altitudeLocal,
        altitudeRelative = altitudeRelative,
        altitudeTerrain = altitudeTerrain,
        bottomClearance = bottomClearance,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Altitude =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var altitudeMonotonic: Float = 0F

    public var altitudeAmsl: Float = 0F

    public var altitudeLocal: Float = 0F

    public var altitudeRelative: Float = 0F

    public var altitudeTerrain: Float = 0F

    public var bottomClearance: Float = 0F

    public fun build(): Altitude = Altitude(
      timeUsec = timeUsec,
      altitudeMonotonic = altitudeMonotonic,
      altitudeAmsl = altitudeAmsl,
      altitudeLocal = altitudeLocal,
      altitudeRelative = altitudeRelative,
      altitudeTerrain = altitudeTerrain,
      bottomClearance = bottomClearance,
    )
  }
}
