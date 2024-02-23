package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Actions that may be specified in MAV_CMD_OVERRIDE_GOTO to override mission execution.
 */
@GeneratedMavEnum
public enum class MavGoto(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Hold at the current position.
   */
  @GeneratedMavEnumEntry
  DO_HOLD(0u),
  /**
   * Continue with the next item in mission execution.
   */
  @GeneratedMavEnumEntry
  DO_CONTINUE(1u),
  /**
   * Hold at the current position of the system
   */
  @GeneratedMavEnumEntry
  HOLD_AT_CURRENT_POSITION(2u),
  /**
   * Hold at the position specified in the parameters of the DO_HOLD action
   */
  @GeneratedMavEnumEntry
  HOLD_AT_SPECIFIED_POSITION(3u),
  ;

  public companion object : MavEnum.MavCompanion<MavGoto> {
    override fun getEntryFromValueOrNull(v: UInt): MavGoto? = when (v) {
      0u -> DO_HOLD
      1u -> DO_CONTINUE
      2u -> HOLD_AT_CURRENT_POSITION
      3u -> HOLD_AT_SPECIFIED_POSITION
      else -> null
    }
  }
}
