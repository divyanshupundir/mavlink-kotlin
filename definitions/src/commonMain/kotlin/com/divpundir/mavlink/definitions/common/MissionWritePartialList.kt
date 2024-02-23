package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * This message is sent to the MAV to write a partial list. If start index == end index, only one
 * item will be transmitted / updated. If the start index is NOT 0 and above the current list size,
 * this request should be REJECTED!
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param startIndex Start index. Must be smaller / equal to the largest index of the current
 * onboard list.
 * @param endIndex End index, equal or greater than start index.
 * @param missionType Mission type.
 */
@GeneratedMavMessage(
  id = 38u,
  crcExtra = 9,
)
public data class MissionWritePartialList(
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
   * Start index. Must be smaller / equal to the largest index of the current onboard list.
   */
  @GeneratedMavField(type = "int16_t")
  public val startIndex: Short = 0,
  /**
   * End index, equal or greater than start index.
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
) : MavMessage<MissionWritePartialList> {
  override val instanceCompanion: MavMessage.MavCompanion<MissionWritePartialList> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt16(startIndex)
    encoder.encodeInt16(endIndex)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt16(startIndex)
    encoder.encodeInt16(endIndex)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(missionType.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MissionWritePartialList> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 7

    override val id: UInt = 38u

    override val crcExtra: Byte = 9

    override fun deserialize(bytes: ByteArray): MissionWritePartialList {
      val decoder = MavDataDecoder(bytes)

      val startIndex = decoder.safeDecodeInt16()
      val endIndex = decoder.safeDecodeInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val missionType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavMissionType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return MissionWritePartialList(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        startIndex = startIndex,
        endIndex = endIndex,
        missionType = missionType,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MissionWritePartialList =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var startIndex: Short = 0

    public var endIndex: Short = 0

    public var missionType: MavEnumValue<MavMissionType> = MavEnumValue.fromValue(0u)

    public fun build(): MissionWritePartialList = MissionWritePartialList(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      startIndex = startIndex,
      endIndex = endIndex,
      missionType = missionType,
    )
  }
}
