package xyz.urbanmatrix.mavlink.definitions.asluav

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloat

/**
 * Voltage and current sensor data
 */
@GeneratedMavMessage(
  id = 8002,
  crc = 218,
)
public data class SensPower(
  /**
   *  Power board voltage sensor reading
   */
  public val adc121VspbVolt: Float = 0F,
  /**
   *  Power board current sensor reading
   */
  public val adc121CspbAmp: Float = 0F,
  /**
   *  Board current sensor 1 reading
   */
  public val adc121Cs1Amp: Float = 0F,
  /**
   *  Board current sensor 2 reading
   */
  public val adc121Cs2Amp: Float = 0F,
) : MavMessage<SensPower> {
  public override val instanceMetadata: MavMessage.Metadata<SensPower> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(adc121VspbVolt)
    outputBuffer.encodeFloat(adc121CspbAmp)
    outputBuffer.encodeFloat(adc121Cs1Amp)
    outputBuffer.encodeFloat(adc121Cs2Amp)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 8002

    private const val CRC: Int = 218

    private const val SIZE: Int = 16

    private val DESERIALIZER: MavDeserializer<SensPower> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val adc121VspbVolt = inputBuffer.decodeFloat()
      val adc121CspbAmp = inputBuffer.decodeFloat()
      val adc121Cs1Amp = inputBuffer.decodeFloat()
      val adc121Cs2Amp = inputBuffer.decodeFloat()

      SensPower(
        adc121VspbVolt = adc121VspbVolt,
        adc121CspbAmp = adc121CspbAmp,
        adc121Cs1Amp = adc121Cs1Amp,
        adc121Cs2Amp = adc121Cs2Amp,
      )
    }


    private val METADATA: MavMessage.Metadata<SensPower> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SensPower> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var adc121VspbVolt: Float = 0F

    public var adc121CspbAmp: Float = 0F

    public var adc121Cs1Amp: Float = 0F

    public var adc121Cs2Amp: Float = 0F

    public fun build(): SensPower = SensPower(
      adc121VspbVolt = adc121VspbVolt,
      adc121CspbAmp = adc121CspbAmp,
      adc121Cs1Amp = adc121Cs1Amp,
      adc121Cs2Amp = adc121Cs2Amp,
    )
  }
}
