package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Message that announces the sequence number of the current active mission item. The MAV will fly
 * towards this mission item.
 */
@GeneratedMavMessage(
  id = 42u,
  crcExtra = 28,
)
public data class MissionCurrent(
  /**
   * Sequence
   */
  @GeneratedMavField(type = "uint16_t")
  public val seq: UShort = 0u,
) : MavMessage<MissionCurrent> {
  public override val instanceCompanion: MavMessage.MavCompanion<MissionCurrent> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(seq)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(seq)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MissionCurrent> {
    public override val id: UInt = 42u

    public override val crcExtra: Byte = 28

    public override fun deserialize(bytes: ByteArray): MissionCurrent {
      val buffer = Buffer().write(bytes)

      val seq = buffer.decodeUInt16()

      return MissionCurrent(
        seq = seq,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MissionCurrent =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var seq: UShort = 0u

    public fun build(): MissionCurrent = MissionCurrent(
      seq = seq,
    )
  }
}
