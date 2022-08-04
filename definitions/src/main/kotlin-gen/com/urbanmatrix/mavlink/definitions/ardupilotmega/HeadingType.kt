package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class HeadingType(
  public override val `value`: Long,
) : MavEnum {
  HEADING_TYPE_COURSE_OVER_GROUND(0L),
  HEADING_TYPE_HEADING(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): HeadingType? = when (v) {
      0L -> HEADING_TYPE_COURSE_OVER_GROUND
      1L -> HEADING_TYPE_HEADING
      else -> null
    }
  }
}
