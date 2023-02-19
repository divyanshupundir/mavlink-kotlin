package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproFieldOfView(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * 0x00: Wide.
   */
  @GeneratedMavEnumEntry
  WIDE(0u),
  /**
   * 0x01: Medium.
   */
  @GeneratedMavEnumEntry
  MEDIUM(1u),
  /**
   * 0x02: Narrow.
   */
  @GeneratedMavEnumEntry
  NARROW(2u),
  ;

  public companion object : MavEnum.Companion<GoproFieldOfView> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproFieldOfView? = when (v) {
      0u -> WIDE
      1u -> MEDIUM
      2u -> NARROW
      else -> null
    }
  }
}
