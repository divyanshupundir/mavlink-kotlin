package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
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
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(mpptTimestamp)
    output.encodeFloat(mppt1Volt)
    output.encodeFloat(mppt1Amp)
    output.encodeFloat(mppt2Volt)
    output.encodeFloat(mppt2Amp)
    output.encodeFloat(mppt3Volt)
    output.encodeFloat(mppt3Amp)
    output.encodeUInt16(mppt1Pwm)
    output.encodeUInt16(mppt2Pwm)
    output.encodeUInt16(mppt3Pwm)
    output.encodeUInt8(mppt1Status)
    output.encodeUInt8(mppt2Status)
    output.encodeUInt8(mppt3Status)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(mpptTimestamp)
    output.encodeFloat(mppt1Volt)
    output.encodeFloat(mppt1Amp)
    output.encodeFloat(mppt2Volt)
    output.encodeFloat(mppt2Amp)
    output.encodeFloat(mppt3Volt)
    output.encodeFloat(mppt3Amp)
    output.encodeUInt16(mppt1Pwm)
    output.encodeUInt16(mppt2Pwm)
    output.encodeUInt16(mppt3Pwm)
    output.encodeUInt8(mppt1Status)
    output.encodeUInt8(mppt2Status)
    output.encodeUInt8(mppt3Status)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SensMppt> {
    private const val SIZE_V1: Int = 41

    private const val SIZE_V2: Int = 41

    public override val id: UInt = 8_003u

    public override val crcExtra: Byte = -25

    public override fun deserialize(source: BufferedSource): SensMppt {
      val mpptTimestamp = source.decodeUInt64()
      val mppt1Volt = source.decodeFloat()
      val mppt1Amp = source.decodeFloat()
      val mppt2Volt = source.decodeFloat()
      val mppt2Amp = source.decodeFloat()
      val mppt3Volt = source.decodeFloat()
      val mppt3Amp = source.decodeFloat()
      val mppt1Pwm = source.decodeUInt16()
      val mppt2Pwm = source.decodeUInt16()
      val mppt3Pwm = source.decodeUInt16()
      val mppt1Status = source.decodeUInt8()
      val mppt2Status = source.decodeUInt8()
      val mppt3Status = source.decodeUInt8()

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
