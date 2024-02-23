package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit

/**
 * Status generated in each node in the communication chain and injected into MAVLink stream.
 *
 * @param timestamp Timestamp (time since system boot).
 * units = ms
 * @param txBuf Remaining free transmit buffer space
 * units = %
 * @param rxBuf Remaining free receive buffer space
 * units = %
 * @param txRate Transmit rate
 * units = bytes/s
 * @param rxRate Receive rate
 * units = bytes/s
 * @param rxParseErr Number of bytes that could not be parsed correctly.
 * units = bytes
 * @param txOverflows Transmit buffer overflows. This number wraps around as it reaches UINT16_MAX
 * units = bytes
 * @param rxOverflows Receive buffer overflows. This number wraps around as it reaches UINT16_MAX
 * units = bytes
 * @param messagesSent Messages sent
 * @param messagesReceived Messages received (estimated from counting seq)
 * @param messagesLost Messages lost (estimated from counting seq)
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 8u,
  crcExtra = 117,
)
public data class LinkNodeStatus(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   * Remaining free transmit buffer space
   * units = %
   */
  @GeneratedMavField(type = "uint8_t")
  public val txBuf: UByte = 0u,
  /**
   * Remaining free receive buffer space
   * units = %
   */
  @GeneratedMavField(type = "uint8_t")
  public val rxBuf: UByte = 0u,
  /**
   * Transmit rate
   * units = bytes/s
   */
  @GeneratedMavField(type = "uint32_t")
  public val txRate: UInt = 0u,
  /**
   * Receive rate
   * units = bytes/s
   */
  @GeneratedMavField(type = "uint32_t")
  public val rxRate: UInt = 0u,
  /**
   * Number of bytes that could not be parsed correctly.
   * units = bytes
   */
  @GeneratedMavField(type = "uint16_t")
  public val rxParseErr: UShort = 0u,
  /**
   * Transmit buffer overflows. This number wraps around as it reaches UINT16_MAX
   * units = bytes
   */
  @GeneratedMavField(type = "uint16_t")
  public val txOverflows: UShort = 0u,
  /**
   * Receive buffer overflows. This number wraps around as it reaches UINT16_MAX
   * units = bytes
   */
  @GeneratedMavField(type = "uint16_t")
  public val rxOverflows: UShort = 0u,
  /**
   * Messages sent
   */
  @GeneratedMavField(type = "uint32_t")
  public val messagesSent: UInt = 0u,
  /**
   * Messages received (estimated from counting seq)
   */
  @GeneratedMavField(type = "uint32_t")
  public val messagesReceived: UInt = 0u,
  /**
   * Messages lost (estimated from counting seq)
   */
  @GeneratedMavField(type = "uint32_t")
  public val messagesLost: UInt = 0u,
) : MavMessage<LinkNodeStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<LinkNodeStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timestamp)
    encoder.encodeUInt32(txRate)
    encoder.encodeUInt32(rxRate)
    encoder.encodeUInt32(messagesSent)
    encoder.encodeUInt32(messagesReceived)
    encoder.encodeUInt32(messagesLost)
    encoder.encodeUInt16(rxParseErr)
    encoder.encodeUInt16(txOverflows)
    encoder.encodeUInt16(rxOverflows)
    encoder.encodeUInt8(txBuf)
    encoder.encodeUInt8(rxBuf)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timestamp)
    encoder.encodeUInt32(txRate)
    encoder.encodeUInt32(rxRate)
    encoder.encodeUInt32(messagesSent)
    encoder.encodeUInt32(messagesReceived)
    encoder.encodeUInt32(messagesLost)
    encoder.encodeUInt16(rxParseErr)
    encoder.encodeUInt16(txOverflows)
    encoder.encodeUInt16(rxOverflows)
    encoder.encodeUInt8(txBuf)
    encoder.encodeUInt8(rxBuf)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LinkNodeStatus> {
    private const val SIZE_V1: Int = 36

    private const val SIZE_V2: Int = 36

    override val id: UInt = 8u

    override val crcExtra: Byte = 117

    override fun deserialize(bytes: ByteArray): LinkNodeStatus {
      val decoder = MavDataDecoder(bytes)

      val timestamp = decoder.safeDecodeUInt64()
      val txRate = decoder.safeDecodeUInt32()
      val rxRate = decoder.safeDecodeUInt32()
      val messagesSent = decoder.safeDecodeUInt32()
      val messagesReceived = decoder.safeDecodeUInt32()
      val messagesLost = decoder.safeDecodeUInt32()
      val rxParseErr = decoder.safeDecodeUInt16()
      val txOverflows = decoder.safeDecodeUInt16()
      val rxOverflows = decoder.safeDecodeUInt16()
      val txBuf = decoder.safeDecodeUInt8()
      val rxBuf = decoder.safeDecodeUInt8()

      return LinkNodeStatus(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): LinkNodeStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: ULong = 0uL

    public var txBuf: UByte = 0u

    public var rxBuf: UByte = 0u

    public var txRate: UInt = 0u

    public var rxRate: UInt = 0u

    public var rxParseErr: UShort = 0u

    public var txOverflows: UShort = 0u

    public var rxOverflows: UShort = 0u

    public var messagesSent: UInt = 0u

    public var messagesReceived: UInt = 0u

    public var messagesLost: UInt = 0u

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
