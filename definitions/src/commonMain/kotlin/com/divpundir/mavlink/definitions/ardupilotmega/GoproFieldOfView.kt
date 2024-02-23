package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GoproFieldOfView(
  override val `value`: UInt,
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

  public companion object : MavEnum.MavCompanion<GoproFieldOfView> {
    override fun getEntryFromValueOrNull(v: UInt): GoproFieldOfView? = when (v) {
      0u -> WIDE
      1u -> MEDIUM
      2u -> NARROW
      else -> null
    }
  }
}
