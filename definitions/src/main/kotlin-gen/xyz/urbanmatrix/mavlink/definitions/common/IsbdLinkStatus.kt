package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Status of the Iridium SBD link.
 */
@GeneratedMavMessage(
  id = 335,
  crc = 225,
)
public data class IsbdLinkStatus(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   * Timestamp of the last successful sbd session. The receiving end can infer timestamp format
   * (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val lastHeartbeat: BigInteger = BigInteger.ZERO,
  /**
   * Number of failed SBD sessions.
   */
  public val failedSessions: Int = 0,
  /**
   * Number of successful SBD sessions.
   */
  public val successfulSessions: Int = 0,
  /**
   * Signal quality equal to the number of bars displayed on the ISU signal strength indicator.
   * Range is 0 to 5, where 0 indicates no signal and 5 indicates maximum signal strength.
   */
  public val signalQuality: Int = 0,
  /**
   * 1: Ring call pending, 0: No call pending.
   */
  public val ringPending: Int = 0,
  /**
   * 1: Transmission session pending, 0: No transmission session pending.
   */
  public val txSessionPending: Int = 0,
  /**
   * 1: Receiving session pending, 0: No receiving session pending.
   */
  public val rxSessionPending: Int = 0,
) : MavMessage<IsbdLinkStatus> {
  public override val instanceMetadata: MavMessage.Metadata<IsbdLinkStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeUint64(lastHeartbeat)
    outputBuffer.encodeUint16(failedSessions)
    outputBuffer.encodeUint16(successfulSessions)
    outputBuffer.encodeUint8(signalQuality)
    outputBuffer.encodeUint8(ringPending)
    outputBuffer.encodeUint8(txSessionPending)
    outputBuffer.encodeUint8(rxSessionPending)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 335

    private const val CRC: Int = 225

    private const val SIZE: Int = 24

    private val DESERIALIZER: MavDeserializer<IsbdLinkStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint64()
      val lastHeartbeat = inputBuffer.decodeUint64()
      val failedSessions = inputBuffer.decodeUint16()
      val successfulSessions = inputBuffer.decodeUint16()
      val signalQuality = inputBuffer.decodeUint8()
      val ringPending = inputBuffer.decodeUint8()
      val txSessionPending = inputBuffer.decodeUint8()
      val rxSessionPending = inputBuffer.decodeUint8()

      IsbdLinkStatus(
        timestamp = timestamp,
        lastHeartbeat = lastHeartbeat,
        failedSessions = failedSessions,
        successfulSessions = successfulSessions,
        signalQuality = signalQuality,
        ringPending = ringPending,
        txSessionPending = txSessionPending,
        rxSessionPending = rxSessionPending,
      )
    }


    private val METADATA: MavMessage.Metadata<IsbdLinkStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<IsbdLinkStatus> = METADATA
  }
}
