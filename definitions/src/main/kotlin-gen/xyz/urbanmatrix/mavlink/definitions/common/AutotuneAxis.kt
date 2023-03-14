package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Enable axes that will be tuned via autotuning. Used in MAV_CMD_DO_AUTOTUNE_ENABLE.
 */
@GeneratedMavEnum(bitmask = true)
public enum class AutotuneAxis(
  public override val `value`: UInt,
) : MavBitmask {
  /**
   * Flight stack tunes axis according to its default settings.
   */
  @GeneratedMavEnumEntry
  DEFAULT(0u),
  /**
   * Autotune roll axis.
   */
  @GeneratedMavEnumEntry
  ROLL(1u),
  /**
   * Autotune pitch axis.
   */
  @GeneratedMavEnumEntry
  PITCH(2u),
  /**
   * Autotune yaw axis.
   */
  @GeneratedMavEnumEntry
  YAW(4u),
  ;

  public companion object : MavEnum.Companion<AutotuneAxis>, MavBitmask.Companion<AutotuneAxis> {
    public override fun getEntryFromValueOrNull(v: UInt): AutotuneAxis? = when (v) {
      0u -> DEFAULT
      1u -> ROLL
      2u -> PITCH
      4u -> YAW
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<AutotuneAxis> = buildList {
      if (v and 0u == 0u) add(DEFAULT)
      if (v and 1u == 1u) add(ROLL)
      if (v and 2u == 2u) add(PITCH)
      if (v and 4u == 4u) add(YAW)
    }
  }
}
