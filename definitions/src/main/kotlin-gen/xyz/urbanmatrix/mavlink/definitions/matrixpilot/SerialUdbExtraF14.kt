package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF14> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(sueTrapSource)
    outputBuffer.encodeInt16(sueRcon)
    outputBuffer.encodeInt16(sueTrapFlags)
    outputBuffer.encodeInt16(sueOscFailCount)
    outputBuffer.encodeUInt8(sueWindEstimation)
    outputBuffer.encodeUInt8(sueGpsType)
    outputBuffer.encodeUInt8(sueDr)
    outputBuffer.encodeUInt8(sueBoardType)
    outputBuffer.encodeUInt8(sueAirframe)
    outputBuffer.encodeUInt8(sueClockConfig)
    outputBuffer.encodeUInt8(sueFlightPlanType)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(sueTrapSource)
    outputBuffer.encodeInt16(sueRcon)
    outputBuffer.encodeInt16(sueTrapFlags)
    outputBuffer.encodeInt16(sueOscFailCount)
    outputBuffer.encodeUInt8(sueWindEstimation)
    outputBuffer.encodeUInt8(sueGpsType)
    outputBuffer.encodeUInt8(sueDr)
    outputBuffer.encodeUInt8(sueBoardType)
    outputBuffer.encodeUInt8(sueAirframe)
    outputBuffer.encodeUInt8(sueClockConfig)
    outputBuffer.encodeUInt8(sueFlightPlanType)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 178u

    private const val CRC_EXTRA: Byte = 123

    private const val SIZE_V1: Int = 17

    private const val SIZE_V2: Int = 17

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF14> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueTrapSource = inputBuffer.decodeUInt32()
      val sueRcon = inputBuffer.decodeInt16()
      val sueTrapFlags = inputBuffer.decodeInt16()
      val sueOscFailCount = inputBuffer.decodeInt16()
      val sueWindEstimation = inputBuffer.decodeUInt8()
      val sueGpsType = inputBuffer.decodeUInt8()
      val sueDr = inputBuffer.decodeUInt8()
      val sueBoardType = inputBuffer.decodeUInt8()
      val sueAirframe = inputBuffer.decodeUInt8()
      val sueClockConfig = inputBuffer.decodeUInt8()
      val sueFlightPlanType = inputBuffer.decodeUInt8()

      SerialUdbExtraF14(
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


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF14> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF14> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SerialUdbExtraF14 =
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
