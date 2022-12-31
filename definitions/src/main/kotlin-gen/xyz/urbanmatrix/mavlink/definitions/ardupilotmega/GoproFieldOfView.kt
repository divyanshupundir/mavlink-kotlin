package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproFieldOfView(
  public override val `value`: Long,
) : MavEnum {
  /**
   * 0x00: Wide.
   */
  @GeneratedMavEnumEntry
  WIDE(0L),
  /**
   * 0x01: Medium.
   */
  @GeneratedMavEnumEntry
  MEDIUM(1L),
  /**
   * 0x02: Narrow.
   */
  @GeneratedMavEnumEntry
  NARROW(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproFieldOfView? = when (v) {
      0L -> WIDE
      1L -> MEDIUM
      2L -> NARROW
      else -> null
    }
  }
}
