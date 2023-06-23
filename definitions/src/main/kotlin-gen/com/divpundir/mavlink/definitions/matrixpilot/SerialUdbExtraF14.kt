package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(sueTrapSource)
    output.encodeInt16(sueRcon)
    output.encodeInt16(sueTrapFlags)
    output.encodeInt16(sueOscFailCount)
    output.encodeUInt8(sueWindEstimation)
    output.encodeUInt8(sueGpsType)
    output.encodeUInt8(sueDr)
    output.encodeUInt8(sueBoardType)
    output.encodeUInt8(sueAirframe)
    output.encodeUInt8(sueClockConfig)
    output.encodeUInt8(sueFlightPlanType)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(sueTrapSource)
    output.encodeInt16(sueRcon)
    output.encodeInt16(sueTrapFlags)
    output.encodeInt16(sueOscFailCount)
    output.encodeUInt8(sueWindEstimation)
    output.encodeUInt8(sueGpsType)
    output.encodeUInt8(sueDr)
    output.encodeUInt8(sueBoardType)
    output.encodeUInt8(sueAirframe)
    output.encodeUInt8(sueClockConfig)
    output.encodeUInt8(sueFlightPlanType)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF14> {
    private const val SIZE_V1: Int = 17

    private const val SIZE_V2: Int = 17

    public override val id: UInt = 178u

    public override val crcExtra: Byte = 123

    public override fun deserialize(source: BufferedSource): SerialUdbExtraF14 {
      val sueTrapSource = source.decodeUInt32()
      val sueRcon = source.decodeInt16()
      val sueTrapFlags = source.decodeInt16()
      val sueOscFailCount = source.decodeInt16()
      val sueWindEstimation = source.decodeUInt8()
      val sueGpsType = source.decodeUInt8()
      val sueDr = source.decodeUInt8()
      val sueBoardType = source.decodeUInt8()
      val sueAirframe = source.decodeUInt8()
      val sueClockConfig = source.decodeUInt8()
      val sueFlightPlanType = source.decodeUInt8()

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
