package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidCategoryEu(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The category for the UA, according to the EU specification, is undeclared.
   */
  @GeneratedMavEnumEntry
  UNDECLARED(0L),
  /**
   * The category for the UA, according to the EU specification, is the Open category.
   */
  @GeneratedMavEnumEntry
  OPEN(1L),
  /**
   * The category for the UA, according to the EU specification, is the Specific category.
   */
  @GeneratedMavEnumEntry
  SPECIFIC(2L),
  /**
   * The category for the UA, according to the EU specification, is the Certified category.
   */
  @GeneratedMavEnumEntry
  CERTIFIED(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidCategoryEu? = when (v) {
      0L -> UNDECLARED
      1L -> OPEN
      2L -> SPECIFIC
      3L -> CERTIFIED
      else -> null
    }
  }
}
