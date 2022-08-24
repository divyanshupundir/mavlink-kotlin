package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Bitmap of options for the MAV_CMD_DO_REPOSITION
 */
@GeneratedMavEnum
public enum class MavDoRepositionFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The aircraft should immediately transition into guided. This should not be set for follow me
   * applications
   */
  MAV_DO_REPOSITION_FLAGS_CHANGE_MODE(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavDoRepositionFlags? = when (v) {
      1L -> MAV_DO_REPOSITION_FLAGS_CHANGE_MODE
      else -> null
    }
  }
}
