package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Reports the on/off state of relays, as controlled by MAV_CMD_DO_SET_RELAY.
 *         Message streaming should be requested using MAV_CMD_SET_MESSAGE_INTERVAL.
 *         Note that it should not be sent on every relay state change to avoid flooding the link.
 *       
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param on Relay states. Relay instance numbers are represented as individual bits in this mask by offset.
 * @param present Relay present. Relay instance numbers are represented as individual bits in this mask by offset.  Bits will be true if a relay instance is configured.
 */
@GeneratedMavMessage(
  id = 376u,
  crcExtra = -57,
)
public data class RelayStatus(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(
    type = "uint32_t",
    units = "ms",
  )
  public val timeBootMs: UInt = 0u,
  /**
   * Relay states. Relay instance numbers are represented as individual bits in this mask by offset.
   */
  @GeneratedMavField(
    type = "uint16_t",
    display = "bitmask",
  )
  public val on: UShort = 0u,
  /**
   * Relay present. Relay instance numbers are represented as individual bits in this mask by offset.  Bits will be true if a relay instance is configured.
   */
  @GeneratedMavField(
    type = "uint16_t",
    display = "bitmask",
  )
  public val present: UShort = 0u,
) : MavMessage<RelayStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<RelayStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt16(on)
    encoder.encodeUInt16(present)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt16(on)
    encoder.encodeUInt16(present)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RelayStatus> {
    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    override val id: UInt = 376u

    override val crcExtra: Byte = -57

    override fun deserialize(bytes: ByteArray): RelayStatus {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val on = decoder.safeDecodeUInt16()
      val present = decoder.safeDecodeUInt16()

      return RelayStatus(
        timeBootMs = timeBootMs,
        on = on,
        present = present,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RelayStatus = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var on: UShort = 0u

    public var present: UShort = 0u

    public fun build(): RelayStatus = RelayStatus(
      timeBootMs = timeBootMs,
      on = on,
      present = present,
    )
  }
}
