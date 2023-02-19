package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Flags in RALLY_POINT message.
 */
@GeneratedMavEnum(bitmask = true)
public enum class RallyFlags(
  public override val `value`: UInt,
) : MavBitmask {
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
  ;

  public companion object : MavEnum.Companion<RallyFlags>, MavBitmask.Companion<RallyFlags> {
    public override fun getEntryFromValueOrNull(v: UInt): RallyFlags? = when (v) {
      1u -> FAVORABLE_WIND
      2u -> LAND_IMMEDIATELY
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<RallyFlags> = buildList {
      if (v and 1u == 1u) add(FAVORABLE_WIND)
      if (v and 2u == 2u) add(LAND_IMMEDIATELY)
    }
  }
}
