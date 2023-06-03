package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GoproModel(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Unknown gopro model.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * Hero 3+ Silver (HeroBus not supported by GoPro).
   */
  @GeneratedMavEnumEntry
  HERO_3_PLUS_SILVER(1u),
  /**
   * Hero 3+ Black.
   */
  @GeneratedMavEnumEntry
  HERO_3_PLUS_BLACK(2u),
  /**
   * Hero 4 Silver.
   */
  @GeneratedMavEnumEntry
  HERO_4_SILVER(3u),
  /**
   * Hero 4 Black.
   */
  @GeneratedMavEnumEntry
  HERO_4_BLACK(4u),
  ;

  public companion object : MavEnum.MavCompanion<GoproModel> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproModel? = when (v) {
      0u -> UNKNOWN
      1u -> HERO_3_PLUS_SILVER
      2u -> HERO_3_PLUS_BLACK
      3u -> HERO_4_SILVER
      4u -> HERO_4_BLACK
      else -> null
    }
  }
}
