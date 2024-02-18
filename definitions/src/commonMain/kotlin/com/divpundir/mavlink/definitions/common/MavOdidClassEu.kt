package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavOdidClassEu(
  override val `value`: UInt,
) : MavEnum {
  /**
   * The class for the UA, according to the EU specification, is undeclared.
   */
  @GeneratedMavEnumEntry
  UNDECLARED(0u),
  /**
   * The class for the UA, according to the EU specification, is Class 0.
   */
  @GeneratedMavEnumEntry
  CLASS_0(1u),
  /**
   * The class for the UA, according to the EU specification, is Class 1.
   */
  @GeneratedMavEnumEntry
  CLASS_1(2u),
  /**
   * The class for the UA, according to the EU specification, is Class 2.
   */
  @GeneratedMavEnumEntry
  CLASS_2(3u),
  /**
   * The class for the UA, according to the EU specification, is Class 3.
   */
  @GeneratedMavEnumEntry
  CLASS_3(4u),
  /**
   * The class for the UA, according to the EU specification, is Class 4.
   */
  @GeneratedMavEnumEntry
  CLASS_4(5u),
  /**
   * The class for the UA, according to the EU specification, is Class 5.
   */
  @GeneratedMavEnumEntry
  CLASS_5(6u),
  /**
   * The class for the UA, according to the EU specification, is Class 6.
   */
  @GeneratedMavEnumEntry
  CLASS_6(7u),
  ;

  public companion object : MavEnum.MavCompanion<MavOdidClassEu> {
    override fun getEntryFromValueOrNull(v: UInt): MavOdidClassEu? = when (v) {
      0u -> UNDECLARED
      1u -> CLASS_0
      2u -> CLASS_1
      3u -> CLASS_2
      4u -> CLASS_3
      5u -> CLASS_4
      6u -> CLASS_5
      7u -> CLASS_6
      else -> null
    }
  }
}
