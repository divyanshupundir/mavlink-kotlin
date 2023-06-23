package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(sueFeedForward)
    output.encodeFloat(sueTurnRateNav)
    output.encodeFloat(sueTurnRateFbw)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(sueFeedForward)
    output.encodeFloat(sueTurnRateNav)
    output.encodeFloat(sueTurnRateFbw)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF17> {
    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    public override val id: UInt = 183u

    public override val crcExtra: Byte = -81

    public override fun deserialize(source: BufferedSource): SerialUdbExtraF17 {
      val sueFeedForward = source.decodeFloat()
      val sueTurnRateNav = source.decodeFloat()
      val sueTurnRateFbw = source.decodeFloat()

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
