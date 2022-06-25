package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Enumeration of distance sensor types
 */
public enum class MavDistanceSensor(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Laser rangefinder, e.g. LightWare SF02/F or PulsedLight units
   */
  MAV_DISTANCE_SENSOR_LASER(0L),
  /**
   * Ultrasound rangefinder, e.g. MaxBotix units
   */
  MAV_DISTANCE_SENSOR_ULTRASOUND(1L),
  /**
   * Infrared rangefinder, e.g. Sharp units
   */
  MAV_DISTANCE_SENSOR_INFRARED(2L),
  /**
   * Radar type, e.g. uLanding units
   */
  MAV_DISTANCE_SENSOR_RADAR(3L),
  /**
   * Broken or unknown type, e.g. analog units
   */
  MAV_DISTANCE_SENSOR_UNKNOWN(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavDistanceSensor? = when (v) {
      0L -> MAV_DISTANCE_SENSOR_LASER
      1L -> MAV_DISTANCE_SENSOR_ULTRASOUND
      2L -> MAV_DISTANCE_SENSOR_INFRARED
      3L -> MAV_DISTANCE_SENSOR_RADAR
      4L -> MAV_DISTANCE_SENSOR_UNKNOWN
      else -> null
    }
  }
}
