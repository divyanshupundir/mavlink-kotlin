package xyz.urbanmatrix.mavlink.definitions.asluav

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Status of the SatCom link
 */
@GeneratedMavMessage(
  id = 8015,
  crc = 23,
)
public data class SatcomLinkStatus(
  /**
   * Timestamp
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   * Timestamp of the last successful sbd session
   */
  @GeneratedMavField(type = "uint64_t")
  public val lastHeartbeat: BigInteger = BigInteger.ZERO,
  /**
   * Number of failed sessions
   */
  @GeneratedMavField(type = "uint16_t")
  public val failedSessions: Int = 0,
  /**
   * Number of successful sessions
   */
  @GeneratedMavField(type = "uint16_t")
  public val successfulSessions: Int = 0,
  /**
   * Signal quality
   */
  @GeneratedMavField(type = "uint8_t")
  public val signalQuality: Int = 0,
  /**
   * Ring call pending
   */
  @GeneratedMavField(type = "uint8_t")
  public val ringPending: Int = 0,
  /**
   * Transmission session pending
   */
  @GeneratedMavField(type = "uint8_t")
  public val txSessionPending: Int = 0,
  /**
   * Receiving session pending
   */
  @GeneratedMavField(type = "uint8_t")
  public val rxSessionPending: Int = 0,
) : MavMessage<SatcomLinkStatus> {
  public override val instanceMetadata: MavMessage.Metadata<SatcomLinkStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
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

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeUint64(lastHeartbeat)
    outputBuffer.encodeUint16(failedSessions)
    outputBuffer.encodeUint16(successfulSessions)
    outputBuffer.encodeUint8(signalQuality)
    outputBuffer.encodeUint8(ringPending)
    outputBuffer.encodeUint8(txSessionPending)
    outputBuffer.encodeUint8(rxSessionPending)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 8015

    private const val CRC: Int = 23

    private const val SIZE_V1: Int = 24

    private const val SIZE_V2: Int = 24

    private val DESERIALIZER: MavDeserializer<SatcomLinkStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint64()
      val lastHeartbeat = inputBuffer.decodeUint64()
      val failedSessions = inputBuffer.decodeUint16()
      val successfulSessions = inputBuffer.decodeUint16()
      val signalQuality = inputBuffer.decodeUint8()
      val ringPending = inputBuffer.decodeUint8()
      val txSessionPending = inputBuffer.decodeUint8()
      val rxSessionPending = inputBuffer.decodeUint8()

      SatcomLinkStatus(
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


    private val METADATA: MavMessage.Metadata<SatcomLinkStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SatcomLinkStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SatcomLinkStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: BigInteger = BigInteger.ZERO

    public var lastHeartbeat: BigInteger = BigInteger.ZERO

    public var failedSessions: Int = 0

    public var successfulSessions: Int = 0

    public var signalQuality: Int = 0

    public var ringPending: Int = 0

    public var txSessionPending: Int = 0

    public var rxSessionPending: Int = 0

    public fun build(): SatcomLinkStatus = SatcomLinkStatus(
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
}
