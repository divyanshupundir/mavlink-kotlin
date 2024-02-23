package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * A certain mission item has been reached. The system will either hold this position (or circle on
 * the orbit) or (if the autocontinue on the WP was set) continue to the next waypoint.
 *
 * @param seq Sequence
 */
@GeneratedMavMessage(
  id = 46u,
  crcExtra = 11,
)
public data class MissionItemReached(
  /**
   * Sequence
   */
  @GeneratedMavField(type = "uint16_t")
  public val seq: UShort = 0u,
) : MavMessage<MissionItemReached> {
  override val instanceCompanion: MavMessage.MavCompanion<MissionItemReached> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(seq)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(seq)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MissionItemReached> {
    private const val SIZE_V1: Int = 2

    private const val SIZE_V2: Int = 2

    override val id: UInt = 46u

    override val crcExtra: Byte = 11

    override fun deserialize(bytes: ByteArray): MissionItemReached {
      val decoder = MavDataDecoder(bytes)

      val seq = decoder.safeDecodeUInt16()

      return MissionItemReached(
        seq = seq,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MissionItemReached =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var seq: UShort = 0u

    public fun build(): MissionItemReached = MissionItemReached(
      seq = seq,
    )
  }
}
