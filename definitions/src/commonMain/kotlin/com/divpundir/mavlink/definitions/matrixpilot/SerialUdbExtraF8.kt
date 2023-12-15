package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

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

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(sueHeightTargetMax)
    encoder.encodeFloat(sueHeightTargetMin)
    encoder.encodeFloat(sueAltHoldThrottleMin)
    encoder.encodeFloat(sueAltHoldThrottleMax)
    encoder.encodeFloat(sueAltHoldPitchMin)
    encoder.encodeFloat(sueAltHoldPitchMax)
    encoder.encodeFloat(sueAltHoldPitchHigh)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(sueHeightTargetMax)
    encoder.encodeFloat(sueHeightTargetMin)
    encoder.encodeFloat(sueAltHoldThrottleMin)
    encoder.encodeFloat(sueAltHoldThrottleMax)
    encoder.encodeFloat(sueAltHoldPitchMin)
    encoder.encodeFloat(sueAltHoldPitchMax)
    encoder.encodeFloat(sueAltHoldPitchHigh)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF8> {
    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    public override val id: UInt = 176u

    public override val crcExtra: Byte = -114

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF8 {
      val decoder = MavDataDecoder(bytes)

      val sueHeightTargetMax = decoder.safeDecodeFloat()
      val sueHeightTargetMin = decoder.safeDecodeFloat()
      val sueAltHoldThrottleMin = decoder.safeDecodeFloat()
      val sueAltHoldThrottleMax = decoder.safeDecodeFloat()
      val sueAltHoldPitchMin = decoder.safeDecodeFloat()
      val sueAltHoldPitchMax = decoder.safeDecodeFloat()
      val sueAltHoldPitchHigh = decoder.safeDecodeFloat()

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
