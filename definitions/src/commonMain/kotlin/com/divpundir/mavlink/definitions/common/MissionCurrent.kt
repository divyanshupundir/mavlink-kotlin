package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
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
 *
 *         Message that announces the sequence number of the current target mission item (that the
 * system will fly towards/execute when the mission is running).
 *         This message should be streamed all the time (nominally at 1Hz).
 *         This message should be emitted following a call to MAV_CMD_DO_SET_MISSION_CURRENT or
 * SET_MISSION_CURRENT.
 *       
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
) : MavMessage<MissionCurrent> {
  public override val instanceCompanion: MavMessage.MavCompanion<MissionCurrent> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(seq)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(seq)
    encoder.encodeUInt16(total)
    encoder.encodeEnumValue(missionState.value, 1)
    encoder.encodeUInt8(missionMode)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MissionCurrent> {
    private const val SIZE_V1: Int = 2

    private const val SIZE_V2: Int = 6

    public override val id: UInt = 42u

    public override val crcExtra: Byte = 28

    public override fun deserialize(bytes: ByteArray): MissionCurrent {
      val decoder = MavDataDecoder(bytes)

      val seq = decoder.safeDecodeUInt16()
      val total = decoder.safeDecodeUInt16()
      val missionState = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MissionState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val missionMode = decoder.safeDecodeUInt8()

      return MissionCurrent(
        seq = seq,
        total = total,
        missionState = missionState,
        missionMode = missionMode,
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

    public fun build(): MissionCurrent = MissionCurrent(
      seq = seq,
      total = total,
      missionState = missionState,
      missionMode = missionMode,
    )
  }
}
