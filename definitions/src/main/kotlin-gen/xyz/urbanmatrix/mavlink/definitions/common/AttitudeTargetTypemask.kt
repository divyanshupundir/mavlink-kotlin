package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Bitmap to indicate which dimensions should be ignored by the vehicle: a value of 0b00000000
 * indicates that none of the setpoint dimensions should be ignored.
 */
@GeneratedMavEnum
public enum class AttitudeTargetTypemask(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Ignore body roll rate
   */
  @GeneratedMavEnumEntry
  ATTITUDE_TARGET_TYPEMASK_BODY_ROLL_RATE_IGNORE(1L),
  /**
   * Ignore body pitch rate
   */
  @GeneratedMavEnumEntry
  ATTITUDE_TARGET_TYPEMASK_BODY_PITCH_RATE_IGNORE(2L),
  /**
   * Ignore body yaw rate
   */
  @GeneratedMavEnumEntry
  ATTITUDE_TARGET_TYPEMASK_BODY_YAW_RATE_IGNORE(4L),
  /**
   * Use 3D body thrust setpoint instead of throttle
   */
  @GeneratedMavEnumEntry
  ATTITUDE_TARGET_TYPEMASK_THRUST_BODY_SET(32L),
  /**
   * Ignore throttle
   */
  @GeneratedMavEnumEntry
  ATTITUDE_TARGET_TYPEMASK_THROTTLE_IGNORE(64L),
  /**
   * Ignore attitude
   */
  @GeneratedMavEnumEntry
  ATTITUDE_TARGET_TYPEMASK_ATTITUDE_IGNORE(128L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): AttitudeTargetTypemask? = when (v) {
      1L -> ATTITUDE_TARGET_TYPEMASK_BODY_ROLL_RATE_IGNORE
      2L -> ATTITUDE_TARGET_TYPEMASK_BODY_PITCH_RATE_IGNORE
      4L -> ATTITUDE_TARGET_TYPEMASK_BODY_YAW_RATE_IGNORE
      32L -> ATTITUDE_TARGET_TYPEMASK_THRUST_BODY_SET
      64L -> ATTITUDE_TARGET_TYPEMASK_THROTTLE_IGNORE
      128L -> ATTITUDE_TARGET_TYPEMASK_ATTITUDE_IGNORE
      else -> null
    }
  }
}
