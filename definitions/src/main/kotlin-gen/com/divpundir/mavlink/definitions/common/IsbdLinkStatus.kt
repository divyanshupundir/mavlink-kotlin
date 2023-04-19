package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
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
 * Status of the Iridium SBD link.
 */
@GeneratedMavMessage(
  id = 335u,
  crcExtra = -31,
)
public data class IsbdLinkStatus(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   * Timestamp of the last successful sbd session. The receiving end can infer timestamp format
   * (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
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
  public override val instanceMetadata: MavMessage.Metadata<IsbdLinkStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeUInt64(lastHeartbeat)
    outputBuffer.encodeUInt16(failedSessions)
    outputBuffer.encodeUInt16(successfulSessions)
    outputBuffer.encodeUInt8(signalQuality)
    outputBuffer.encodeUInt8(ringPending)
    outputBuffer.encodeUInt8(txSessionPending)
    outputBuffer.encodeUInt8(rxSessionPending)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeUInt64(lastHeartbeat)
    outputBuffer.encodeUInt16(failedSessions)
    outputBuffer.encodeUInt16(successfulSessions)
    outputBuffer.encodeUInt8(signalQuality)
    outputBuffer.encodeUInt8(ringPending)
    outputBuffer.encodeUInt8(txSessionPending)
    outputBuffer.encodeUInt8(rxSessionPending)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 335u

    private const val CRC_EXTRA: Byte = -31

    private const val SIZE_V1: Int = 24

    private const val SIZE_V2: Int = 24

    private val DESERIALIZER: MavDeserializer<IsbdLinkStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUInt64()
      val lastHeartbeat = inputBuffer.decodeUInt64()
      val failedSessions = inputBuffer.decodeUInt16()
      val successfulSessions = inputBuffer.decodeUInt16()
      val signalQuality = inputBuffer.decodeUInt8()
      val ringPending = inputBuffer.decodeUInt8()
      val txSessionPending = inputBuffer.decodeUInt8()
      val rxSessionPending = inputBuffer.decodeUInt8()

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


    private val METADATA: MavMessage.Metadata<IsbdLinkStatus> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<IsbdLinkStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): IsbdLinkStatus =
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
