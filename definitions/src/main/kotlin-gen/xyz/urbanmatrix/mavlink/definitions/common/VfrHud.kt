package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUint16

/**
 * Metrics typically displayed on a HUD for fixed wing aircraft.
 */
@GeneratedMavMessage(
  id = 74,
  crc = 20,
)
public data class VfrHud(
  /**
   * Vehicle speed in form appropriate for vehicle type. For standard aircraft this is typically
   * calibrated airspeed (CAS) or indicated airspeed (IAS) - either of which can be used by a pilot to
   * estimate stall speed.
   */
  public val airspeed: Float = 0F,
  /**
   * Current ground speed.
   */
  public val groundspeed: Float = 0F,
  /**
   * Current heading in compass units (0-360, 0=north).
   */
  public val heading: Int = 0,
  /**
   * Current throttle setting (0 to 100).
   */
  public val throttle: Int = 0,
  /**
   * Current altitude (MSL).
   */
  public val alt: Float = 0F,
  /**
   * Current climb rate.
   */
  public val climb: Float = 0F,
) : MavMessage<VfrHud> {
  public override val instanceMetadata: MavMessage.Metadata<VfrHud> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(airspeed)
    outputBuffer.encodeFloat(groundspeed)
    outputBuffer.encodeFloat(alt)
    outputBuffer.encodeFloat(climb)
    outputBuffer.encodeInt16(heading)
    outputBuffer.encodeUint16(throttle)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 74

    private const val CRC: Int = 20

    private const val SIZE: Int = 20

    private val DESERIALIZER: MavDeserializer<VfrHud> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val airspeed = inputBuffer.decodeFloat()
      val groundspeed = inputBuffer.decodeFloat()
      val alt = inputBuffer.decodeFloat()
      val climb = inputBuffer.decodeFloat()
      val heading = inputBuffer.decodeInt16()
      val throttle = inputBuffer.decodeUint16()

      VfrHud(
        airspeed = airspeed,
        groundspeed = groundspeed,
        heading = heading,
        throttle = throttle,
        alt = alt,
        climb = climb,
      )
    }


    private val METADATA: MavMessage.Metadata<VfrHud> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<VfrHud> = METADATA
  }
}
