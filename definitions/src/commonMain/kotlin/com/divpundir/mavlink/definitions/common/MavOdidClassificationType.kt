package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavOdidClassificationType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * The classification type for the UA is undeclared.
   */
  @GeneratedMavEnumEntry
  UNDECLARED(0u),
  /**
   * The classification type for the UA follows EU (European Union) specifications.
   */
  @GeneratedMavEnumEntry
  EU(1u),
  ;

  public companion object : MavEnum.MavCompanion<MavOdidClassificationType> {
    override fun getEntryFromValueOrNull(v: UInt): MavOdidClassificationType? = when (v) {
      0u -> UNDECLARED
      1u -> EU
      else -> null
    }
  }
}
