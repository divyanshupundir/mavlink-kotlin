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
 * The RAW values of the RC channels received. The standard PPM modulation is as follows: 1000
 * microseconds: 0%, 2000 microseconds: 100%. A value of UINT16_MAX implies the channel is unused.
 * Individual receivers/transmitters might violate this specification.
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param port Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk
 * should use: 0 = MAIN, 1 = AUX.
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
 * @param rssi Receive signal strength indicator in device-dependent units/scale. Values: [0-254],
 * UINT8_MAX: invalid/unknown.
 */
@GeneratedMavMessage(
  id = 35u,
  crcExtra = -12,
)
public data class RcChannelsRaw(
  /**
   * Timestamp (time since system boot).
   * units = ms
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
   * Receive signal strength indicator in device-dependent units/scale. Values: [0-254], UINT8_MAX:
   * invalid/unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rssi: UByte = 0u,
) : MavMessage<RcChannelsRaw> {
  override val instanceCompanion: MavMessage.MavCompanion<RcChannelsRaw> = Companion

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
    encoder.encodeUInt8(port)
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
    encoder.encodeUInt8(port)
    encoder.encodeUInt8(rssi)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RcChannelsRaw> {
    private const val SIZE_V1: Int = 22

    private const val SIZE_V2: Int = 22

    override val id: UInt = 35u

    override val crcExtra: Byte = -12

    override fun deserialize(bytes: ByteArray): RcChannelsRaw {
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
      val port = decoder.safeDecodeUInt8()
      val rssi = decoder.safeDecodeUInt8()

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
