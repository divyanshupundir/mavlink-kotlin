package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavCmd(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Mission command to reset Maximum Power Point Tracker (MPPT)
   *
   * index = 1; 
   * MPPT number
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
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
  RESET_MPPT(40001u),
  /**
   * Mission command to perform a power cycle on payload
   *
   * index = 1; 
   * Complete power cycle
   *
   * index = 2; 
   * VISensor power cycle
   *
   * index = 3; 
   * Empty
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
  PAYLOAD_CONTROL(40002u),
  ;

  public companion object : MavEnum.Companion<MavCmd> {
    public override fun getEntryFromValueOrNull(v: UInt): MavCmd? = when (v) {
      40001u -> RESET_MPPT
      40002u -> PAYLOAD_CONTROL
      else -> null
    }
  }
}
