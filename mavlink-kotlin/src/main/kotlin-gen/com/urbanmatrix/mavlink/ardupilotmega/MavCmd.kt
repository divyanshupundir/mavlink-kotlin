package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class MavCmd(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Set the distance to be repeated on mission resume
   *
   * index = 1; label = Distance; units = m; 
   * Distance.
   *
   * index = 2; 
   * Empty.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_DO_SET_RESUME_REPEAT_DIST(215L),
  /**
   * Control attached liquid sprayer
   *
   * index = 1; label = Sprayer Enable; 
   * 0: disable sprayer. 1: enable sprayer.
   *
   * index = 2; 
   * Empty.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_DO_SPRAYER(216L),
  /**
   * Pass instructions onto scripting, a script should be checking for a new command
   *
   * index = 1; label = ID; 
   * uint16 ID value to be passed to scripting
   *
   * index = 2; label = param 1; 
   * float value to be passed to scripting
   *
   * index = 3; label = param 2; 
   * float value to be passed to scripting
   *
   * index = 4; label = param 3; 
   * float value to be passed to scripting
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_DO_SEND_SCRIPT_MESSAGE(217L),
  /**
   * Execute auxiliary function
   *
   * index = 1; label = AuxiliaryFunction; 
   * Auxiliary Function.
   *
   * index = 2; label = SwitchPosition; 
   * Switch Level.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_DO_AUX_FUNCTION(218L),
  /**
   * Mission command to wait for an altitude or downwards vertical speed. This is meant for high
   * altitude balloon launches, allowing the aircraft to be idle until either an altitude is reached or
   * a negative vertical speed is reached (indicating early balloon burst). The wiggle time is how
   * often to wiggle the control surfaces to prevent them seizing up.
   *
   * index = 1; label = Altitude; units = m; 
   * Altitude.
   *
   * index = 2; label = Descent Speed; units = m/s; 
   * Descent speed.
   *
   * index = 3; label = Wiggle Time; units = s; 
   * How long to wiggle the control surfaces to prevent them seizing up.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_NAV_ALTITUDE_WAIT(83L),
  /**
   * A system wide power-off event has been initiated.
   *
   * index = 1; 
   * Empty.
   *
   * index = 2; 
   * Empty.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_POWER_OFF_INITIATED(42000L),
  /**
   * FLY button has been clicked.
   *
   * index = 1; 
   * Empty.
   *
   * index = 2; 
   * Empty.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_SOLO_BTN_FLY_CLICK(42001L),
  /**
   * FLY button has been held for 1.5 seconds.
   *
   * index = 1; label = Takeoff Altitude; units = m; 
   * Takeoff altitude.
   *
   * index = 2; 
   * Empty.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_SOLO_BTN_FLY_HOLD(42002L),
  /**
   * PAUSE button has been clicked.
   *
   * index = 1; label = Shot Mode; 
   * 1 if Solo is in a shot mode, 0 otherwise.
   *
   * index = 2; 
   * Empty.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_SOLO_BTN_PAUSE_CLICK(42003L),
  /**
   * Magnetometer calibration based on fixed position
   *         in earth field given by inclination, declination and intensity.
   *
   * index = 1; label = Declination; units = deg; 
   * Magnetic declination.
   *
   * index = 2; label = Inclination; units = deg; 
   * Magnetic inclination.
   *
   * index = 3; label = Intensity; units = mgauss; 
   * Magnetic intensity.
   *
   * index = 4; label = Yaw; units = deg; 
   * Yaw.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_FIXED_MAG_CAL(42004L),
  /**
   * Magnetometer calibration based on fixed expected field values.
   *
   * index = 1; label = Field X; units = mgauss; 
   * Field strength X.
   *
   * index = 2; label = Field Y; units = mgauss; 
   * Field strength Y.
   *
   * index = 3; label = Field Z; units = mgauss; 
   * Field strength Z.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_FIXED_MAG_CAL_FIELD(42005L),
  /**
   * Set EKF sensor source set.
   *
   * index = 1; label = SourceSetId; 
   * Source Set Id.
   *
   * index = 2; 
   * Empty.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_SET_EKF_SOURCE_SET(42007L),
  /**
   * Initiate a magnetometer calibration.
   *
   * index = 1; label = Magnetometers Bitmask; 
   * Bitmask of magnetometers to calibrate. Use 0 to calibrate all sensors that can be started
   * (sensors may not start if disabled, unhealthy, etc.). The command will NACK if calibration does
   * not start for a sensor explicitly specified by the bitmask.
   *
   * index = 2; label = Retry on Failure; 
   * Automatically retry on failure (0=no retry, 1=retry).
   *
   * index = 3; label = Autosave; 
   * Save without user input (0=require input, 1=autosave).
   *
   * index = 4; label = Delay; units = s; 
   * Delay.
   *
   * index = 5; label = Autoreboot; 
   * Autoreboot (0=user reboot, 1=autoreboot).
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_DO_START_MAG_CAL(42424L),
  /**
   * Accept a magnetometer calibration.
   *
   * index = 1; label = Magnetometers Bitmask; 
   * Bitmask of magnetometers that calibration is accepted (0 means all).
   *
   * index = 2; 
   * Empty.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_DO_ACCEPT_MAG_CAL(42425L),
  /**
   * Cancel a running magnetometer calibration.
   *
   * index = 1; label = Magnetometers Bitmask; 
   * Bitmask of magnetometers to cancel a running calibration (0 means all).
   *
   * index = 2; 
   * Empty.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_DO_CANCEL_MAG_CAL(42426L),
  /**
   * Used when doing accelerometer calibration. When sent to the GCS tells it what position to put
   * the vehicle in. When sent to the vehicle says what position the vehicle is in.
   *
   * index = 1; label = Position; 
   * Position.
   *
   * index = 2; 
   * Empty.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_ACCELCAL_VEHICLE_POS(42429L),
  /**
   * Reply with the version banner.
   *
   * index = 1; 
   * Empty.
   *
   * index = 2; 
   * Empty.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_DO_SEND_BANNER(42428L),
  /**
   * Command autopilot to get into factory test/diagnostic mode.
   *
   * index = 1; label = Test Mode; 
   * 0: activate test mode, 1: exit test mode.
   *
   * index = 2; 
   * Empty.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_SET_FACTORY_TEST_MODE(42427L),
  /**
   * Causes the gimbal to reset and boot as if it was just powered on.
   *
   * index = 1; 
   * Empty.
   *
   * index = 2; 
   * Empty.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_GIMBAL_RESET(42501L),
  /**
   * Reports progress and success or failure of gimbal axis calibration procedure.
   *
   * index = 1; label = Axis; 
   * Gimbal axis we're reporting calibration progress for.
   *
   * index = 2; label = Progress; units = %; 
   * Current calibration progress for this axis.
   *
   * index = 3; label = Status; 
   * Status of the calibration.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_GIMBAL_AXIS_CALIBRATION_STATUS(42502L),
  /**
   * Starts commutation calibration on the gimbal.
   *
   * index = 1; 
   * Empty.
   *
   * index = 2; 
   * Empty.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_GIMBAL_REQUEST_AXIS_CALIBRATION(42503L),
  /**
   * Erases gimbal application and parameters.
   *
   * index = 1; 
   * Magic number.
   *
   * index = 2; 
   * Magic number.
   *
   * index = 3; 
   * Magic number.
   *
   * index = 4; 
   * Magic number.
   *
   * index = 5; 
   * Magic number.
   *
   * index = 6; 
   * Magic number.
   *
   * index = 7; 
   * Magic number.
   */
  MAV_CMD_GIMBAL_FULL_RESET(42505L),
  /**
   * Update the bootloader
   *
   * index = 1; 
   * Empty
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; label = Magic Number; 
   * Magic number - set to 290876 to actually flash
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  MAV_CMD_FLASH_BOOTLOADER(42650L),
  /**
   * Reset battery capacity for batteries that accumulate consumed battery via integration.
   *
   * index = 1; label = battery mask; 
   * Bitmask of batteries to reset. Least significant bit is for the first battery.
   *
   * index = 2; label = percentage; 
   * Battery percentage remaining to set.
   */
  MAV_CMD_BATTERY_RESET(42651L),
  /**
   * Issue a trap signal to the autopilot process, presumably to enter the debugger.
   *
   * index = 1; 
   * Magic number - set to 32451 to actually trap.
   *
   * index = 2; 
   * Empty.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  MAV_CMD_DEBUG_TRAP(42700L),
  /**
   * Control onboard scripting.
   *
   * index = 1; 
   * Scripting command to execute
   */
  MAV_CMD_SCRIPTING(42701L),
  /**
   * Scripting command as NAV command with wait for completion.
   *
   * index = 1; label = command; 
   * integer command number (0 to 255)
   *
   * index = 2; label = timeout; units = s; 
   * timeout for operation in seconds. Zero means no timeout (0 to 255)
   *
   * index = 3; label = arg1; 
   * argument1.
   *
   * index = 4; label = arg2; 
   * argument2.
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  MAV_CMD_NAV_SCRIPT_TIME(42702L),
  /**
   * Maintain an attitude for a specified time.
   *
   * index = 1; label = time; units = s; 
   * Time to maintain specified attitude and climb rate
   *
   * index = 2; label = roll; units = deg; 
   * Roll angle in degrees (positive is lean right, negative is lean left)
   *
   * index = 3; label = pitch; units = deg; 
   * Pitch angle in degrees (positive is lean back, negative is lean forward)
   *
   * index = 4; label = yaw; units = deg; 
   * Yaw angle
   *
   * index = 5; label = climb_rate; units = m/s; 
   * Climb rate
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  MAV_CMD_NAV_ATTITUDE_TIME(42703L),
  /**
   * Change flight speed at a given rate. This slews the vehicle at a controllable rate between it's
   * previous speed and the new one. (affects GUIDED only. Outside GUIDED, aircraft ignores these
   * commands. Designed for onboard companion-computer command-and-control, not normally operator/GCS
   * control.)
   *
   * index = 1; label = speed type; 
   * Airspeed or groundspeed.
   *
   * index = 2; label = speed target; units = m/s; 
   * Target Speed
   *
   * index = 3; label = speed rate-of-change; units = m/s/s; 
   * Acceleration rate, 0 to take effect instantly
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  MAV_CMD_GUIDED_CHANGE_SPEED(43000L),
  /**
   * Change target altitude at a given rate. This slews the vehicle at a controllable rate between
   * it's previous altitude and the new one. (affects GUIDED only. Outside GUIDED, aircraft ignores
   * these commands. Designed for onboard companion-computer command-and-control, not normally
   * operator/GCS control.)
   *
   * index = 1; 
   * Empty
   *
   * index = 2; 
   * Empty
   *
   * index = 3; label = alt rate-of-change; units = m/s/s; 
   * Rate of change, toward new altitude. 0 for maximum rate change. Positive numbers only, as
   * negative numbers will not converge on the new target alt.
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; label = target alt; units = m; 
   * Target Altitude
   */
  MAV_CMD_GUIDED_CHANGE_ALTITUDE(43001L),
  /**
   * Change to target heading at a given rate, overriding previous heading/s. This slews the vehicle
   * at a controllable rate between it's previous heading and the new one. (affects GUIDED only.
   * Exiting GUIDED returns aircraft to normal behaviour defined elsewhere. Designed for onboard
   * companion-computer command-and-control, not normally operator/GCS control.)
   *
   * index = 1; label = heading type; 
   * course-over-ground or raw vehicle heading.
   *
   * index = 2; label = heading target; units = deg; 
   * Target heading.
   *
   * index = 3; label = heading rate-of-change; units = m/s/s; 
   * Maximum centripetal accelearation, ie rate of change,  toward new heading.
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  MAV_CMD_GUIDED_CHANGE_HEADING(43002L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavCmd? = when (v) {
      215L -> MAV_CMD_DO_SET_RESUME_REPEAT_DIST
      216L -> MAV_CMD_DO_SPRAYER
      217L -> MAV_CMD_DO_SEND_SCRIPT_MESSAGE
      218L -> MAV_CMD_DO_AUX_FUNCTION
      83L -> MAV_CMD_NAV_ALTITUDE_WAIT
      42000L -> MAV_CMD_POWER_OFF_INITIATED
      42001L -> MAV_CMD_SOLO_BTN_FLY_CLICK
      42002L -> MAV_CMD_SOLO_BTN_FLY_HOLD
      42003L -> MAV_CMD_SOLO_BTN_PAUSE_CLICK
      42004L -> MAV_CMD_FIXED_MAG_CAL
      42005L -> MAV_CMD_FIXED_MAG_CAL_FIELD
      42007L -> MAV_CMD_SET_EKF_SOURCE_SET
      42424L -> MAV_CMD_DO_START_MAG_CAL
      42425L -> MAV_CMD_DO_ACCEPT_MAG_CAL
      42426L -> MAV_CMD_DO_CANCEL_MAG_CAL
      42429L -> MAV_CMD_ACCELCAL_VEHICLE_POS
      42428L -> MAV_CMD_DO_SEND_BANNER
      42427L -> MAV_CMD_SET_FACTORY_TEST_MODE
      42501L -> MAV_CMD_GIMBAL_RESET
      42502L -> MAV_CMD_GIMBAL_AXIS_CALIBRATION_STATUS
      42503L -> MAV_CMD_GIMBAL_REQUEST_AXIS_CALIBRATION
      42505L -> MAV_CMD_GIMBAL_FULL_RESET
      42650L -> MAV_CMD_FLASH_BOOTLOADER
      42651L -> MAV_CMD_BATTERY_RESET
      42700L -> MAV_CMD_DEBUG_TRAP
      42701L -> MAV_CMD_SCRIPTING
      42702L -> MAV_CMD_NAV_SCRIPT_TIME
      42703L -> MAV_CMD_NAV_ATTITUDE_TIME
      43000L -> MAV_CMD_GUIDED_CHANGE_SPEED
      43001L -> MAV_CMD_GUIDED_CHANGE_ALTITUDE
      43002L -> MAV_CMD_GUIDED_CHANGE_HEADING
      else -> null
    }
  }
}
