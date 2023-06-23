package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Set the mission item with sequence number seq as current item. This means that the MAV will
 * continue to this mission item on the shortest path (not following the mission items in-between).
 */
@GeneratedMavMessage(
  id = 41u,
  crcExtra = 28,
)
public data class MissionSetCurrent(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Sequence
   */
  @GeneratedMavField(type = "uint16_t")
  public val seq: UShort = 0u,
) : MavMessage<MissionSetCurrent> {
  public override val instanceCompanion: MavMessage.MavCompanion<MissionSetCurrent> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(seq)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(seq)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<MissionSetCurrent> {
    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 4

    public override val id: UInt = 41u

    public override val crcExtra: Byte = 28

    public override fun deserialize(source: BufferedSource): MissionSetCurrent {
      val seq = source.decodeUInt16()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()

      return MissionSetCurrent(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        seq = seq,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MissionSetCurrent =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var seq: UShort = 0u

    public fun build(): MissionSetCurrent = MissionSetCurrent(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      seq = seq,
    )
  }
}
