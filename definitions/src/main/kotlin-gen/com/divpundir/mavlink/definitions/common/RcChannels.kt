package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
  public override val instanceMetadata: MavMessage.Metadata<RcChannels> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt16(chan1Raw)
    outputBuffer.encodeUInt16(chan2Raw)
    outputBuffer.encodeUInt16(chan3Raw)
    outputBuffer.encodeUInt16(chan4Raw)
    outputBuffer.encodeUInt16(chan5Raw)
    outputBuffer.encodeUInt16(chan6Raw)
    outputBuffer.encodeUInt16(chan7Raw)
    outputBuffer.encodeUInt16(chan8Raw)
    outputBuffer.encodeUInt16(chan9Raw)
    outputBuffer.encodeUInt16(chan10Raw)
    outputBuffer.encodeUInt16(chan11Raw)
    outputBuffer.encodeUInt16(chan12Raw)
    outputBuffer.encodeUInt16(chan13Raw)
    outputBuffer.encodeUInt16(chan14Raw)
    outputBuffer.encodeUInt16(chan15Raw)
    outputBuffer.encodeUInt16(chan16Raw)
    outputBuffer.encodeUInt16(chan17Raw)
    outputBuffer.encodeUInt16(chan18Raw)
    outputBuffer.encodeUInt8(chancount)
    outputBuffer.encodeUInt8(rssi)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt16(chan1Raw)
    outputBuffer.encodeUInt16(chan2Raw)
    outputBuffer.encodeUInt16(chan3Raw)
    outputBuffer.encodeUInt16(chan4Raw)
    outputBuffer.encodeUInt16(chan5Raw)
    outputBuffer.encodeUInt16(chan6Raw)
    outputBuffer.encodeUInt16(chan7Raw)
    outputBuffer.encodeUInt16(chan8Raw)
    outputBuffer.encodeUInt16(chan9Raw)
    outputBuffer.encodeUInt16(chan10Raw)
    outputBuffer.encodeUInt16(chan11Raw)
    outputBuffer.encodeUInt16(chan12Raw)
    outputBuffer.encodeUInt16(chan13Raw)
    outputBuffer.encodeUInt16(chan14Raw)
    outputBuffer.encodeUInt16(chan15Raw)
    outputBuffer.encodeUInt16(chan16Raw)
    outputBuffer.encodeUInt16(chan17Raw)
    outputBuffer.encodeUInt16(chan18Raw)
    outputBuffer.encodeUInt8(chancount)
    outputBuffer.encodeUInt8(rssi)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 65u

    private const val CRC_EXTRA: Byte = 118

    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    private val DESERIALIZER: MavDeserializer<RcChannels> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val chan1Raw = inputBuffer.decodeUInt16()
      val chan2Raw = inputBuffer.decodeUInt16()
      val chan3Raw = inputBuffer.decodeUInt16()
      val chan4Raw = inputBuffer.decodeUInt16()
      val chan5Raw = inputBuffer.decodeUInt16()
      val chan6Raw = inputBuffer.decodeUInt16()
      val chan7Raw = inputBuffer.decodeUInt16()
      val chan8Raw = inputBuffer.decodeUInt16()
      val chan9Raw = inputBuffer.decodeUInt16()
      val chan10Raw = inputBuffer.decodeUInt16()
      val chan11Raw = inputBuffer.decodeUInt16()
      val chan12Raw = inputBuffer.decodeUInt16()
      val chan13Raw = inputBuffer.decodeUInt16()
      val chan14Raw = inputBuffer.decodeUInt16()
      val chan15Raw = inputBuffer.decodeUInt16()
      val chan16Raw = inputBuffer.decodeUInt16()
      val chan17Raw = inputBuffer.decodeUInt16()
      val chan18Raw = inputBuffer.decodeUInt16()
      val chancount = inputBuffer.decodeUInt8()
      val rssi = inputBuffer.decodeUInt8()

      RcChannels(
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


    private val METADATA: MavMessage.Metadata<RcChannels> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RcChannels> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): RcChannels =
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
