package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * The RAW values of the RC channels received. The standard PPM modulation is as follows: 1000
 * microseconds: 0%, 2000 microseconds: 100%. A value of UINT16_MAX implies the channel is unused.
 * Individual receivers/transmitters might violate this specification.
 */
@GeneratedMavMessage(
  id = 35,
  crc = 244,
)
public data class RcChannelsRaw(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: Long = 0L,
  /**
   * Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk should use: 0 =
   * MAIN, 1 = AUX.
   */
  @GeneratedMavField(type = "uint8_t")
  public val port: Int = 0,
  /**
   * RC channel 1 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan1Raw: Int = 0,
  /**
   * RC channel 2 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan2Raw: Int = 0,
  /**
   * RC channel 3 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan3Raw: Int = 0,
  /**
   * RC channel 4 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan4Raw: Int = 0,
  /**
   * RC channel 5 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan5Raw: Int = 0,
  /**
   * RC channel 6 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan6Raw: Int = 0,
  /**
   * RC channel 7 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan7Raw: Int = 0,
  /**
   * RC channel 8 value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chan8Raw: Int = 0,
  /**
   * Receive signal strength indicator in device-dependent units/scale. Values: [0-254], UINT8_MAX:
   * invalid/unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rssi: Int = 0,
) : MavMessage<RcChannelsRaw> {
  public override val instanceMetadata: MavMessage.Metadata<RcChannelsRaw> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeUint16(chan1Raw)
    outputBuffer.encodeUint16(chan2Raw)
    outputBuffer.encodeUint16(chan3Raw)
    outputBuffer.encodeUint16(chan4Raw)
    outputBuffer.encodeUint16(chan5Raw)
    outputBuffer.encodeUint16(chan6Raw)
    outputBuffer.encodeUint16(chan7Raw)
    outputBuffer.encodeUint16(chan8Raw)
    outputBuffer.encodeUint8(port)
    outputBuffer.encodeUint8(rssi)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeUint16(chan1Raw)
    outputBuffer.encodeUint16(chan2Raw)
    outputBuffer.encodeUint16(chan3Raw)
    outputBuffer.encodeUint16(chan4Raw)
    outputBuffer.encodeUint16(chan5Raw)
    outputBuffer.encodeUint16(chan6Raw)
    outputBuffer.encodeUint16(chan7Raw)
    outputBuffer.encodeUint16(chan8Raw)
    outputBuffer.encodeUint8(port)
    outputBuffer.encodeUint8(rssi)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 35

    private const val CRC: Int = 244

    private const val SIZE: Int = 22

    private val DESERIALIZER: MavDeserializer<RcChannelsRaw> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val chan1Raw = inputBuffer.decodeUint16()
      val chan2Raw = inputBuffer.decodeUint16()
      val chan3Raw = inputBuffer.decodeUint16()
      val chan4Raw = inputBuffer.decodeUint16()
      val chan5Raw = inputBuffer.decodeUint16()
      val chan6Raw = inputBuffer.decodeUint16()
      val chan7Raw = inputBuffer.decodeUint16()
      val chan8Raw = inputBuffer.decodeUint16()
      val port = inputBuffer.decodeUint8()
      val rssi = inputBuffer.decodeUint8()

      RcChannelsRaw(
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


    private val METADATA: MavMessage.Metadata<RcChannelsRaw> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RcChannelsRaw> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var port: Int = 0

    public var chan1Raw: Int = 0

    public var chan2Raw: Int = 0

    public var chan3Raw: Int = 0

    public var chan4Raw: Int = 0

    public var chan5Raw: Int = 0

    public var chan6Raw: Int = 0

    public var chan7Raw: Int = 0

    public var chan8Raw: Int = 0

    public var rssi: Int = 0

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
