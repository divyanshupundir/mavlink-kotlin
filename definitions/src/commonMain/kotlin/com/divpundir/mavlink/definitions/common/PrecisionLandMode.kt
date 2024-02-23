package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Precision land modes (used in MAV_CMD_NAV_LAND).
 */
@GeneratedMavEnum
public enum class PrecisionLandMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Normal (non-precision) landing.
   */
  @GeneratedMavEnumEntry
  DISABLED(0u),
  /**
   * Use precision landing if beacon detected when land command accepted, otherwise land normally.
   */
  @GeneratedMavEnumEntry
  OPPORTUNISTIC(1u),
  /**
   * Use precision landing, searching for beacon if not found when land command accepted (land
   * normally if beacon cannot be found).
   */
  @GeneratedMavEnumEntry
  REQUIRED(2u),
  ;

  public companion object : MavEnum.MavCompanion<PrecisionLandMode> {
    override fun getEntryFromValueOrNull(v: UInt): PrecisionLandMode? = when (v) {
      0u -> DISABLED
      1u -> OPPORTUNISTIC
      2u -> REQUIRED
      else -> null
    }
  }
}
