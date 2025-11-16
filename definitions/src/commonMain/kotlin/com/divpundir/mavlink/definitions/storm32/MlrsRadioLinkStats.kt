package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Radio link statistics for a MAVLink RC receiver or transmitter and other links. Tx: ground-side
 * device, Rx: vehicle-side device.
 *         The message is normally emitted in regular time intervals upon each actual or expected
 * reception of an over-the-air data packet on the link.
 *         A MAVLink RC receiver should emit it shortly after it emits a RADIO_RC_CHANNELS message
 * (if it is emitting that message).
 *         Per default, rssi values are in MAVLink units: 0 represents weakest signal, 254
 * represents maximum signal, UINT8_MAX represents unknown.
 *         The RADIO_LINK_STATS_FLAGS_RSSI_DBM flag is set if the rssi units are negative dBm:
 * 1..254 correspond to -1..-254 dBm, 0 represents no reception, UINT8_MAX represents unknown.
 *         The target_system field should normally be set to the system id of the system the link is
 * connected to, typically the flight controller.
 *         The target_component field can normally be set to 0, so that all components of the system
 * can receive the message.
 *         Note: The frequency fields are extensions to ensure that they are located at the end of
 * the serialized payload and subject to MAVLink's trailing-zero trimming.
 *       
 *
 * @param targetSystem System ID (ID of target system, normally flight controller).
 * @param targetComponent Component ID (normally 0 for broadcast).
 * @param flags Radio link statistics flags.
 * @param rxLqRc Link quality of RC data stream from Tx to Rx. Values: 1..100, 0: no link
 * connection, UINT8_MAX: unknown.
 * units = c%
 * @param rxLqSer Link quality of serial MAVLink data stream from Tx to Rx. Values: 1..100, 0: no
 * link connection, UINT8_MAX: unknown.
 * units = c%
 * @param rxRssi1 Rssi of antenna 1. 0: no reception, UINT8_MAX: unknown.
 * @param rxSnr1 Noise on antenna 1. Radio link dependent. INT8_MAX: unknown.
 * @param txLqSer Link quality of serial MAVLink data stream from Rx to Tx. Values: 1..100, 0: no
 * link connection, UINT8_MAX: unknown.
 * units = c%
 * @param txRssi1 Rssi of antenna 1. 0: no reception. UINT8_MAX: unknown.
 * @param txSnr1 Noise on antenna 1. Radio link dependent. INT8_MAX: unknown.
 * @param rxRssi2 Rssi of antenna 2. 0: no reception, UINT8_MAX: use rx_rssi1 if it is known else
 * unknown.
 * @param rxSnr2 Noise on antenna 2. Radio link dependent. INT8_MAX: use rx_snr1 if it is known else
 * unknown.
 * @param txRssi2 Rssi of antenna 2. 0: no reception. UINT8_MAX: use tx_rssi1 if it is known else
 * unknown.
 * @param txSnr2 Noise on antenna 2. Radio link dependent. INT8_MAX: use tx_snr1 if it is known else
 * unknown.
 * @param frequency1 Frequency on antenna1 in Hz. 0: unknown.
 * units = Hz
 * @param frequency2 Frequency on antenna2 in Hz. 0: unknown.
 * units = Hz
 */
