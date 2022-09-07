package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint64

/**
 * The current system altitude.
 */
@GeneratedMavMessage(
  id = 141,
  crc = 47,
)
public data class Altitude(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * This altitude measure is initialized on system boot and monotonic (it is never reset, but
   * represents the local altitude change). The only guarantee on this field is that it will never be
   * reset and is consistent within a flight. The recommended value for this field is the uncorrected
   * barometric altitude at boot time. This altitude will also drift and vary between flights.
   */
  public val altitudeMonotonic: Float = 0F,
  /**
   * This altitude measure is strictly above mean sea level and might be non-monotonic (it might
   * reset on events like GPS lock or when a new QNH value is set). It should be the altitude to which
   * global altitude waypoints are compared to. Note that it is *not* the GPS altitude, however, most
   * GPS modules already output MSL by default and not the WGS84 altitude.
   */
  public val altitudeAmsl: Float = 0F,
  /**
   * This is the local altitude in the local coordinate frame. It is not the altitude above home,
   * but in reference to the coordinate origin (0, 0, 0). It is up-positive.
   */
  public val altitudeLocal: Float = 0F,
  /**
   * This is the altitude above the home position. It resets on each change of the current home
   * position.
   */
  public val altitudeRelative: Float = 0F,
  /**
   * This is the altitude above terrain. It might be fed by a terrain database or an altimeter.
   * Values smaller than -1000 should be interpreted as unknown.
   */
  public val altitudeTerrain: Float = 0F,
  /**
   * This is not the altitude, but the clear space below the system according to the fused clearance
   * estimate. It generally should max out at the maximum range of e.g. the laser altimeter. It is
   * generally a moving target. A negative value indicates no measurement available.
   */
  public val bottomClearance: Float = 0F,
) : MavMessage<Altitude> {
  public override val instanceMetadata: MavMessage.Metadata<Altitude> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloat(altitudeMonotonic)
    outputBuffer.encodeFloat(altitudeAmsl)
    outputBuffer.encodeFloat(altitudeLocal)
    outputBuffer.encodeFloat(altitudeRelative)
    outputBuffer.encodeFloat(altitudeTerrain)
    outputBuffer.encodeFloat(bottomClearance)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 141

    private const val CRC: Int = 47

    private const val SIZE: Int = 32

    private val DESERIALIZER: MavDeserializer<Altitude> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
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


    private val METADATA: MavMessage.Metadata<Altitude> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Altitude> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: BigInteger = BigInteger.ZERO

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
