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
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timestamp)
    output.encodeUInt64(lastHeartbeat)
    output.encodeUInt16(failedSessions)
    output.encodeUInt16(successfulSessions)
    output.encodeUInt8(signalQuality)
    output.encodeUInt8(ringPending)
    output.encodeUInt8(txSessionPending)
    output.encodeUInt8(rxSessionPending)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timestamp)
    output.encodeUInt64(lastHeartbeat)
    output.encodeUInt16(failedSessions)
    output.encodeUInt16(successfulSessions)
    output.encodeUInt8(signalQuality)
    output.encodeUInt8(ringPending)
    output.encodeUInt8(txSessionPending)
    output.encodeUInt8(rxSessionPending)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SatcomLinkStatus> {
    private const val SIZE_V1: Int = 24

    private const val SIZE_V2: Int = 24

    public override val id: UInt = 8_015u

    public override val crcExtra: Byte = 23

    public override fun deserialize(source: BufferedSource): SatcomLinkStatus {
      val timestamp = source.decodeUInt64()
      val lastHeartbeat = source.decodeUInt64()
      val failedSessions = source.decodeUInt16()
      val successfulSessions = source.decodeUInt16()
      val signalQuality = source.decodeUInt8()
      val ringPending = source.decodeUInt8()
      val txSessionPending = source.decodeUInt8()
      val rxSessionPending = source.decodeUInt8()

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
