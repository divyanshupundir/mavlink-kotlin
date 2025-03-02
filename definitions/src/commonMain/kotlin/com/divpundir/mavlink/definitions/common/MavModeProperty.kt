package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Mode properties.
 *       
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavModeProperty(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * If set, this mode is an advanced mode.
   *           For example a rate-controlled manual mode might be advanced, whereas a
   * position-controlled manual mode is not.
   *           A GCS can optionally use this flag to configure the UI for its intended users.
   *         
   */
  @GeneratedMavEnumEntry
  ADVANCED(1u),
  /**
   * If set, this mode should not be added to the list of selectable modes.
   *           The mode might still be selected by the FC directly (for example as part of a
   * failsafe).
   *         
   */
  @GeneratedMavEnumEntry
  NOT_USER_SELECTABLE(2u),
  /**
   * If set, this mode is automatically controlled (it may use but does not require a manual
   * controller).
   *           If unset the mode is a assumed to require user input (be a manual mode).
   *         
   */
  @GeneratedMavEnumEntry
  AUTO_MODE(4u),
  ;

  public companion object : MavBitmask.MavCompanion<MavModeProperty> {
    override fun getEntryFromValueOrNull(v: UInt): MavModeProperty? = when (v) {
      1u -> ADVANCED
      2u -> NOT_USER_SELECTABLE
      4u -> AUTO_MODE
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<MavModeProperty> = buildList {
      if (v and 1u == 1u) add(ADVANCED)
      if (v and 2u == 2u) add(NOT_USER_SELECTABLE)
      if (v and 4u == 4u) add(AUTO_MODE)
    }
  }
}
