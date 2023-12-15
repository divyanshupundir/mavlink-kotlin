package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GoproPhotoResolution(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * 5MP Medium.
   */
  @GeneratedMavEnumEntry
  _5MP_MEDIUM(0u),
  /**
   * 7MP Medium.
   */
  @GeneratedMavEnumEntry
  _7MP_MEDIUM(1u),
  /**
   * 7MP Wide.
   */
  @GeneratedMavEnumEntry
  _7MP_WIDE(2u),
  /**
   * 10MP Wide.
   */
  @GeneratedMavEnumEntry
  _10MP_WIDE(3u),
  /**
   * 12MP Wide.
   */
  @GeneratedMavEnumEntry
  _12MP_WIDE(4u),
  ;

  public companion object : MavEnum.MavCompanion<GoproPhotoResolution> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproPhotoResolution? = when (v) {
      0u -> _5MP_MEDIUM
      1u -> _7MP_MEDIUM
      2u -> _7MP_WIDE
      3u -> _10MP_WIDE
      4u -> _12MP_WIDE
      else -> null
    }
  }
}
