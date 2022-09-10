package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F14: format
 */
@GeneratedMavMessage(
  id = 178,
  crc = 123,
)
public data class SerialUdbExtraF14(
  /**
   * Serial UDB Extra Wind Estimation Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueWindEstimation: Int = 0,
  /**
   * Serial UDB Extra Type of GPS Unit
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueGpsType: Int = 0,
  /**
   * Serial UDB Extra Dead Reckoning Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueDr: Int = 0,
  /**
   * Serial UDB Extra Type of UDB Hardware
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueBoardType: Int = 0,
  /**
   * Serial UDB Extra Type of Airframe
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueAirframe: Int = 0,
  /**
   * Serial UDB Extra Reboot Register of DSPIC
   */
  @GeneratedMavField(type = "int16_t")
  public val sueRcon: Int = 0,
  /**
   * Serial UDB Extra  Last dspic Trap Flags
   */
  @GeneratedMavField(type = "int16_t")
  public val sueTrapFlags: Int = 0,
  /**
   * Serial UDB Extra Type Program Address of Last Trap
   */
  @GeneratedMavField(type = "uint32_t")
  public val sueTrapSource: Long = 0L,
  /**
   * Serial UDB Extra Number of Ocillator Failures
   */
  @GeneratedMavField(type = "int16_t")
  public val sueOscFailCount: Int = 0,
  /**
   * Serial UDB Extra UDB Internal Clock Configuration
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueClockConfig: Int = 0,
  /**
   * Serial UDB Extra Type of Flight Plan
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueFlightPlanType: Int = 0,
) : MavMessage<SerialUdbExtraF14> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF14> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(sueTrapSource)
    outputBuffer.encodeInt16(sueRcon)
    outputBuffer.encodeInt16(sueTrapFlags)
    outputBuffer.encodeInt16(sueOscFailCount)
    outputBuffer.encodeUint8(sueWindEstimation)
    outputBuffer.encodeUint8(sueGpsType)
    outputBuffer.encodeUint8(sueDr)
    outputBuffer.encodeUint8(sueBoardType)
    outputBuffer.encodeUint8(sueAirframe)
    outputBuffer.encodeUint8(sueClockConfig)
    outputBuffer.encodeUint8(sueFlightPlanType)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(sueTrapSource)
    outputBuffer.encodeInt16(sueRcon)
    outputBuffer.encodeInt16(sueTrapFlags)
    outputBuffer.encodeInt16(sueOscFailCount)
    outputBuffer.encodeUint8(sueWindEstimation)
    outputBuffer.encodeUint8(sueGpsType)
    outputBuffer.encodeUint8(sueDr)
    outputBuffer.encodeUint8(sueBoardType)
    outputBuffer.encodeUint8(sueAirframe)
    outputBuffer.encodeUint8(sueClockConfig)
    outputBuffer.encodeUint8(sueFlightPlanType)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 178

    private const val CRC: Int = 123

    private const val SIZE_V1: Int = 17

    private const val SIZE_V2: Int = 17

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF14> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueTrapSource = inputBuffer.decodeUint32()
      val sueRcon = inputBuffer.decodeInt16()
      val sueTrapFlags = inputBuffer.decodeInt16()
      val sueOscFailCount = inputBuffer.decodeInt16()
      val sueWindEstimation = inputBuffer.decodeUint8()
      val sueGpsType = inputBuffer.decodeUint8()
      val sueDr = inputBuffer.decodeUint8()
      val sueBoardType = inputBuffer.decodeUint8()
      val sueAirframe = inputBuffer.decodeUint8()
      val sueClockConfig = inputBuffer.decodeUint8()
      val sueFlightPlanType = inputBuffer.decodeUint8()

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


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF14> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF14> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueWindEstimation: Int = 0

    public var sueGpsType: Int = 0

    public var sueDr: Int = 0

    public var sueBoardType: Int = 0

    public var sueAirframe: Int = 0

    public var sueRcon: Int = 0

    public var sueTrapFlags: Int = 0

    public var sueTrapSource: Long = 0L

    public var sueOscFailCount: Int = 0

    public var sueClockConfig: Int = 0

    public var sueFlightPlanType: Int = 0

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
