package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeInt16Array
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeInt16Array
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Radio channels. Supports up to 24 channels. Channel values are in centerd 13 bit format. Range is
 * [-4096,4096], center is 0. Conversion to PWM is x * 5/32 + 1500. Should be emitted only by
 * components with component id MAV_COMP_ID_TELEMETRY_RADIO.
 *
 * @param count Total number of RC channels being received. This can be larger than 24, indicating
 * that more channels are available but not given in this message.
 * @param flags Radio channels status flags.
 * @param channels RC channels. Channels above count should be set to 0, to benefit from MAVLink's
 * zero padding.
 */
@GeneratedMavMessage(
  id = 60_045u,
  crcExtra = 89,
)
public data class RadioRcChannels(
  /**
   * Total number of RC channels being received. This can be larger than 24, indicating that more
   * channels are available but not given in this message.
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: UByte = 0u,
  /**
   * Radio channels status flags.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavBitmaskValue<RadioRcChannelsFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * RC channels. Channels above count should be set to 0, to benefit from MAVLink's zero padding.
   */
  @GeneratedMavField(
    type = "int16_t[24]",
    extension = true,
  )
  public val channels: List<Short> = emptyList(),
) : MavMessage<RadioRcChannels> {
  override val instanceCompanion: MavMessage.MavCompanion<RadioRcChannels> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(count)
    encoder.encodeBitmaskValue(flags.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(count)
    encoder.encodeBitmaskValue(flags.value, 1)
    encoder.encodeInt16Array(channels, 48)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RadioRcChannels> {
    private const val SIZE_V1: Int = 2

    private const val SIZE_V2: Int = 50

    override val id: UInt = 60_045u

    override val crcExtra: Byte = 89

    override fun deserialize(bytes: ByteArray): RadioRcChannels {
      val decoder = MavDataDecoder(bytes)

      val count = decoder.safeDecodeUInt8()
      val flags = decoder.safeDecodeBitmaskValue(1).let { value ->
        val flags = RadioRcChannelsFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val channels = decoder.safeDecodeInt16Array(48)

      return RadioRcChannels(
        count = count,
        flags = flags,
        channels = channels,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RadioRcChannels =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var count: UByte = 0u

    public var flags: MavBitmaskValue<RadioRcChannelsFlags> = MavBitmaskValue.fromValue(0u)

    public var channels: List<Short> = emptyList()

    public fun build(): RadioRcChannels = RadioRcChannels(
      count = count,
      flags = flags,
      channels = channels,
    )
  }
}
