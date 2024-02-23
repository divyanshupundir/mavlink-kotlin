package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * These encode the sensors whose status is sent as part of the SYS_STATUS message.
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavSysStatusSensor(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * 0x01 3D gyro
   */
  @GeneratedMavEnumEntry
  _3D_GYRO(1u),
  /**
   * 0x02 3D accelerometer
   */
  @GeneratedMavEnumEntry
  _3D_ACCEL(2u),
  /**
   * 0x04 3D magnetometer
   */
  @GeneratedMavEnumEntry
  _3D_MAG(4u),
  /**
   * 0x08 absolute pressure
   */
  @GeneratedMavEnumEntry
  ABSOLUTE_PRESSURE(8u),
  /**
   * 0x10 differential pressure
   */
  @GeneratedMavEnumEntry
  DIFFERENTIAL_PRESSURE(16u),
  /**
   * 0x20 GPS
   */
  @GeneratedMavEnumEntry
  GPS(32u),
  /**
   * 0x40 optical flow
   */
  @GeneratedMavEnumEntry
  OPTICAL_FLOW(64u),
  /**
   * 0x80 computer vision position
   */
  @GeneratedMavEnumEntry
  VISION_POSITION(128u),
  /**
   * 0x100 laser based position
   */
  @GeneratedMavEnumEntry
  LASER_POSITION(256u),
  /**
   * 0x200 external ground truth (Vicon or Leica)
   */
  @GeneratedMavEnumEntry
  EXTERNAL_GROUND_TRUTH(512u),
  /**
   * 0x400 3D angular rate control
   */
  @GeneratedMavEnumEntry
  ANGULAR_RATE_CONTROL(1_024u),
  /**
   * 0x800 attitude stabilization
   */
  @GeneratedMavEnumEntry
  ATTITUDE_STABILIZATION(2_048u),
  /**
   * 0x1000 yaw position
   */
  @GeneratedMavEnumEntry
  YAW_POSITION(4_096u),
  /**
   * 0x2000 z/altitude control
   */
  @GeneratedMavEnumEntry
  Z_ALTITUDE_CONTROL(8_192u),
  /**
   * 0x4000 x/y position control
   */
  @GeneratedMavEnumEntry
  XY_POSITION_CONTROL(16_384u),
  /**
   * 0x8000 motor outputs / control
   */
  @GeneratedMavEnumEntry
  MOTOR_OUTPUTS(32_768u),
  /**
   * 0x10000 RC receiver
   */
  @GeneratedMavEnumEntry
  RC_RECEIVER(65_536u),
  /**
   * 0x20000 2nd 3D gyro
   */
  @GeneratedMavEnumEntry
  _3D_GYRO2(131_072u),
  /**
   * 0x40000 2nd 3D accelerometer
   */
  @GeneratedMavEnumEntry
  _3D_ACCEL2(262_144u),
  /**
   * 0x80000 2nd 3D magnetometer
   */
  @GeneratedMavEnumEntry
  _3D_MAG2(524_288u),
  /**
   * 0x100000 geofence
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_GEOFENCE(1_048_576u),
  /**
   * 0x200000 AHRS subsystem health
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_AHRS(2_097_152u),
  /**
   * 0x400000 Terrain subsystem health
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_TERRAIN(4_194_304u),
  /**
   * 0x800000 Motors are reversed
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_REVERSE_MOTOR(8_388_608u),
  /**
   * 0x1000000 Logging
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_LOGGING(16_777_216u),
  /**
   * 0x2000000 Battery
   */
  @GeneratedMavEnumEntry
  BATTERY(33_554_432u),
  /**
   * 0x4000000 Proximity
   */
  @GeneratedMavEnumEntry
  PROXIMITY(67_108_864u),
  /**
   * 0x8000000 Satellite Communication 
   */
  @GeneratedMavEnumEntry
  SATCOM(134_217_728u),
  /**
   * 0x10000000 pre-arm check status. Always healthy when armed
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_PREARM_CHECK(268_435_456u),
  /**
   * 0x20000000 Avoidance/collision prevention
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_OBSTACLE_AVOIDANCE(536_870_912u),
  /**
   * 0x40000000 propulsion (actuator, esc, motor or propellor)
   */
  @GeneratedMavEnumEntry
  PROPULSION(1_073_741_824u),
  /**
   * 0x80000000 Extended bit-field are used for further sensor status bits (needs to be set in
   * onboard_control_sensors_present only)
   */
  @GeneratedMavEnumEntry
  MAV_SYS_STATUS_EXTENSION_USED(2_147_483_648u),
  ;

  public companion object : MavBitmask.MavCompanion<MavSysStatusSensor> {
    override fun getEntryFromValueOrNull(v: UInt): MavSysStatusSensor? = when (v) {
      1u -> _3D_GYRO
      2u -> _3D_ACCEL
      4u -> _3D_MAG
      8u -> ABSOLUTE_PRESSURE
      16u -> DIFFERENTIAL_PRESSURE
      32u -> GPS
      64u -> OPTICAL_FLOW
      128u -> VISION_POSITION
      256u -> LASER_POSITION
      512u -> EXTERNAL_GROUND_TRUTH
      1024u -> ANGULAR_RATE_CONTROL
      2048u -> ATTITUDE_STABILIZATION
      4096u -> YAW_POSITION
      8192u -> Z_ALTITUDE_CONTROL
      16384u -> XY_POSITION_CONTROL
      32768u -> MOTOR_OUTPUTS
      65536u -> RC_RECEIVER
      131072u -> _3D_GYRO2
      262144u -> _3D_ACCEL2
      524288u -> _3D_MAG2
      1048576u -> MAV_SYS_STATUS_GEOFENCE
      2097152u -> MAV_SYS_STATUS_AHRS
      4194304u -> MAV_SYS_STATUS_TERRAIN
      8388608u -> MAV_SYS_STATUS_REVERSE_MOTOR
      16777216u -> MAV_SYS_STATUS_LOGGING
      33554432u -> BATTERY
      67108864u -> PROXIMITY
      134217728u -> SATCOM
      268435456u -> MAV_SYS_STATUS_PREARM_CHECK
      536870912u -> MAV_SYS_STATUS_OBSTACLE_AVOIDANCE
      1073741824u -> PROPULSION
      2147483648u -> MAV_SYS_STATUS_EXTENSION_USED
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<MavSysStatusSensor> = buildList {
      if (v and 1u == 1u) add(_3D_GYRO)
      if (v and 2u == 2u) add(_3D_ACCEL)
      if (v and 4u == 4u) add(_3D_MAG)
      if (v and 8u == 8u) add(ABSOLUTE_PRESSURE)
      if (v and 16u == 16u) add(DIFFERENTIAL_PRESSURE)
      if (v and 32u == 32u) add(GPS)
      if (v and 64u == 64u) add(OPTICAL_FLOW)
      if (v and 128u == 128u) add(VISION_POSITION)
      if (v and 256u == 256u) add(LASER_POSITION)
      if (v and 512u == 512u) add(EXTERNAL_GROUND_TRUTH)
      if (v and 1024u == 1024u) add(ANGULAR_RATE_CONTROL)
      if (v and 2048u == 2048u) add(ATTITUDE_STABILIZATION)
      if (v and 4096u == 4096u) add(YAW_POSITION)
      if (v and 8192u == 8192u) add(Z_ALTITUDE_CONTROL)
      if (v and 16384u == 16384u) add(XY_POSITION_CONTROL)
      if (v and 32768u == 32768u) add(MOTOR_OUTPUTS)
      if (v and 65536u == 65536u) add(RC_RECEIVER)
      if (v and 131072u == 131072u) add(_3D_GYRO2)
      if (v and 262144u == 262144u) add(_3D_ACCEL2)
      if (v and 524288u == 524288u) add(_3D_MAG2)
      if (v and 1048576u == 1048576u) add(MAV_SYS_STATUS_GEOFENCE)
      if (v and 2097152u == 2097152u) add(MAV_SYS_STATUS_AHRS)
      if (v and 4194304u == 4194304u) add(MAV_SYS_STATUS_TERRAIN)
      if (v and 8388608u == 8388608u) add(MAV_SYS_STATUS_REVERSE_MOTOR)
      if (v and 16777216u == 16777216u) add(MAV_SYS_STATUS_LOGGING)
      if (v and 33554432u == 33554432u) add(BATTERY)
      if (v and 67108864u == 67108864u) add(PROXIMITY)
      if (v and 134217728u == 134217728u) add(SATCOM)
      if (v and 268435456u == 268435456u) add(MAV_SYS_STATUS_PREARM_CHECK)
      if (v and 536870912u == 536870912u) add(MAV_SYS_STATUS_OBSTACLE_AVOIDANCE)
      if (v and 1073741824u == 1073741824u) add(PROPULSION)
      if (v and 2147483648u == 2147483648u) add(MAV_SYS_STATUS_EXTENSION_USED)
    }
  }
}
