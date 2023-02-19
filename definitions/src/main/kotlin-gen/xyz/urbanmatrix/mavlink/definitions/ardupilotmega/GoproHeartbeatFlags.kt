package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum(bitmask = true)
public enum class GoproHeartbeatFlags(
  public override val `value`: UInt,
) : MavBitmask {
  /**
   * GoPro is currently recording.
   */
  @GeneratedMavEnumEntry
  GOPRO_FLAG_RECORDING(1u),
  ;

  public companion object : MavEnum.Companion<GoproHeartbeatFlags>,
      MavBitmask.Companion<GoproHeartbeatFlags> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproHeartbeatFlags? = when (v) {
      1u -> GOPRO_FLAG_RECORDING
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<GoproHeartbeatFlags> = buildList {
      if (v and 1u == 1u) add(GOPRO_FLAG_RECORDING)
    }
  }
}
