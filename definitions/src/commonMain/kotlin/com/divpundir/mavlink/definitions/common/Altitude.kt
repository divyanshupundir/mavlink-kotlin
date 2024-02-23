package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * The current system altitude.
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param altitudeMonotonic This altitude measure is initialized on system boot and monotonic (it is
 * never reset, but represents the local altitude change). The only guarantee on this field is that it
 * will never be reset and is consistent within a flight. The recommended value for this field is the
 * uncorrected barometric altitude at boot time. This altitude will also drift and vary between
 * flights.
 * units = m
 * @param altitudeAmsl This altitude measure is strictly above mean sea level and might be
 * non-monotonic (it might reset on events like GPS lock or when a new QNH value is set). It should be
 * the altitude to which global altitude waypoints are compared to. Note that it is *not* the GPS
 * altitude, however, most GPS modules already output MSL by default and not the WGS84 altitude.
 * units = m
 * @param altitudeLocal This is the local altitude in the local coordinate frame. It is not the
 * altitude above home, but in reference to the coordinate origin (0, 0, 0). It is up-positive.
 * units = m
 * @param altitudeRelative This is the altitude above the home position. It resets on each change of
 * the current home position.
 * units = m
 * @param altitudeTerrain This is the altitude above terrain. It might be fed by a terrain database
 * or an altimeter. Values smaller than -1000 should be interpreted as unknown.
 * units = m
 * @param bottomClearance This is not the altitude, but the clear space below the system according
 * to the fused clearance estimate. It generally should max out at the maximum range of e.g. the laser
 * altimeter. It is generally a moving target. A negative value indicates no measurement available.
 * units = m
 */
@GeneratedMavMessage(
  id = 141u,
  crcExtra = 47,
)
public data class Altitude(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * This altitude measure is initialized on system boot and monotonic (it is never reset, but
   * represents the local altitude change). The only guarantee on this field is that it will never be
   * reset and is consistent within a flight. The recommended value for this field is the uncorrected
   * barometric altitude at boot time. This altitude will also drift and vary between flights.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val altitudeMonotonic: Float = 0F,
  /**
   * This altitude measure is strictly above mean sea level and might be non-monotonic (it might
   * reset on events like GPS lock or when a new QNH value is set). It should be the altitude to which
   * global altitude waypoints are compared to. Note that it is *not* the GPS altitude, however, most
   * GPS modules already output MSL by default and not the WGS84 altitude.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val altitudeAmsl: Float = 0F,
  /**
   * This is the local altitude in the local coordinate frame. It is not the altitude above home,
   * but in reference to the coordinate origin (0, 0, 0). It is up-positive.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val altitudeLocal: Float = 0F,
  /**
   * This is the altitude above the home position. It resets on each change of the current home
   * position.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val altitudeRelative: Float = 0F,
  /**
   * This is the altitude above terrain. It might be fed by a terrain database or an altimeter.
   * Values smaller than -1000 should be interpreted as unknown.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val altitudeTerrain: Float = 0F,
  /**
   * This is not the altitude, but the clear space below the system according to the fused clearance
   * estimate. It generally should max out at the maximum range of e.g. the laser altimeter. It is
   * generally a moving target. A negative value indicates no measurement available.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val bottomClearance: Float = 0F,
) : MavMessage<Altitude> {
  override val instanceCompanion: MavMessage.MavCompanion<Altitude> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(altitudeMonotonic)
    encoder.encodeFloat(altitudeAmsl)
    encoder.encodeFloat(altitudeLocal)
    encoder.encodeFloat(altitudeRelative)
    encoder.encodeFloat(altitudeTerrain)
    encoder.encodeFloat(bottomClearance)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(altitudeMonotonic)
    encoder.encodeFloat(altitudeAmsl)
    encoder.encodeFloat(altitudeLocal)
    encoder.encodeFloat(altitudeRelative)
    encoder.encodeFloat(altitudeTerrain)
    encoder.encodeFloat(bottomClearance)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Altitude> {
    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 32

    override val id: UInt = 141u

    override val crcExtra: Byte = 47

    override fun deserialize(bytes: ByteArray): Altitude {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val altitudeMonotonic = decoder.safeDecodeFloat()
      val altitudeAmsl = decoder.safeDecodeFloat()
      val altitudeLocal = decoder.safeDecodeFloat()
      val altitudeRelative = decoder.safeDecodeFloat()
      val altitudeTerrain = decoder.safeDecodeFloat()
      val bottomClearance = decoder.safeDecodeFloat()

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
