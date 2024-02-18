package com.divpundir.mavlink.definitions.ualberta

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Mode currently commanded by pilot
 *
 */
@GeneratedMavEnum
public enum class UalbertaPilotMode(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  PILOT_MANUAL(1u),
  @GeneratedMavEnumEntry
  PILOT_AUTO(2u),
  /**
   *  Rotomotion mode 
   */
  @GeneratedMavEnumEntry
  PILOT_ROTO(3u),
  ;

  public companion object : MavEnum.MavCompanion<UalbertaPilotMode> {
    override fun getEntryFromValueOrNull(v: UInt): UalbertaPilotMode? = when (v) {
      1u -> PILOT_MANUAL
      2u -> PILOT_AUTO
      3u -> PILOT_ROTO
      else -> null
    }
  }
}
