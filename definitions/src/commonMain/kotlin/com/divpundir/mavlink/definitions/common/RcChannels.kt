package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
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
 * The PPM values of the RC channels received. The standard PPM modulation is as follows: 1000
 * microseconds: 0%, 2000 microseconds: 100%.  A value of UINT16_MAX implies the channel is unused.
 * Individual receivers/transmitters might violate this specification.
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param chancount Total number of RC channels being received. This can be larger than 18,
 * indicating that more channels are available but not given in this message. This value should be 0
 * when no RC channels are available.
 * @param chan1Raw RC channel 1 value.
 * units = us
 * @param chan2Raw RC channel 2 value.
 * units = us
 * @param chan3Raw RC channel 3 value.
 * units = us
 * @param chan4Raw RC channel 4 value.
 * units = us
 * @param chan5Raw RC channel 5 value.
 * units = us
 * @param chan6Raw RC channel 6 value.
 * units = us
 * @param chan7Raw RC channel 7 value.
 * units = us
 * @param chan8Raw RC channel 8 value.
 * units = us
 * @param chan9Raw RC channel 9 value.
 * units = us
 * @param chan10Raw RC channel 10 value.
 * units = us
 * @param chan11Raw RC channel 11 value.
 * units = us
 * @param chan12Raw RC channel 12 value.
 * units = us
 * @param chan13Raw RC channel 13 value.
 * units = us
 * @param chan14Raw RC channel 14 value.
 * units = us
 * @param chan15Raw RC channel 15 value.
 * units = us
 * @param chan16Raw RC channel 16 value.
 * units = us
 * @param chan17Raw RC channel 17 value.
 * units = us
 * @param chan18Raw RC channel 18 value.
 * units = us
 * @param rssi Receive signal strength indicator in device-dependent units/scale. Values: [0-254],
 * UINT8_MAX: invalid/unknown.
 */
