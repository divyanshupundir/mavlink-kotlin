package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 8u,
  crcExtra = 117,
)
public data class LinkNodeStatus(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   * Remaining free transmit buffer space
   */
  @GeneratedMavField(type = "uint8_t")
  public val txBuf: UByte = 0u,
  /**
   * Remaining free receive buffer space
   */
  @GeneratedMavField(type = "uint8_t")
  public val rxBuf: UByte = 0u,
  /**
   * Transmit rate
   */
  @GeneratedMavField(type = "uint32_t")
  public val txRate: UInt = 0u,
  /**
   * Receive rate
   */
  @GeneratedMavField(type = "uint32_t")
  public val rxRate: UInt = 0u,
  /**
   * Number of bytes that could not be parsed correctly.
   */
  @GeneratedMavField(type = "uint16_t")
  public val rxParseErr: UShort = 0u,
  /**
   * Transmit buffer overflows. This number wraps around as it reaches UINT16_MAX
   */
  @GeneratedMavField(type = "uint16_t")
  public val txOverflows: UShort = 0u,
  /**
   * Receive buffer overflows. This number wraps around as it reaches UINT16_MAX
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
  public override val instanceCompanion: MavMessage.MavCompanion<LinkNodeStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeUInt32(txRate)
    outputBuffer.encodeUInt32(rxRate)
    outputBuffer.encodeUInt32(messagesSent)
    outputBuffer.encodeUInt32(messagesReceived)
    outputBuffer.encodeUInt32(messagesLost)
    outputBuffer.encodeUInt16(rxParseErr)
    outputBuffer.encodeUInt16(txOverflows)
    outputBuffer.encodeUInt16(rxOverflows)
    outputBuffer.encodeUInt8(txBuf)
    outputBuffer.encodeUInt8(rxBuf)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeUInt32(txRate)
    outputBuffer.encodeUInt32(rxRate)
    outputBuffer.encodeUInt32(messagesSent)
    outputBuffer.encodeUInt32(messagesReceived)
    outputBuffer.encodeUInt32(messagesLost)
    outputBuffer.encodeUInt16(rxParseErr)
    outputBuffer.encodeUInt16(txOverflows)
    outputBuffer.encodeUInt16(rxOverflows)
    outputBuffer.encodeUInt8(txBuf)
    outputBuffer.encodeUInt8(rxBuf)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LinkNodeStatus> {
    private const val SIZE_V1: Int = 36

    private const val SIZE_V2: Int = 36

    public override val id: UInt = 8u

    public override val crcExtra: Byte = 117

    public override fun deserialize(bytes: ByteArray): LinkNodeStatus {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUInt64()
      val txRate = inputBuffer.decodeUInt32()
      val rxRate = inputBuffer.decodeUInt32()
      val messagesSent = inputBuffer.decodeUInt32()
      val messagesReceived = inputBuffer.decodeUInt32()
      val messagesLost = inputBuffer.decodeUInt32()
      val rxParseErr = inputBuffer.decodeUInt16()
      val txOverflows = inputBuffer.decodeUInt16()
      val rxOverflows = inputBuffer.decodeUInt16()
      val txBuf = inputBuffer.decodeUInt8()
      val rxBuf = inputBuffer.decodeUInt8()

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
