package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt
import kotlin.collections.List

@GeneratedMavEnum(bitmask = true)
public enum class GoproVideoSettingsFlags(
  public override val `value`: UInt,
) : MavBitmask {
  /**
   * 0=NTSC, 1=PAL.
   */
  @GeneratedMavEnumEntry
  GOPRO_VIDEO_SETTINGS_TV_MODE(1u),
  ;

  public companion object : MavEnum.Companion<GoproVideoSettingsFlags>,
      MavBitmask.Companion<GoproVideoSettingsFlags> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproVideoSettingsFlags? = when (v) {
      1u -> GOPRO_VIDEO_SETTINGS_TV_MODE
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<GoproVideoSettingsFlags> = buildList {
      if (v and 1u == 1u) add(GOPRO_VIDEO_SETTINGS_TV_MODE)
    }
  }
}
