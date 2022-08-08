package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Enable axes that will be tuned via autotuning. Used in MAV_CMD_DO_AUTOTUNE_ENABLE.
 */
@GeneratedMavEnum
public enum class AutotuneAxis(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Flight stack tunes axis according to its default settings.
   */
  AUTOTUNE_AXIS_DEFAULT(0L),
  /**
   * Autotune roll axis.
   */
  AUTOTUNE_AXIS_ROLL(1L),
  /**
   * Autotune pitch axis.
   */
  AUTOTUNE_AXIS_PITCH(2L),
  /**
   * Autotune yaw axis.
   */
  AUTOTUNE_AXIS_YAW(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): AutotuneAxis? = when (v) {
      0L -> AUTOTUNE_AXIS_DEFAULT
      1L -> AUTOTUNE_AXIS_ROLL
      2L -> AUTOTUNE_AXIS_PITCH
      4L -> AUTOTUNE_AXIS_YAW
      else -> null
    }
  }
}
