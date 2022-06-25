package com.urbanmatrix.mavlink.asluav

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Status of the SatCom link
 */
public data class SatcomLinkStatus(
  /**
   * Timestamp
   */
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   * Timestamp of the last successful sbd session
   */
  public val lastHeartbeat: BigInteger = BigInteger.ZERO,
  /**
   * Number of failed sessions
   */
  public val failedSessions: Int = 0,
  /**
   * Number of successful sessions
   */
  public val successfulSessions: Int = 0,
  /**
   * Signal quality
   */
  public val signalQuality: Int = 0,
  /**
   * Ring call pending
   */
  public val ringPending: Int = 0,
  /**
   * Transmission session pending
   */
  public val txSessionPending: Int = 0,
  /**
   * Receiving session pending
   */
  public val rxSessionPending: Int = 0,
) : MavMessage<SatcomLinkStatus> {
  public override val instanceMetadata: MavMessage.Metadata<SatcomLinkStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(24).order(ByteOrder.LITTLE_ENDIAN)
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
    private const val ID: Int = 8015

    private const val CRC: Int = 23

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
  }
}
