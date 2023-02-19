package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Bitmap of options for the MAV_CMD_DO_REPOSITION
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavDoRepositionFlags(
  public override val `value`: UInt,
) : MavBitmask {
  /**
   * The aircraft should immediately transition into guided. This should not be set for follow me
   * applications
   */
  @GeneratedMavEnumEntry
  CHANGE_MODE(1u),
  ;

  public companion object : MavEnum.Companion<MavDoRepositionFlags>,
      MavBitmask.Companion<MavDoRepositionFlags> {
    public override fun getEntryFromValueOrNull(v: UInt): MavDoRepositionFlags? = when (v) {
      1u -> CHANGE_MODE
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<MavDoRepositionFlags> = buildList {
      if (v and 1u == 1u) add(CHANGE_MODE)
    }
  }
}