@GeneratedMavMessage(
  id = 60_045u,
  crcExtra = 14,
)
public data class MlrsRadioLinkStats(
  /**
   * System ID (ID of target system, normally flight controller).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID (normally 0 for broadcast).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Radio link statistics flags.
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavBitmaskValue<MlrsRadioLinkStatsFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Link quality of RC data stream from Tx to Rx. Values: 1..100, 0: no link connection, UINT8_MAX:
   * unknown.
   * units = c%
   */
  @GeneratedMavField(type = "uint8_t")
  public val rxLqRc: UByte = 0u,
  /**
   * Link quality of serial MAVLink data stream from Tx to Rx. Values: 1..100, 0: no link
   * connection, UINT8_MAX: unknown.
   * units = c%
   */
  @GeneratedMavField(type = "uint8_t")
  public val rxLqSer: UByte = 0u,
  /**
   * Rssi of antenna 1. 0: no reception, UINT8_MAX: unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rxRssi1: UByte = 0u,
  /**
   * Noise on antenna 1. Radio link dependent. INT8_MAX: unknown.
   */
  @GeneratedMavField(type = "int8_t")
  public val rxSnr1: Byte = 0,
  /**
   * Link quality of serial MAVLink data stream from Rx to Tx. Values: 1..100, 0: no link
   * connection, UINT8_MAX: unknown.
   * units = c%
   */
  @GeneratedMavField(type = "uint8_t")
  public val txLqSer: UByte = 0u,
  /**
   * Rssi of antenna 1. 0: no reception. UINT8_MAX: unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val txRssi1: UByte = 0u,
  /**
   * Noise on antenna 1. Radio link dependent. INT8_MAX: unknown.
   */
  @GeneratedMavField(type = "int8_t")
  public val txSnr1: Byte = 0,
  /**
   * Rssi of antenna 2. 0: no reception, UINT8_MAX: use rx_rssi1 if it is known else unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rxRssi2: UByte = 0u,
  /**
   * Noise on antenna 2. Radio link dependent. INT8_MAX: use rx_snr1 if it is known else unknown.
   */
  @GeneratedMavField(type = "int8_t")
  public val rxSnr2: Byte = 0,
  /**
   * Rssi of antenna 2. 0: no reception. UINT8_MAX: use tx_rssi1 if it is known else unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val txRssi2: UByte = 0u,
  /**
   * Noise on antenna 2. Radio link dependent. INT8_MAX: use tx_snr1 if it is known else unknown.
   */
  @GeneratedMavField(type = "int8_t")
  public val txSnr2: Byte = 0,
  /**
   * Frequency on antenna1 in Hz. 0: unknown.
   * units = Hz
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val frequency1: Float = 0F,
  /**
   * Frequency on antenna2 in Hz. 0: unknown.
   * units = Hz
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val frequency2: Float = 0F,
) : MavMessage<MlrsRadioLinkStats> {
  override val instanceCompanion: MavMessage.MavCompanion<MlrsRadioLinkStats> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeBitmaskValue(flags.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(rxLqRc)
    encoder.encodeUInt8(rxLqSer)
    encoder.encodeUInt8(rxRssi1)
    encoder.encodeInt8(rxSnr1)
    encoder.encodeUInt8(txLqSer)
    encoder.encodeUInt8(txRssi1)
    encoder.encodeInt8(txSnr1)
    encoder.encodeUInt8(rxRssi2)
    encoder.encodeInt8(rxSnr2)
    encoder.encodeUInt8(txRssi2)
    encoder.encodeInt8(txSnr2)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeBitmaskValue(flags.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(rxLqRc)
    encoder.encodeUInt8(rxLqSer)
    encoder.encodeUInt8(rxRssi1)
    encoder.encodeInt8(rxSnr1)
    encoder.encodeUInt8(txLqSer)
    encoder.encodeUInt8(txRssi1)
    encoder.encodeInt8(txSnr1)
    encoder.encodeUInt8(rxRssi2)
    encoder.encodeInt8(rxSnr2)
    encoder.encodeUInt8(txRssi2)
    encoder.encodeInt8(txSnr2)
    encoder.encodeFloat(frequency1)
    encoder.encodeFloat(frequency2)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MlrsRadioLinkStats> {
    private const val SIZE_V1: Int = 15

    private const val SIZE_V2: Int = 23

    override val id: UInt = 60_045u

    override val crcExtra: Byte = 14

    override fun deserialize(bytes: ByteArray): MlrsRadioLinkStats {
      val decoder = MavDataDecoder(bytes)

      val flags = decoder.safeDecodeBitmaskValue(2).let { value ->
        val flags = MlrsRadioLinkStatsFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val rxLqRc = decoder.safeDecodeUInt8()
      val rxLqSer = decoder.safeDecodeUInt8()
      val rxRssi1 = decoder.safeDecodeUInt8()
      val rxSnr1 = decoder.safeDecodeInt8()
      val txLqSer = decoder.safeDecodeUInt8()
      val txRssi1 = decoder.safeDecodeUInt8()
      val txSnr1 = decoder.safeDecodeInt8()
      val rxRssi2 = decoder.safeDecodeUInt8()
      val rxSnr2 = decoder.safeDecodeInt8()
      val txRssi2 = decoder.safeDecodeUInt8()
      val txSnr2 = decoder.safeDecodeInt8()
      val frequency1 = decoder.safeDecodeFloat()
      val frequency2 = decoder.safeDecodeFloat()

      return MlrsRadioLinkStats(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        flags = flags,
        rxLqRc = rxLqRc,
        rxLqSer = rxLqSer,
        rxRssi1 = rxRssi1,
        rxSnr1 = rxSnr1,
        txLqSer = txLqSer,
        txRssi1 = txRssi1,
        txSnr1 = txSnr1,
        rxRssi2 = rxRssi2,
        rxSnr2 = rxSnr2,
        txRssi2 = txRssi2,
        txSnr2 = txSnr2,
        frequency1 = frequency1,
        frequency2 = frequency2,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MlrsRadioLinkStats =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var flags: MavBitmaskValue<MlrsRadioLinkStatsFlags> = MavBitmaskValue.fromValue(0u)

    public var rxLqRc: UByte = 0u

    public var rxLqSer: UByte = 0u

    public var rxRssi1: UByte = 0u

    public var rxSnr1: Byte = 0

    public var txLqSer: UByte = 0u

    public var txRssi1: UByte = 0u

    public var txSnr1: Byte = 0

    public var rxRssi2: UByte = 0u

    public var rxSnr2: Byte = 0

    public var txRssi2: UByte = 0u

    public var txSnr2: Byte = 0

    public var frequency1: Float = 0F

    public var frequency2: Float = 0F

    public fun build(): MlrsRadioLinkStats = MlrsRadioLinkStats(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      flags = flags,
      rxLqRc = rxLqRc,
      rxLqSer = rxLqSer,
      rxRssi1 = rxRssi1,
      rxSnr1 = rxSnr1,
      txLqSer = txLqSer,
      txRssi1 = txRssi1,
      txSnr1 = txSnr1,
      rxRssi2 = rxRssi2,
      rxSnr2 = rxSnr2,
      txRssi2 = txRssi2,
      txSnr2 = txSnr2,
      frequency1 = frequency1,
      frequency2 = frequency2,
    )
  }
}