@GeneratedMavMessage(
  id = 65u,
  crcExtra = 118,
)
public data class RcChannels(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Total number of RC channels being received. This can be larger than 18, indicating that more
   * channels are available but not given in this message. This value should be 0 when no RC channels
   * are available.
   */
  @GeneratedMavField(type = "uint8_t")
  public val chancount: UByte = 0u,
  /**
   * RC channel 1 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan1Raw: UShort = 0u,
  /**
   * RC channel 2 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan2Raw: UShort = 0u,
  /**
   * RC channel 3 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan3Raw: UShort = 0u,
  /**
   * RC channel 4 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan4Raw: UShort = 0u,
  /**
   * RC channel 5 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan5Raw: UShort = 0u,
  /**
   * RC channel 6 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan6Raw: UShort = 0u,
  /**
   * RC channel 7 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan7Raw: UShort = 0u,
  /**
   * RC channel 8 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan8Raw: UShort = 0u,
  /**
   * RC channel 9 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan9Raw: UShort = 0u,
  /**
   * RC channel 10 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan10Raw: UShort = 0u,
  /**
   * RC channel 11 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan11Raw: UShort = 0u,
  /**
   * RC channel 12 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan12Raw: UShort = 0u,
  /**
   * RC channel 13 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan13Raw: UShort = 0u,
  /**
   * RC channel 14 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan14Raw: UShort = 0u,
  /**
   * RC channel 15 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan15Raw: UShort = 0u,
  /**
   * RC channel 16 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan16Raw: UShort = 0u,
  /**
   * RC channel 17 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan17Raw: UShort = 0u,
  /**
   * RC channel 18 value.
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan18Raw: UShort = 0u,
  /**
   * Receive signal strength indicator in device-dependent units/scale. Values: [0-254], UINT8_MAX:
   * invalid/unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rssi: UByte = 0u,
) : MavMessage<RcChannels> {
  override val instanceCompanion: MavMessage.MavCompanion<RcChannels> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt16(chan1Raw)
    encoder.encodeUInt16(chan2Raw)
    encoder.encodeUInt16(chan3Raw)
    encoder.encodeUInt16(chan4Raw)
    encoder.encodeUInt16(chan5Raw)
    encoder.encodeUInt16(chan6Raw)
    encoder.encodeUInt16(chan7Raw)
    encoder.encodeUInt16(chan8Raw)
    encoder.encodeUInt16(chan9Raw)
    encoder.encodeUInt16(chan10Raw)
    encoder.encodeUInt16(chan11Raw)
    encoder.encodeUInt16(chan12Raw)
    encoder.encodeUInt16(chan13Raw)
    encoder.encodeUInt16(chan14Raw)
    encoder.encodeUInt16(chan15Raw)
    encoder.encodeUInt16(chan16Raw)
    encoder.encodeUInt16(chan17Raw)
    encoder.encodeUInt16(chan18Raw)
    encoder.encodeUInt8(chancount)
    encoder.encodeUInt8(rssi)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt16(chan1Raw)
    encoder.encodeUInt16(chan2Raw)
    encoder.encodeUInt16(chan3Raw)
    encoder.encodeUInt16(chan4Raw)
    encoder.encodeUInt16(chan5Raw)
    encoder.encodeUInt16(chan6Raw)
    encoder.encodeUInt16(chan7Raw)
    encoder.encodeUInt16(chan8Raw)
    encoder.encodeUInt16(chan9Raw)
    encoder.encodeUInt16(chan10Raw)
    encoder.encodeUInt16(chan11Raw)
    encoder.encodeUInt16(chan12Raw)
    encoder.encodeUInt16(chan13Raw)
    encoder.encodeUInt16(chan14Raw)
    encoder.encodeUInt16(chan15Raw)
    encoder.encodeUInt16(chan16Raw)
    encoder.encodeUInt16(chan17Raw)
    encoder.encodeUInt16(chan18Raw)
    encoder.encodeUInt8(chancount)
    encoder.encodeUInt8(rssi)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RcChannels> {
    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    override val id: UInt = 65u

    override val crcExtra: Byte = 118

    override fun deserialize(bytes: ByteArray): RcChannels {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val chan1Raw = decoder.safeDecodeUInt16()
      val chan2Raw = decoder.safeDecodeUInt16()
      val chan3Raw = decoder.safeDecodeUInt16()
      val chan4Raw = decoder.safeDecodeUInt16()
      val chan5Raw = decoder.safeDecodeUInt16()
      val chan6Raw = decoder.safeDecodeUInt16()
      val chan7Raw = decoder.safeDecodeUInt16()
      val chan8Raw = decoder.safeDecodeUInt16()
      val chan9Raw = decoder.safeDecodeUInt16()
      val chan10Raw = decoder.safeDecodeUInt16()
      val chan11Raw = decoder.safeDecodeUInt16()
      val chan12Raw = decoder.safeDecodeUInt16()
      val chan13Raw = decoder.safeDecodeUInt16()
      val chan14Raw = decoder.safeDecodeUInt16()
      val chan15Raw = decoder.safeDecodeUInt16()
      val chan16Raw = decoder.safeDecodeUInt16()
      val chan17Raw = decoder.safeDecodeUInt16()
      val chan18Raw = decoder.safeDecodeUInt16()
      val chancount = decoder.safeDecodeUInt8()
      val rssi = decoder.safeDecodeUInt8()

      return RcChannels(
        timeBootMs = timeBootMs,
        chancount = chancount,
        chan1Raw = chan1Raw,
        chan2Raw = chan2Raw,
        chan3Raw = chan3Raw,
        chan4Raw = chan4Raw,
        chan5Raw = chan5Raw,
        chan6Raw = chan6Raw,
        chan7Raw = chan7Raw,
        chan8Raw = chan8Raw,
        chan9Raw = chan9Raw,
        chan10Raw = chan10Raw,
        chan11Raw = chan11Raw,
        chan12Raw = chan12Raw,
        chan13Raw = chan13Raw,
        chan14Raw = chan14Raw,
        chan15Raw = chan15Raw,
        chan16Raw = chan16Raw,
        chan17Raw = chan17Raw,
        chan18Raw = chan18Raw,
        rssi = rssi,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RcChannels =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var chancount: UByte = 0u

    public var chan1Raw: UShort = 0u

    public var chan2Raw: UShort = 0u

    public var chan3Raw: UShort = 0u

    public var chan4Raw: UShort = 0u

    public var chan5Raw: UShort = 0u

    public var chan6Raw: UShort = 0u

    public var chan7Raw: UShort = 0u

    public var chan8Raw: UShort = 0u

    public var chan9Raw: UShort = 0u

    public var chan10Raw: UShort = 0u

    public var chan11Raw: UShort = 0u

    public var chan12Raw: UShort = 0u

    public var chan13Raw: UShort = 0u

    public var chan14Raw: UShort = 0u

    public var chan15Raw: UShort = 0u

    public var chan16Raw: UShort = 0u

    public var chan17Raw: UShort = 0u

    public var chan18Raw: UShort = 0u

    public var rssi: UByte = 0u

    public fun build(): RcChannels = RcChannels(
      timeBootMs = timeBootMs,
      chancount = chancount,
      chan1Raw = chan1Raw,
      chan2Raw = chan2Raw,
      chan3Raw = chan3Raw,
      chan4Raw = chan4Raw,
      chan5Raw = chan5Raw,
      chan6Raw = chan6Raw,
      chan7Raw = chan7Raw,
      chan8Raw = chan8Raw,
      chan9Raw = chan9Raw,
      chan10Raw = chan10Raw,
      chan11Raw = chan11Raw,
      chan12Raw = chan12Raw,
      chan13Raw = chan13Raw,
      chan14Raw = chan14Raw,
      chan15Raw = chan15Raw,
      chan16Raw = chan16Raw,
      chan17Raw = chan17Raw,
      chan18Raw = chan18Raw,
      rssi = rssi,
    )
  }
}
