package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class HeadingType(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  COURSE_OVER_GROUND(0u),
  @GeneratedMavEnumEntry
  HEADING(1u),
  @GeneratedMavEnumEntry
  DEFAULT(2u),
  ;

  public companion object : MavEnum.MavCompanion<HeadingType> {
    override fun getEntryFromValueOrNull(v: UInt): HeadingType? = when (v) {
      0u -> COURSE_OVER_GROUND
      1u -> HEADING
      2u -> DEFAULT
      else -> null
    }
  }
}
