package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

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
  @GeneratedMavEnumEntry
  AUTOTUNE_AXIS_DEFAULT(0L),
  /**
   * Autotune roll axis.
   */
  @GeneratedMavEnumEntry
  AUTOTUNE_AXIS_ROLL(1L),
  /**
   * Autotune pitch axis.
   */
  @GeneratedMavEnumEntry
  AUTOTUNE_AXIS_PITCH(2L),
  /**
   * Autotune yaw axis.
   */
  @GeneratedMavEnumEntry
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
