package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproPhotoResolution(
  public override val `value`: Long,
) : MavEnum {
  /**
   * 5MP Medium.
   */
  @GeneratedMavEnumEntry
  _5MP_MEDIUM(0L),
  /**
   * 7MP Medium.
   */
  @GeneratedMavEnumEntry
  _7MP_MEDIUM(1L),
  /**
   * 7MP Wide.
   */
  @GeneratedMavEnumEntry
  _7MP_WIDE(2L),
  /**
   * 10MP Wide.
   */
  @GeneratedMavEnumEntry
  _10MP_WIDE(3L),
  /**
   * 12MP Wide.
   */
  @GeneratedMavEnumEntry
  _12MP_WIDE(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproPhotoResolution? = when (v) {
      0L -> _5MP_MEDIUM
      1L -> _7MP_MEDIUM
      2L -> _7MP_WIDE
      3L -> _10MP_WIDE
      4L -> _12MP_WIDE
      else -> null
    }
  }
}
