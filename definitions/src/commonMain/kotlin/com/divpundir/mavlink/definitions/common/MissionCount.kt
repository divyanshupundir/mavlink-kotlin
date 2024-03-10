package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
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
 * This message is emitted as response to MISSION_REQUEST_LIST by the MAV and to initiate a write
 * transaction. The GCS can then request the individual mission item based on the knowledge of the
 * total number of waypoints.
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param count Number of mission items in the sequence
 * @param missionType Mission type.
 * @param opaqueId Id of current on-vehicle mission, fence, or rally point plan (on download from
 * vehicle).
 *         This field is used when downloading a plan from a vehicle to a GCS.
 *         0 on upload to the vehicle from GCS.
 *         0 if plan ids are not supported.
 *         The current on-vehicle plan ids are streamed in `MISSION_CURRENT`, allowing a GCS to
 * determine if any part of the plan has changed and needs to be re-uploaded.
 *         The ids are recalculated by the vehicle when any part of the on-vehicle plan changes
 * (when a new plan is uploaded, the vehicle returns the new id to the GCS in MISSION_ACK).
 *       
 */
@GeneratedMavMessage(
  id = 44u,
  crcExtra = -35,
)
public data class MissionCount(
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
   * Number of mission items in the sequence
   */
  @GeneratedMavField(type = "uint16_t")
  public val count: UShort = 0u,
  /**
   * Mission type.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val missionType: MavEnumValue<MavMissionType> = MavEnumValue.fromValue(0u),
  /**
   * Id of current on-vehicle mission, fence, or rally point plan (on download from vehicle).
   *         This field is used when downloading a plan from a vehicle to a GCS.
   *         0 on upload to the vehicle from GCS.
   *         0 if plan ids are not supported.
   *         The current on-vehicle plan ids are streamed in `MISSION_CURRENT`, allowing a GCS to
   * determine if any part of the plan has changed and needs to be re-uploaded.
   *         The ids are recalculated by the vehicle when any part of the on-vehicle plan changes
   * (when a new plan is uploaded, the vehicle returns the new id to the GCS in MISSION_ACK).
   *       
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val opaqueId: UInt = 0u,
) : MavMessage<MissionCount> {
  override val instanceCompanion: MavMessage.MavCompanion<MissionCount> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(count)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(count)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(missionType.value, 1)
    encoder.encodeUInt32(opaqueId)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MissionCount> {
    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 9

    override val id: UInt = 44u

    override val crcExtra: Byte = -35

    override fun deserialize(bytes: ByteArray): MissionCount {
      val decoder = MavDataDecoder(bytes)

      val count = decoder.safeDecodeUInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val missionType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavMissionType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val opaqueId = decoder.safeDecodeUInt32()

      return MissionCount(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        count = count,
        missionType = missionType,
        opaqueId = opaqueId,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MissionCount =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var count: UShort = 0u

    public var missionType: MavEnumValue<MavMissionType> = MavEnumValue.fromValue(0u)

    public var opaqueId: UInt = 0u

    public fun build(): MissionCount = MissionCount(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      count = count,
      missionType = missionType,
      opaqueId = opaqueId,
    )
  }
}
