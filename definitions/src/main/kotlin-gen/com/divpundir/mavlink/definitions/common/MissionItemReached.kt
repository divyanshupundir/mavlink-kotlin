package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * A certain mission item has been reached. The system will either hold this position (or circle on
 * the orbit) or (if the autocontinue on the WP was set) continue to the next waypoint.
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
  public override val instanceCompanion: MavMessage.MavCompanion<MissionItemReached> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(seq)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(seq)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<MissionItemReached> {
    private const val SIZE_V1: Int = 2

    private const val SIZE_V2: Int = 2

    public override val id: UInt = 46u

    public override val crcExtra: Byte = 11

    public override fun deserialize(source: BufferedSource): MissionItemReached {
      val seq = source.decodeUInt16()

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
