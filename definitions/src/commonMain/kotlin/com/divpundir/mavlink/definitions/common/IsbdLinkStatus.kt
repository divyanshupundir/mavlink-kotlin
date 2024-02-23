package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt16
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
 * Status of the Iridium SBD link.
 *
 * @param timestamp Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param lastHeartbeat Timestamp of the last successful sbd session. The receiving end can infer
 * timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
 * units = us
 * @param failedSessions Number of failed SBD sessions.
 * @param successfulSessions Number of successful SBD sessions.
 * @param signalQuality Signal quality equal to the number of bars displayed on the ISU signal
 * strength indicator. Range is 0 to 5, where 0 indicates no signal and 5 indicates maximum signal
 * strength.
 * @param ringPending 1: Ring call pending, 0: No call pending.
 * @param txSessionPending 1: Transmission session pending, 0: No transmission session pending.
 * @param rxSessionPending 1: Receiving session pending, 0: No receiving session pending.
 */
@GeneratedMavMessage(
  id = 335u,
  crcExtra = -31,
)
public data class IsbdLinkStatus(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   * Timestamp of the last successful sbd session. The receiving end can infer timestamp format
   * (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val lastHeartbeat: ULong = 0uL,
  /**
   * Number of failed SBD sessions.
   */
  @GeneratedMavField(type = "uint16_t")
  public val failedSessions: UShort = 0u,
  /**
   * Number of successful SBD sessions.
   */
  @GeneratedMavField(type = "uint16_t")
  public val successfulSessions: UShort = 0u,
  /**
   * Signal quality equal to the number of bars displayed on the ISU signal strength indicator.
   * Range is 0 to 5, where 0 indicates no signal and 5 indicates maximum signal strength.
   */
  @GeneratedMavField(type = "uint8_t")
  public val signalQuality: UByte = 0u,
  /**
   * 1: Ring call pending, 0: No call pending.
   */
  @GeneratedMavField(type = "uint8_t")
  public val ringPending: UByte = 0u,
  /**
   * 1: Transmission session pending, 0: No transmission session pending.
   */
  @GeneratedMavField(type = "uint8_t")
  public val txSessionPending: UByte = 0u,
  /**
   * 1: Receiving session pending, 0: No receiving session pending.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rxSessionPending: UByte = 0u,
) : MavMessage<IsbdLinkStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<IsbdLinkStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timestamp)
    encoder.encodeUInt64(lastHeartbeat)
    encoder.encodeUInt16(failedSessions)
    encoder.encodeUInt16(successfulSessions)
    encoder.encodeUInt8(signalQuality)
    encoder.encodeUInt8(ringPending)
    encoder.encodeUInt8(txSessionPending)
    encoder.encodeUInt8(rxSessionPending)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timestamp)
    encoder.encodeUInt64(lastHeartbeat)
    encoder.encodeUInt16(failedSessions)
    encoder.encodeUInt16(successfulSessions)
    encoder.encodeUInt8(signalQuality)
    encoder.encodeUInt8(ringPending)
    encoder.encodeUInt8(txSessionPending)
    encoder.encodeUInt8(rxSessionPending)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<IsbdLinkStatus> {
    private const val SIZE_V1: Int = 24

    private const val SIZE_V2: Int = 24

    override val id: UInt = 335u

    override val crcExtra: Byte = -31

    override fun deserialize(bytes: ByteArray): IsbdLinkStatus {
      val decoder = MavDataDecoder(bytes)

      val timestamp = decoder.safeDecodeUInt64()
      val lastHeartbeat = decoder.safeDecodeUInt64()
      val failedSessions = decoder.safeDecodeUInt16()
      val successfulSessions = decoder.safeDecodeUInt16()
      val signalQuality = decoder.safeDecodeUInt8()
      val ringPending = decoder.safeDecodeUInt8()
      val txSessionPending = decoder.safeDecodeUInt8()
      val rxSessionPending = decoder.safeDecodeUInt8()

      return IsbdLinkStatus(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): IsbdLinkStatus =
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

    public fun build(): IsbdLinkStatus = IsbdLinkStatus(
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
