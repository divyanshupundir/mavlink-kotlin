package com.urbanmatrix.mavlink.ASLUAV

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class MavCmd(
  public override val `value`: Long,
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
  MAV_CMD_RESET_MPPT(40001L),
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
  MAV_CMD_PAYLOAD_CONTROL(40002L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavCmd? = when (v) {
      40001L -> MAV_CMD_RESET_MPPT
      40002L -> MAV_CMD_PAYLOAD_CONTROL
      else -> null
    }
  }
}
