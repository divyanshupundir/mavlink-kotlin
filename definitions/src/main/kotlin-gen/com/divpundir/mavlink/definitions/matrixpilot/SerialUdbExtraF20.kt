package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeInt16(sueTrimValueInput1)
    buffer.encodeInt16(sueTrimValueInput2)
    buffer.encodeInt16(sueTrimValueInput3)
    buffer.encodeInt16(sueTrimValueInput4)
    buffer.encodeInt16(sueTrimValueInput5)
    buffer.encodeInt16(sueTrimValueInput6)
    buffer.encodeInt16(sueTrimValueInput7)
    buffer.encodeInt16(sueTrimValueInput8)
    buffer.encodeInt16(sueTrimValueInput9)
    buffer.encodeInt16(sueTrimValueInput10)
    buffer.encodeInt16(sueTrimValueInput11)
    buffer.encodeInt16(sueTrimValueInput12)
    buffer.encodeUInt8(sueNumberOfInputs)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt16(sueTrimValueInput1)
    buffer.encodeInt16(sueTrimValueInput2)
    buffer.encodeInt16(sueTrimValueInput3)
    buffer.encodeInt16(sueTrimValueInput4)
    buffer.encodeInt16(sueTrimValueInput5)
    buffer.encodeInt16(sueTrimValueInput6)
    buffer.encodeInt16(sueTrimValueInput7)
    buffer.encodeInt16(sueTrimValueInput8)
    buffer.encodeInt16(sueTrimValueInput9)
    buffer.encodeInt16(sueTrimValueInput10)
    buffer.encodeInt16(sueTrimValueInput11)
    buffer.encodeInt16(sueTrimValueInput12)
    buffer.encodeUInt8(sueNumberOfInputs)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF20> {
    public override val id: UInt = 186u

    public override val crcExtra: Byte = -112

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF20 {
      val buffer = Buffer().write(bytes)

      val sueTrimValueInput1 = buffer.decodeInt16()
      val sueTrimValueInput2 = buffer.decodeInt16()
      val sueTrimValueInput3 = buffer.decodeInt16()
      val sueTrimValueInput4 = buffer.decodeInt16()
      val sueTrimValueInput5 = buffer.decodeInt16()
      val sueTrimValueInput6 = buffer.decodeInt16()
      val sueTrimValueInput7 = buffer.decodeInt16()
      val sueTrimValueInput8 = buffer.decodeInt16()
      val sueTrimValueInput9 = buffer.decodeInt16()
      val sueTrimValueInput10 = buffer.decodeInt16()
      val sueTrimValueInput11 = buffer.decodeInt16()
      val sueTrimValueInput12 = buffer.decodeInt16()
      val sueNumberOfInputs = buffer.decodeUInt8()

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
