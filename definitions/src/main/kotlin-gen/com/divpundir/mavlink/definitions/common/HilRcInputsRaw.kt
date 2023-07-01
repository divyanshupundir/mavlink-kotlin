package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit

/**
 * Sent from simulation to autopilot. The RAW values of the RC channels received. The standard PPM
 * modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual
 * receivers/transmitters might violate this specification.
 */
@GeneratedMavMessage(
  id = 92u,
  crcExtra = 54,
)
public data class HilRcInputsRaw(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * RC channel 1 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan1Raw: UShort = 0u,
  /**
   * RC channel 2 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan2Raw: UShort = 0u,
  /**
   * RC channel 3 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan3Raw: UShort = 0u,
  /**
   * RC channel 4 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan4Raw: UShort = 0u,
  /**
   * RC channel 5 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan5Raw: UShort = 0u,
  /**
   * RC channel 6 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan6Raw: UShort = 0u,
  /**
   * RC channel 7 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan7Raw: UShort = 0u,
  /**
   * RC channel 8 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan8Raw: UShort = 0u,
  /**
   * RC channel 9 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan9Raw: UShort = 0u,
  /**
   * RC channel 10 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan10Raw: UShort = 0u,
  /**
   * RC channel 11 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan11Raw: UShort = 0u,
  /**
   * RC channel 12 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan12Raw: UShort = 0u,
  /**
   * Receive signal strength indicator in device-dependent units/scale. Values: [0-254], UINT8_MAX:
   * invalid/unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rssi: UByte = 0u,
) : MavMessage<HilRcInputsRaw> {
  public override val instanceCompanion: MavMessage.MavCompanion<HilRcInputsRaw> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
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
    encoder.encodeUInt8(rssi)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
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
    encoder.encodeUInt8(rssi)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HilRcInputsRaw> {
    private const val SIZE_V1: Int = 33

    private const val SIZE_V2: Int = 33

    public override val id: UInt = 92u

    public override val crcExtra: Byte = 54

    public override fun deserialize(bytes: ByteArray): HilRcInputsRaw {
      val decoder = MavDataDecoder.wrap(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
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
      val rssi = decoder.safeDecodeUInt8()

      return HilRcInputsRaw(
        timeUsec = timeUsec,
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
        rssi = rssi,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): HilRcInputsRaw =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

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

    public var rssi: UByte = 0u

    public fun build(): HilRcInputsRaw = HilRcInputsRaw(
      timeUsec = timeUsec,
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
      rssi = rssi,
    )
  }
}
