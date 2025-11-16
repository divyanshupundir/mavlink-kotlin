package com.divpundir.mavlink.definitions.standard

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Enum used to indicate true or false (also: success or failure, enabled or disabled, active or
 * inactive).
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavBool(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * False.
   */
  @GeneratedMavEnumEntry
  FALSE(0u),
  /**
   * True.
   */
  @GeneratedMavEnumEntry
  TRUE(1u),
  ;

  public companion object : MavBitmask.MavCompanion<MavBool> {
    override fun getEntryFromValueOrNull(v: UInt): MavBool? = when (v) {
      0u -> FALSE
      1u -> TRUE
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<MavBool> = buildList {
      if (v and 0u == 0u) add(FALSE)
      if (v and 1u == 1u) add(TRUE)
    }
  }
}
