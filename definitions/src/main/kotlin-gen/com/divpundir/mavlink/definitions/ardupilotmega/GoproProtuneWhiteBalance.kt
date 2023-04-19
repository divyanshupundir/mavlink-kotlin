package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GoproProtuneWhiteBalance(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Auto.
   */
  @GeneratedMavEnumEntry
  AUTO(0u),
  /**
   * 3000K.
   */
  @GeneratedMavEnumEntry
  _3000K(1u),
  /**
   * 5500K.
   */
  @GeneratedMavEnumEntry
  _5500K(2u),
  /**
   * 6500K.
   */
  @GeneratedMavEnumEntry
  _6500K(3u),
  /**
   * Camera Raw.
   */
  @GeneratedMavEnumEntry
  RAW(4u),
  ;

  public companion object : MavEnum.Companion<GoproProtuneWhiteBalance> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproProtuneWhiteBalance? = when (v) {
      0u -> AUTO
      1u -> _3000K
      2u -> _5500K
      3u -> _6500K
      4u -> RAW
      else -> null
    }
  }
}
