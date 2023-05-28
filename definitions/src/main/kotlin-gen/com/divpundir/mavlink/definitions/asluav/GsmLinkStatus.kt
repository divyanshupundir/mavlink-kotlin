package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
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
import kotlin.Unit

/**
 * Status of GSM modem (connected to onboard computer)
 */
@GeneratedMavMessage(
  id = 8_014u,
  crcExtra = -56,
)
public data class GsmLinkStatus(
  /**
   * Timestamp (of OBC)
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   * GSM modem used
   */
  @GeneratedMavField(type = "uint8_t")
  public val gsmModemType: MavEnumValue<GsmModemType> = MavEnumValue.fromValue(0u),
  /**
   * GSM link type
   */
  @GeneratedMavField(type = "uint8_t")
  public val gsmLinkType: MavEnumValue<GsmLinkType> = MavEnumValue.fromValue(0u),
  /**
   * RSSI as reported by modem (unconverted)
   */
  @GeneratedMavField(type = "uint8_t")
  public val rssi: UByte = 0u,
  /**
   * RSRP (LTE) or RSCP (WCDMA) as reported by modem (unconverted)
   */
  @GeneratedMavField(type = "uint8_t")
  public val rsrpRscp: UByte = 0u,
  /**
   * SINR (LTE) or ECIO (WCDMA) as reported by modem (unconverted)
   */
  @GeneratedMavField(type = "uint8_t")
  public val sinrEcio: UByte = 0u,
  /**
   * RSRQ (LTE only) as reported by modem (unconverted)
   */
  @GeneratedMavField(type = "uint8_t")
  public val rsrq: UByte = 0u,
) : MavMessage<GsmLinkStatus> {
  public override val instanceMetadata: MavMessage.Metadata<GsmLinkStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeEnumValue(gsmModemType.value, 1)
    outputBuffer.encodeEnumValue(gsmLinkType.value, 1)
    outputBuffer.encodeUInt8(rssi)
    outputBuffer.encodeUInt8(rsrpRscp)
    outputBuffer.encodeUInt8(sinrEcio)
    outputBuffer.encodeUInt8(rsrq)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeEnumValue(gsmModemType.value, 1)
    outputBuffer.encodeEnumValue(gsmLinkType.value, 1)
    outputBuffer.encodeUInt8(rssi)
    outputBuffer.encodeUInt8(rsrpRscp)
    outputBuffer.encodeUInt8(sinrEcio)
    outputBuffer.encodeUInt8(rsrq)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 8_014u

    private const val CRC_EXTRA: Byte = -56

    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 14

    private val DESERIALIZER: MavDeserializer<GsmLinkStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUInt64()
      val gsmModemType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GsmModemType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val gsmLinkType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GsmLinkType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val rssi = inputBuffer.decodeUInt8()
      val rsrpRscp = inputBuffer.decodeUInt8()
      val sinrEcio = inputBuffer.decodeUInt8()
      val rsrq = inputBuffer.decodeUInt8()

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


    private val METADATA: MavMessage.Metadata<GsmLinkStatus> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GsmLinkStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GsmLinkStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: ULong = 0uL

    public var gsmModemType: MavEnumValue<GsmModemType> = MavEnumValue.fromValue(0u)

    public var gsmLinkType: MavEnumValue<GsmLinkType> = MavEnumValue.fromValue(0u)

    public var rssi: UByte = 0u

    public var rsrpRscp: UByte = 0u

    public var sinrEcio: UByte = 0u

    public var rsrq: UByte = 0u

    public fun build(): GsmLinkStatus = GsmLinkStatus(
      timestamp = timestamp,
      gsmModemType = gsmModemType,
      gsmLinkType = gsmLinkType,
      rssi = rssi,
      rsrpRscp = rsrpRscp,
      sinrEcio = sinrEcio,
      rsrq = rsrq,
    )
  }
}
