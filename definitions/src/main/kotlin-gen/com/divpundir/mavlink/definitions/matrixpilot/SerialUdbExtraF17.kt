package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F17 format
 */
@GeneratedMavMessage(
  id = 183u,
  crcExtra = -81,
)
public data class SerialUdbExtraF17(
  /**
   * SUE Feed Forward Gain
   */
  @GeneratedMavField(type = "float")
  public val sueFeedForward: Float = 0F,
  /**
   * SUE Max Turn Rate when Navigating
   */
  @GeneratedMavField(type = "float")
  public val sueTurnRateNav: Float = 0F,
  /**
   * SUE Max Turn Rate in Fly By Wire Mode
   */
  @GeneratedMavField(type = "float")
  public val sueTurnRateFbw: Float = 0F,
) : MavMessage<SerialUdbExtraF17> {
  public override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF17> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(sueFeedForward)
    buffer.encodeFloat(sueTurnRateNav)
    buffer.encodeFloat(sueTurnRateFbw)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(sueFeedForward)
    buffer.encodeFloat(sueTurnRateNav)
    buffer.encodeFloat(sueTurnRateFbw)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF17> {
    public override val id: UInt = 183u

    public override val crcExtra: Byte = -81

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF17 {
      val buffer = Buffer().write(bytes)

      val sueFeedForward = buffer.decodeFloat()
      val sueTurnRateNav = buffer.decodeFloat()
      val sueTurnRateFbw = buffer.decodeFloat()

      return SerialUdbExtraF17(
        sueFeedForward = sueFeedForward,
        sueTurnRateNav = sueTurnRateNav,
        sueTurnRateFbw = sueTurnRateFbw,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialUdbExtraF17 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueFeedForward: Float = 0F

    public var sueTurnRateNav: Float = 0F

    public var sueTurnRateFbw: Float = 0F

    public fun build(): SerialUdbExtraF17 = SerialUdbExtraF17(
      sueFeedForward = sueFeedForward,
      sueTurnRateNav = sueTurnRateNav,
      sueTurnRateFbw = sueTurnRateFbw,
    )
  }
}
