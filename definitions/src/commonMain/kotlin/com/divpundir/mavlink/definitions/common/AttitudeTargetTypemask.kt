package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Bitmap to indicate which dimensions should be ignored by the vehicle: a value of 0b00000000
 * indicates that none of the setpoint dimensions should be ignored.
 */
@GeneratedMavEnum(bitmask = true)
public enum class AttitudeTargetTypemask(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Ignore body roll rate
   */
  @GeneratedMavEnumEntry
  BODY_ROLL_RATE_IGNORE(1u),
  /**
   * Ignore body pitch rate
   */
  @GeneratedMavEnumEntry
  BODY_PITCH_RATE_IGNORE(2u),
  /**
   * Ignore body yaw rate
   */
  @GeneratedMavEnumEntry
  BODY_YAW_RATE_IGNORE(4u),
  /**
   * Use 3D body thrust setpoint instead of throttle
   */
  @GeneratedMavEnumEntry
  THRUST_BODY_SET(32u),
  /**
   * Ignore throttle
   */
  @GeneratedMavEnumEntry
  THROTTLE_IGNORE(64u),
  /**
   * Ignore attitude
   */
  @GeneratedMavEnumEntry
  ATTITUDE_IGNORE(128u),
  ;

  public companion object : MavBitmask.MavCompanion<AttitudeTargetTypemask> {
    override fun getEntryFromValueOrNull(v: UInt): AttitudeTargetTypemask? = when (v) {
      1u -> BODY_ROLL_RATE_IGNORE
      2u -> BODY_PITCH_RATE_IGNORE
      4u -> BODY_YAW_RATE_IGNORE
      32u -> THRUST_BODY_SET
      64u -> THROTTLE_IGNORE
      128u -> ATTITUDE_IGNORE
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<AttitudeTargetTypemask> = buildList {
      if (v and 1u == 1u) add(BODY_ROLL_RATE_IGNORE)
      if (v and 2u == 2u) add(BODY_PITCH_RATE_IGNORE)
      if (v and 4u == 4u) add(BODY_YAW_RATE_IGNORE)
      if (v and 32u == 32u) add(THRUST_BODY_SET)
      if (v and 64u == 64u) add(THROTTLE_IGNORE)
      if (v and 128u == 128u) add(ATTITUDE_IGNORE)
    }
  }
}
