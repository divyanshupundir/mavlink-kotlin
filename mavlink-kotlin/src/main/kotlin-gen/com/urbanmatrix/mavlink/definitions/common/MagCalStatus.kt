package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class MagCalStatus(
  public override val `value`: Long,
) : MavEnum {
  MAG_CAL_NOT_STARTED(0L),
  MAG_CAL_WAITING_TO_START(1L),
  MAG_CAL_RUNNING_STEP_ONE(2L),
  MAG_CAL_RUNNING_STEP_TWO(3L),
  MAG_CAL_SUCCESS(4L),
  MAG_CAL_FAILED(5L),
  MAG_CAL_BAD_ORIENTATION(6L),
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
