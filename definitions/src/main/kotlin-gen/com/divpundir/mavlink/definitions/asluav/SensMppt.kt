package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
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
  id = 8_003u,
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
  public override val instanceCompanion: MavMessage.MavCompanion<SensMppt> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt64(mpptTimestamp)
    encoder.encodeFloat(mppt1Volt)
    encoder.encodeFloat(mppt1Amp)
    encoder.encodeFloat(mppt2Volt)
    encoder.encodeFloat(mppt2Amp)
    encoder.encodeFloat(mppt3Volt)
    encoder.encodeFloat(mppt3Amp)
    encoder.encodeUInt16(mppt1Pwm)
    encoder.encodeUInt16(mppt2Pwm)
    encoder.encodeUInt16(mppt3Pwm)
    encoder.encodeUInt8(mppt1Status)
    encoder.encodeUInt8(mppt2Status)
    encoder.encodeUInt8(mppt3Status)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt64(mpptTimestamp)
    encoder.encodeFloat(mppt1Volt)
    encoder.encodeFloat(mppt1Amp)
    encoder.encodeFloat(mppt2Volt)
    encoder.encodeFloat(mppt2Amp)
    encoder.encodeFloat(mppt3Volt)
    encoder.encodeFloat(mppt3Amp)
    encoder.encodeUInt16(mppt1Pwm)
    encoder.encodeUInt16(mppt2Pwm)
    encoder.encodeUInt16(mppt3Pwm)
    encoder.encodeUInt8(mppt1Status)
    encoder.encodeUInt8(mppt2Status)
    encoder.encodeUInt8(mppt3Status)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SensMppt> {
    private const val SIZE_V1: Int = 41

    private const val SIZE_V2: Int = 41

    public override val id: UInt = 8_003u

    public override val crcExtra: Byte = -25

    public override fun deserialize(bytes: ByteArray): SensMppt {
      val decoder = MavDataDecoder.wrap(bytes)

      val mpptTimestamp = decoder.safeDecodeUInt64()
      val mppt1Volt = decoder.safeDecodeFloat()
      val mppt1Amp = decoder.safeDecodeFloat()
      val mppt2Volt = decoder.safeDecodeFloat()
      val mppt2Amp = decoder.safeDecodeFloat()
      val mppt3Volt = decoder.safeDecodeFloat()
      val mppt3Amp = decoder.safeDecodeFloat()
      val mppt1Pwm = decoder.safeDecodeUInt16()
      val mppt2Pwm = decoder.safeDecodeUInt16()
      val mppt3Pwm = decoder.safeDecodeUInt16()
      val mppt1Status = decoder.safeDecodeUInt8()
      val mppt2Status = decoder.safeDecodeUInt8()
      val mppt3Status = decoder.safeDecodeUInt8()

      return SensMppt(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): SensMppt =
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
