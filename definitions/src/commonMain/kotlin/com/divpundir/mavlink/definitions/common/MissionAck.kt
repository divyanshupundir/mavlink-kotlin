package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt32
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
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param type Mission result.
 * @param missionType Mission type.
 * @param opaqueId Id of new on-vehicle mission, fence, or rally point plan (on upload to vehicle).
 *         The id is calculated and returned by a vehicle when a new plan is uploaded by a GCS.
 *         The only requirement on the id is that it must change when there is any change to the
 * on-vehicle plan type (there is no requirement that the id be globally unique).
 *         0 on download from the vehicle to the GCS (on download the ID is set in MISSION_COUNT).
 *         0 if plan ids are not supported.
 *         The current on-vehicle plan ids are streamed in `MISSION_CURRENT`, allowing a GCS to
 * determine if any part of the plan has changed and needs to be re-uploaded.
 *       
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
  /**
   * Id of new on-vehicle mission, fence, or rally point plan (on upload to vehicle).
   *         The id is calculated and returned by a vehicle when a new plan is uploaded by a GCS.
   *         The only requirement on the id is that it must change when there is any change to the
   * on-vehicle plan type (there is no requirement that the id be globally unique).
   *         0 on download from the vehicle to the GCS (on download the ID is set in MISSION_COUNT).
   *         0 if plan ids are not supported.
   *         The current on-vehicle plan ids are streamed in `MISSION_CURRENT`, allowing a GCS to
   * determine if any part of the plan has changed and needs to be re-uploaded.
   *       
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val opaqueId: UInt = 0u,
) : MavMessage<MissionAck> {
  override val instanceCompanion: MavMessage.MavCompanion<MissionAck> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(type.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeEnumValue(missionType.value, 1)
    encoder.encodeUInt32(opaqueId)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MissionAck> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 8

    override val id: UInt = 47u

    override val crcExtra: Byte = -103

    override fun deserialize(bytes: ByteArray): MissionAck {
      val decoder = MavDataDecoder(bytes)

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
      val opaqueId = decoder.safeDecodeUInt32()

      return MissionAck(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        type = type,
        missionType = missionType,
        opaqueId = opaqueId,
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

    public var opaqueId: UInt = 0u

    public fun build(): MissionAck = MissionAck(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      type = type,
      missionType = missionType,
      opaqueId = opaqueId,
    )
  }
}
