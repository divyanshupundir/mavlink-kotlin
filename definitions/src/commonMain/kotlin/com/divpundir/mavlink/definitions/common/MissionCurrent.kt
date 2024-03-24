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
 *
 *         Message that announces the sequence number of the current target mission item (that the
 * system will fly towards/execute when the mission is running).
 *         This message should be streamed all the time (nominally at 1Hz).
 *         This message should be emitted following a call to MAV_CMD_DO_SET_MISSION_CURRENT or
 * SET_MISSION_CURRENT.
 *       
 *
 * @param seq Sequence
 * @param total Total number of mission items on vehicle (on last item, sequence == total). If the
 * autopilot stores its home location as part of the mission this will be excluded from the total. 0:
 * Not supported, UINT16_MAX if no mission is present on the vehicle.
 * @param missionState Mission state machine state. MISSION_STATE_UNKNOWN if state reporting not
 * supported.
 * @param missionMode Vehicle is in a mode that can execute mission items or suspended. 0: Unknown,
 * 1: In mission mode, 2: Suspended (not in mission mode).
 * @param missionId Id of current on-vehicle mission plan, or 0 if IDs are not supported or there is
 * no mission loaded. GCS can use this to track changes to the mission plan type. The same value is
 * returned on mission upload (in the MISSION_ACK).
 * @param fenceId Id of current on-vehicle fence plan, or 0 if IDs are not supported or there is no
 * fence loaded. GCS can use this to track changes to the fence plan type. The same value is returned
 * on fence upload (in the MISSION_ACK).
 * @param rallyPointsId Id of current on-vehicle rally point plan, or 0 if IDs are not supported or
 * there are no rally points loaded. GCS can use this to track changes to the rally point plan type.
 * The same value is returned on rally point upload (in the MISSION_ACK).
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
  /**
   * Total number of mission items on vehicle (on last item, sequence == total). If the autopilot
   * stores its home location as part of the mission this will be excluded from the total. 0: Not
   * supported, UINT16_MAX if no mission is present on the vehicle.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val total: UShort = 0u,
  /**
   * Mission state machine state. MISSION_STATE_UNKNOWN if state reporting not supported.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val missionState: MavEnumValue<MissionState> = MavEnumValue.fromValue(0u),
  /**
   * Vehicle is in a mode that can execute mission items or suspended. 0: Unknown, 1: In mission
   * mode, 2: Suspended (not in mission mode).
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val missionMode: UByte = 0u,
  /**
   * Id of current on-vehicle mission plan, or 0 if IDs are not supported or there is no mission
   * loaded. GCS can use this to track changes to the mission plan type. The same value is returned on
   * mission upload (in the MISSION_ACK).
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val missionId: UInt = 0u,
  /**
   * Id of current on-vehicle fence plan, or 0 if IDs are not supported or there is no fence loaded.
   * GCS can use this to track changes to the fence plan type. The same value is returned on fence
   * upload (in the MISSION_ACK).
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val fenceId: UInt = 0u,
  /**
   * Id of current on-vehicle rally point plan, or 0 if IDs are not supported or there are no rally
   * points loaded. GCS can use this to track changes to the rally point plan type. The same value is
   * returned on rally point upload (in the MISSION_ACK).
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val rallyPointsId: UInt = 0u,
) : MavMessage<MissionCurrent> {
  override val instanceCompanion: MavMessage.MavCompanion<MissionCurrent> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(seq)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(seq)
    encoder.encodeUInt16(total)
    encoder.encodeEnumValue(missionState.value, 1)
    encoder.encodeUInt8(missionMode)
    encoder.encodeUInt32(missionId)
    encoder.encodeUInt32(fenceId)
    encoder.encodeUInt32(rallyPointsId)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MissionCurrent> {
    private const val SIZE_V1: Int = 2

    private const val SIZE_V2: Int = 18

    override val id: UInt = 42u

    override val crcExtra: Byte = 28

    override fun deserialize(bytes: ByteArray): MissionCurrent {
      val decoder = MavDataDecoder(bytes)

      val seq = decoder.safeDecodeUInt16()
      val total = decoder.safeDecodeUInt16()
      val missionState = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MissionState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val missionMode = decoder.safeDecodeUInt8()
      val missionId = decoder.safeDecodeUInt32()
      val fenceId = decoder.safeDecodeUInt32()
      val rallyPointsId = decoder.safeDecodeUInt32()

      return MissionCurrent(
        seq = seq,
        total = total,
        missionState = missionState,
        missionMode = missionMode,
        missionId = missionId,
        fenceId = fenceId,
        rallyPointsId = rallyPointsId,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MissionCurrent =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var seq: UShort = 0u

    public var total: UShort = 0u

    public var missionState: MavEnumValue<MissionState> = MavEnumValue.fromValue(0u)

    public var missionMode: UByte = 0u

    public var missionId: UInt = 0u

    public var fenceId: UInt = 0u

    public var rallyPointsId: UInt = 0u

    public fun build(): MissionCurrent = MissionCurrent(
      seq = seq,
      total = total,
      missionState = missionState,
      missionMode = missionMode,
      missionId = missionId,
      fenceId = fenceId,
      rallyPointsId = rallyPointsId,
    )
  }
}
