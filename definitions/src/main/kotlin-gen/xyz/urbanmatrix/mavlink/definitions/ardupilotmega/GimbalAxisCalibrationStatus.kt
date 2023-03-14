package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GimbalAxisCalibrationStatus(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Axis calibration is in progress.
   */
  @GeneratedMavEnumEntry
  IN_PROGRESS(0u),
  /**
   * Axis calibration succeeded.
   */
  @GeneratedMavEnumEntry
  SUCCEEDED(1u),
  /**
   * Axis calibration failed.
   */
  @GeneratedMavEnumEntry
  FAILED(2u),
  ;

  public companion object : MavEnum.Companion<GimbalAxisCalibrationStatus> {
    public override fun getEntryFromValueOrNull(v: UInt): GimbalAxisCalibrationStatus? = when (v) {
      0u -> IN_PROGRESS
      1u -> SUCCEEDED
      2u -> FAILED
      else -> null
    }
  }
}
