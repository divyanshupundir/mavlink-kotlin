package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Raw ADC output.
 */
@GeneratedMavMessage(
  id = 153u,
  crcExtra = -68,
)
public data class ApAdc(
  /**
   * ADC output 1.
   */
  @GeneratedMavField(type = "uint16_t")
  public val adc1: UShort = 0u,
  /**
   * ADC output 2.
   */
  @GeneratedMavField(type = "uint16_t")
  public val adc2: UShort = 0u,
  /**
   * ADC output 3.
   */
  @GeneratedMavField(type = "uint16_t")
  public val adc3: UShort = 0u,
  /**
   * ADC output 4.
   */
  @GeneratedMavField(type = "uint16_t")
  public val adc4: UShort = 0u,
  /**
   * ADC output 5.
   */
  @GeneratedMavField(type = "uint16_t")
  public val adc5: UShort = 0u,
  /**
   * ADC output 6.
   */
  @GeneratedMavField(type = "uint16_t")
  public val adc6: UShort = 0u,
) : MavMessage<ApAdc> {
  public override val instanceMetadata: MavMessage.Metadata<ApAdc> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(adc1)
    outputBuffer.encodeUInt16(adc2)
    outputBuffer.encodeUInt16(adc3)
    outputBuffer.encodeUInt16(adc4)
    outputBuffer.encodeUInt16(adc5)
    outputBuffer.encodeUInt16(adc6)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(adc1)
    outputBuffer.encodeUInt16(adc2)
    outputBuffer.encodeUInt16(adc3)
    outputBuffer.encodeUInt16(adc4)
    outputBuffer.encodeUInt16(adc5)
    outputBuffer.encodeUInt16(adc6)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 153u

    private const val CRC_EXTRA: Byte = -68

    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    private val DESERIALIZER: MavDeserializer<ApAdc> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val adc1 = inputBuffer.decodeUInt16()
      val adc2 = inputBuffer.decodeUInt16()
      val adc3 = inputBuffer.decodeUInt16()
      val adc4 = inputBuffer.decodeUInt16()
      val adc5 = inputBuffer.decodeUInt16()
      val adc6 = inputBuffer.decodeUInt16()

      ApAdc(
        adc1 = adc1,
        adc2 = adc2,
        adc3 = adc3,
        adc4 = adc4,
        adc5 = adc5,
        adc6 = adc6,
      )
    }


    private val METADATA: MavMessage.Metadata<ApAdc> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ApAdc> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): ApAdc =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var adc1: UShort = 0u

    public var adc2: UShort = 0u

    public var adc3: UShort = 0u

    public var adc4: UShort = 0u

    public var adc5: UShort = 0u

    public var adc6: UShort = 0u

    public fun build(): ApAdc = ApAdc(
      adc1 = adc1,
      adc2 = adc2,
      adc3 = adc3,
      adc4 = adc4,
      adc5 = adc5,
      adc6 = adc6,
    )
  }
}
