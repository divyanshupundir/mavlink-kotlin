package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

@GeneratedMavEnum(bitmask = true)
public enum class GoproHeartbeatFlags(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * GoPro is currently recording.
   */
  @GeneratedMavEnumEntry
  GOPRO_FLAG_RECORDING(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproHeartbeatFlags? = when (v) {
      1L -> GOPRO_FLAG_RECORDING
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<GoproHeartbeatFlags> = buildList {
      if (v and 1L == 1L) add(GOPRO_FLAG_RECORDING)
    }
  }
}
