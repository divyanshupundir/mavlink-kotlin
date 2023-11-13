package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F20 format
 */
@GeneratedMavMessage(
  id = 186u,
  crcExtra = -112,
)
public data class SerialUdbExtraF20(
  /**
   * SUE Number of Input Channels
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueNumberOfInputs: UByte = 0u,
  /**
   * SUE UDB PWM Trim Value on Input 1
   */
  @GeneratedMavField(type = "int16_t")
  public val sueTrimValueInput1: Short = 0,
  /**
   * SUE UDB PWM Trim Value on Input 2
   */
  @GeneratedMavField(type = "int16_t")
  public val sueTrimValueInput2: Short = 0,
  /**
   * SUE UDB PWM Trim Value on Input 3
   */
  @GeneratedMavField(type = "int16_t")
  public val sueTrimValueInput3: Short = 0,
  /**
   * SUE UDB PWM Trim Value on Input 4
   */
  @GeneratedMavField(type = "int16_t")
  public val sueTrimValueInput4: Short = 0,
  /**
   * SUE UDB PWM Trim Value on Input 5
   */
  @GeneratedMavField(type = "int16_t")
  public val sueTrimValueInput5: Short = 0,
  /**
   * SUE UDB PWM Trim Value on Input 6
   */
  @GeneratedMavField(type = "int16_t")
  public val sueTrimValueInput6: Short = 0,
  /**
   * SUE UDB PWM Trim Value on Input 7
   */
  @GeneratedMavField(type = "int16_t")
  public val sueTrimValueInput7: Short = 0,
  /**
   * SUE UDB PWM Trim Value on Input 8
   */
  @GeneratedMavField(type = "int16_t")
  public val sueTrimValueInput8: Short = 0,
  /**
   * SUE UDB PWM Trim Value on Input 9
   */
  @GeneratedMavField(type = "int16_t")
  public val sueTrimValueInput9: Short = 0,
  /**
   * SUE UDB PWM Trim Value on Input 10
   */
  @GeneratedMavField(type = "int16_t")
  public val sueTrimValueInput10: Short = 0,
  /**
   * SUE UDB PWM Trim Value on Input 11
   */
  @GeneratedMavField(type = "int16_t")
  public val sueTrimValueInput11: Short = 0,
  /**
   * SUE UDB PWM Trim Value on Input 12
   */
  @GeneratedMavField(type = "int16_t")
  public val sueTrimValueInput12: Short = 0,
) : MavMessage<SerialUdbExtraF20> {
  public override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF20> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt16(sueTrimValueInput1)
    encoder.encodeInt16(sueTrimValueInput2)
    encoder.encodeInt16(sueTrimValueInput3)
    encoder.encodeInt16(sueTrimValueInput4)
    encoder.encodeInt16(sueTrimValueInput5)
    encoder.encodeInt16(sueTrimValueInput6)
    encoder.encodeInt16(sueTrimValueInput7)
    encoder.encodeInt16(sueTrimValueInput8)
    encoder.encodeInt16(sueTrimValueInput9)
    encoder.encodeInt16(sueTrimValueInput10)
    encoder.encodeInt16(sueTrimValueInput11)
    encoder.encodeInt16(sueTrimValueInput12)
    encoder.encodeUInt8(sueNumberOfInputs)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt16(sueTrimValueInput1)
    encoder.encodeInt16(sueTrimValueInput2)
    encoder.encodeInt16(sueTrimValueInput3)
    encoder.encodeInt16(sueTrimValueInput4)
    encoder.encodeInt16(sueTrimValueInput5)
    encoder.encodeInt16(sueTrimValueInput6)
    encoder.encodeInt16(sueTrimValueInput7)
    encoder.encodeInt16(sueTrimValueInput8)
    encoder.encodeInt16(sueTrimValueInput9)
    encoder.encodeInt16(sueTrimValueInput10)
    encoder.encodeInt16(sueTrimValueInput11)
    encoder.encodeInt16(sueTrimValueInput12)
    encoder.encodeUInt8(sueNumberOfInputs)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF20> {
    private const val SIZE_V1: Int = 25

    private const val SIZE_V2: Int = 25

    public override val id: UInt = 186u

    public override val crcExtra: Byte = -112

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF20 {
      val decoder = MavDataDecoder(bytes)

      val sueTrimValueInput1 = decoder.safeDecodeInt16()
      val sueTrimValueInput2 = decoder.safeDecodeInt16()
      val sueTrimValueInput3 = decoder.safeDecodeInt16()
      val sueTrimValueInput4 = decoder.safeDecodeInt16()
      val sueTrimValueInput5 = decoder.safeDecodeInt16()
      val sueTrimValueInput6 = decoder.safeDecodeInt16()
      val sueTrimValueInput7 = decoder.safeDecodeInt16()
      val sueTrimValueInput8 = decoder.safeDecodeInt16()
      val sueTrimValueInput9 = decoder.safeDecodeInt16()
      val sueTrimValueInput10 = decoder.safeDecodeInt16()
      val sueTrimValueInput11 = decoder.safeDecodeInt16()
      val sueTrimValueInput12 = decoder.safeDecodeInt16()
      val sueNumberOfInputs = decoder.safeDecodeUInt8()

      return SerialUdbExtraF20(
        sueNumberOfInputs = sueNumberOfInputs,
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
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialUdbExtraF20 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueNumberOfInputs: UByte = 0u

    public var sueTrimValueInput1: Short = 0

    public var sueTrimValueInput2: Short = 0

    public var sueTrimValueInput3: Short = 0

    public var sueTrimValueInput4: Short = 0

    public var sueTrimValueInput5: Short = 0

    public var sueTrimValueInput6: Short = 0

    public var sueTrimValueInput7: Short = 0

    public var sueTrimValueInput8: Short = 0

    public var sueTrimValueInput9: Short = 0

    public var sueTrimValueInput10: Short = 0

    public var sueTrimValueInput11: Short = 0

    public var sueTrimValueInput12: Short = 0

    public fun build(): SerialUdbExtraF20 = SerialUdbExtraF20(
      sueNumberOfInputs = sueNumberOfInputs,
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
    )
  }
}
