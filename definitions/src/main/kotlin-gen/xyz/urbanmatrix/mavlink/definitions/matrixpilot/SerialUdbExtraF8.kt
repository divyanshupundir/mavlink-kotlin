package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF8> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(sueHeightTargetMax)
    outputBuffer.encodeFloat(sueHeightTargetMin)
    outputBuffer.encodeFloat(sueAltHoldThrottleMin)
    outputBuffer.encodeFloat(sueAltHoldThrottleMax)
    outputBuffer.encodeFloat(sueAltHoldPitchMin)
    outputBuffer.encodeFloat(sueAltHoldPitchMax)
    outputBuffer.encodeFloat(sueAltHoldPitchHigh)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(sueHeightTargetMax)
    outputBuffer.encodeFloat(sueHeightTargetMin)
    outputBuffer.encodeFloat(sueAltHoldThrottleMin)
    outputBuffer.encodeFloat(sueAltHoldThrottleMax)
    outputBuffer.encodeFloat(sueAltHoldPitchMin)
    outputBuffer.encodeFloat(sueAltHoldPitchMax)
    outputBuffer.encodeFloat(sueAltHoldPitchHigh)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 176u

    private const val CRC_EXTRA: Byte = -114

    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF8> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueHeightTargetMax = inputBuffer.decodeFloat()
      val sueHeightTargetMin = inputBuffer.decodeFloat()
      val sueAltHoldThrottleMin = inputBuffer.decodeFloat()
      val sueAltHoldThrottleMax = inputBuffer.decodeFloat()
      val sueAltHoldPitchMin = inputBuffer.decodeFloat()
      val sueAltHoldPitchMax = inputBuffer.decodeFloat()
      val sueAltHoldPitchHigh = inputBuffer.decodeFloat()

      SerialUdbExtraF8(
        sueHeightTargetMax = sueHeightTargetMax,
        sueHeightTargetMin = sueHeightTargetMin,
        sueAltHoldThrottleMin = sueAltHoldThrottleMin,
        sueAltHoldThrottleMax = sueAltHoldThrottleMax,
        sueAltHoldPitchMin = sueAltHoldPitchMin,
        sueAltHoldPitchMax = sueAltHoldPitchMax,
        sueAltHoldPitchHigh = sueAltHoldPitchHigh,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF8> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF8> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SerialUdbExtraF8 =
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
