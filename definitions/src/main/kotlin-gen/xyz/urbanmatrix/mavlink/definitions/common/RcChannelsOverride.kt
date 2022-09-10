package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * The RAW values of the RC channels sent to the MAV to override info received from the RC radio.
 * The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%.
 * Individual receivers/transmitters might violate this specification.  Note carefully the semantic
 * differences between the first 8 channels and the subsequent channels
 */
@GeneratedMavMessage(
  id = 70,
  crc = 124,
)
public data class RcChannelsOverride(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * RC channel 1 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to
   * release this channel back to the RC radio.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan1Raw: Int = 0,
  /**
   * RC channel 2 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to
   * release this channel back to the RC radio.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan2Raw: Int = 0,
  /**
   * RC channel 3 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to
   * release this channel back to the RC radio.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan3Raw: Int = 0,
  /**
   * RC channel 4 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to
   * release this channel back to the RC radio.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan4Raw: Int = 0,
  /**
   * RC channel 5 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to
   * release this channel back to the RC radio.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan5Raw: Int = 0,
  /**
   * RC channel 6 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to
   * release this channel back to the RC radio.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan6Raw: Int = 0,
  /**
   * RC channel 7 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to
   * release this channel back to the RC radio.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan7Raw: Int = 0,
  /**
   * RC channel 8 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to
   * release this channel back to the RC radio.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan8Raw: Int = 0,
  /**
   * RC channel 9 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan9Raw: Int = 0,
  /**
   * RC channel 10 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan10Raw: Int = 0,
  /**
   * RC channel 11 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan11Raw: Int = 0,
  /**
   * RC channel 12 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan12Raw: Int = 0,
  /**
   * RC channel 13 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan13Raw: Int = 0,
  /**
   * RC channel 14 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan14Raw: Int = 0,
  /**
   * RC channel 15 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan15Raw: Int = 0,
  /**
   * RC channel 16 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan16Raw: Int = 0,
  /**
   * RC channel 17 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan17Raw: Int = 0,
  /**
   * RC channel 18 value. A value of 0 or UINT16_MAX means to ignore this field. A value of
   * UINT16_MAX-1 means to release this channel back to the RC radio.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chan18Raw: Int = 0,
) : MavMessage<RcChannelsOverride> {
  public override val instanceMetadata: MavMessage.Metadata<RcChannelsOverride> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(chan1Raw)
    outputBuffer.encodeUint16(chan2Raw)
    outputBuffer.encodeUint16(chan3Raw)
    outputBuffer.encodeUint16(chan4Raw)
    outputBuffer.encodeUint16(chan5Raw)
    outputBuffer.encodeUint16(chan6Raw)
    outputBuffer.encodeUint16(chan7Raw)
    outputBuffer.encodeUint16(chan8Raw)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(chan1Raw)
    outputBuffer.encodeUint16(chan2Raw)
    outputBuffer.encodeUint16(chan3Raw)
    outputBuffer.encodeUint16(chan4Raw)
    outputBuffer.encodeUint16(chan5Raw)
    outputBuffer.encodeUint16(chan6Raw)
    outputBuffer.encodeUint16(chan7Raw)
    outputBuffer.encodeUint16(chan8Raw)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint16(chan9Raw)
    outputBuffer.encodeUint16(chan10Raw)
    outputBuffer.encodeUint16(chan11Raw)
    outputBuffer.encodeUint16(chan12Raw)
    outputBuffer.encodeUint16(chan13Raw)
    outputBuffer.encodeUint16(chan14Raw)
    outputBuffer.encodeUint16(chan15Raw)
    outputBuffer.encodeUint16(chan16Raw)
    outputBuffer.encodeUint16(chan17Raw)
    outputBuffer.encodeUint16(chan18Raw)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 70

    private const val CRC: Int = 124

    private const val SIZE_V1: Int = 18

    private const val SIZE_V2: Int = 38

    private val DESERIALIZER: MavDeserializer<RcChannelsOverride> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val chan1Raw = inputBuffer.decodeUint16()
      val chan2Raw = inputBuffer.decodeUint16()
      val chan3Raw = inputBuffer.decodeUint16()
      val chan4Raw = inputBuffer.decodeUint16()
      val chan5Raw = inputBuffer.decodeUint16()
      val chan6Raw = inputBuffer.decodeUint16()
      val chan7Raw = inputBuffer.decodeUint16()
      val chan8Raw = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val chan9Raw = inputBuffer.decodeUint16()
      val chan10Raw = inputBuffer.decodeUint16()
      val chan11Raw = inputBuffer.decodeUint16()
      val chan12Raw = inputBuffer.decodeUint16()
      val chan13Raw = inputBuffer.decodeUint16()
      val chan14Raw = inputBuffer.decodeUint16()
      val chan15Raw = inputBuffer.decodeUint16()
      val chan16Raw = inputBuffer.decodeUint16()
      val chan17Raw = inputBuffer.decodeUint16()
      val chan18Raw = inputBuffer.decodeUint16()

      RcChannelsOverride(
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


    private val METADATA: MavMessage.Metadata<RcChannelsOverride> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RcChannelsOverride> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var chan1Raw: Int = 0

    public var chan2Raw: Int = 0

    public var chan3Raw: Int = 0

    public var chan4Raw: Int = 0

    public var chan5Raw: Int = 0

    public var chan6Raw: Int = 0

    public var chan7Raw: Int = 0

    public var chan8Raw: Int = 0

    public var chan9Raw: Int = 0

    public var chan10Raw: Int = 0

    public var chan11Raw: Int = 0

    public var chan12Raw: Int = 0

    public var chan13Raw: Int = 0

    public var chan14Raw: Int = 0

    public var chan15Raw: Int = 0

    public var chan16Raw: Int = 0

    public var chan17Raw: Int = 0

    public var chan18Raw: Int = 0

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
