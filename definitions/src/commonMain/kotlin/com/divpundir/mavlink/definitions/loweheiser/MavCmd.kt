package com.divpundir.mavlink.definitions.loweheiser

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavCmd(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Set Loweheiser desired states
   *
   * index = 1; 
   * EFI Index
   *
   * index = 2; 
   * Desired Engine/EFI State (0: Power Off, 1:Running)
   *
   * index = 3; 
   * Desired Governor State (0:manual throttle, 1:Governed throttle)
   *
   * index = 4; 
   * Manual throttle level, 0% - 100%
   *
   * index = 5; 
   * Electronic Start up (0:Off, 1:On)
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  LOWEHEISER_SET_STATE(10_151u),
  ;

  public companion object : MavEnum.MavCompanion<MavCmd> {
    override fun getEntryFromValueOrNull(v: UInt): MavCmd? = when (v) {
      10151u -> LOWEHEISER_SET_STATE
      else -> null
    }
  }
}
