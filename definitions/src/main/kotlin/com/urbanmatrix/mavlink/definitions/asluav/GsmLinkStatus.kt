package com.urbanmatrix.mavlink.definitions.asluav

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Status of GSM modem (connected to onboard computer)
 */
public data class GsmLinkStatus(
  /**
   * Timestamp (of OBC)
   */
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   * GSM modem used
   */
  public val gsmModemType: MavEnumValue<GsmModemType> = MavEnumValue.fromValue(0),
  /**
   * GSM link type
   */
  public val gsmLinkType: MavEnumValue<GsmLinkType> = MavEnumValue.fromValue(0),
  /**
   * RSSI as reported by modem (unconverted)
   */
  public val rssi: Int = 0,
  /**
   * RSRP (LTE) or RSCP (WCDMA) as reported by modem (unconverted)
   */
  public val rsrpRscp: Int = 0,
  /**
   * SINR (LTE) or ECIO (WCDMA) as reported by modem (unconverted)
   */
  public val sinrEcio: Int = 0,
  /**
   * RSRQ (LTE only) as reported by modem (unconverted)
   */
  public val rsrq: Int = 0,
) : MavMessage<GsmLinkStatus> {
  public override val instanceMetadata: MavMessage.Metadata<GsmLinkStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeEnumValue(gsmModemType.value, 1)
    outputBuffer.encodeEnumValue(gsmLinkType.value, 1)
    outputBuffer.encodeUint8(rssi)
    outputBuffer.encodeUint8(rsrpRscp)
    outputBuffer.encodeUint8(sinrEcio)
    outputBuffer.encodeUint8(rsrq)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 8014

    private const val CRC: Int = 200

    private const val SIZE: Int = 14

    private val DESERIALIZER: MavDeserializer<GsmLinkStatus> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for GsmLinkStatus: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint64()
      val gsmModemType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GsmModemType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val gsmLinkType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GsmLinkType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val rssi = inputBuffer.decodeUint8()
      val rsrpRscp = inputBuffer.decodeUint8()
      val sinrEcio = inputBuffer.decodeUint8()
      val rsrq = inputBuffer.decodeUint8()

      GsmLinkStatus(
        timestamp = timestamp,
        gsmModemType = gsmModemType,
        gsmLinkType = gsmLinkType,
        rssi = rssi,
        rsrpRscp = rsrpRscp,
        sinrEcio = sinrEcio,
        rsrq = rsrq,
      )
    }


    private val METADATA: MavMessage.Metadata<GsmLinkStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GsmLinkStatus> = METADATA
  }
}
