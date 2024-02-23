package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * Status of GSM modem (connected to onboard computer)
 *
 * @param timestamp Timestamp (of OBC)
 * units = us
 * @param gsmModemType GSM modem used
 * @param gsmLinkType GSM link type
 * @param rssi RSSI as reported by modem (unconverted)
 * @param rsrpRscp RSRP (LTE) or RSCP (WCDMA) as reported by modem (unconverted)
 * @param sinrEcio SINR (LTE) or ECIO (WCDMA) as reported by modem (unconverted)
 * @param rsrq RSRQ (LTE only) as reported by modem (unconverted)
 */
@GeneratedMavMessage(
  id = 8_014u,
  crcExtra = -56,
)
public data class GsmLinkStatus(
  /**
   * Timestamp (of OBC)
   * units = us
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
  override val instanceCompanion: MavMessage.MavCompanion<GsmLinkStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timestamp)
    encoder.encodeEnumValue(gsmModemType.value, 1)
    encoder.encodeEnumValue(gsmLinkType.value, 1)
    encoder.encodeUInt8(rssi)
    encoder.encodeUInt8(rsrpRscp)
    encoder.encodeUInt8(sinrEcio)
    encoder.encodeUInt8(rsrq)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timestamp)
    encoder.encodeEnumValue(gsmModemType.value, 1)
    encoder.encodeEnumValue(gsmLinkType.value, 1)
    encoder.encodeUInt8(rssi)
    encoder.encodeUInt8(rsrpRscp)
    encoder.encodeUInt8(sinrEcio)
    encoder.encodeUInt8(rsrq)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GsmLinkStatus> {
    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 14

    override val id: UInt = 8_014u

    override val crcExtra: Byte = -56

    override fun deserialize(bytes: ByteArray): GsmLinkStatus {
      val decoder = MavDataDecoder(bytes)

      val timestamp = decoder.safeDecodeUInt64()
      val gsmModemType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = GsmModemType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val gsmLinkType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = GsmLinkType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val rssi = decoder.safeDecodeUInt8()
      val rsrpRscp = decoder.safeDecodeUInt8()
      val sinrEcio = decoder.safeDecodeUInt8()
      val rsrq = decoder.safeDecodeUInt8()

      return GsmLinkStatus(
        timestamp = timestamp,
        gsmModemType = gsmModemType,
        gsmLinkType = gsmLinkType,
        rssi = rssi,
        rsrpRscp = rsrpRscp,
        sinrEcio = sinrEcio,
        rsrq = rsrq,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GsmLinkStatus =
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
