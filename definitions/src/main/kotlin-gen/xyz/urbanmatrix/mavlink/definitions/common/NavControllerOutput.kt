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
 * The state of the navigation and position controller.
 */
@GeneratedMavMessage(
  id = 62,
  crc = 183,
)
public data class NavControllerOutput(
  /**
   * Current desired roll
   */
  public val navRoll: Float = 0F,
  /**
   * Current desired pitch
   */
  public val navPitch: Float = 0F,
  /**
   * Current desired heading
   */
  public val navBearing: Int = 0,
  /**
   * Bearing to current waypoint/target
   */
  public val targetBearing: Int = 0,
  /**
   * Distance to active waypoint
   */
  public val wpDist: Int = 0,
  /**
   * Current altitude error
   */
  public val altError: Float = 0F,
  /**
   * Current airspeed error
   */
  public val aspdError: Float = 0F,
  /**
   * Current crosstrack error on x-y plane
   */
  public val xtrackError: Float = 0F,
) : MavMessage<NavControllerOutput> {
  public override val instanceMetadata: MavMessage.Metadata<NavControllerOutput> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(navRoll)
    outputBuffer.encodeFloat(navPitch)
    outputBuffer.encodeFloat(altError)
    outputBuffer.encodeFloat(aspdError)
    outputBuffer.encodeFloat(xtrackError)
    outputBuffer.encodeInt16(navBearing)
    outputBuffer.encodeInt16(targetBearing)
    outputBuffer.encodeUint16(wpDist)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 62

    private const val CRC: Int = 183

    private const val SIZE: Int = 26

    private val DESERIALIZER: MavDeserializer<NavControllerOutput> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val navRoll = inputBuffer.decodeFloat()
      val navPitch = inputBuffer.decodeFloat()
      val altError = inputBuffer.decodeFloat()
      val aspdError = inputBuffer.decodeFloat()
      val xtrackError = inputBuffer.decodeFloat()
      val navBearing = inputBuffer.decodeInt16()
      val targetBearing = inputBuffer.decodeInt16()
      val wpDist = inputBuffer.decodeUint16()

      NavControllerOutput(
        navRoll = navRoll,
        navPitch = navPitch,
        navBearing = navBearing,
        targetBearing = targetBearing,
        wpDist = wpDist,
        altError = altError,
        aspdError = aspdError,
        xtrackError = xtrackError,
      )
    }


    private val METADATA: MavMessage.Metadata<NavControllerOutput> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<NavControllerOutput> = METADATA
  }
}
