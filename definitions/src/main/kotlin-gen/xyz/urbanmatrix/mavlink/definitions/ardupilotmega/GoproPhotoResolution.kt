package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

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

  public companion object : MavEnum.Companion<GoproPhotoResolution> {
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
