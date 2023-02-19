package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidCategoryEu(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * The category for the UA, according to the EU specification, is undeclared.
   */
  @GeneratedMavEnumEntry
  UNDECLARED(0u),
  /**
   * The category for the UA, according to the EU specification, is the Open category.
   */
  @GeneratedMavEnumEntry
  OPEN(1u),
  /**
   * The category for the UA, according to the EU specification, is the Specific category.
   */
  @GeneratedMavEnumEntry
  SPECIFIC(2u),
  /**
   * The category for the UA, according to the EU specification, is the Certified category.
   */
  @GeneratedMavEnumEntry
  CERTIFIED(3u),
  ;

  public companion object : MavEnum.Companion<MavOdidCategoryEu> {
    public override fun getEntryFromValueOrNull(v: UInt): MavOdidCategoryEu? = when (v) {
      0u -> UNDECLARED
      1u -> OPEN
      2u -> SPECIFIC
      3u -> CERTIFIED
      else -> null
    }
  }
}
