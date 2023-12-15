package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
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
  public override val instanceCompanion: MavMessage.MavCompanion<ApAdc> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(adc1)
    encoder.encodeUInt16(adc2)
    encoder.encodeUInt16(adc3)
    encoder.encodeUInt16(adc4)
    encoder.encodeUInt16(adc5)
    encoder.encodeUInt16(adc6)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(adc1)
    encoder.encodeUInt16(adc2)
    encoder.encodeUInt16(adc3)
    encoder.encodeUInt16(adc4)
    encoder.encodeUInt16(adc5)
    encoder.encodeUInt16(adc6)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ApAdc> {
    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    public override val id: UInt = 153u

    public override val crcExtra: Byte = -68

    public override fun deserialize(bytes: ByteArray): ApAdc {
      val decoder = MavDataDecoder(bytes)

      val adc1 = decoder.safeDecodeUInt16()
      val adc2 = decoder.safeDecodeUInt16()
      val adc3 = decoder.safeDecodeUInt16()
      val adc4 = decoder.safeDecodeUInt16()
      val adc5 = decoder.safeDecodeUInt16()
      val adc6 = decoder.safeDecodeUInt16()

      return ApAdc(
        adc1 = adc1,
        adc2 = adc2,
        adc3 = adc3,
        adc4 = adc4,
        adc5 = adc5,
        adc6 = adc6,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ApAdc =
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
