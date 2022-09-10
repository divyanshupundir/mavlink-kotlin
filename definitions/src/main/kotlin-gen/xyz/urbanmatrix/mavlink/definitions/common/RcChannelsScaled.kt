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
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * The scaled values of the RC channels received: (-100%) -10000, (0%) 0, (100%) 10000. Channels
 * that are inactive should be set to UINT16_MAX.
 */
@GeneratedMavMessage(
  id = 34,
  crc = 237,
)
public data class RcChannelsScaled(
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
   * RC channel 1 value scaled.
   */
  @GeneratedMavField(type = "int16_t")
  public val chan1Scaled: Int = 0,
  /**
   * RC channel 2 value scaled.
   */
  @GeneratedMavField(type = "int16_t")
  public val chan2Scaled: Int = 0,
  /**
   * RC channel 3 value scaled.
   */
  @GeneratedMavField(type = "int16_t")
  public val chan3Scaled: Int = 0,
  /**
   * RC channel 4 value scaled.
   */
  @GeneratedMavField(type = "int16_t")
  public val chan4Scaled: Int = 0,
  /**
   * RC channel 5 value scaled.
   */
  @GeneratedMavField(type = "int16_t")
  public val chan5Scaled: Int = 0,
  /**
   * RC channel 6 value scaled.
   */
  @GeneratedMavField(type = "int16_t")
  public val chan6Scaled: Int = 0,
  /**
   * RC channel 7 value scaled.
   */
  @GeneratedMavField(type = "int16_t")
  public val chan7Scaled: Int = 0,
  /**
   * RC channel 8 value scaled.
   */
  @GeneratedMavField(type = "int16_t")
  public val chan8Scaled: Int = 0,
  /**
   * Receive signal strength indicator in device-dependent units/scale. Values: [0-254], UINT8_MAX:
   * invalid/unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rssi: Int = 0,
) : MavMessage<RcChannelsScaled> {
  public override val instanceMetadata: MavMessage.Metadata<RcChannelsScaled> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt16(chan1Scaled)
    outputBuffer.encodeInt16(chan2Scaled)
    outputBuffer.encodeInt16(chan3Scaled)
    outputBuffer.encodeInt16(chan4Scaled)
    outputBuffer.encodeInt16(chan5Scaled)
    outputBuffer.encodeInt16(chan6Scaled)
    outputBuffer.encodeInt16(chan7Scaled)
    outputBuffer.encodeInt16(chan8Scaled)
    outputBuffer.encodeUint8(port)
    outputBuffer.encodeUint8(rssi)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt16(chan1Scaled)
    outputBuffer.encodeInt16(chan2Scaled)
    outputBuffer.encodeInt16(chan3Scaled)
    outputBuffer.encodeInt16(chan4Scaled)
    outputBuffer.encodeInt16(chan5Scaled)
    outputBuffer.encodeInt16(chan6Scaled)
    outputBuffer.encodeInt16(chan7Scaled)
    outputBuffer.encodeInt16(chan8Scaled)
    outputBuffer.encodeUint8(port)
    outputBuffer.encodeUint8(rssi)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 34

    private const val CRC: Int = 237

    private const val SIZE_V1: Int = 22

    private const val SIZE_V2: Int = 22

    private val DESERIALIZER: MavDeserializer<RcChannelsScaled> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val chan1Scaled = inputBuffer.decodeInt16()
      val chan2Scaled = inputBuffer.decodeInt16()
      val chan3Scaled = inputBuffer.decodeInt16()
      val chan4Scaled = inputBuffer.decodeInt16()
      val chan5Scaled = inputBuffer.decodeInt16()
      val chan6Scaled = inputBuffer.decodeInt16()
      val chan7Scaled = inputBuffer.decodeInt16()
      val chan8Scaled = inputBuffer.decodeInt16()
      val port = inputBuffer.decodeUint8()
      val rssi = inputBuffer.decodeUint8()

      RcChannelsScaled(
        timeBootMs = timeBootMs,
        port = port,
        chan1Scaled = chan1Scaled,
        chan2Scaled = chan2Scaled,
        chan3Scaled = chan3Scaled,
        chan4Scaled = chan4Scaled,
        chan5Scaled = chan5Scaled,
        chan6Scaled = chan6Scaled,
        chan7Scaled = chan7Scaled,
        chan8Scaled = chan8Scaled,
        rssi = rssi,
      )
    }


    private val METADATA: MavMessage.Metadata<RcChannelsScaled> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RcChannelsScaled> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var port: Int = 0

    public var chan1Scaled: Int = 0

    public var chan2Scaled: Int = 0

    public var chan3Scaled: Int = 0

    public var chan4Scaled: Int = 0

    public var chan5Scaled: Int = 0

    public var chan6Scaled: Int = 0

    public var chan7Scaled: Int = 0

    public var chan8Scaled: Int = 0

    public var rssi: Int = 0

    public fun build(): RcChannelsScaled = RcChannelsScaled(
      timeBootMs = timeBootMs,
      port = port,
      chan1Scaled = chan1Scaled,
      chan2Scaled = chan2Scaled,
      chan3Scaled = chan3Scaled,
      chan4Scaled = chan4Scaled,
      chan5Scaled = chan5Scaled,
      chan6Scaled = chan6Scaled,
      chan7Scaled = chan7Scaled,
      chan8Scaled = chan8Scaled,
      rssi = rssi,
    )
  }
}
