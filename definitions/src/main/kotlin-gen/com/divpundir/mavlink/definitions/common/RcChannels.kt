package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * The PPM values of the RC channels received. The standard PPM modulation is as follows: 1000
 * microseconds: 0%, 2000 microseconds: 100%.  A value of UINT16_MAX implies the channel is unused.
 * Individual receivers/transmitters might violate this specification.
 */
@GeneratedMavMessage(
  id = 65u,
  crcExtra = 118,
)
public data class RcChannels(
  /**
   * Timestamp (time since system boot).
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
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan1Raw: UShort = 0u,
  /**
   * RC channel 2 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan2Raw: UShort = 0u,
  /**
   * RC channel 3 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan3Raw: UShort = 0u,
  /**
   * RC channel 4 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan4Raw: UShort = 0u,
  /**
   * RC channel 5 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan5Raw: UShort = 0u,
  /**
   * RC channel 6 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan6Raw: UShort = 0u,
  /**
   * RC channel 7 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan7Raw: UShort = 0u,
  /**
   * RC channel 8 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan8Raw: UShort = 0u,
  /**
   * RC channel 9 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan9Raw: UShort = 0u,
  /**
   * RC channel 10 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan10Raw: UShort = 0u,
  /**
   * RC channel 11 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan11Raw: UShort = 0u,
  /**
   * RC channel 12 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan12Raw: UShort = 0u,
  /**
   * RC channel 13 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan13Raw: UShort = 0u,
  /**
   * RC channel 14 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan14Raw: UShort = 0u,
  /**
   * RC channel 15 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan15Raw: UShort = 0u,
  /**
   * RC channel 16 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan16Raw: UShort = 0u,
  /**
   * RC channel 17 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan17Raw: UShort = 0u,
  /**
   * RC channel 18 value.
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
  public override val instanceCompanion: MavMessage.MavCompanion<RcChannels> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeUInt16(chan1Raw)
    buffer.encodeUInt16(chan2Raw)
    buffer.encodeUInt16(chan3Raw)
    buffer.encodeUInt16(chan4Raw)
    buffer.encodeUInt16(chan5Raw)
    buffer.encodeUInt16(chan6Raw)
    buffer.encodeUInt16(chan7Raw)
    buffer.encodeUInt16(chan8Raw)
    buffer.encodeUInt16(chan9Raw)
    buffer.encodeUInt16(chan10Raw)
    buffer.encodeUInt16(chan11Raw)
    buffer.encodeUInt16(chan12Raw)
    buffer.encodeUInt16(chan13Raw)
    buffer.encodeUInt16(chan14Raw)
    buffer.encodeUInt16(chan15Raw)
    buffer.encodeUInt16(chan16Raw)
    buffer.encodeUInt16(chan17Raw)
    buffer.encodeUInt16(chan18Raw)
    buffer.encodeUInt8(chancount)
    buffer.encodeUInt8(rssi)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeUInt16(chan1Raw)
    buffer.encodeUInt16(chan2Raw)
    buffer.encodeUInt16(chan3Raw)
    buffer.encodeUInt16(chan4Raw)
    buffer.encodeUInt16(chan5Raw)
    buffer.encodeUInt16(chan6Raw)
    buffer.encodeUInt16(chan7Raw)
    buffer.encodeUInt16(chan8Raw)
    buffer.encodeUInt16(chan9Raw)
    buffer.encodeUInt16(chan10Raw)
    buffer.encodeUInt16(chan11Raw)
    buffer.encodeUInt16(chan12Raw)
    buffer.encodeUInt16(chan13Raw)
    buffer.encodeUInt16(chan14Raw)
    buffer.encodeUInt16(chan15Raw)
    buffer.encodeUInt16(chan16Raw)
    buffer.encodeUInt16(chan17Raw)
    buffer.encodeUInt16(chan18Raw)
    buffer.encodeUInt8(chancount)
    buffer.encodeUInt8(rssi)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RcChannels> {
    public override val id: UInt = 65u

    public override val crcExtra: Byte = 118

    public override fun deserialize(bytes: ByteArray): RcChannels {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val chan1Raw = buffer.decodeUInt16()
      val chan2Raw = buffer.decodeUInt16()
      val chan3Raw = buffer.decodeUInt16()
      val chan4Raw = buffer.decodeUInt16()
      val chan5Raw = buffer.decodeUInt16()
      val chan6Raw = buffer.decodeUInt16()
      val chan7Raw = buffer.decodeUInt16()
      val chan8Raw = buffer.decodeUInt16()
      val chan9Raw = buffer.decodeUInt16()
      val chan10Raw = buffer.decodeUInt16()
      val chan11Raw = buffer.decodeUInt16()
      val chan12Raw = buffer.decodeUInt16()
      val chan13Raw = buffer.decodeUInt16()
      val chan14Raw = buffer.decodeUInt16()
      val chan15Raw = buffer.decodeUInt16()
      val chan16Raw = buffer.decodeUInt16()
      val chan17Raw = buffer.decodeUInt16()
      val chan18Raw = buffer.decodeUInt16()
      val chancount = buffer.decodeUInt8()
      val rssi = buffer.decodeUInt8()

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
