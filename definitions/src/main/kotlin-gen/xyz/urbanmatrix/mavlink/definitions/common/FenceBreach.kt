package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class FenceBreach(
  public override val `value`: Long,
) : MavEnum {
  /**
   * No last fence breach
   */
  @GeneratedMavEnumEntry
  FENCE_BREACH_NONE(0L),
  /**
   * Breached minimum altitude
   */
  @GeneratedMavEnumEntry
  FENCE_BREACH_MINALT(1L),
  /**
   * Breached maximum altitude
   */
  @GeneratedMavEnumEntry
  FENCE_BREACH_MAXALT(2L),
  /**
   * Breached fence boundary
   */
  @GeneratedMavEnumEntry
  FENCE_BREACH_BOUNDARY(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): FenceBreach? = when (v) {
      0L -> FENCE_BREACH_NONE
      1L -> FENCE_BREACH_MINALT
      2L -> FENCE_BREACH_MAXALT
      3L -> FENCE_BREACH_BOUNDARY
      else -> null
    }
  }
}
