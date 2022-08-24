package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Bitmap to indicate which dimensions should be ignored by the vehicle: a value of
 * 0b0000000000000000 or 0b0000001000000000 indicates that none of the setpoint dimensions should be
 * ignored. If bit 9 is set the floats afx afy afz should be interpreted as force instead of
 * acceleration.
 */
@GeneratedMavEnum
public enum class PositionTargetTypemask(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Ignore position x
   */
  POSITION_TARGET_TYPEMASK_X_IGNORE(1L),
  /**
   * Ignore position y
   */
  POSITION_TARGET_TYPEMASK_Y_IGNORE(2L),
  /**
   * Ignore position z
   */
  POSITION_TARGET_TYPEMASK_Z_IGNORE(4L),
  /**
   * Ignore velocity x
   */
  POSITION_TARGET_TYPEMASK_VX_IGNORE(8L),
  /**
   * Ignore velocity y
   */
  POSITION_TARGET_TYPEMASK_VY_IGNORE(16L),
  /**
   * Ignore velocity z
   */
  POSITION_TARGET_TYPEMASK_VZ_IGNORE(32L),
  /**
   * Ignore acceleration x
   */
  POSITION_TARGET_TYPEMASK_AX_IGNORE(64L),
  /**
   * Ignore acceleration y
   */
  POSITION_TARGET_TYPEMASK_AY_IGNORE(128L),
  /**
   * Ignore acceleration z
   */
  POSITION_TARGET_TYPEMASK_AZ_IGNORE(256L),
  /**
   * Use force instead of acceleration
   */
  POSITION_TARGET_TYPEMASK_FORCE_SET(512L),
  /**
   * Ignore yaw
   */
  POSITION_TARGET_TYPEMASK_YAW_IGNORE(1024L),
  /**
   * Ignore yaw rate
   */
  POSITION_TARGET_TYPEMASK_YAW_RATE_IGNORE(2048L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): PositionTargetTypemask? = when (v) {
      1L -> POSITION_TARGET_TYPEMASK_X_IGNORE
      2L -> POSITION_TARGET_TYPEMASK_Y_IGNORE
      4L -> POSITION_TARGET_TYPEMASK_Z_IGNORE
      8L -> POSITION_TARGET_TYPEMASK_VX_IGNORE
      16L -> POSITION_TARGET_TYPEMASK_VY_IGNORE
      32L -> POSITION_TARGET_TYPEMASK_VZ_IGNORE
      64L -> POSITION_TARGET_TYPEMASK_AX_IGNORE
      128L -> POSITION_TARGET_TYPEMASK_AY_IGNORE
      256L -> POSITION_TARGET_TYPEMASK_AZ_IGNORE
      512L -> POSITION_TARGET_TYPEMASK_FORCE_SET
      1024L -> POSITION_TARGET_TYPEMASK_YAW_IGNORE
      2048L -> POSITION_TARGET_TYPEMASK_YAW_RATE_IGNORE
      else -> null
    }
  }
}
