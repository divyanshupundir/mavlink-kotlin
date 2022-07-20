package com.urbanmatrix.mavlink.definitions.matrixpilot

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
 * Backwards compatible version of SERIAL_UDB_EXTRA F17 format
 */
public data class SerialUdbExtraF17(
  /**
   * SUE Feed Forward Gain
   */
  public val sueFeedForward: Float = 0F,
  /**
   * SUE Max Turn Rate when Navigating
   */
  public val sueTurnRateNav: Float = 0F,
  /**
   * SUE Max Turn Rate in Fly By Wire Mode
   */
  public val sueTurnRateFbw: Float = 0F,
) : MavMessage<SerialUdbExtraF17> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF17> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(sueFeedForward)
    outputBuffer.encodeFloat(sueTurnRateNav)
    outputBuffer.encodeFloat(sueTurnRateFbw)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 183

    private const val CRC: Int = 175

    private const val SIZE: Int = 12

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF17> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueFeedForward = inputBuffer.decodeFloat()
      val sueTurnRateNav = inputBuffer.decodeFloat()
      val sueTurnRateFbw = inputBuffer.decodeFloat()

      SerialUdbExtraF17(
        sueFeedForward = sueFeedForward,
        sueTurnRateNav = sueTurnRateNav,
        sueTurnRateFbw = sueTurnRateFbw,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF17> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF17> = METADATA
  }
}
