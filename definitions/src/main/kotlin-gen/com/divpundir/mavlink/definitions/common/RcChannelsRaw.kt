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
 * The RAW values of the RC channels received. The standard PPM modulation is as follows: 1000
 * microseconds: 0%, 2000 microseconds: 100%. A value of UINT16_MAX implies the channel is unused.
 * Individual receivers/transmitters might violate this specification.
 */
@GeneratedMavMessage(
  id = 35u,
  crcExtra = -12,
)
public data class RcChannelsRaw(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk should use: 0 =
   * MAIN, 1 = AUX.
   */
  @GeneratedMavField(type = "uint8_t")
  public val port: UByte = 0u,
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
   * Receive signal strength indicator in device-dependent units/scale. Values: [0-254], UINT8_MAX:
   * invalid/unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rssi: UByte = 0u,
) : MavMessage<RcChannelsRaw> {
  public override val instanceCompanion: MavMessage.MavCompanion<RcChannelsRaw> = Companion

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
    buffer.encodeUInt8(port)
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
    buffer.encodeUInt8(port)
    buffer.encodeUInt8(rssi)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RcChannelsRaw> {
    public override val id: UInt = 35u

    public override val crcExtra: Byte = -12

    public override fun deserialize(bytes: ByteArray): RcChannelsRaw {
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
      val port = buffer.decodeUInt8()
      val rssi = buffer.decodeUInt8()

      return RcChannelsRaw(
        timeBootMs = timeBootMs,
        port = port,
        chan1Raw = chan1Raw,
        chan2Raw = chan2Raw,
        chan3Raw = chan3Raw,
        chan4Raw = chan4Raw,
        chan5Raw = chan5Raw,
        chan6Raw = chan6Raw,
        chan7Raw = chan7Raw,
        chan8Raw = chan8Raw,
        rssi = rssi,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RcChannelsRaw =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var port: UByte = 0u

    public var chan1Raw: UShort = 0u

    public var chan2Raw: UShort = 0u

    public var chan3Raw: UShort = 0u

    public var chan4Raw: UShort = 0u

    public var chan5Raw: UShort = 0u

    public var chan6Raw: UShort = 0u

    public var chan7Raw: UShort = 0u

    public var chan8Raw: UShort = 0u

    public var rssi: UByte = 0u

    public fun build(): RcChannelsRaw = RcChannelsRaw(
      timeBootMs = timeBootMs,
      port = port,
      chan1Raw = chan1Raw,
      chan2Raw = chan2Raw,
      chan3Raw = chan3Raw,
      chan4Raw = chan4Raw,
      chan5Raw = chan5Raw,
      chan6Raw = chan6Raw,
      chan7Raw = chan7Raw,
      chan8Raw = chan8Raw,
      rssi = rssi,
    )
  }
}
