package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Enable axes that will be tuned via autotuning. Used in MAV_CMD_DO_AUTOTUNE_ENABLE.
 */
@GeneratedMavEnum(bitmask = true)
public enum class AutotuneAxis(
  public override val `value`: Long,
) : MavBitmask {
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

    public fun getFlagsFromValue(v: Long): List<AutotuneAxis> = buildList {
      if (v and 0L == 0L) add(AUTOTUNE_AXIS_DEFAULT)
      if (v and 1L == 1L) add(AUTOTUNE_AXIS_ROLL)
      if (v and 2L == 2L) add(AUTOTUNE_AXIS_PITCH)
      if (v and 4L == 4L) add(AUTOTUNE_AXIS_YAW)
    }
  }
}
