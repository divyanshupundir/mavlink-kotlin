package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * List of possible units where failures can be injected.
 */
@GeneratedMavEnum
public enum class FailureUnit(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  SENSOR_GYRO(0u),
  @GeneratedMavEnumEntry
  SENSOR_ACCEL(1u),
  @GeneratedMavEnumEntry
  SENSOR_MAG(2u),
  @GeneratedMavEnumEntry
  SENSOR_BARO(3u),
  @GeneratedMavEnumEntry
  SENSOR_GPS(4u),
  @GeneratedMavEnumEntry
  SENSOR_OPTICAL_FLOW(5u),
  @GeneratedMavEnumEntry
  SENSOR_VIO(6u),
  @GeneratedMavEnumEntry
  SENSOR_DISTANCE_SENSOR(7u),
  @GeneratedMavEnumEntry
  SENSOR_AIRSPEED(8u),
  @GeneratedMavEnumEntry
  SYSTEM_BATTERY(100u),
  @GeneratedMavEnumEntry
  SYSTEM_MOTOR(101u),
  @GeneratedMavEnumEntry
  SYSTEM_SERVO(102u),
  @GeneratedMavEnumEntry
  SYSTEM_AVOIDANCE(103u),
  @GeneratedMavEnumEntry
  SYSTEM_RC_SIGNAL(104u),
  @GeneratedMavEnumEntry
  SYSTEM_MAVLINK_SIGNAL(105u),
  ;

  public companion object : MavEnum.MavCompanion<FailureUnit> {
    override fun getEntryFromValueOrNull(v: UInt): FailureUnit? = when (v) {
      0u -> SENSOR_GYRO
      1u -> SENSOR_ACCEL
      2u -> SENSOR_MAG
      3u -> SENSOR_BARO
      4u -> SENSOR_GPS
      5u -> SENSOR_OPTICAL_FLOW
      6u -> SENSOR_VIO
      7u -> SENSOR_DISTANCE_SENSOR
      8u -> SENSOR_AIRSPEED
      100u -> SYSTEM_BATTERY
      101u -> SYSTEM_MOTOR
      102u -> SYSTEM_SERVO
      103u -> SYSTEM_AVOIDANCE
      104u -> SYSTEM_RC_SIGNAL
      105u -> SYSTEM_MAVLINK_SIGNAL
      else -> null
    }
  }
}
