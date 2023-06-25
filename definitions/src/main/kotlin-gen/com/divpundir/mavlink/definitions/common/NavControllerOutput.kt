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
  public override val instanceCompanion: MavMessage.MavCompanion<NavControllerOutput> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(navRoll)
    buffer.encodeFloat(navPitch)
    buffer.encodeFloat(altError)
    buffer.encodeFloat(aspdError)
    buffer.encodeFloat(xtrackError)
    buffer.encodeInt16(navBearing)
    buffer.encodeInt16(targetBearing)
    buffer.encodeUInt16(wpDist)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(navRoll)
    buffer.encodeFloat(navPitch)
    buffer.encodeFloat(altError)
    buffer.encodeFloat(aspdError)
    buffer.encodeFloat(xtrackError)
    buffer.encodeInt16(navBearing)
    buffer.encodeInt16(targetBearing)
    buffer.encodeUInt16(wpDist)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<NavControllerOutput> {
    public override val id: UInt = 62u

    public override val crcExtra: Byte = -73

    public override fun deserialize(bytes: ByteArray): NavControllerOutput {
      val buffer = Buffer().write(bytes)

      val navRoll = buffer.decodeFloat()
      val navPitch = buffer.decodeFloat()
      val altError = buffer.decodeFloat()
      val aspdError = buffer.decodeFloat()
      val xtrackError = buffer.decodeFloat()
      val navBearing = buffer.decodeInt16()
      val targetBearing = buffer.decodeInt16()
      val wpDist = buffer.decodeUInt16()

      return NavControllerOutput(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): NavControllerOutput =
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
