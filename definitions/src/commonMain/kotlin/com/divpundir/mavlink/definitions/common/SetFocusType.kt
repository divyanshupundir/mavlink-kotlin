package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Focus types for MAV_CMD_SET_CAMERA_FOCUS
 */
@GeneratedMavEnum
public enum class SetFocusType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Focus one step increment (-1 for focusing in, 1 for focusing out towards infinity).
   */
  @GeneratedMavEnumEntry
  FOCUS_TYPE_STEP(0u),
  /**
   * Continuous focus up/down until stopped (-1 for focusing in, 1 for focusing out towards
   * infinity, 0 to stop focusing)
   */
  @GeneratedMavEnumEntry
  FOCUS_TYPE_CONTINUOUS(1u),
  /**
   * Focus value as proportion of full camera focus range (a value between 0.0 and 100.0)
   */
  @GeneratedMavEnumEntry
  FOCUS_TYPE_RANGE(2u),
  /**
   * Focus value in metres. Note that there is no message to get the valid focus range of the
   * camera, so this can type can only be used for cameras where the range is known (implying that this
   * cannot reliably be used in a GCS for an arbitrary camera).
   */
  @GeneratedMavEnumEntry
  FOCUS_TYPE_METERS(3u),
  /**
   * Focus automatically.
   */
  @GeneratedMavEnumEntry
  FOCUS_TYPE_AUTO(4u),
  /**
   * Single auto focus. Mainly used for still pictures. Usually abbreviated as AF-S.
   */
  @GeneratedMavEnumEntry
  FOCUS_TYPE_AUTO_SINGLE(5u),
  /**
   * Continuous auto focus. Mainly used for dynamic scenes. Abbreviated as AF-C.
   */
  @GeneratedMavEnumEntry
  FOCUS_TYPE_AUTO_CONTINUOUS(6u),
  ;

  public companion object : MavEnum.MavCompanion<SetFocusType> {
    override fun getEntryFromValueOrNull(v: UInt): SetFocusType? = when (v) {
      0u -> FOCUS_TYPE_STEP
      1u -> FOCUS_TYPE_CONTINUOUS
      2u -> FOCUS_TYPE_RANGE
      3u -> FOCUS_TYPE_METERS
      4u -> FOCUS_TYPE_AUTO
      5u -> FOCUS_TYPE_AUTO_SINGLE
      6u -> FOCUS_TYPE_AUTO_CONTINUOUS
      else -> null
    }
  }
}
