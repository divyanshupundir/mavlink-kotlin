package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint16
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Raw ADC output.
 */
public data class ApAdc(
  /**
   * ADC output 1.
   */
  public val adc1: Int = 0,
  /**
   * ADC output 2.
   */
  public val adc2: Int = 0,
  /**
   * ADC output 3.
   */
  public val adc3: Int = 0,
  /**
   * ADC output 4.
   */
  public val adc4: Int = 0,
  /**
   * ADC output 5.
   */
  public val adc5: Int = 0,
  /**
   * ADC output 6.
   */
  public val adc6: Int = 0,
) : MavMessage<ApAdc> {
  public override val instanceMetadata: MavMessage.Metadata<ApAdc> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(12).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(adc1)
    outputBuffer.encodeUint16(adc2)
    outputBuffer.encodeUint16(adc3)
    outputBuffer.encodeUint16(adc4)
    outputBuffer.encodeUint16(adc5)
    outputBuffer.encodeUint16(adc6)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 153

    private const val CRC: Int = 188

    private val DESERIALIZER: MavDeserializer<ApAdc> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val adc1 = inputBuffer.decodeUint16()
      val adc2 = inputBuffer.decodeUint16()
      val adc3 = inputBuffer.decodeUint16()
      val adc4 = inputBuffer.decodeUint16()
      val adc5 = inputBuffer.decodeUint16()
      val adc6 = inputBuffer.decodeUint16()
      ApAdc(
        adc1 = adc1,
        adc2 = adc2,
        adc3 = adc3,
        adc4 = adc4,
        adc5 = adc5,
        adc6 = adc6,
      )
    }


    private val METADATA: MavMessage.Metadata<ApAdc> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ApAdc> = METADATA
  }
}
