package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

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
  public override val instanceMetadata: MavMessage.Metadata<Altitude> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(altitudeMonotonic)
    outputBuffer.encodeFloat(altitudeAmsl)
    outputBuffer.encodeFloat(altitudeLocal)
    outputBuffer.encodeFloat(altitudeRelative)
    outputBuffer.encodeFloat(altitudeTerrain)
    outputBuffer.encodeFloat(bottomClearance)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(altitudeMonotonic)
    outputBuffer.encodeFloat(altitudeAmsl)
    outputBuffer.encodeFloat(altitudeLocal)
    outputBuffer.encodeFloat(altitudeRelative)
    outputBuffer.encodeFloat(altitudeTerrain)
    outputBuffer.encodeFloat(bottomClearance)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 141u

    private const val CRC_EXTRA: Byte = 47

    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 32

    private val DESERIALIZER: MavDeserializer<Altitude> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val altitudeMonotonic = inputBuffer.decodeFloat()
      val altitudeAmsl = inputBuffer.decodeFloat()
      val altitudeLocal = inputBuffer.decodeFloat()
      val altitudeRelative = inputBuffer.decodeFloat()
      val altitudeTerrain = inputBuffer.decodeFloat()
      val bottomClearance = inputBuffer.decodeFloat()

      Altitude(
        timeUsec = timeUsec,
        altitudeMonotonic = altitudeMonotonic,
        altitudeAmsl = altitudeAmsl,
        altitudeLocal = altitudeLocal,
        altitudeRelative = altitudeRelative,
        altitudeTerrain = altitudeTerrain,
        bottomClearance = bottomClearance,
      )
    }


    private val METADATA: MavMessage.Metadata<Altitude> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Altitude> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Altitude =
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
