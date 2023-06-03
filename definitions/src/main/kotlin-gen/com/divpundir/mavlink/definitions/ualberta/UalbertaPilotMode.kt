package com.divpundir.mavlink.definitions.ualberta

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Mode currently commanded by pilot
 */
@GeneratedMavEnum
public enum class UalbertaPilotMode(
  public override val `value`: UInt,
) : MavEnum {
  /**
   *  sdf
   */
  @GeneratedMavEnumEntry
  PILOT_MANUAL(1u),
  /**
   *  dfs
   */
  @GeneratedMavEnumEntry
  PILOT_AUTO(2u),
  /**
   *  Rotomotion mode 
   */
  @GeneratedMavEnumEntry
  PILOT_ROTO(3u),
  ;

  public companion object : MavEnum.MavCompanion<UalbertaPilotMode> {
    public override fun getEntryFromValueOrNull(v: UInt): UalbertaPilotMode? = when (v) {
      1u -> PILOT_MANUAL
      2u -> PILOT_AUTO
      3u -> PILOT_ROTO
      else -> null
    }
  }
}
