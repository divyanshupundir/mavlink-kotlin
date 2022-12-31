package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Bitmap of options for the MAV_CMD_DO_REPOSITION
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavDoRepositionFlags(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * The aircraft should immediately transition into guided. This should not be set for follow me
   * applications
   */
  @GeneratedMavEnumEntry
  CHANGE_MODE(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavDoRepositionFlags? = when (v) {
      1L -> CHANGE_MODE
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<MavDoRepositionFlags> = buildList {
      if (v and 1L == 1L) add(CHANGE_MODE)
    }
  }
}
