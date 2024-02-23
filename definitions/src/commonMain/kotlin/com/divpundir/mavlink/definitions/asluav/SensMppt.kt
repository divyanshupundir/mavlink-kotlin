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
 *
 * @param mpptTimestamp  MPPT last timestamp 
 * units = us
 * @param mppt1Volt  MPPT1 voltage 
 * units = V
 * @param mppt1Amp  MPPT1 current 
 * units = A
 * @param mppt1Pwm  MPPT1 pwm 
 * units = us
 * @param mppt1Status  MPPT1 status 
 * @param mppt2Volt  MPPT2 voltage 
 * units = V
 * @param mppt2Amp  MPPT2 current 
 * units = A
 * @param mppt2Pwm  MPPT2 pwm 
 * units = us
 * @param mppt2Status  MPPT2 status 
 * @param mppt3Volt MPPT3 voltage 
 * units = V
 * @param mppt3Amp  MPPT3 current 
 * units = A
 * @param mppt3Pwm  MPPT3 pwm 
 * units = us
 * @param mppt3Status  MPPT3 status 
 */
@GeneratedMavMessage(
  id = 8_003u,
  crcExtra = -25,
)
public data class SensMppt(
  /**
   *  MPPT last timestamp 
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val mpptTimestamp: ULong = 0uL,
  /**
   *  MPPT1 voltage 
   * units = V
   */
  @GeneratedMavField(type = "float")
  public val mppt1Volt: Float = 0F,
  /**
   *  MPPT1 current 
   * units = A
   */
  @GeneratedMavField(type = "float")
  public val mppt1Amp: Float = 0F,
  /**
   *  MPPT1 pwm 
   * units = us
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
   * units = V
   */
  @GeneratedMavField(type = "float")
  public val mppt2Volt: Float = 0F,
  /**
   *  MPPT2 current 
   * units = A
   */
  @GeneratedMavField(type = "float")
  public val mppt2Amp: Float = 0F,
  /**
   *  MPPT2 pwm 
   * units = us
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
   * units = V
   */
  @GeneratedMavField(type = "float")
  public val mppt3Volt: Float = 0F,
  /**
   *  MPPT3 current 
   * units = A
   */
  @GeneratedMavField(type = "float")
  public val mppt3Amp: Float = 0F,
  /**
   *  MPPT3 pwm 
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val mppt3Pwm: UShort = 0u,
  /**
   *  MPPT3 status 
   */
  @GeneratedMavField(type = "uint8_t")
  public val mppt3Status: UByte = 0u,
) : MavMessage<SensMppt> {
  override val instanceCompanion: MavMessage.MavCompanion<SensMppt> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
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

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
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

    override val id: UInt = 8_003u

    override val crcExtra: Byte = -25

    override fun deserialize(bytes: ByteArray): SensMppt {
      val decoder = MavDataDecoder(bytes)

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
