package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MagCalStatus(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  MAG_CAL_NOT_STARTED(0L),
  @GeneratedMavEnumEntry
  MAG_CAL_WAITING_TO_START(1L),
  @GeneratedMavEnumEntry
  MAG_CAL_RUNNING_STEP_ONE(2L),
  @GeneratedMavEnumEntry
  MAG_CAL_RUNNING_STEP_TWO(3L),
  @GeneratedMavEnumEntry
  MAG_CAL_SUCCESS(4L),
  @GeneratedMavEnumEntry
  MAG_CAL_FAILED(5L),
  @GeneratedMavEnumEntry
  MAG_CAL_BAD_ORIENTATION(6L),
  @GeneratedMavEnumEntry
  MAG_CAL_BAD_RADIUS(7L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MagCalStatus? = when (v) {
      0L -> MAG_CAL_NOT_STARTED
      1L -> MAG_CAL_WAITING_TO_START
      2L -> MAG_CAL_RUNNING_STEP_ONE
      3L -> MAG_CAL_RUNNING_STEP_TWO
      4L -> MAG_CAL_SUCCESS
      5L -> MAG_CAL_FAILED
      6L -> MAG_CAL_BAD_ORIENTATION
      7L -> MAG_CAL_BAD_RADIUS
      else -> null
    }
  }
}
