package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Radio link statistics. Should be emitted only by components with component id
 * MAV_COMP_ID_TELEMETRY_RADIO. Per default, rssi values are in MAVLink units: 0 represents weakest
 * signal, 254 represents maximum signal; can be changed to dBm with the flag
 * RADIO_LINK_STATS_FLAGS_RSSI_DBM.
 */
@GeneratedMavMessage(
  id = 60_046u,
  crcExtra = -18,
)
public data class RadioLinkStats(
  /**
   * Radio link statistics flags.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavBitmaskValue<RadioLinkStatsFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Values: 0..100. UINT8_MAX: invalid/unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rxLq: UByte = 0u,
  /**
   * Rssi of antenna1. UINT8_MAX: invalid/unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rxRssi1: UByte = 0u,
  /**
   * Noise on antenna1. Radio dependent. INT8_MAX: invalid/unknown.
   */
  @GeneratedMavField(type = "int8_t")
  public val rxSnr1: Byte = 0,
  /**
   * Rssi of antenna2. UINT8_MAX: ignore/unknown, use rx_rssi1.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rxRssi2: UByte = 0u,
  /**
   * Noise on antenna2. Radio dependent. INT8_MAX: ignore/unknown, use rx_snr1.
   */
  @GeneratedMavField(type = "int8_t")
  public val rxSnr2: Byte = 0,
  /**
   * 0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Rx receive diversity, use rx_rssi1, rx_snr1.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rxReceiveAntenna: UByte = 0u,
  /**
   * 0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Rx transmit diversity.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rxTransmitAntenna: UByte = 0u,
  /**
   * Values: 0..100. UINT8_MAX: invalid/unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val txLq: UByte = 0u,
  /**
   * Rssi of antenna1. UINT8_MAX: invalid/unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val txRssi1: UByte = 0u,
  /**
   * Noise on antenna1. Radio dependent. INT8_MAX: invalid/unknown.
   */
  @GeneratedMavField(type = "int8_t")
  public val txSnr1: Byte = 0,
  /**
   * Rssi of antenna2. UINT8_MAX: ignore/unknown, use tx_rssi1.
   */
  @GeneratedMavField(type = "uint8_t")
  public val txRssi2: UByte = 0u,
  /**
   * Noise on antenna2. Radio dependent. INT8_MAX: ignore/unknown, use tx_snr1.
   */
  @GeneratedMavField(type = "int8_t")
  public val txSnr2: Byte = 0,
  /**
   * 0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Tx receive diversity, use tx_rssi1, tx_snr1.
   */
  @GeneratedMavField(type = "uint8_t")
  public val txReceiveAntenna: UByte = 0u,
  /**
   * 0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Tx transmit diversity.
   */
  @GeneratedMavField(type = "uint8_t")
  public val txTransmitAntenna: UByte = 0u,
) : MavMessage<RadioLinkStats> {
  public override val instanceCompanion: MavMessage.MavCompanion<RadioLinkStats> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeBitmaskValue(flags.value, 1)
    encoder.encodeUInt8(rxLq)
    encoder.encodeUInt8(rxRssi1)
    encoder.encodeInt8(rxSnr1)
    encoder.encodeUInt8(rxRssi2)
    encoder.encodeInt8(rxSnr2)
    encoder.encodeUInt8(rxReceiveAntenna)
    encoder.encodeUInt8(rxTransmitAntenna)
    encoder.encodeUInt8(txLq)
    encoder.encodeUInt8(txRssi1)
    encoder.encodeInt8(txSnr1)
    encoder.encodeUInt8(txRssi2)
    encoder.encodeInt8(txSnr2)
    encoder.encodeUInt8(txReceiveAntenna)
    encoder.encodeUInt8(txTransmitAntenna)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeBitmaskValue(flags.value, 1)
    encoder.encodeUInt8(rxLq)
    encoder.encodeUInt8(rxRssi1)
    encoder.encodeInt8(rxSnr1)
    encoder.encodeUInt8(rxRssi2)
    encoder.encodeInt8(rxSnr2)
    encoder.encodeUInt8(rxReceiveAntenna)
    encoder.encodeUInt8(rxTransmitAntenna)
    encoder.encodeUInt8(txLq)
    encoder.encodeUInt8(txRssi1)
    encoder.encodeInt8(txSnr1)
    encoder.encodeUInt8(txRssi2)
    encoder.encodeInt8(txSnr2)
    encoder.encodeUInt8(txReceiveAntenna)
    encoder.encodeUInt8(txTransmitAntenna)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RadioLinkStats> {
    private const val SIZE_V1: Int = 15

    private const val SIZE_V2: Int = 15

    public override val id: UInt = 60_046u

    public override val crcExtra: Byte = -18

    public override fun deserialize(bytes: ByteArray): RadioLinkStats {
      val decoder = MavDataDecoder(bytes)

      val flags = decoder.safeDecodeBitmaskValue(1).let { value ->
        val flags = RadioLinkStatsFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val rxLq = decoder.safeDecodeUInt8()
      val rxRssi1 = decoder.safeDecodeUInt8()
      val rxSnr1 = decoder.safeDecodeInt8()
      val rxRssi2 = decoder.safeDecodeUInt8()
      val rxSnr2 = decoder.safeDecodeInt8()
      val rxReceiveAntenna = decoder.safeDecodeUInt8()
      val rxTransmitAntenna = decoder.safeDecodeUInt8()
      val txLq = decoder.safeDecodeUInt8()
      val txRssi1 = decoder.safeDecodeUInt8()
      val txSnr1 = decoder.safeDecodeInt8()
      val txRssi2 = decoder.safeDecodeUInt8()
      val txSnr2 = decoder.safeDecodeInt8()
      val txReceiveAntenna = decoder.safeDecodeUInt8()
      val txTransmitAntenna = decoder.safeDecodeUInt8()

      return RadioLinkStats(
        flags = flags,
        rxLq = rxLq,
        rxRssi1 = rxRssi1,
        rxSnr1 = rxSnr1,
        rxRssi2 = rxRssi2,
        rxSnr2 = rxSnr2,
        rxReceiveAntenna = rxReceiveAntenna,
        rxTransmitAntenna = rxTransmitAntenna,
        txLq = txLq,
        txRssi1 = txRssi1,
        txSnr1 = txSnr1,
        txRssi2 = txRssi2,
        txSnr2 = txSnr2,
        txReceiveAntenna = txReceiveAntenna,
        txTransmitAntenna = txTransmitAntenna,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RadioLinkStats =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var flags: MavBitmaskValue<RadioLinkStatsFlags> = MavBitmaskValue.fromValue(0u)

    public var rxLq: UByte = 0u

    public var rxRssi1: UByte = 0u

    public var rxSnr1: Byte = 0

    public var rxRssi2: UByte = 0u

    public var rxSnr2: Byte = 0

    public var rxReceiveAntenna: UByte = 0u

    public var rxTransmitAntenna: UByte = 0u

    public var txLq: UByte = 0u

    public var txRssi1: UByte = 0u

    public var txSnr1: Byte = 0

    public var txRssi2: UByte = 0u

    public var txSnr2: Byte = 0

    public var txReceiveAntenna: UByte = 0u

    public var txTransmitAntenna: UByte = 0u

    public fun build(): RadioLinkStats = RadioLinkStats(
      flags = flags,
      rxLq = rxLq,
      rxRssi1 = rxRssi1,
      rxSnr1 = rxSnr1,
      rxRssi2 = rxRssi2,
      rxSnr2 = rxSnr2,
      rxReceiveAntenna = rxReceiveAntenna,
      rxTransmitAntenna = rxTransmitAntenna,
      txLq = txLq,
      txRssi1 = txRssi1,
      txSnr1 = txSnr1,
      txRssi2 = txRssi2,
      txSnr2 = txSnr2,
      txReceiveAntenna = txReceiveAntenna,
      txTransmitAntenna = txTransmitAntenna,
    )
  }
}
