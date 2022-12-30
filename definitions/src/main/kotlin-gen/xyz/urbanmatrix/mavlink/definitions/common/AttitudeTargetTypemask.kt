package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Bitmap to indicate which dimensions should be ignored by the vehicle: a value of 0b00000000
 * indicates that none of the setpoint dimensions should be ignored.
 */
@GeneratedMavEnum(bitmask = true)
public enum class AttitudeTargetTypemask(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * Ignore body roll rate
   */
  @GeneratedMavEnumEntry
  BODY_ROLL_RATE_IGNORE(1L),
  /**
   * Ignore body pitch rate
   */
  @GeneratedMavEnumEntry
  BODY_PITCH_RATE_IGNORE(2L),
  /**
   * Ignore body yaw rate
   */
  @GeneratedMavEnumEntry
  BODY_YAW_RATE_IGNORE(4L),
  /**
   * Use 3D body thrust setpoint instead of throttle
   */
  @GeneratedMavEnumEntry
  THRUST_BODY_SET(32L),
  /**
   * Ignore throttle
   */
  @GeneratedMavEnumEntry
  THROTTLE_IGNORE(64L),
  /**
   * Ignore attitude
   */
  @GeneratedMavEnumEntry
  ATTITUDE_IGNORE(128L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): AttitudeTargetTypemask? = when (v) {
      1L -> BODY_ROLL_RATE_IGNORE
      2L -> BODY_PITCH_RATE_IGNORE
      4L -> BODY_YAW_RATE_IGNORE
      32L -> THRUST_BODY_SET
      64L -> THROTTLE_IGNORE
      128L -> ATTITUDE_IGNORE
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<AttitudeTargetTypemask> = buildList {
      if (v and 1L == 1L) add(BODY_ROLL_RATE_IGNORE)
      if (v and 2L == 2L) add(BODY_PITCH_RATE_IGNORE)
      if (v and 4L == 4L) add(BODY_YAW_RATE_IGNORE)
      if (v and 32L == 32L) add(THRUST_BODY_SET)
      if (v and 64L == 64L) add(THROTTLE_IGNORE)
      if (v and 128L == 128L) add(ATTITUDE_IGNORE)
    }
  }
}
