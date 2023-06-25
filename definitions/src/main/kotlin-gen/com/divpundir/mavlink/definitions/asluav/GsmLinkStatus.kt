package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer

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
  public override val instanceCompanion: MavMessage.MavCompanion<GsmLinkStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timestamp)
    buffer.encodeEnumValue(gsmModemType.value, 1)
    buffer.encodeEnumValue(gsmLinkType.value, 1)
    buffer.encodeUInt8(rssi)
    buffer.encodeUInt8(rsrpRscp)
    buffer.encodeUInt8(sinrEcio)
    buffer.encodeUInt8(rsrq)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timestamp)
    buffer.encodeEnumValue(gsmModemType.value, 1)
    buffer.encodeEnumValue(gsmLinkType.value, 1)
    buffer.encodeUInt8(rssi)
    buffer.encodeUInt8(rsrpRscp)
    buffer.encodeUInt8(sinrEcio)
    buffer.encodeUInt8(rsrq)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GsmLinkStatus> {
    public override val id: UInt = 8_014u

    public override val crcExtra: Byte = -56

    public override fun deserialize(bytes: ByteArray): GsmLinkStatus {
      val buffer = Buffer().write(bytes)

      val timestamp = buffer.decodeUInt64()
      val gsmModemType = buffer.decodeEnumValue(1).let { value ->
        val entry = GsmModemType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val gsmLinkType = buffer.decodeEnumValue(1).let { value ->
        val entry = GsmLinkType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val rssi = buffer.decodeUInt8()
      val rsrpRscp = buffer.decodeUInt8()
      val sinrEcio = buffer.decodeUInt8()
      val rsrq = buffer.decodeUInt8()

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
