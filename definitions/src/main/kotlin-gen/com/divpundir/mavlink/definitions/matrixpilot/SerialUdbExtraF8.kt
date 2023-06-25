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
    val buffer = Buffer()
    buffer.encodeFloat(sueHeightTargetMax)
    buffer.encodeFloat(sueHeightTargetMin)
    buffer.encodeFloat(sueAltHoldThrottleMin)
    buffer.encodeFloat(sueAltHoldThrottleMax)
    buffer.encodeFloat(sueAltHoldPitchMin)
    buffer.encodeFloat(sueAltHoldPitchMax)
    buffer.encodeFloat(sueAltHoldPitchHigh)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(sueHeightTargetMax)
    buffer.encodeFloat(sueHeightTargetMin)
    buffer.encodeFloat(sueAltHoldThrottleMin)
    buffer.encodeFloat(sueAltHoldThrottleMax)
    buffer.encodeFloat(sueAltHoldPitchMin)
    buffer.encodeFloat(sueAltHoldPitchMax)
    buffer.encodeFloat(sueAltHoldPitchHigh)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF8> {
    public override val id: UInt = 176u

    public override val crcExtra: Byte = -114

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF8 {
      val buffer = Buffer().write(bytes)

      val sueHeightTargetMax = buffer.decodeFloat()
      val sueHeightTargetMin = buffer.decodeFloat()
      val sueAltHoldThrottleMin = buffer.decodeFloat()
      val sueAltHoldThrottleMax = buffer.decodeFloat()
      val sueAltHoldPitchMin = buffer.decodeFloat()
      val sueAltHoldPitchMax = buffer.decodeFloat()
      val sueAltHoldPitchHigh = buffer.decodeFloat()

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
