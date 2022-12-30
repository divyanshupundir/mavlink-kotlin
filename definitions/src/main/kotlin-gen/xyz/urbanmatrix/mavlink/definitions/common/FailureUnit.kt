package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * List of possible units where failures can be injected.
 */
@GeneratedMavEnum
public enum class FailureUnit(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  SENSOR_GYRO(0L),
  @GeneratedMavEnumEntry
  SENSOR_ACCEL(1L),
  @GeneratedMavEnumEntry
  SENSOR_MAG(2L),
  @GeneratedMavEnumEntry
  SENSOR_BARO(3L),
  @GeneratedMavEnumEntry
  SENSOR_GPS(4L),
  @GeneratedMavEnumEntry
  SENSOR_OPTICAL_FLOW(5L),
  @GeneratedMavEnumEntry
  SENSOR_VIO(6L),
  @GeneratedMavEnumEntry
  SENSOR_DISTANCE_SENSOR(7L),
  @GeneratedMavEnumEntry
  SENSOR_AIRSPEED(8L),
  @GeneratedMavEnumEntry
  SYSTEM_BATTERY(100L),
  @GeneratedMavEnumEntry
  SYSTEM_MOTOR(101L),
  @GeneratedMavEnumEntry
  SYSTEM_SERVO(102L),
  @GeneratedMavEnumEntry
  SYSTEM_AVOIDANCE(103L),
  @GeneratedMavEnumEntry
  SYSTEM_RC_SIGNAL(104L),
  @GeneratedMavEnumEntry
  SYSTEM_MAVLINK_SIGNAL(105L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): FailureUnit? = when (v) {
      0L -> SENSOR_GYRO
      1L -> SENSOR_ACCEL
      2L -> SENSOR_MAG
      3L -> SENSOR_BARO
      4L -> SENSOR_GPS
      5L -> SENSOR_OPTICAL_FLOW
      6L -> SENSOR_VIO
      7L -> SENSOR_DISTANCE_SENSOR
      8L -> SENSOR_AIRSPEED
      100L -> SYSTEM_BATTERY
      101L -> SYSTEM_MOTOR
      102L -> SYSTEM_SERVO
      103L -> SYSTEM_AVOIDANCE
      104L -> SYSTEM_RC_SIGNAL
      105L -> SYSTEM_MAVLINK_SIGNAL
      else -> null
    }
  }
}
