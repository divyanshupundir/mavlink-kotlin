package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproProtuneWhiteBalance(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Auto.
   */
  @GeneratedMavEnumEntry
  AUTO(0L),
  /**
   * 3000K.
   */
  @GeneratedMavEnumEntry
  _3000K(1L),
  /**
   * 5500K.
   */
  @GeneratedMavEnumEntry
  _5500K(2L),
  /**
   * 6500K.
   */
  @GeneratedMavEnumEntry
  _6500K(3L),
  /**
   * Camera Raw.
   */
  @GeneratedMavEnumEntry
  RAW(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproProtuneWhiteBalance? = when (v) {
      0L -> AUTO
      1L -> _3000K
      2L -> _5500K
      3L -> _6500K
      4L -> RAW
      else -> null
    }
  }
}
