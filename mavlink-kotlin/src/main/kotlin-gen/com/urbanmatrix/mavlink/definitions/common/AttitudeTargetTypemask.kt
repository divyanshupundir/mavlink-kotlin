package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Bitmap to indicate which dimensions should be ignored by the vehicle: a value of 0b00000000
 * indicates that none of the setpoint dimensions should be ignored.
 */
public enum class AttitudeTargetTypemask(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Ignore body roll rate
   */
  ATTITUDE_TARGET_TYPEMASK_BODY_ROLL_RATE_IGNORE(1L),
  /**
   * Ignore body pitch rate
   */
  ATTITUDE_TARGET_TYPEMASK_BODY_PITCH_RATE_IGNORE(2L),
  /**
   * Ignore body yaw rate
   */
  ATTITUDE_TARGET_TYPEMASK_BODY_YAW_RATE_IGNORE(4L),
  /**
   * Use 3D body thrust setpoint instead of throttle
   */
  ATTITUDE_TARGET_TYPEMASK_THRUST_BODY_SET(32L),
  /**
   * Ignore throttle
   */
  ATTITUDE_TARGET_TYPEMASK_THROTTLE_IGNORE(64L),
  /**
   * Ignore attitude
   */
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
