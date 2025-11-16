package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Injected by a radio link endpoint into the MAVLink stream for purposes of flow control. Should be
 * emitted only by components with component id MAV_COMP_ID_TELEMETRY_RADIO.
 *
 * @param txSerRate Transmitted bytes per second, UINT16_MAX: invalid/unknown.
 * units = bytes/s
 * @param rxSerRate Received bytes per second, UINT16_MAX: invalid/unknown.
 * units = bytes/s
 * @param txUsedSerBandwidth Transmit bandwidth consumption. Values: 0..100, UINT8_MAX:
 * invalid/unknown.
 * units = c%
 * @param rxUsedSerBandwidth Receive bandwidth consumption. Values: 0..100, UINT8_MAX:
 * invalid/unknown.
 * units = c%
 * @param txbuf For compatibility with legacy method. UINT8_MAX: unknown.
 * units = c%
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 60_047u,
  crcExtra = 55,
)
public data class MlrsRadioLinkFlowControl(
  /**
   * Transmitted bytes per second, UINT16_MAX: invalid/unknown.
   * units = bytes/s
   */
  @GeneratedMavField(type = "uint16_t")
  public val txSerRate: UShort = 0u,
  /**
   * Received bytes per second, UINT16_MAX: invalid/unknown.
   * units = bytes/s
   */
  @GeneratedMavField(type = "uint16_t")
  public val rxSerRate: UShort = 0u,
  /**
   * Transmit bandwidth consumption. Values: 0..100, UINT8_MAX: invalid/unknown.
   * units = c%
   */
  @GeneratedMavField(type = "uint8_t")
  public val txUsedSerBandwidth: UByte = 0u,
  /**
   * Receive bandwidth consumption. Values: 0..100, UINT8_MAX: invalid/unknown.
   * units = c%
   */
  @GeneratedMavField(type = "uint8_t")
  public val rxUsedSerBandwidth: UByte = 0u,
  /**
   * For compatibility with legacy method. UINT8_MAX: unknown.
   * units = c%
   */
  @GeneratedMavField(type = "uint8_t")
  public val txbuf: UByte = 0u,
) : MavMessage<MlrsRadioLinkFlowControl> {
  override val instanceCompanion: MavMessage.MavCompanion<MlrsRadioLinkFlowControl> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(txSerRate)
    encoder.encodeUInt16(rxSerRate)
    encoder.encodeUInt8(txUsedSerBandwidth)
    encoder.encodeUInt8(rxUsedSerBandwidth)
    encoder.encodeUInt8(txbuf)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(txSerRate)
    encoder.encodeUInt16(rxSerRate)
    encoder.encodeUInt8(txUsedSerBandwidth)
    encoder.encodeUInt8(rxUsedSerBandwidth)
    encoder.encodeUInt8(txbuf)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MlrsRadioLinkFlowControl> {
    private const val SIZE_V1: Int = 7

    private const val SIZE_V2: Int = 7

    override val id: UInt = 60_047u

    override val crcExtra: Byte = 55

    override fun deserialize(bytes: ByteArray): MlrsRadioLinkFlowControl {
      val decoder = MavDataDecoder(bytes)

      val txSerRate = decoder.safeDecodeUInt16()
      val rxSerRate = decoder.safeDecodeUInt16()
      val txUsedSerBandwidth = decoder.safeDecodeUInt8()
      val rxUsedSerBandwidth = decoder.safeDecodeUInt8()
      val txbuf = decoder.safeDecodeUInt8()

      return MlrsRadioLinkFlowControl(
        txSerRate = txSerRate,
        rxSerRate = rxSerRate,
        txUsedSerBandwidth = txUsedSerBandwidth,
        rxUsedSerBandwidth = rxUsedSerBandwidth,
        txbuf = txbuf,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MlrsRadioLinkFlowControl =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var txSerRate: UShort = 0u

    public var rxSerRate: UShort = 0u

    public var txUsedSerBandwidth: UByte = 0u

    public var rxUsedSerBandwidth: UByte = 0u

    public var txbuf: UByte = 0u

    public fun build(): MlrsRadioLinkFlowControl = MlrsRadioLinkFlowControl(
      txSerRate = txSerRate,
      rxSerRate = rxSerRate,
      txUsedSerBandwidth = txUsedSerBandwidth,
      rxUsedSerBandwidth = rxUsedSerBandwidth,
      txbuf = txbuf,
    )
  }
}
