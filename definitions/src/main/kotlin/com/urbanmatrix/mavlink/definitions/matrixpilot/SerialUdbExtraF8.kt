package com.urbanmatrix.mavlink.definitions.matrixpilot

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.encodeFloat
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F8: format
 */
public data class SerialUdbExtraF8(
  /**
   * Serial UDB Extra HEIGHT_TARGET_MAX
   */
  public val sueHeightTargetMax: Float = 0F,
  /**
   * Serial UDB Extra HEIGHT_TARGET_MIN
   */
  public val sueHeightTargetMin: Float = 0F,
  /**
   * Serial UDB Extra ALT_HOLD_THROTTLE_MIN
   */
  public val sueAltHoldThrottleMin: Float = 0F,
  /**
   * Serial UDB Extra ALT_HOLD_THROTTLE_MAX
   */
  public val sueAltHoldThrottleMax: Float = 0F,
  /**
   * Serial UDB Extra ALT_HOLD_PITCH_MIN
   */
  public val sueAltHoldPitchMin: Float = 0F,
  /**
   * Serial UDB Extra ALT_HOLD_PITCH_MAX
   */
  public val sueAltHoldPitchMax: Float = 0F,
  /**
   * Serial UDB Extra ALT_HOLD_PITCH_HIGH
   */
  public val sueAltHoldPitchHigh: Float = 0F,
) : MavMessage<SerialUdbExtraF8> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF8> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(sueHeightTargetMax)
    outputBuffer.encodeFloat(sueHeightTargetMin)
    outputBuffer.encodeFloat(sueAltHoldThrottleMin)
    outputBuffer.encodeFloat(sueAltHoldThrottleMax)
    outputBuffer.encodeFloat(sueAltHoldPitchMin)
    outputBuffer.encodeFloat(sueAltHoldPitchMax)
    outputBuffer.encodeFloat(sueAltHoldPitchHigh)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 176

    private const val CRC: Int = 142

    private const val SIZE: Int = 28

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF8> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for SerialUdbExtraF8: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

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


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF8> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF8> = METADATA
  }
}
