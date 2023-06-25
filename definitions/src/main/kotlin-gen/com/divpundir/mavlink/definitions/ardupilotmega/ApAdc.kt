package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeUInt16(adc1)
    buffer.encodeUInt16(adc2)
    buffer.encodeUInt16(adc3)
    buffer.encodeUInt16(adc4)
    buffer.encodeUInt16(adc5)
    buffer.encodeUInt16(adc6)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(adc1)
    buffer.encodeUInt16(adc2)
    buffer.encodeUInt16(adc3)
    buffer.encodeUInt16(adc4)
    buffer.encodeUInt16(adc5)
    buffer.encodeUInt16(adc6)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ApAdc> {
    public override val id: UInt = 153u

    public override val crcExtra: Byte = -68

    public override fun deserialize(bytes: ByteArray): ApAdc {
      val buffer = Buffer().write(bytes)

      val adc1 = buffer.decodeUInt16()
      val adc2 = buffer.decodeUInt16()
      val adc3 = buffer.decodeUInt16()
      val adc4 = buffer.decodeUInt16()
      val adc5 = buffer.decodeUInt16()
      val adc6 = buffer.decodeUInt16()

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
