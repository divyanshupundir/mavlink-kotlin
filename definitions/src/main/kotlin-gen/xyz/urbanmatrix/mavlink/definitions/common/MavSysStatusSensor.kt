package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * These encode the sensors whose status is sent as part of the SYS_STATUS message.
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavSysStatusSensor(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * 0x01 3D gyro
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_3D_GYRO(1L),
  /**
   * 0x02 3D accelerometer
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_3D_ACCEL(2L),
  /**
   * 0x04 3D magnetometer
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_3D_MAG(4L),
  /**
   * 0x08 absolute pressure
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_ABSOLUTE_PRESSURE(8L),
  /**
   * 0x10 differential pressure
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_DIFFERENTIAL_PRESSURE(16L),
  /**
   * 0x20 GPS
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_GPS(32L),
  /**
   * 0x40 optical flow
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_OPTICAL_FLOW(64L),
  /**
   * 0x80 computer vision position
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_VISION_POSITION(128L),
  /**
   * 0x100 laser based position
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_LASER_POSITION(256L),
  /**
   * 0x200 external ground truth (Vicon or Leica)
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_EXTERNAL_GROUND_TRUTH(512L),
  /**
   * 0x400 3D angular rate control
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_ANGULAR_RATE_CONTROL(1024L),
  /**
   * 0x800 attitude stabilization
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_ATTITUDE_STABILIZATION(2048L),
  /**
   * 0x1000 yaw position
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_YAW_POSITION(4096L),
  /**
   * 0x2000 z/altitude control
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_Z_ALTITUDE_CONTROL(8192L),
  /**
   * 0x4000 x/y position control
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_XY_POSITION_CONTROL(16384L),
  /**
   * 0x8000 motor outputs / control
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_MOTOR_OUTPUTS(32768L),
  /**
   * 0x10000 rc receiver
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_RC_RECEIVER(65536L),
  /**
   * 0x20000 2nd 3D gyro
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_3D_GYRO2(131072L),
  /**
   * 0x40000 2nd 3D accelerometer
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_3D_ACCEL2(262144L),
  /**
   * 0x80000 2nd 3D magnetometer
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_3D_MAG2(524288L),
  /**
   * 0x100000 geofence
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_GEOFENCE(1048576L),
  /**
   * 0x200000 AHRS subsystem health
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_AHRS(2097152L),
  /**
   * 0x400000 Terrain subsystem health
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_TERRAIN(4194304L),
  /**
   * 0x800000 Motors are reversed
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_REVERSE_MOTOR(8388608L),
  /**
   * 0x1000000 Logging
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_LOGGING(16777216L),
  /**
   * 0x2000000 Battery
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_BATTERY(33554432L),
  /**
   * 0x4000000 Proximity
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_PROXIMITY(67108864L),
  /**
   * 0x8000000 Satellite Communication 
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_SATCOM(134217728L),
  /**
   * 0x10000000 pre-arm check status. Always healthy when armed
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_PREARM_CHECK(268435456L),
  /**
   * 0x20000000 Avoidance/collision prevention
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_OBSTACLE_AVOIDANCE(536870912L),
  /**
   * 0x40000000 propulsion (actuator, esc, motor or propellor)
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_SENSOR_PROPULSION(1073741824L),
  /**
   * 0x80000000 Extended bit-field are used for further sensor status bits (needs to be set in
   * onboard_control_sensors_present only)
   */
  @GeneratedMavEnumEntry
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

    public fun getFlagsFromValue(v: Long): List<MavSysStatusSensor> = buildList {
      if (v and 1L == 1L) add(MAV_SYS_STATUS_SENSOR_3D_GYRO)
      if (v and 2L == 2L) add(MAV_SYS_STATUS_SENSOR_3D_ACCEL)
      if (v and 4L == 4L) add(MAV_SYS_STATUS_SENSOR_3D_MAG)
      if (v and 8L == 8L) add(MAV_SYS_STATUS_SENSOR_ABSOLUTE_PRESSURE)
      if (v and 16L == 16L) add(MAV_SYS_STATUS_SENSOR_DIFFERENTIAL_PRESSURE)
      if (v and 32L == 32L) add(MAV_SYS_STATUS_SENSOR_GPS)
      if (v and 64L == 64L) add(MAV_SYS_STATUS_SENSOR_OPTICAL_FLOW)
      if (v and 128L == 128L) add(MAV_SYS_STATUS_SENSOR_VISION_POSITION)
      if (v and 256L == 256L) add(MAV_SYS_STATUS_SENSOR_LASER_POSITION)
      if (v and 512L == 512L) add(MAV_SYS_STATUS_SENSOR_EXTERNAL_GROUND_TRUTH)
      if (v and 1024L == 1024L) add(MAV_SYS_STATUS_SENSOR_ANGULAR_RATE_CONTROL)
      if (v and 2048L == 2048L) add(MAV_SYS_STATUS_SENSOR_ATTITUDE_STABILIZATION)
      if (v and 4096L == 4096L) add(MAV_SYS_STATUS_SENSOR_YAW_POSITION)
      if (v and 8192L == 8192L) add(MAV_SYS_STATUS_SENSOR_Z_ALTITUDE_CONTROL)
      if (v and 16384L == 16384L) add(MAV_SYS_STATUS_SENSOR_XY_POSITION_CONTROL)
      if (v and 32768L == 32768L) add(MAV_SYS_STATUS_SENSOR_MOTOR_OUTPUTS)
      if (v and 65536L == 65536L) add(MAV_SYS_STATUS_SENSOR_RC_RECEIVER)
      if (v and 131072L == 131072L) add(MAV_SYS_STATUS_SENSOR_3D_GYRO2)
      if (v and 262144L == 262144L) add(MAV_SYS_STATUS_SENSOR_3D_ACCEL2)
      if (v and 524288L == 524288L) add(MAV_SYS_STATUS_SENSOR_3D_MAG2)
      if (v and 1048576L == 1048576L) add(MAV_SYS_STATUS_GEOFENCE)
      if (v and 2097152L == 2097152L) add(MAV_SYS_STATUS_AHRS)
      if (v and 4194304L == 4194304L) add(MAV_SYS_STATUS_TERRAIN)
      if (v and 8388608L == 8388608L) add(MAV_SYS_STATUS_REVERSE_MOTOR)
      if (v and 16777216L == 16777216L) add(MAV_SYS_STATUS_LOGGING)
      if (v and 33554432L == 33554432L) add(MAV_SYS_STATUS_SENSOR_BATTERY)
      if (v and 67108864L == 67108864L) add(MAV_SYS_STATUS_SENSOR_PROXIMITY)
      if (v and 134217728L == 134217728L) add(MAV_SYS_STATUS_SENSOR_SATCOM)
      if (v and 268435456L == 268435456L) add(MAV_SYS_STATUS_PREARM_CHECK)
      if (v and 536870912L == 536870912L) add(MAV_SYS_STATUS_OBSTACLE_AVOIDANCE)
      if (v and 1073741824L == 1073741824L) add(MAV_SYS_STATUS_SENSOR_PROPULSION)
      if (v and 2147483648L == 2147483648L) add(MAV_SYS_STATUS_EXTENSION_USED)
    }
  }
}
