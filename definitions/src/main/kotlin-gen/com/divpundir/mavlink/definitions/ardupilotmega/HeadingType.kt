package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class HeadingType(
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  COURSE_OVER_GROUND(0u),
  @GeneratedMavEnumEntry
  HEADING(1u),
  ;

  public companion object : MavEnum.Companion<HeadingType> {
    public override fun getEntryFromValueOrNull(v: UInt): HeadingType? = when (v) {
      0u -> COURSE_OVER_GROUND
      1u -> HEADING
      else -> null
    }
  }
}
