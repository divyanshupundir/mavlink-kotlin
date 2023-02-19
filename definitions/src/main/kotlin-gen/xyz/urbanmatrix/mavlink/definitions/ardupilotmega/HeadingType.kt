package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

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
