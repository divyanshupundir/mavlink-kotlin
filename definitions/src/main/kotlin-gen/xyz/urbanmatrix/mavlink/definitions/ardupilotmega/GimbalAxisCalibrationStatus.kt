package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GimbalAxisCalibrationStatus(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Axis calibration is in progress.
   */
  @GeneratedMavEnumEntry
  IN_PROGRESS(0L),
  /**
   * Axis calibration succeeded.
   */
  @GeneratedMavEnumEntry
  SUCCEEDED(1L),
  /**
   * Axis calibration failed.
   */
  @GeneratedMavEnumEntry
  FAILED(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GimbalAxisCalibrationStatus? = when (v) {
      0L -> IN_PROGRESS
      1L -> SUCCEEDED
      2L -> FAILED
      else -> null
    }
  }
}
