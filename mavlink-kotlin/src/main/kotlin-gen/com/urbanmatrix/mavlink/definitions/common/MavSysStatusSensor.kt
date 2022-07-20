package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * These encode the sensors whose status is sent as part of the SYS_STATUS message.
 */
public enum class MavSysStatusSensor(
  public override val `value`: Long,
) : MavEnum {
  /**
   * 0x01 3D gyro
   */
  MAV_SYS_STATUS_SENSOR_3D_GYRO(1L),
  /**
   * 0x02 3D accelerometer
   */
  MAV_SYS_STATUS_SENSOR_3D_ACCEL(2L),
  /**
   * 0x04 3D magnetometer
   */
  MAV_SYS_STATUS_SENSOR_3D_MAG(4L),
  /**
   * 0x08 absolute pressure
   */
  MAV_SYS_STATUS_SENSOR_ABSOLUTE_PRESSURE(8L),
  /**
   * 0x10 differential pressure
   */
  MAV_SYS_STATUS_SENSOR_DIFFERENTIAL_PRESSURE(16L),
  /**
   * 0x20 GPS
   */
  MAV_SYS_STATUS_SENSOR_GPS(32L),
  /**
   * 0x40 optical flow
   */
  MAV_SYS_STATUS_SENSOR_OPTICAL_FLOW(64L),
  /**
   * 0x80 computer vision position
   */
  MAV_SYS_STATUS_SENSOR_VISION_POSITION(128L),
  /**
   * 0x100 laser based position
   */
  MAV_SYS_STATUS_SENSOR_LASER_POSITION(256L),
  /**
   * 0x200 external ground truth (Vicon or Leica)
   */
  MAV_SYS_STATUS_SENSOR_EXTERNAL_GROUND_TRUTH(512L),
  /**
   * 0x400 3D angular rate control
   */
  MAV_SYS_STATUS_SENSOR_ANGULAR_RATE_CONTROL(1024L),
  /**
   * 0x800 attitude stabilization
   */
  MAV_SYS_STATUS_SENSOR_ATTITUDE_STABILIZATION(2048L),
  /**
   * 0x1000 yaw position
   */
  MAV_SYS_STATUS_SENSOR_YAW_POSITION(4096L),
  /**
   * 0x2000 z/altitude control
   */
  MAV_SYS_STATUS_SENSOR_Z_ALTITUDE_CONTROL(8192L),
  /**
   * 0x4000 x/y position control
   */
  MAV_SYS_STATUS_SENSOR_XY_POSITION_CONTROL(16384L),
  /**
   * 0x8000 motor outputs / control
   */
  MAV_SYS_STATUS_SENSOR_MOTOR_OUTPUTS(32768L),
  /**
   * 0x10000 rc receiver
   */
  MAV_SYS_STATUS_SENSOR_RC_RECEIVER(65536L),
  /**
   * 0x20000 2nd 3D gyro
   */
  MAV_SYS_STATUS_SENSOR_3D_GYRO2(131072L),
  /**
   * 0x40000 2nd 3D accelerometer
   */
  MAV_SYS_STATUS_SENSOR_3D_ACCEL2(262144L),
  /**
   * 0x80000 2nd 3D magnetometer
   */
  MAV_SYS_STATUS_SENSOR_3D_MAG2(524288L),
  /**
   * 0x100000 geofence
   */
  MAV_SYS_STATUS_GEOFENCE(1048576L),
  /**
   * 0x200000 AHRS subsystem health
   */
  MAV_SYS_STATUS_AHRS(2097152L),
  /**
   * 0x400000 Terrain subsystem health
   */
  MAV_SYS_STATUS_TERRAIN(4194304L),
  /**
   * 0x800000 Motors are reversed
   */
  MAV_SYS_STATUS_REVERSE_MOTOR(8388608L),
  /**
   * 0x1000000 Logging
   */
  MAV_SYS_STATUS_LOGGING(16777216L),
  /**
   * 0x2000000 Battery
   */
  MAV_SYS_STATUS_SENSOR_BATTERY(33554432L),
  /**
   * 0x4000000 Proximity
   */
  MAV_SYS_STATUS_SENSOR_PROXIMITY(67108864L),
  /**
   * 0x8000000 Satellite Communication 
   */
  MAV_SYS_STATUS_SENSOR_SATCOM(134217728L),
  /**
   * 0x10000000 pre-arm check status. Always healthy when armed
   */
  MAV_SYS_STATUS_PREARM_CHECK(268435456L),
  /**
   * 0x20000000 Avoidance/collision prevention
   */
  MAV_SYS_STATUS_OBSTACLE_AVOIDANCE(536870912L),
  /**
   * 0x40000000 propulsion (actuator, esc, motor or propellor)
   */
  MAV_SYS_STATUS_SENSOR_PROPULSION(1073741824L),
  /**
   * 0x80000000 Extended bit-field are used for further sensor status bits (needs to be set in
   * onboard_control_sensors_present only)
   */
  MAV_SYS_STATUS_EXTENSION_USED(2147483648L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavSysStatusSensor? = when (v) {
      1L -> MAV_SYS_STATUS_SENSOR_3D_GYRO
      2L -> MAV_SYS_STATUS_SENSOR_3D_ACCEL
      4L -> MAV_SYS_STATUS_SENSOR_3D_MAG
      8L -> MAV_SYS_STATUS_SENSOR_ABSOLUTE_PRESSURE
      16L -> MAV_SYS_STATUS_SENSOR_DIFFERENTIAL_PRESSURE
      32L -> MAV_SYS_STATUS_SENSOR_GPS
      64L -> MAV_SYS_STATUS_SENSOR_OPTICAL_FLOW
      128L -> MAV_SYS_STATUS_SENSOR_VISION_POSITION
      256L -> MAV_SYS_STATUS_SENSOR_LASER_POSITION
      512L -> MAV_SYS_STATUS_SENSOR_EXTERNAL_GROUND_TRUTH
      1024L -> MAV_SYS_STATUS_SENSOR_ANGULAR_RATE_CONTROL
      2048L -> MAV_SYS_STATUS_SENSOR_ATTITUDE_STABILIZATION
      4096L -> MAV_SYS_STATUS_SENSOR_YAW_POSITION
      8192L -> MAV_SYS_STATUS_SENSOR_Z_ALTITUDE_CONTROL
      16384L -> MAV_SYS_STATUS_SENSOR_XY_POSITION_CONTROL
      32768L -> MAV_SYS_STATUS_SENSOR_MOTOR_OUTPUTS
      65536L -> MAV_SYS_STATUS_SENSOR_RC_RECEIVER
      131072L -> MAV_SYS_STATUS_SENSOR_3D_GYRO2
      262144L -> MAV_SYS_STATUS_SENSOR_3D_ACCEL2
      524288L -> MAV_SYS_STATUS_SENSOR_3D_MAG2
      1048576L -> MAV_SYS_STATUS_GEOFENCE
      2097152L -> MAV_SYS_STATUS_AHRS
      4194304L -> MAV_SYS_STATUS_TERRAIN
      8388608L -> MAV_SYS_STATUS_REVERSE_MOTOR
      16777216L -> MAV_SYS_STATUS_LOGGING
      33554432L -> MAV_SYS_STATUS_SENSOR_BATTERY
      67108864L -> MAV_SYS_STATUS_SENSOR_PROXIMITY
      134217728L -> MAV_SYS_STATUS_SENSOR_SATCOM
      268435456L -> MAV_SYS_STATUS_PREARM_CHECK
      536870912L -> MAV_SYS_STATUS_OBSTACLE_AVOIDANCE
      1073741824L -> MAV_SYS_STATUS_SENSOR_PROPULSION
      2147483648L -> MAV_SYS_STATUS_EXTENSION_USED
      else -> null
    }
  }
}
