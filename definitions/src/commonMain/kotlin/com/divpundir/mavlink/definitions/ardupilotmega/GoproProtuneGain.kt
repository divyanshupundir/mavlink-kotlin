package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GoproProtuneGain(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * ISO 400.
   */
  @GeneratedMavEnumEntry
  _400(0u),
  /**
   * ISO 800 (Only Hero 4).
   */
  @GeneratedMavEnumEntry
  _800(1u),
  /**
   * ISO 1600.
   */
  @GeneratedMavEnumEntry
  _1600(2u),
  /**
   * ISO 3200 (Only Hero 4).
   */
  @GeneratedMavEnumEntry
  _3200(3u),
  /**
   * ISO 6400.
   */
  @GeneratedMavEnumEntry
  _6400(4u),
  ;

  public companion object : MavEnum.MavCompanion<GoproProtuneGain> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproProtuneGain? = when (v) {
      0u -> _400
      1u -> _800
      2u -> _1600
      3u -> _3200
      4u -> _6400
      else -> null
    }
  }
}
