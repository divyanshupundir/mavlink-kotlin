package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

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

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt16(seq)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt16(seq)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MissionSetCurrent> {
    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 4

    public override val id: UInt = 41u

    public override val crcExtra: Byte = 28

    public override fun deserialize(bytes: ByteArray): MissionSetCurrent {
      val decoder = MavDataDecoder.wrap(bytes)

      val seq = decoder.safeDecodeUInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

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
