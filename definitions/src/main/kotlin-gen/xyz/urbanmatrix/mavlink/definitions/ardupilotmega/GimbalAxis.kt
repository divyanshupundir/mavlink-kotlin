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
  YAW(0L),
  /**
   * Gimbal pitch axis.
   */
  @GeneratedMavEnumEntry
  PITCH(1L),
  /**
   * Gimbal roll axis.
   */
  @GeneratedMavEnumEntry
  ROLL(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GimbalAxis? = when (v) {
      0L -> YAW
      1L -> PITCH
      2L -> ROLL
      else -> null
    }
  }
}
