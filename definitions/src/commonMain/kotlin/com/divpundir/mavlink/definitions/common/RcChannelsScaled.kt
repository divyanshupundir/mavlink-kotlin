package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * The scaled values of the RC channels received: (-100%) -10000, (0%) 0, (100%) 10000. Channels
 * that are inactive should be set to INT16_MAX.
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param port Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk
 * should use: 0 = MAIN, 1 = AUX.
 * @param chan1Scaled RC channel 1 value scaled.
 * @param chan2Scaled RC channel 2 value scaled.
 * @param chan3Scaled RC channel 3 value scaled.
 * @param chan4Scaled RC channel 4 value scaled.
 * @param chan5Scaled RC channel 5 value scaled.
 * @param chan6Scaled RC channel 6 value scaled.
 * @param chan7Scaled RC channel 7 value scaled.
 * @param chan8Scaled RC channel 8 value scaled.
 * @param rssi Receive signal strength indicator in device-dependent units/scale. Values: [0-254],
 * UINT8_MAX: invalid/unknown.
 */
@GeneratedMavMessage(
  id = 34u,
  crcExtra = -19,
)
public data class RcChannelsScaled(
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
   * RC channel 1 value scaled.
   */
  @GeneratedMavField(type = "int16_t")
  public val chan1Scaled: Short = 0,
  /**
   * RC channel 2 value scaled.
   */
  @GeneratedMavField(type = "int16_t")
  public val chan2Scaled: Short = 0,
  /**
   * RC channel 3 value scaled.
   */
  @GeneratedMavField(type = "int16_t")
  public val chan3Scaled: Short = 0,
  /**
   * RC channel 4 value scaled.
   */
  @GeneratedMavField(type = "int16_t")
  public val chan4Scaled: Short = 0,
  /**
   * RC channel 5 value scaled.
   */
  @GeneratedMavField(type = "int16_t")
  public val chan5Scaled: Short = 0,
  /**
   * RC channel 6 value scaled.
   */
  @GeneratedMavField(type = "int16_t")
  public val chan6Scaled: Short = 0,
  /**
   * RC channel 7 value scaled.
   */
  @GeneratedMavField(type = "int16_t")
  public val chan7Scaled: Short = 0,
  /**
   * RC channel 8 value scaled.
   */
  @GeneratedMavField(type = "int16_t")
  public val chan8Scaled: Short = 0,
  /**
   * Receive signal strength indicator in device-dependent units/scale. Values: [0-254], UINT8_MAX:
   * invalid/unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rssi: UByte = 0u,
) : MavMessage<RcChannelsScaled> {
  override val instanceCompanion: MavMessage.MavCompanion<RcChannelsScaled> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt16(chan1Scaled)
    encoder.encodeInt16(chan2Scaled)
    encoder.encodeInt16(chan3Scaled)
    encoder.encodeInt16(chan4Scaled)
    encoder.encodeInt16(chan5Scaled)
    encoder.encodeInt16(chan6Scaled)
    encoder.encodeInt16(chan7Scaled)
    encoder.encodeInt16(chan8Scaled)
    encoder.encodeUInt8(port)
    encoder.encodeUInt8(rssi)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt16(chan1Scaled)
    encoder.encodeInt16(chan2Scaled)
    encoder.encodeInt16(chan3Scaled)
    encoder.encodeInt16(chan4Scaled)
    encoder.encodeInt16(chan5Scaled)
    encoder.encodeInt16(chan6Scaled)
    encoder.encodeInt16(chan7Scaled)
    encoder.encodeInt16(chan8Scaled)
    encoder.encodeUInt8(port)
    encoder.encodeUInt8(rssi)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RcChannelsScaled> {
    private const val SIZE_V1: Int = 22

    private const val SIZE_V2: Int = 22

    override val id: UInt = 34u

    override val crcExtra: Byte = -19

    override fun deserialize(bytes: ByteArray): RcChannelsScaled {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val chan1Scaled = decoder.safeDecodeInt16()
      val chan2Scaled = decoder.safeDecodeInt16()
      val chan3Scaled = decoder.safeDecodeInt16()
      val chan4Scaled = decoder.safeDecodeInt16()
      val chan5Scaled = decoder.safeDecodeInt16()
      val chan6Scaled = decoder.safeDecodeInt16()
      val chan7Scaled = decoder.safeDecodeInt16()
      val chan8Scaled = decoder.safeDecodeInt16()
      val port = decoder.safeDecodeUInt8()
      val rssi = decoder.safeDecodeUInt8()

      return RcChannelsScaled(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): RcChannelsScaled =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var port: UByte = 0u

    public var chan1Scaled: Short = 0

    public var chan2Scaled: Short = 0

    public var chan3Scaled: Short = 0

    public var chan4Scaled: Short = 0

    public var chan5Scaled: Short = 0

    public var chan6Scaled: Short = 0

    public var chan7Scaled: Short = 0

    public var chan8Scaled: Short = 0

    public var rssi: UByte = 0u

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
