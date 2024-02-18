package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
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
 * Status generated by radio and injected into MAVLink stream.
 *
 */
@GeneratedMavMessage(
  id = 109u,
  crcExtra = -71,
)
public data class RadioStatus(
  /**
   * Local (message sender) received signal strength indication in device-dependent units/scale.
   * Values: [0-254], UINT8_MAX: invalid/unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rssi: UByte = 0u,
  /**
   * Remote (message receiver) signal strength indication in device-dependent units/scale. Values:
   * [0-254], UINT8_MAX: invalid/unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val remrssi: UByte = 0u,
  /**
   * Remaining free transmitter buffer space.
   */
  @GeneratedMavField(type = "uint8_t")
  public val txbuf: UByte = 0u,
  /**
   * Local background noise level. These are device dependent RSSI values (scale as approx 2x dB on
   * SiK radios). Values: [0-254], UINT8_MAX: invalid/unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val noise: UByte = 0u,
  /**
   * Remote background noise level. These are device dependent RSSI values (scale as approx 2x dB on
   * SiK radios). Values: [0-254], UINT8_MAX: invalid/unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val remnoise: UByte = 0u,
  /**
   * Count of radio packet receive errors (since boot).
   */
  @GeneratedMavField(type = "uint16_t")
  public val rxerrors: UShort = 0u,
  /**
   * Count of error corrected radio packets (since boot).
   */
  @GeneratedMavField(type = "uint16_t")
  public val fixed: UShort = 0u,
) : MavMessage<RadioStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<RadioStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(rxerrors)
    encoder.encodeUInt16(fixed)
    encoder.encodeUInt8(rssi)
    encoder.encodeUInt8(remrssi)
    encoder.encodeUInt8(txbuf)
    encoder.encodeUInt8(noise)
    encoder.encodeUInt8(remnoise)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(rxerrors)
    encoder.encodeUInt16(fixed)
    encoder.encodeUInt8(rssi)
    encoder.encodeUInt8(remrssi)
    encoder.encodeUInt8(txbuf)
    encoder.encodeUInt8(noise)
    encoder.encodeUInt8(remnoise)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RadioStatus> {
    private const val SIZE_V1: Int = 9

    private const val SIZE_V2: Int = 9

    override val id: UInt = 109u

    override val crcExtra: Byte = -71

    override fun deserialize(bytes: ByteArray): RadioStatus {
      val decoder = MavDataDecoder(bytes)

      val rxerrors = decoder.safeDecodeUInt16()
      val fixed = decoder.safeDecodeUInt16()
      val rssi = decoder.safeDecodeUInt8()
      val remrssi = decoder.safeDecodeUInt8()
      val txbuf = decoder.safeDecodeUInt8()
      val noise = decoder.safeDecodeUInt8()
      val remnoise = decoder.safeDecodeUInt8()

      return RadioStatus(
        rssi = rssi,
        remrssi = remrssi,
        txbuf = txbuf,
        noise = noise,
        remnoise = remnoise,
        rxerrors = rxerrors,
        fixed = fixed,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RadioStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var rssi: UByte = 0u

    public var remrssi: UByte = 0u

    public var txbuf: UByte = 0u

    public var noise: UByte = 0u

    public var remnoise: UByte = 0u

    public var rxerrors: UShort = 0u

    public var fixed: UShort = 0u

    public fun build(): RadioStatus = RadioStatus(
      rssi = rssi,
      remrssi = remrssi,
      txbuf = txbuf,
      noise = noise,
      remnoise = remnoise,
      rxerrors = rxerrors,
      fixed = fixed,
    )
  }
}
