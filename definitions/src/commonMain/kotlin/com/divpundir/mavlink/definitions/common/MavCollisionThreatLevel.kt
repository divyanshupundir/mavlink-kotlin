package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Aircraft-rated danger from this threat.
 */
@GeneratedMavEnum
public enum class MavCollisionThreatLevel(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Not a threat
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Craft is mildly concerned about this threat
   */
  @GeneratedMavEnumEntry
  LOW(1u),
  /**
   * Craft is panicking, and may take actions to avoid threat
   */
  @GeneratedMavEnumEntry
  HIGH(2u),
  ;

  public companion object : MavEnum.MavCompanion<MavCollisionThreatLevel> {
    override fun getEntryFromValueOrNull(v: UInt): MavCollisionThreatLevel? = when (v) {
      0u -> NONE
      1u -> LOW
      2u -> HIGH
      else -> null
    }
  }
}
