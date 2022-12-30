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
  NONE(0L),
  /**
   * Breached minimum altitude
   */
  @GeneratedMavEnumEntry
  MINALT(1L),
  /**
   * Breached maximum altitude
   */
  @GeneratedMavEnumEntry
  MAXALT(2L),
  /**
   * Breached fence boundary
   */
  @GeneratedMavEnumEntry
  BOUNDARY(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): FenceBreach? = when (v) {
      0L -> NONE
      1L -> MINALT
      2L -> MAXALT
      3L -> BOUNDARY
      else -> null
    }
  }
}
