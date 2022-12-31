package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Aircraft-rated danger from this threat.
 */
@GeneratedMavEnum
public enum class MavCollisionThreatLevel(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Not a threat
   */
  @GeneratedMavEnumEntry
  NONE(0L),
  /**
   * Craft is mildly concerned about this threat
   */
  @GeneratedMavEnumEntry
  LOW(1L),
  /**
   * Craft is panicking, and may take actions to avoid threat
   */
  @GeneratedMavEnumEntry
  HIGH(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavCollisionThreatLevel? = when (v) {
      0L -> NONE
      1L -> LOW
      2L -> HIGH
      else -> null
    }
  }
}
