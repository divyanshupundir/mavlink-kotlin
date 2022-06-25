package com.urbanmatrix.mavlink.matrixpilot

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
 * Backwards compatible version of SERIAL_UDB_EXTRA F6: format
 */
public data class SerialUdbExtraF6(
  /**
   * Serial UDB Extra PITCHGAIN Proportional Control
   */
  public val suePitchgain: Float = 0F,
  /**
   * Serial UDB Extra Pitch Rate Control
   */
  public val suePitchkd: Float = 0F,
  /**
   * Serial UDB Extra Rudder to Elevator Mix
   */
  public val sueRudderElevMix: Float = 0F,
  /**
   * Serial UDB Extra Roll to Elevator Mix
   */
  public val sueRollElevMix: Float = 0F,
  /**
   * Gain For Boosting Manual Elevator control When Plane Stabilized
   */
  public val sueElevatorBoost: Float = 0F,
) : MavMessage<SerialUdbExtraF6> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF6> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(20).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(suePitchgain)
    outputBuffer.encodeFloat(suePitchkd)
    outputBuffer.encodeFloat(sueRudderElevMix)
    outputBuffer.encodeFloat(sueRollElevMix)
    outputBuffer.encodeFloat(sueElevatorBoost)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 174

    private const val CRC: Int = 54

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF6> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val suePitchgain = inputBuffer.decodeFloat()
      val suePitchkd = inputBuffer.decodeFloat()
      val sueRudderElevMix = inputBuffer.decodeFloat()
      val sueRollElevMix = inputBuffer.decodeFloat()
      val sueElevatorBoost = inputBuffer.decodeFloat()
      SerialUdbExtraF6(
        suePitchgain = suePitchgain,
        suePitchkd = suePitchkd,
        sueRudderElevMix = sueRudderElevMix,
        sueRollElevMix = sueRollElevMix,
        sueElevatorBoost = sueElevatorBoost,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF6> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF6> = METADATA
  }
}
