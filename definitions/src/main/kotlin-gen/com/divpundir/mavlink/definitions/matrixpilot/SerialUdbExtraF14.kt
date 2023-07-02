package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
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
 * Backwards compatible version of SERIAL_UDB_EXTRA F14: format
 */
@GeneratedMavMessage(
  id = 178u,
  crcExtra = 123,
)
public data class SerialUdbExtraF14(
  /**
   * Serial UDB Extra Wind Estimation Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueWindEstimation: UByte = 0u,
  /**
   * Serial UDB Extra Type of GPS Unit
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueGpsType: UByte = 0u,
  /**
   * Serial UDB Extra Dead Reckoning Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueDr: UByte = 0u,
  /**
   * Serial UDB Extra Type of UDB Hardware
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueBoardType: UByte = 0u,
  /**
   * Serial UDB Extra Type of Airframe
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueAirframe: UByte = 0u,
  /**
   * Serial UDB Extra Reboot Register of DSPIC
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRcon: Short = 0,
  /**
   * Serial UDB Extra  Last dspic Trap Flags
   */
  @GeneratedMavField(type = "int16_t")
  public val sueTrapFlags: Short = 0,
  /**
   * Serial UDB Extra Type Program Address of Last Trap
   */
  @GeneratedMavField(type = "uint32_t")
  public val sueTrapSource: UInt = 0u,
  /**
   * Serial UDB Extra Number of Ocillator Failures
   */
  @GeneratedMavField(type = "int16_t")
  public val sueOscFailCount: Short = 0,
  /**
   * Serial UDB Extra UDB Internal Clock Configuration
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueClockConfig: UByte = 0u,
  /**
   * Serial UDB Extra Type of Flight Plan
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueFlightPlanType: UByte = 0u,
) : MavMessage<SerialUdbExtraF14> {
  public override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF14> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt32(sueTrapSource)
    encoder.encodeInt16(sueRcon)
    encoder.encodeInt16(sueTrapFlags)
    encoder.encodeInt16(sueOscFailCount)
    encoder.encodeUInt8(sueWindEstimation)
    encoder.encodeUInt8(sueGpsType)
    encoder.encodeUInt8(sueDr)
    encoder.encodeUInt8(sueBoardType)
    encoder.encodeUInt8(sueAirframe)
    encoder.encodeUInt8(sueClockConfig)
    encoder.encodeUInt8(sueFlightPlanType)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt32(sueTrapSource)
    encoder.encodeInt16(sueRcon)
    encoder.encodeInt16(sueTrapFlags)
    encoder.encodeInt16(sueOscFailCount)
    encoder.encodeUInt8(sueWindEstimation)
    encoder.encodeUInt8(sueGpsType)
    encoder.encodeUInt8(sueDr)
    encoder.encodeUInt8(sueBoardType)
    encoder.encodeUInt8(sueAirframe)
    encoder.encodeUInt8(sueClockConfig)
    encoder.encodeUInt8(sueFlightPlanType)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF14> {
    private const val SIZE_V1: Int = 17

    private const val SIZE_V2: Int = 17

    public override val id: UInt = 178u

    public override val crcExtra: Byte = 123

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF14 {
      val decoder = MavDataDecoder.wrap(bytes)

      val sueTrapSource = decoder.safeDecodeUInt32()
      val sueRcon = decoder.safeDecodeInt16()
      val sueTrapFlags = decoder.safeDecodeInt16()
      val sueOscFailCount = decoder.safeDecodeInt16()
      val sueWindEstimation = decoder.safeDecodeUInt8()
      val sueGpsType = decoder.safeDecodeUInt8()
      val sueDr = decoder.safeDecodeUInt8()
      val sueBoardType = decoder.safeDecodeUInt8()
      val sueAirframe = decoder.safeDecodeUInt8()
      val sueClockConfig = decoder.safeDecodeUInt8()
      val sueFlightPlanType = decoder.safeDecodeUInt8()

      return SerialUdbExtraF14(
        sueWindEstimation = sueWindEstimation,
        sueGpsType = sueGpsType,
        sueDr = sueDr,
        sueBoardType = sueBoardType,
        sueAirframe = sueAirframe,
        sueRcon = sueRcon,
        sueTrapFlags = sueTrapFlags,
        sueTrapSource = sueTrapSource,
        sueOscFailCount = sueOscFailCount,
        sueClockConfig = sueClockConfig,
        sueFlightPlanType = sueFlightPlanType,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialUdbExtraF14 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueWindEstimation: UByte = 0u

    public var sueGpsType: UByte = 0u

    public var sueDr: UByte = 0u

    public var sueBoardType: UByte = 0u

    public var sueAirframe: UByte = 0u

    public var sueRcon: Short = 0

    public var sueTrapFlags: Short = 0

    public var sueTrapSource: UInt = 0u

    public var sueOscFailCount: Short = 0

    public var sueClockConfig: UByte = 0u

    public var sueFlightPlanType: UByte = 0u

    public fun build(): SerialUdbExtraF14 = SerialUdbExtraF14(
      sueWindEstimation = sueWindEstimation,
      sueGpsType = sueGpsType,
      sueDr = sueDr,
      sueBoardType = sueBoardType,
      sueAirframe = sueAirframe,
      sueRcon = sueRcon,
      sueTrapFlags = sueTrapFlags,
      sueTrapSource = sueTrapSource,
      sueOscFailCount = sueOscFailCount,
      sueClockConfig = sueClockConfig,
      sueFlightPlanType = sueFlightPlanType,
    )
  }
}
