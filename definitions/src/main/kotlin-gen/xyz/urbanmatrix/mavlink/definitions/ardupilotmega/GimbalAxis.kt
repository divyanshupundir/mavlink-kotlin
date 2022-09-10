package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GimbalAxis(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Gimbal yaw axis.
   */
  @GeneratedMavEnumEntry
  GIMBAL_AXIS_YAW(0L),
  /**
   * Gimbal pitch axis.
   */
  @GeneratedMavEnumEntry
  GIMBAL_AXIS_PITCH(1L),
  /**
   * Gimbal roll axis.
   */
  @GeneratedMavEnumEntry
  GIMBAL_AXIS_ROLL(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GimbalAxis? = when (v) {
      0L -> GIMBAL_AXIS_YAW
      1L -> GIMBAL_AXIS_PITCH
      2L -> GIMBAL_AXIS_ROLL
      else -> null
    }
  }
}
