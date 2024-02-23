package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavOdidArmStatus(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Passing arming checks.
   */
  @GeneratedMavEnumEntry
  GOOD_TO_ARM(0u),
  /**
   * Generic arming failure, see error string for details.
   */
  @GeneratedMavEnumEntry
  PRE_ARM_FAIL_GENERIC(1u),
  ;

  public companion object : MavEnum.MavCompanion<MavOdidArmStatus> {
    override fun getEntryFromValueOrNull(v: UInt): MavOdidArmStatus? = when (v) {
      0u -> GOOD_TO_ARM
      1u -> PRE_ARM_FAIL_GENERIC
      else -> null
    }
  }
}
