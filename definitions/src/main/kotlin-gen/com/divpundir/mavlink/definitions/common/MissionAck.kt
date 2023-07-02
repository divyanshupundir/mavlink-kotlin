package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Acknowledgment message during waypoint handling. The type field states if this message is a
 * positive ack (type=0) or if an error happened (type=non-zero).
 */
@GeneratedMavMessage(
  id = 47u,
  crcExtra = -103,
)
public data class MissionAck(
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
   * Mission result.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: MavEnumValue<MavMissionResult> = MavEnumValue.fromValue(0u),
  /**
   * Mission type.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val missionType: MavEnumValue<MavMissionType> = MavEnumValue.fromValue(0u),
) : MavMessage<MissionAck> {
  public override val instanceCompanion: MavMessage.MavCompanion<MissionAck> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(type.value, 1)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeEnumValue(missionType.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MissionAck> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 4

    public override val id: UInt = 47u

    public override val crcExtra: Byte = -103

    public override fun deserialize(bytes: ByteArray): MissionAck {
      val decoder = MavDataDecoder.wrap(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val type = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavMissionResult.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val missionType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavMissionType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return MissionAck(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        type = type,
        missionType = missionType,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MissionAck =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var type: MavEnumValue<MavMissionResult> = MavEnumValue.fromValue(0u)

    public var missionType: MavEnumValue<MavMissionType> = MavEnumValue.fromValue(0u)

    public fun build(): MissionAck = MissionAck(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      type = type,
      missionType = missionType,
    )
  }
}
