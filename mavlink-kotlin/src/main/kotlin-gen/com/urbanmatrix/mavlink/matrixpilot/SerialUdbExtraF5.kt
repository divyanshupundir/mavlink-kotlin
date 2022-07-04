package com.urbanmatrix.mavlink.matrixpilot

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
 * Backwards compatible version of SERIAL_UDB_EXTRA F5: format
 */
public data class SerialUdbExtraF5(
  /**
   * Serial UDB YAWKP_AILERON Gain for Proporional control of navigation
   */
  public val sueYawkpAileron: Float = 0F,
  /**
   * Serial UDB YAWKD_AILERON Gain for Rate control of navigation
   */
  public val sueYawkdAileron: Float = 0F,
  /**
   * Serial UDB Extra ROLLKP Gain for Proportional control of roll stabilization
   */
  public val sueRollkp: Float = 0F,
  /**
   * Serial UDB Extra ROLLKD Gain for Rate control of roll stabilization
   */
  public val sueRollkd: Float = 0F,
) : MavMessage<SerialUdbExtraF5> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF5> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(sueYawkpAileron)
    outputBuffer.encodeFloat(sueYawkdAileron)
    outputBuffer.encodeFloat(sueRollkp)
    outputBuffer.encodeFloat(sueRollkd)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 173

    private const val CRC: Int = 54

    private const val SIZE: Int = 16

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF5> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for SerialUdbExtraF5: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueYawkpAileron = inputBuffer.decodeFloat()
      val sueYawkdAileron = inputBuffer.decodeFloat()
      val sueRollkp = inputBuffer.decodeFloat()
      val sueRollkd = inputBuffer.decodeFloat()

      SerialUdbExtraF5(
        sueYawkpAileron = sueYawkpAileron,
        sueYawkdAileron = sueYawkdAileron,
        sueRollkp = sueRollkp,
        sueRollkd = sueRollkd,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF5> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF5> = METADATA
  }
}
