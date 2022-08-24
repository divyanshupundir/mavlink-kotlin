package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GimbalAxisCalibrationRequired(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Whether or not this axis requires calibration is unknown at this time.
   */
  GIMBAL_AXIS_CALIBRATION_REQUIRED_UNKNOWN(0L),
  /**
   * This axis requires calibration.
   */
  GIMBAL_AXIS_CALIBRATION_REQUIRED_TRUE(1L),
  /**
   * This axis does not require calibration.
   */
  GIMBAL_AXIS_CALIBRATION_REQUIRED_FALSE(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GimbalAxisCalibrationRequired? = when (v) {
      0L -> GIMBAL_AXIS_CALIBRATION_REQUIRED_UNKNOWN
      1L -> GIMBAL_AXIS_CALIBRATION_REQUIRED_TRUE
      2L -> GIMBAL_AXIS_CALIBRATION_REQUIRED_FALSE
      else -> null
    }
  }
}
