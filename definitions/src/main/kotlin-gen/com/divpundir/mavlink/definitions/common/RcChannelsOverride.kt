package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
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
 * The RAW values of the RC channels sent to the MAV to override info received from the RC radio.
 * The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%.
 * Individual receivers/transmitters might violate this specification.  Note carefully the semantic
 * differences between the first 8 channels and the subsequent channels
 */
@GeneratedMavMessage(
  id = 70u,
  crcExtra = 124,
)
public data class RcChannelsOverride(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * RC channel 1 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to
   * release this channel back to the RC radio.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan1Raw: UShort = 0u,
  /**
   * RC channel 2 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to
   * release this channel back to the RC radio.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan2Raw: UShort = 0u,
  /**
   * RC channel 3 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to
   * release this channel back to the RC radio.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan3Raw: UShort = 0u,
  /**
   * RC channel 4 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to
   * release this channel back to the RC radio.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan4Raw: UShort = 0u,
  /**
   * RC channel 5 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to
   * release this channel back to the RC radio.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan5Raw: UShort = 0u,
  /**
   * RC channel 6 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to
   * release this channel back to the RC radio.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan6Raw: UShort = 0u,
  /**
   * RC channel 7 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to
   * release this channel back to the RC radio.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan7Raw: UShort = 0u,
  /**
   * RC channel 8 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to
   * release this channel back to the RC radio.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan8Raw: UShort = 0u,
  /**
   * RC channel 9 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan9Raw: UShort = 0u,
  /**
   * RC channel 10 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan10Raw: UShort = 0u,
  /**
   * RC channel 11 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan11Raw: UShort = 0u,
  /**
   * RC channel 12 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan12Raw: UShort = 0u,
  /**
   * RC channel 13 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan13Raw: UShort = 0u,
  /**
   * RC channel 14 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan14Raw: UShort = 0u,
  /**
   * RC channel 15 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan15Raw: UShort = 0u,
  /**
   * RC channel 16 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan16Raw: UShort = 0u,
  /**
   * RC channel 17 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan17Raw: UShort = 0u,
  /**
   * RC channel 18 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan18Raw: UShort = 0u,
) : MavMessage<RcChannelsOverride> {
  public override val instanceCompanion: MavMessage.MavCompanion<RcChannelsOverride> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(chan1Raw)
    buffer.encodeUInt16(chan2Raw)
    buffer.encodeUInt16(chan3Raw)
    buffer.encodeUInt16(chan4Raw)
    buffer.encodeUInt16(chan5Raw)
    buffer.encodeUInt16(chan6Raw)
    buffer.encodeUInt16(chan7Raw)
    buffer.encodeUInt16(chan8Raw)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(chan1Raw)
    buffer.encodeUInt16(chan2Raw)
    buffer.encodeUInt16(chan3Raw)
    buffer.encodeUInt16(chan4Raw)
    buffer.encodeUInt16(chan5Raw)
    buffer.encodeUInt16(chan6Raw)
    buffer.encodeUInt16(chan7Raw)
    buffer.encodeUInt16(chan8Raw)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
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
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RcChannelsOverride> {
    public override val id: UInt = 70u

    public override val crcExtra: Byte = 124

    public override fun deserialize(bytes: ByteArray): RcChannelsOverride {
      val buffer = Buffer().write(bytes)

      val chan1Raw = buffer.decodeUInt16()
      val chan2Raw = buffer.decodeUInt16()
      val chan3Raw = buffer.decodeUInt16()
      val chan4Raw = buffer.decodeUInt16()
      val chan5Raw = buffer.decodeUInt16()
      val chan6Raw = buffer.decodeUInt16()
      val chan7Raw = buffer.decodeUInt16()
      val chan8Raw = buffer.decodeUInt16()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
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

      return RcChannelsOverride(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
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
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RcChannelsOverride =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

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

    public fun build(): RcChannelsOverride = RcChannelsOverride(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
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
    )
  }
}
