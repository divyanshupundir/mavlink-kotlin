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
import kotlin.ByteArray
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt16(startIndex)
    buffer.encodeInt16(endIndex)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt16(startIndex)
    buffer.encodeInt16(endIndex)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeEnumValue(missionType.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MissionRequestPartialList> {
    public override val id: UInt = 37u

    public override val crcExtra: Byte = -44

    public override fun deserialize(bytes: ByteArray): MissionRequestPartialList {
      val buffer = Buffer().write(bytes)

      val startIndex = buffer.decodeInt16()
      val endIndex = buffer.decodeInt16()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val missionType = buffer.decodeEnumValue(1).let { value ->
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
