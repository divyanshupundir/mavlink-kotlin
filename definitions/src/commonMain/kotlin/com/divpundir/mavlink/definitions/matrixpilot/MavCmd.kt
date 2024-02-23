package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavCmd(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Request storage of different parameter values and logs. This command will be only accepted if
   * in pre-flight mode.
   *
   * index = 1; 
   * Storage action: Action defined by MAV_PREFLIGHT_STORAGE_ACTION_ADVANCED
   *
   * index = 2; 
   * Storage area as defined by parameter database
   *
   * index = 3; 
   * Storage flags as defined by parameter database
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  PREFLIGHT_STORAGE_ADVANCED(0u),
  ;

  public companion object : MavEnum.MavCompanion<MavCmd> {
    override fun getEntryFromValueOrNull(v: UInt): MavCmd? = when (v) {
      0u -> PREFLIGHT_STORAGE_ADVANCED
      else -> null
    }
  }
}
