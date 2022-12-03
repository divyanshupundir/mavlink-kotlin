package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  @GeneratedMavField(type = "float")
  public val navRoll: Float = 0F,
  /**
   * Current desired pitch
   */
  @GeneratedMavField(type = "float")
  public val navPitch: Float = 0F,
  /**
   * Current desired heading
   */
  @GeneratedMavField(type = "int16_t")
  public val navBearing: Int = 0,
  /**
   * Bearing to current waypoint/target
   */
  @GeneratedMavField(type = "int16_t")
  public val targetBearing: Int = 0,
  /**
   * Distance to active waypoint
   */
  @GeneratedMavField(type = "uint16_t")
  public val wpDist: Int = 0,
  /**
   * Current altitude error
   */
  @GeneratedMavField(type = "float")
  public val altError: Float = 0F,
  /**
   * Current airspeed error
   */
  @GeneratedMavField(type = "float")
  public val aspdError: Float = 0F,
  /**
   * Current crosstrack error on x-y plane
   */
  @GeneratedMavField(type = "float")
  public val xtrackError: Float = 0F,
) : MavMessage<NavControllerOutput> {
  public override val instanceMetadata: MavMessage.Metadata<NavControllerOutput> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
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

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(navRoll)
    outputBuffer.encodeFloat(navPitch)
    outputBuffer.encodeFloat(altError)
    outputBuffer.encodeFloat(aspdError)
    outputBuffer.encodeFloat(xtrackError)
    outputBuffer.encodeInt16(navBearing)
    outputBuffer.encodeInt16(targetBearing)
    outputBuffer.encodeUint16(wpDist)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 62

    private const val CRC: Int = 183

    private const val SIZE_V1: Int = 26

    private const val SIZE_V2: Int = 26

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

    public fun builder(builderAction: Builder.() -> Unit): NavControllerOutput =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var navRoll: Float = 0F

    public var navPitch: Float = 0F

    public var navBearing: Int = 0

    public var targetBearing: Int = 0

    public var wpDist: Int = 0

    public var altError: Float = 0F

    public var aspdError: Float = 0F

    public var xtrackError: Float = 0F

    public fun build(): NavControllerOutput = NavControllerOutput(
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
}
