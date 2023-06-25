package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Status of the SatCom link
 */
@GeneratedMavMessage(
  id = 8_015u,
  crcExtra = 23,
)
public data class SatcomLinkStatus(
  /**
   * Timestamp
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   * Timestamp of the last successful sbd session
   */
  @GeneratedMavField(type = "uint64_t")
  public val lastHeartbeat: ULong = 0uL,
  /**
   * Number of failed sessions
   */
  @GeneratedMavField(type = "uint16_t")
  public val failedSessions: UShort = 0u,
  /**
   * Number of successful sessions
   */
  @GeneratedMavField(type = "uint16_t")
  public val successfulSessions: UShort = 0u,
  /**
   * Signal quality
   */
  @GeneratedMavField(type = "uint8_t")
  public val signalQuality: UByte = 0u,
  /**
   * Ring call pending
   */
  @GeneratedMavField(type = "uint8_t")
  public val ringPending: UByte = 0u,
  /**
   * Transmission session pending
   */
  @GeneratedMavField(type = "uint8_t")
  public val txSessionPending: UByte = 0u,
  /**
   * Receiving session pending
   */
  @GeneratedMavField(type = "uint8_t")
  public val rxSessionPending: UByte = 0u,
) : MavMessage<SatcomLinkStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<SatcomLinkStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timestamp)
    buffer.encodeUInt64(lastHeartbeat)
    buffer.encodeUInt16(failedSessions)
    buffer.encodeUInt16(successfulSessions)
    buffer.encodeUInt8(signalQuality)
    buffer.encodeUInt8(ringPending)
    buffer.encodeUInt8(txSessionPending)
    buffer.encodeUInt8(rxSessionPending)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timestamp)
    buffer.encodeUInt64(lastHeartbeat)
    buffer.encodeUInt16(failedSessions)
    buffer.encodeUInt16(successfulSessions)
    buffer.encodeUInt8(signalQuality)
    buffer.encodeUInt8(ringPending)
    buffer.encodeUInt8(txSessionPending)
    buffer.encodeUInt8(rxSessionPending)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SatcomLinkStatus> {
    public override val id: UInt = 8_015u

    public override val crcExtra: Byte = 23

    public override fun deserialize(bytes: ByteArray): SatcomLinkStatus {
      val buffer = Buffer().write(bytes)

      val timestamp = buffer.decodeUInt64()
      val lastHeartbeat = buffer.decodeUInt64()
      val failedSessions = buffer.decodeUInt16()
      val successfulSessions = buffer.decodeUInt16()
      val signalQuality = buffer.decodeUInt8()
      val ringPending = buffer.decodeUInt8()
      val txSessionPending = buffer.decodeUInt8()
      val rxSessionPending = buffer.decodeUInt8()

      return SatcomLinkStatus(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): SatcomLinkStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: ULong = 0uL

    public var lastHeartbeat: ULong = 0uL

    public var failedSessions: UShort = 0u

    public var successfulSessions: UShort = 0u

    public var signalQuality: UByte = 0u

    public var ringPending: UByte = 0u

    public var txSessionPending: UByte = 0u

    public var rxSessionPending: UByte = 0u

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
