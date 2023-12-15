package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

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

  public companion object : MavEnum.MavCompanion<GimbalAxisCalibrationStatus> {
    public override fun getEntryFromValueOrNull(v: UInt): GimbalAxisCalibrationStatus? = when (v) {
      0u -> IN_PROGRESS
      1u -> SUCCEEDED
      2u -> FAILED
      else -> null
    }
  }
}
