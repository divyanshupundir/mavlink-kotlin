package com.urbanmatrix.mavlink.ualberta

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Mode currently commanded by pilot
 */
public enum class UalbertaPilotMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   *  sdf
   */
  PILOT_MANUAL(1L),
  /**
   *  dfs
   */
  PILOT_AUTO(2L),
  /**
   *  Rotomotion mode 
   */
  PILOT_ROTO(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UalbertaPilotMode? = when (v) {
      1L -> PILOT_MANUAL
      2L -> PILOT_AUTO
      3L -> PILOT_ROTO
      else -> null
    }
  }
}
