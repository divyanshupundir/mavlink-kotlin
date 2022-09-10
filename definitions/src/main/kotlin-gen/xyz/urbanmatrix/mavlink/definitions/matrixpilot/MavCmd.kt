package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavCmd(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Request storage of different parameter values and logs. This command will be only accepted if
   * in pre-flight mode.
   *
   * index = 1; 
   * Storage action: Action defined by MAV_PREFLIGHT_STORAGE_ACTION_ADVANCED
   *
   * index = 2; 
   * Storage area as defined by parameter database
   *
   * index = 3; 
   * Storage flags as defined by parameter database
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  MAV_CMD_PREFLIGHT_STORAGE_ADVANCED(0L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavCmd? = when (v) {
      0L -> MAV_CMD_PREFLIGHT_STORAGE_ADVANCED
      else -> null
    }
  }
}
