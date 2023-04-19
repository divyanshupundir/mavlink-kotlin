package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit

/**
 * Maximum Power Point Tracker (MPPT) sensor data for solar module power performance tracking
 */
@GeneratedMavMessage(
  id = 8003u,
  crcExtra = -25,
)
public data class SensMppt(
  /**
   *  MPPT last timestamp 
   */
  @GeneratedMavField(type = "uint64_t")
  public val mpptTimestamp: ULong = 0uL,
  /**
   *  MPPT1 voltage 
   */
  @GeneratedMavField(type = "float")
  public val mppt1Volt: Float = 0F,
  /**
   *  MPPT1 current 
   */
  @GeneratedMavField(type = "float")
  public val mppt1Amp: Float = 0F,
  /**
   *  MPPT1 pwm 
   */
  @GeneratedMavField(type = "uint16_t")
  public val mppt1Pwm: UShort = 0u,
  /**
   *  MPPT1 status 
   */
  @GeneratedMavField(type = "uint8_t")
  public val mppt1Status: UByte = 0u,
  /**
   *  MPPT2 voltage 
   */
  @GeneratedMavField(type = "float")
  public val mppt2Volt: Float = 0F,
  /**
   *  MPPT2 current 
   */
  @GeneratedMavField(type = "float")
  public val mppt2Amp: Float = 0F,
  /**
   *  MPPT2 pwm 
   */
  @GeneratedMavField(type = "uint16_t")
  public val mppt2Pwm: UShort = 0u,
  /**
   *  MPPT2 status 
   */
  @GeneratedMavField(type = "uint8_t")
  public val mppt2Status: UByte = 0u,
  /**
   * MPPT3 voltage 
   */
  @GeneratedMavField(type = "float")
  public val mppt3Volt: Float = 0F,
  /**
   *  MPPT3 current 
   */
  @GeneratedMavField(type = "float")
  public val mppt3Amp: Float = 0F,
  /**
   *  MPPT3 pwm 
   */
  @GeneratedMavField(type = "uint16_t")
  public val mppt3Pwm: UShort = 0u,
  /**
   *  MPPT3 status 
   */
  @GeneratedMavField(type = "uint8_t")
  public val mppt3Status: UByte = 0u,
) : MavMessage<SensMppt> {
  public override val instanceMetadata: MavMessage.Metadata<SensMppt> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(mpptTimestamp)
    outputBuffer.encodeFloat(mppt1Volt)
    outputBuffer.encodeFloat(mppt1Amp)
    outputBuffer.encodeFloat(mppt2Volt)
    outputBuffer.encodeFloat(mppt2Amp)
    outputBuffer.encodeFloat(mppt3Volt)
    outputBuffer.encodeFloat(mppt3Amp)
    outputBuffer.encodeUInt16(mppt1Pwm)
    outputBuffer.encodeUInt16(mppt2Pwm)
    outputBuffer.encodeUInt16(mppt3Pwm)
    outputBuffer.encodeUInt8(mppt1Status)
    outputBuffer.encodeUInt8(mppt2Status)
    outputBuffer.encodeUInt8(mppt3Status)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(mpptTimestamp)
    outputBuffer.encodeFloat(mppt1Volt)
    outputBuffer.encodeFloat(mppt1Amp)
    outputBuffer.encodeFloat(mppt2Volt)
    outputBuffer.encodeFloat(mppt2Amp)
    outputBuffer.encodeFloat(mppt3Volt)
    outputBuffer.encodeFloat(mppt3Amp)
    outputBuffer.encodeUInt16(mppt1Pwm)
    outputBuffer.encodeUInt16(mppt2Pwm)
    outputBuffer.encodeUInt16(mppt3Pwm)
    outputBuffer.encodeUInt8(mppt1Status)
    outputBuffer.encodeUInt8(mppt2Status)
    outputBuffer.encodeUInt8(mppt3Status)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 8003u

    private const val CRC_EXTRA: Byte = -25

    private const val SIZE_V1: Int = 41

    private const val SIZE_V2: Int = 41

    private val DESERIALIZER: MavDeserializer<SensMppt> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val mpptTimestamp = inputBuffer.decodeUInt64()
      val mppt1Volt = inputBuffer.decodeFloat()
      val mppt1Amp = inputBuffer.decodeFloat()
      val mppt2Volt = inputBuffer.decodeFloat()
      val mppt2Amp = inputBuffer.decodeFloat()
      val mppt3Volt = inputBuffer.decodeFloat()
      val mppt3Amp = inputBuffer.decodeFloat()
      val mppt1Pwm = inputBuffer.decodeUInt16()
      val mppt2Pwm = inputBuffer.decodeUInt16()
      val mppt3Pwm = inputBuffer.decodeUInt16()
      val mppt1Status = inputBuffer.decodeUInt8()
      val mppt2Status = inputBuffer.decodeUInt8()
      val mppt3Status = inputBuffer.decodeUInt8()

      SensMppt(
        mpptTimestamp = mpptTimestamp,
        mppt1Volt = mppt1Volt,
        mppt1Amp = mppt1Amp,
        mppt1Pwm = mppt1Pwm,
        mppt1Status = mppt1Status,
        mppt2Volt = mppt2Volt,
        mppt2Amp = mppt2Amp,
        mppt2Pwm = mppt2Pwm,
        mppt2Status = mppt2Status,
        mppt3Volt = mppt3Volt,
        mppt3Amp = mppt3Amp,
        mppt3Pwm = mppt3Pwm,
        mppt3Status = mppt3Status,
      )
    }


    private val METADATA: MavMessage.Metadata<SensMppt> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SensMppt> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SensMppt =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var mpptTimestamp: ULong = 0uL

    public var mppt1Volt: Float = 0F

    public var mppt1Amp: Float = 0F

    public var mppt1Pwm: UShort = 0u

    public var mppt1Status: UByte = 0u

    public var mppt2Volt: Float = 0F

    public var mppt2Amp: Float = 0F

    public var mppt2Pwm: UShort = 0u

    public var mppt2Status: UByte = 0u

    public var mppt3Volt: Float = 0F

    public var mppt3Amp: Float = 0F

    public var mppt3Pwm: UShort = 0u

    public var mppt3Status: UByte = 0u

    public fun build(): SensMppt = SensMppt(
      mpptTimestamp = mpptTimestamp,
      mppt1Volt = mppt1Volt,
      mppt1Amp = mppt1Amp,
      mppt1Pwm = mppt1Pwm,
      mppt1Status = mppt1Status,
      mppt2Volt = mppt2Volt,
      mppt2Amp = mppt2Amp,
      mppt2Pwm = mppt2Pwm,
      mppt2Status = mppt2Status,
      mppt3Volt = mppt3Volt,
      mppt3Amp = mppt3Amp,
      mppt3Pwm = mppt3Pwm,
      mppt3Status = mppt3Status,
    )
  }
}
