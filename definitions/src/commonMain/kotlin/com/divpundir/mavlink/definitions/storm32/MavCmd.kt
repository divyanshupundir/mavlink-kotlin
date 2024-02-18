package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import com.divpundir.mavlink.api.WorkInProgress
import kotlin.UInt

@GeneratedMavEnum
public enum class MavCmd(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Command to a gimbal manager to control the gimbal tilt and pan angles. It is possible to set
   * combinations of the values below. E.g. an angle as well as a desired angular rate can be used to
   * get to this angle at a certain angular rate, or an angular rate only will result in continuous
   * turning. NaN is to be used to signal unset. A gimbal device is never to react to this command.
   *
   * index = 1; label = Pitch angle; units = deg; 
   * Pitch/tilt angle (positive: tilt up). NaN to be ignored.
   *
   * index = 2; label = Yaw angle; units = deg; 
   * Yaw/pan angle (positive: pan to the right). NaN to be ignored. The frame is determined by the
   * GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags.
   *
   * index = 3; label = Pitch rate; units = deg/s; 
   * Pitch/tilt rate (positive: tilt up). NaN to be ignored.
   *
   * index = 4; label = Yaw rate; units = deg/s; 
   * Yaw/pan rate (positive: pan to the right). NaN to be ignored. The frame is determined by the
   * GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags.
   *
   * index = 5; label = Gimbal device flags; 
   * Gimbal device flags to be applied.
   *
   * index = 6; label = Gimbal manager flags; 
   * Gimbal manager flags to be applied.
   *
   * index = 7; label = Gimbal ID and client; 
   * Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink gimbal, 0 for
   * all gimbals). Send command multiple times for more than one but not all gimbals. The client is
   * copied into bits 8-15.
   */
  @GeneratedMavEnumEntry
  STORM32_DO_GIMBAL_MANAGER_CONTROL_PITCHYAW(60_002u),
  /**
   * Command to configure a gimbal manager. A gimbal device is never to react to this command. The
   * selected profile is reported in the STORM32_GIMBAL_MANAGER_STATUS message.
   *
   * index = 1; label = Profile; 
   * Gimbal manager profile (0 = default).
   *
   * index = 7; label = Gimbal ID; 
   * Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink gimbal, 0 for
   * all gimbals). Send command multiple times for more than one but not all gimbals.
   */
  @WorkInProgress
  @GeneratedMavEnumEntry
  STORM32_DO_GIMBAL_MANAGER_SETUP(60_010u),
  /**
   * Command to set the shot manager mode.
   *
   * index = 1; label = Mode; 
   * Set shot mode.
   *
   * index = 2; label = Shot state or command; 
   * Set shot state or command. The allowed values are specific to the selected shot mode.
   */
  @WorkInProgress
  @GeneratedMavEnumEntry
  QSHOT_DO_CONFIGURE(60_020u),
  ;

  public companion object : MavEnum.MavCompanion<MavCmd> {
    override fun getEntryFromValueOrNull(v: UInt): MavCmd? = when (v) {
      60002u -> STORM32_DO_GIMBAL_MANAGER_CONTROL_PITCHYAW
      60010u -> STORM32_DO_GIMBAL_MANAGER_SETUP
      60020u -> QSHOT_DO_CONFIGURE
      else -> null
    }
  }
}
