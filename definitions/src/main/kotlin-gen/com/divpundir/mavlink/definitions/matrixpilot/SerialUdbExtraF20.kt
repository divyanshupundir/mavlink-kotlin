package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
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
    outputBuffer.encodeUInt8(sueNumberOfInputs)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
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
    outputBuffer.encodeUInt8(sueNumberOfInputs)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF20> {
    private const val SIZE_V1: Int = 25

    private const val SIZE_V2: Int = 25

    public override val id: UInt = 186u

    public override val crcExtra: Byte = -112

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF20 {
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
      val sueNumberOfInputs = inputBuffer.decodeUInt8()

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
