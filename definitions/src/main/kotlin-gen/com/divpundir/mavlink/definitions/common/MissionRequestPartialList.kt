package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt16
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
 * Request a partial list of mission items from the system/component.
 * https://mavlink.io/en/services/mission.html. If start and end index are the same, just send one
 * waypoint.
 */
@GeneratedMavMessage(
  id = 37u,
  crcExtra = -44,
)
public data class MissionRequestPartialList(
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
   * Start index
   */
  @GeneratedMavField(type = "int16_t")
  public val startIndex: Short = 0,
  /**
   * End index, -1 by default (-1: send list to end). Else a valid index of the list
   */
  @GeneratedMavField(type = "int16_t")
  public val endIndex: Short = 0,
  /**
   * Mission type.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val missionType: MavEnumValue<MavMissionType> = MavEnumValue.fromValue(0u),
) : MavMessage<MissionRequestPartialList> {
  public override val instanceCompanion: MavMessage.MavCompanion<MissionRequestPartialList> =
      Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeInt16(startIndex)
    output.encodeInt16(endIndex)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeInt16(startIndex)
    output.encodeInt16(endIndex)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeEnumValue(missionType.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<MissionRequestPartialList> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 7

    public override val id: UInt = 37u

    public override val crcExtra: Byte = -44

    public override fun deserialize(source: BufferedSource): MissionRequestPartialList {
      val startIndex = source.decodeInt16()
      val endIndex = source.decodeInt16()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val missionType = source.decodeEnumValue(1).let { value ->
        val entry = MavMissionType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return MissionRequestPartialList(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        startIndex = startIndex,
        endIndex = endIndex,
        missionType = missionType,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MissionRequestPartialList =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var startIndex: Short = 0

    public var endIndex: Short = 0

    public var missionType: MavEnumValue<MavMissionType> = MavEnumValue.fromValue(0u)

    public fun build(): MissionRequestPartialList = MissionRequestPartialList(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      startIndex = startIndex,
      endIndex = endIndex,
      missionType = missionType,
    )
  }
}
