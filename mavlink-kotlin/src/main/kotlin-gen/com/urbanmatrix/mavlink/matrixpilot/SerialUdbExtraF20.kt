package com.urbanmatrix.mavlink.matrixpilot

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F20 format
 */
public data class SerialUdbExtraF20(
  /**
   * SUE UDB PWM Trim Value on Input 1
   */
  public val sueTrimValueInput1: Int = 0,
  /**
   * SUE UDB PWM Trim Value on Input 2
   */
  public val sueTrimValueInput2: Int = 0,
  /**
   * SUE UDB PWM Trim Value on Input 3
   */
  public val sueTrimValueInput3: Int = 0,
  /**
   * SUE UDB PWM Trim Value on Input 4
   */
  public val sueTrimValueInput4: Int = 0,
  /**
   * SUE UDB PWM Trim Value on Input 5
   */
  public val sueTrimValueInput5: Int = 0,
  /**
   * SUE UDB PWM Trim Value on Input 6
   */
  public val sueTrimValueInput6: Int = 0,
  /**
   * SUE UDB PWM Trim Value on Input 7
   */
  public val sueTrimValueInput7: Int = 0,
  /**
   * SUE UDB PWM Trim Value on Input 8
   */
  public val sueTrimValueInput8: Int = 0,
  /**
   * SUE UDB PWM Trim Value on Input 9
   */
  public val sueTrimValueInput9: Int = 0,
  /**
   * SUE UDB PWM Trim Value on Input 10
   */
  public val sueTrimValueInput10: Int = 0,
  /**
   * SUE UDB PWM Trim Value on Input 11
   */
  public val sueTrimValueInput11: Int = 0,
  /**
   * SUE UDB PWM Trim Value on Input 12
   */
  public val sueTrimValueInput12: Int = 0,
  /**
   * SUE Number of Input Channels
   */
  public val sueNumberOfInputs: Int = 0,
) : MavMessage<SerialUdbExtraF20> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF20> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(sueTrimValueInput1)
    outputBuffer.encodeInt16(sueTrimValueInput2)
    outputBuffer.encodeInt16(sueTrimValueInput3)
    outputBuffer.encodeInt16(sueTrimValueInput4)
    outputBuffer.encodeInt16(sueTrimValueInput5)
    outputBuffer.encodeInt16(sueTrimValueInput6)
    outputBuffer.encodeInt16(sueTrimValueInput7)
    outputBuffer.encodeInt16(sueTrimValueInput8)
    outputBuffer.encodeInt16(sueTrimValueInput9)
    outputBuffer.encodeInt16(sueTrimValueInput10)
    outputBuffer.encodeInt16(sueTrimValueInput11)
    outputBuffer.encodeInt16(sueTrimValueInput12)
    outputBuffer.encodeUint8(sueNumberOfInputs)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 186

    private const val CRC: Int = 144

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF20> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueTrimValueInput1 = inputBuffer.decodeInt16()
      val sueTrimValueInput2 = inputBuffer.decodeInt16()
      val sueTrimValueInput3 = inputBuffer.decodeInt16()
      val sueTrimValueInput4 = inputBuffer.decodeInt16()
      val sueTrimValueInput5 = inputBuffer.decodeInt16()
      val sueTrimValueInput6 = inputBuffer.decodeInt16()
      val sueTrimValueInput7 = inputBuffer.decodeInt16()
      val sueTrimValueInput8 = inputBuffer.decodeInt16()
      val sueTrimValueInput9 = inputBuffer.decodeInt16()
      val sueTrimValueInput10 = inputBuffer.decodeInt16()
      val sueTrimValueInput11 = inputBuffer.decodeInt16()
      val sueTrimValueInput12 = inputBuffer.decodeInt16()
      val sueNumberOfInputs = inputBuffer.decodeUint8()
      SerialUdbExtraF20(
        sueTrimValueInput1 = sueTrimValueInput1,
        sueTrimValueInput2 = sueTrimValueInput2,
        sueTrimValueInput3 = sueTrimValueInput3,
        sueTrimValueInput4 = sueTrimValueInput4,
        sueTrimValueInput5 = sueTrimValueInput5,
        sueTrimValueInput6 = sueTrimValueInput6,
        sueTrimValueInput7 = sueTrimValueInput7,
        sueTrimValueInput8 = sueTrimValueInput8,
        sueTrimValueInput9 = sueTrimValueInput9,
        sueTrimValueInput10 = sueTrimValueInput10,
        sueTrimValueInput11 = sueTrimValueInput11,
        sueTrimValueInput12 = sueTrimValueInput12,
        sueNumberOfInputs = sueNumberOfInputs,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF20> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF20> = METADATA
  }
}
