package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F19 format
 */
@GeneratedMavMessage(
  id = 185u,
  crcExtra = 87,
)
public data class SerialUdbExtraF19(
  /**
   * SUE aileron output channel
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueAileronOutputChannel: UByte = 0u,
  /**
   * SUE aileron reversed
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueAileronReversed: UByte = 0u,
  /**
   * SUE elevator output channel
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueElevatorOutputChannel: UByte = 0u,
  /**
   * SUE elevator reversed
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueElevatorReversed: UByte = 0u,
  /**
   * SUE throttle output channel
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueThrottleOutputChannel: UByte = 0u,
  /**
   * SUE throttle reversed
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueThrottleReversed: UByte = 0u,
  /**
   * SUE rudder output channel
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueRudderOutputChannel: UByte = 0u,
  /**
   * SUE rudder reversed
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueRudderReversed: UByte = 0u,
) : MavMessage<SerialUdbExtraF19> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF19> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(sueAileronOutputChannel)
    outputBuffer.encodeUInt8(sueAileronReversed)
    outputBuffer.encodeUInt8(sueElevatorOutputChannel)
    outputBuffer.encodeUInt8(sueElevatorReversed)
    outputBuffer.encodeUInt8(sueThrottleOutputChannel)
    outputBuffer.encodeUInt8(sueThrottleReversed)
    outputBuffer.encodeUInt8(sueRudderOutputChannel)
    outputBuffer.encodeUInt8(sueRudderReversed)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(sueAileronOutputChannel)
    outputBuffer.encodeUInt8(sueAileronReversed)
    outputBuffer.encodeUInt8(sueElevatorOutputChannel)
    outputBuffer.encodeUInt8(sueElevatorReversed)
    outputBuffer.encodeUInt8(sueThrottleOutputChannel)
    outputBuffer.encodeUInt8(sueThrottleReversed)
    outputBuffer.encodeUInt8(sueRudderOutputChannel)
    outputBuffer.encodeUInt8(sueRudderReversed)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 185u

    private const val CRC_EXTRA: Byte = 87

    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF19> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueAileronOutputChannel = inputBuffer.decodeUInt8()
      val sueAileronReversed = inputBuffer.decodeUInt8()
      val sueElevatorOutputChannel = inputBuffer.decodeUInt8()
      val sueElevatorReversed = inputBuffer.decodeUInt8()
      val sueThrottleOutputChannel = inputBuffer.decodeUInt8()
      val sueThrottleReversed = inputBuffer.decodeUInt8()
      val sueRudderOutputChannel = inputBuffer.decodeUInt8()
      val sueRudderReversed = inputBuffer.decodeUInt8()

      SerialUdbExtraF19(
        sueAileronOutputChannel = sueAileronOutputChannel,
        sueAileronReversed = sueAileronReversed,
        sueElevatorOutputChannel = sueElevatorOutputChannel,
        sueElevatorReversed = sueElevatorReversed,
        sueThrottleOutputChannel = sueThrottleOutputChannel,
        sueThrottleReversed = sueThrottleReversed,
        sueRudderOutputChannel = sueRudderOutputChannel,
        sueRudderReversed = sueRudderReversed,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF19> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF19> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SerialUdbExtraF19 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueAileronOutputChannel: UByte = 0u

    public var sueAileronReversed: UByte = 0u

    public var sueElevatorOutputChannel: UByte = 0u

    public var sueElevatorReversed: UByte = 0u

    public var sueThrottleOutputChannel: UByte = 0u

    public var sueThrottleReversed: UByte = 0u

    public var sueRudderOutputChannel: UByte = 0u

    public var sueRudderReversed: UByte = 0u

    public fun build(): SerialUdbExtraF19 = SerialUdbExtraF19(
      sueAileronOutputChannel = sueAileronOutputChannel,
      sueAileronReversed = sueAileronReversed,
      sueElevatorOutputChannel = sueElevatorOutputChannel,
      sueElevatorReversed = sueElevatorReversed,
      sueThrottleOutputChannel = sueThrottleOutputChannel,
      sueThrottleReversed = sueThrottleReversed,
      sueRudderOutputChannel = sueRudderOutputChannel,
      sueRudderReversed = sueRudderReversed,
    )
  }
}
