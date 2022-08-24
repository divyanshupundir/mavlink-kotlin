package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F19 format
 */
@GeneratedMavMessage(
  id = 185,
  crc = 87,
)
public data class SerialUdbExtraF19(
  /**
   * SUE aileron output channel
   */
  public val sueAileronOutputChannel: Int = 0,
  /**
   * SUE aileron reversed
   */
  public val sueAileronReversed: Int = 0,
  /**
   * SUE elevator output channel
   */
  public val sueElevatorOutputChannel: Int = 0,
  /**
   * SUE elevator reversed
   */
  public val sueElevatorReversed: Int = 0,
  /**
   * SUE throttle output channel
   */
  public val sueThrottleOutputChannel: Int = 0,
  /**
   * SUE throttle reversed
   */
  public val sueThrottleReversed: Int = 0,
  /**
   * SUE rudder output channel
   */
  public val sueRudderOutputChannel: Int = 0,
  /**
   * SUE rudder reversed
   */
  public val sueRudderReversed: Int = 0,
) : MavMessage<SerialUdbExtraF19> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF19> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(sueAileronOutputChannel)
    outputBuffer.encodeUint8(sueAileronReversed)
    outputBuffer.encodeUint8(sueElevatorOutputChannel)
    outputBuffer.encodeUint8(sueElevatorReversed)
    outputBuffer.encodeUint8(sueThrottleOutputChannel)
    outputBuffer.encodeUint8(sueThrottleReversed)
    outputBuffer.encodeUint8(sueRudderOutputChannel)
    outputBuffer.encodeUint8(sueRudderReversed)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 185

    private const val CRC: Int = 87

    private const val SIZE: Int = 8

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF19> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueAileronOutputChannel = inputBuffer.decodeUint8()
      val sueAileronReversed = inputBuffer.decodeUint8()
      val sueElevatorOutputChannel = inputBuffer.decodeUint8()
      val sueElevatorReversed = inputBuffer.decodeUint8()
      val sueThrottleOutputChannel = inputBuffer.decodeUint8()
      val sueThrottleReversed = inputBuffer.decodeUint8()
      val sueRudderOutputChannel = inputBuffer.decodeUint8()
      val sueRudderReversed = inputBuffer.decodeUint8()

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


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF19> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF19> = METADATA
  }
}
