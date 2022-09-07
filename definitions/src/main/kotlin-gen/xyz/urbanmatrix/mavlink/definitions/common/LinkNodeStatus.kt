package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Status generated in each node in the communication chain and injected into MAVLink stream.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 8,
  crc = 117,
)
public data class LinkNodeStatus(
  /**
   * Timestamp (time since system boot).
   */
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   * Remaining free transmit buffer space
   */
  public val txBuf: Int = 0,
  /**
   * Remaining free receive buffer space
   */
  public val rxBuf: Int = 0,
  /**
   * Transmit rate
   */
  public val txRate: Long = 0L,
  /**
   * Receive rate
   */
  public val rxRate: Long = 0L,
  /**
   * Number of bytes that could not be parsed correctly.
   */
  public val rxParseErr: Int = 0,
  /**
   * Transmit buffer overflows. This number wraps around as it reaches UINT16_MAX
   */
  public val txOverflows: Int = 0,
  /**
   * Receive buffer overflows. This number wraps around as it reaches UINT16_MAX
   */
  public val rxOverflows: Int = 0,
  /**
   * Messages sent
   */
  public val messagesSent: Long = 0L,
  /**
   * Messages received (estimated from counting seq)
   */
  public val messagesReceived: Long = 0L,
  /**
   * Messages lost (estimated from counting seq)
   */
  public val messagesLost: Long = 0L,
) : MavMessage<LinkNodeStatus> {
  public override val instanceMetadata: MavMessage.Metadata<LinkNodeStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeUint32(txRate)
    outputBuffer.encodeUint32(rxRate)
    outputBuffer.encodeUint32(messagesSent)
    outputBuffer.encodeUint32(messagesReceived)
    outputBuffer.encodeUint32(messagesLost)
    outputBuffer.encodeUint16(rxParseErr)
    outputBuffer.encodeUint16(txOverflows)
    outputBuffer.encodeUint16(rxOverflows)
    outputBuffer.encodeUint8(txBuf)
    outputBuffer.encodeUint8(rxBuf)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 8

    private const val CRC: Int = 117

    private const val SIZE: Int = 36

    private val DESERIALIZER: MavDeserializer<LinkNodeStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint64()
      val txRate = inputBuffer.decodeUint32()
      val rxRate = inputBuffer.decodeUint32()
      val messagesSent = inputBuffer.decodeUint32()
      val messagesReceived = inputBuffer.decodeUint32()
      val messagesLost = inputBuffer.decodeUint32()
      val rxParseErr = inputBuffer.decodeUint16()
      val txOverflows = inputBuffer.decodeUint16()
      val rxOverflows = inputBuffer.decodeUint16()
      val txBuf = inputBuffer.decodeUint8()
      val rxBuf = inputBuffer.decodeUint8()

      LinkNodeStatus(
        timestamp = timestamp,
        txBuf = txBuf,
        rxBuf = rxBuf,
        txRate = txRate,
        rxRate = rxRate,
        rxParseErr = rxParseErr,
        txOverflows = txOverflows,
        rxOverflows = rxOverflows,
        messagesSent = messagesSent,
        messagesReceived = messagesReceived,
        messagesLost = messagesLost,
      )
    }


    private val METADATA: MavMessage.Metadata<LinkNodeStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LinkNodeStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: BigInteger = BigInteger.ZERO

    public var txBuf: Int = 0

    public var rxBuf: Int = 0

    public var txRate: Long = 0L

    public var rxRate: Long = 0L

    public var rxParseErr: Int = 0

    public var txOverflows: Int = 0

    public var rxOverflows: Int = 0

    public var messagesSent: Long = 0L

    public var messagesReceived: Long = 0L

    public var messagesLost: Long = 0L

    public fun build(): LinkNodeStatus = LinkNodeStatus(
      timestamp = timestamp,
      txBuf = txBuf,
      rxBuf = rxBuf,
      txRate = txRate,
      rxRate = rxRate,
      rxParseErr = rxParseErr,
      txOverflows = txOverflows,
      rxOverflows = rxOverflows,
      messagesSent = messagesSent,
      messagesReceived = messagesReceived,
      messagesLost = messagesLost,
    )
  }
}
