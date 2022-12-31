package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproProtuneGain(
  public override val `value`: Long,
) : MavEnum {
  /**
   * ISO 400.
   */
  @GeneratedMavEnumEntry
  _400(0L),
  /**
   * ISO 800 (Only Hero 4).
   */
  @GeneratedMavEnumEntry
  _800(1L),
  /**
   * ISO 1600.
   */
  @GeneratedMavEnumEntry
  _1600(2L),
  /**
   * ISO 3200 (Only Hero 4).
   */
  @GeneratedMavEnumEntry
  _3200(3L),
  /**
   * ISO 6400.
   */
  @GeneratedMavEnumEntry
  _6400(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproProtuneGain? = when (v) {
      0L -> _400
      1L -> _800
      2L -> _1600
      3L -> _3200
      4L -> _6400
      else -> null
    }
  }
}
