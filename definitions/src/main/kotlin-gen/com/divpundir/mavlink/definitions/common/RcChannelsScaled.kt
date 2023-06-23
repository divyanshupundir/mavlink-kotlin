package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * The scaled values of the RC channels received: (-100%) -10000, (0%) 0, (100%) 10000. Channels
 * that are inactive should be set to UINT16_MAX.
 */
@GeneratedMavMessage(
  id = 34u,
  crcExtra = -19,
)
public data class RcChannelsScaled(
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
  public override val instanceCompanion: MavMessage.MavCompanion<RcChannelsScaled> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeInt16(chan1Scaled)
    output.encodeInt16(chan2Scaled)
    output.encodeInt16(chan3Scaled)
    output.encodeInt16(chan4Scaled)
    output.encodeInt16(chan5Scaled)
    output.encodeInt16(chan6Scaled)
    output.encodeInt16(chan7Scaled)
    output.encodeInt16(chan8Scaled)
    output.encodeUInt8(port)
    output.encodeUInt8(rssi)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeInt16(chan1Scaled)
    output.encodeInt16(chan2Scaled)
    output.encodeInt16(chan3Scaled)
    output.encodeInt16(chan4Scaled)
    output.encodeInt16(chan5Scaled)
    output.encodeInt16(chan6Scaled)
    output.encodeInt16(chan7Scaled)
    output.encodeInt16(chan8Scaled)
    output.encodeUInt8(port)
    output.encodeUInt8(rssi)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<RcChannelsScaled> {
    private const val SIZE_V1: Int = 22

    private const val SIZE_V2: Int = 22

    public override val id: UInt = 34u

    public override val crcExtra: Byte = -19

    public override fun deserialize(source: BufferedSource): RcChannelsScaled {
      val timeBootMs = source.decodeUInt32()
      val chan1Scaled = source.decodeInt16()
      val chan2Scaled = source.decodeInt16()
      val chan3Scaled = source.decodeInt16()
      val chan4Scaled = source.decodeInt16()
      val chan5Scaled = source.decodeInt16()
      val chan6Scaled = source.decodeInt16()
      val chan7Scaled = source.decodeInt16()
      val chan8Scaled = source.decodeInt16()
      val port = source.decodeUInt8()
      val rssi = source.decodeUInt8()

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
