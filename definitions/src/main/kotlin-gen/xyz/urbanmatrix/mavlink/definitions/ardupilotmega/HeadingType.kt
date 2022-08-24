package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
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
