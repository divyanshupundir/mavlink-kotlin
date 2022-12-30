package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidClassEu(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The class for the UA, according to the EU specification, is undeclared.
   */
  @GeneratedMavEnumEntry
  UNDECLARED(0L),
  /**
   * The class for the UA, according to the EU specification, is Class 0.
   */
  @GeneratedMavEnumEntry
  CLASS_0(1L),
  /**
   * The class for the UA, according to the EU specification, is Class 1.
   */
  @GeneratedMavEnumEntry
  CLASS_1(2L),
  /**
   * The class for the UA, according to the EU specification, is Class 2.
   */
  @GeneratedMavEnumEntry
  CLASS_2(3L),
  /**
   * The class for the UA, according to the EU specification, is Class 3.
   */
  @GeneratedMavEnumEntry
  CLASS_3(4L),
  /**
   * The class for the UA, according to the EU specification, is Class 4.
   */
  @GeneratedMavEnumEntry
  CLASS_4(5L),
  /**
   * The class for the UA, according to the EU specification, is Class 5.
   */
  @GeneratedMavEnumEntry
  CLASS_5(6L),
  /**
   * The class for the UA, according to the EU specification, is Class 6.
   */
  @GeneratedMavEnumEntry
  CLASS_6(7L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidClassEu? = when (v) {
      0L -> UNDECLARED
      1L -> CLASS_0
      2L -> CLASS_1
      3L -> CLASS_2
      4L -> CLASS_3
      5L -> CLASS_4
      6L -> CLASS_5
      7L -> CLASS_6
      else -> null
    }
  }
}
