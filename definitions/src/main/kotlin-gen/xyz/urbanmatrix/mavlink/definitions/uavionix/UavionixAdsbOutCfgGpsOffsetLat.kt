package xyz.urbanmatrix.mavlink.definitions.uavionix

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * GPS lataral offset encoding
 */
@GeneratedMavEnum
public enum class UavionixAdsbOutCfgGpsOffsetLat(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  NO_DATA(0L),
  @GeneratedMavEnumEntry
  LEFT_2M(1L),
  @GeneratedMavEnumEntry
  LEFT_4M(2L),
  @GeneratedMavEnumEntry
  LEFT_6M(3L),
  @GeneratedMavEnumEntry
  RIGHT_0M(4L),
  @GeneratedMavEnumEntry
  RIGHT_2M(5L),
  @GeneratedMavEnumEntry
  RIGHT_4M(6L),
  @GeneratedMavEnumEntry
  RIGHT_6M(7L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UavionixAdsbOutCfgGpsOffsetLat? = when (v) {
      0L -> NO_DATA
      1L -> LEFT_2M
      2L -> LEFT_4M
      3L -> LEFT_6M
      4L -> RIGHT_0M
      5L -> RIGHT_2M
      6L -> RIGHT_4M
      7L -> RIGHT_6M
      else -> null
    }
  }
}
