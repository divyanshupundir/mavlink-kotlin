package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Precision land modes (used in MAV_CMD_NAV_LAND).
 */
@GeneratedMavEnum
public enum class PrecisionLandMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Normal (non-precision) landing.
   */
  @GeneratedMavEnumEntry
  DISABLED(0L),
  /**
   * Use precision landing if beacon detected when land command accepted, otherwise land normally.
   */
  @GeneratedMavEnumEntry
  OPPORTUNISTIC(1L),
  /**
   * Use precision landing, searching for beacon if not found when land command accepted (land
   * normally if beacon cannot be found).
   */
  @GeneratedMavEnumEntry
  REQUIRED(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): PrecisionLandMode? = when (v) {
      0L -> DISABLED
      1L -> OPPORTUNISTIC
      2L -> REQUIRED
      else -> null
    }
  }
}
