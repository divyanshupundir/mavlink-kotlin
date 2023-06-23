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
 * Backwards compatible version of SERIAL_UDB_EXTRA F8: format
 */
@GeneratedMavMessage(
  id = 176u,
  crcExtra = -114,
)
public data class SerialUdbExtraF8(
  /**
   * Serial UDB Extra HEIGHT_TARGET_MAX
   */
  @GeneratedMavField(type = "float")
  public val sueHeightTargetMax: Float = 0F,
  /**
   * Serial UDB Extra HEIGHT_TARGET_MIN
   */
  @GeneratedMavField(type = "float")
  public val sueHeightTargetMin: Float = 0F,
  /**
   * Serial UDB Extra ALT_HOLD_THROTTLE_MIN
   */
  @GeneratedMavField(type = "float")
  public val sueAltHoldThrottleMin: Float = 0F,
  /**
   * Serial UDB Extra ALT_HOLD_THROTTLE_MAX
   */
  @GeneratedMavField(type = "float")
  public val sueAltHoldThrottleMax: Float = 0F,
  /**
   * Serial UDB Extra ALT_HOLD_PITCH_MIN
   */
  @GeneratedMavField(type = "float")
  public val sueAltHoldPitchMin: Float = 0F,
  /**
   * Serial UDB Extra ALT_HOLD_PITCH_MAX
   */
  @GeneratedMavField(type = "float")
  public val sueAltHoldPitchMax: Float = 0F,
  /**
   * Serial UDB Extra ALT_HOLD_PITCH_HIGH
   */
  @GeneratedMavField(type = "float")
  public val sueAltHoldPitchHigh: Float = 0F,
) : MavMessage<SerialUdbExtraF8> {
  public override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF8> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(sueHeightTargetMax)
    output.encodeFloat(sueHeightTargetMin)
    output.encodeFloat(sueAltHoldThrottleMin)
    output.encodeFloat(sueAltHoldThrottleMax)
    output.encodeFloat(sueAltHoldPitchMin)
    output.encodeFloat(sueAltHoldPitchMax)
    output.encodeFloat(sueAltHoldPitchHigh)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(sueHeightTargetMax)
    output.encodeFloat(sueHeightTargetMin)
    output.encodeFloat(sueAltHoldThrottleMin)
    output.encodeFloat(sueAltHoldThrottleMax)
    output.encodeFloat(sueAltHoldPitchMin)
    output.encodeFloat(sueAltHoldPitchMax)
    output.encodeFloat(sueAltHoldPitchHigh)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF8> {
    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    public override val id: UInt = 176u

    public override val crcExtra: Byte = -114

    public override fun deserialize(source: BufferedSource): SerialUdbExtraF8 {
      val sueHeightTargetMax = source.decodeFloat()
      val sueHeightTargetMin = source.decodeFloat()
      val sueAltHoldThrottleMin = source.decodeFloat()
      val sueAltHoldThrottleMax = source.decodeFloat()
      val sueAltHoldPitchMin = source.decodeFloat()
      val sueAltHoldPitchMax = source.decodeFloat()
      val sueAltHoldPitchHigh = source.decodeFloat()

      return SerialUdbExtraF8(
        sueHeightTargetMax = sueHeightTargetMax,
        sueHeightTargetMin = sueHeightTargetMin,
        sueAltHoldThrottleMin = sueAltHoldThrottleMin,
        sueAltHoldThrottleMax = sueAltHoldThrottleMax,
        sueAltHoldPitchMin = sueAltHoldPitchMin,
        sueAltHoldPitchMax = sueAltHoldPitchMax,
        sueAltHoldPitchHigh = sueAltHoldPitchHigh,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialUdbExtraF8 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueHeightTargetMax: Float = 0F

    public var sueHeightTargetMin: Float = 0F

    public var sueAltHoldThrottleMin: Float = 0F

    public var sueAltHoldThrottleMax: Float = 0F

    public var sueAltHoldPitchMin: Float = 0F

    public var sueAltHoldPitchMax: Float = 0F

    public var sueAltHoldPitchHigh: Float = 0F

    public fun build(): SerialUdbExtraF8 = SerialUdbExtraF8(
      sueHeightTargetMax = sueHeightTargetMax,
      sueHeightTargetMin = sueHeightTargetMin,
      sueAltHoldThrottleMin = sueAltHoldThrottleMin,
      sueAltHoldThrottleMax = sueAltHoldThrottleMax,
      sueAltHoldPitchMin = sueAltHoldPitchMin,
      sueAltHoldPitchMax = sueAltHoldPitchMax,
      sueAltHoldPitchHigh = sueAltHoldPitchHigh,
    )
  }
}
