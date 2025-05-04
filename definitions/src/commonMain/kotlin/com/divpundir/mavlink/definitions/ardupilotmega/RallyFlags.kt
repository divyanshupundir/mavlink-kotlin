package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Flags in RALLY_POINT message.
 */
@GeneratedMavEnum
public enum class RallyFlags(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Flag set when requiring favorable winds for landing.
   */
  @GeneratedMavEnumEntry
  FAVORABLE_WIND(1u),
  /**
   * Flag set when plane is to immediately descend to break altitude and land without GCS
   * intervention. Flag not set when plane is to loiter at Rally point until commanded to land.
   */
  @GeneratedMavEnumEntry
  LAND_IMMEDIATELY(2u),
  /**
   * True if the following altitude frame value is valid.
   */
  @GeneratedMavEnumEntry
  ALT_FRAME_VALID(4u),
  /**
   * 2 bit value representing altitude frame. 0: absolute, 1: relative home, 2: relative origin, 3:
   * relative terrain
   */
  @GeneratedMavEnumEntry
  ALT_FRAME(24u),
  ;

  public companion object : MavEnum.MavCompanion<RallyFlags> {
    override fun getEntryFromValueOrNull(v: UInt): RallyFlags? = when (v) {
      1u -> FAVORABLE_WIND
      2u -> LAND_IMMEDIATELY
      4u -> ALT_FRAME_VALID
      24u -> ALT_FRAME
      else -> null
    }
  }
}
