package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class HeadingType(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  COURSE_OVER_GROUND(0L),
  @GeneratedMavEnumEntry
  HEADING(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): HeadingType? = when (v) {
      0L -> COURSE_OVER_GROUND
      1L -> HEADING
      else -> null
    }
  }
}
