package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
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
 * The state of the navigation and position controller.
 */
@GeneratedMavMessage(
  id = 62u,
  crcExtra = -73,
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
  public val navBearing: Short = 0,
  /**
   * Bearing to current waypoint/target
   */
  @GeneratedMavField(type = "int16_t")
  public val targetBearing: Short = 0,
  /**
   * Distance to active waypoint
   */
  @GeneratedMavField(type = "uint16_t")
  public val wpDist: UShort = 0u,
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
    outputBuffer.encodeUInt16(wpDist)
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
    outputBuffer.encodeUInt16(wpDist)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 62u

    private const val CRC_EXTRA: Byte = -73

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
      val wpDist = inputBuffer.decodeUInt16()

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


    private val METADATA: MavMessage.Metadata<NavControllerOutput> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<NavControllerOutput> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): NavControllerOutput =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var navRoll: Float = 0F

    public var navPitch: Float = 0F

    public var navBearing: Short = 0

    public var targetBearing: Short = 0

    public var wpDist: UShort = 0u

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
