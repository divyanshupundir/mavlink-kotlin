package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Aircraft-rated danger from this threat.
 */
public enum class MavCollisionThreatLevel(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Not a threat
   */
  MAV_COLLISION_THREAT_LEVEL_NONE(0L),
  /**
   * Craft is mildly concerned about this threat
   */
  MAV_COLLISION_THREAT_LEVEL_LOW(1L),
  /**
   * Craft is panicking, and may take actions to avoid threat
   */
  MAV_COLLISION_THREAT_LEVEL_HIGH(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavCollisionThreatLevel? = when (v) {
      0L -> MAV_COLLISION_THREAT_LEVEL_NONE
      1L -> MAV_COLLISION_THREAT_LEVEL_LOW
      2L -> MAV_COLLISION_THREAT_LEVEL_HIGH
      else -> null
    }
  }
}
