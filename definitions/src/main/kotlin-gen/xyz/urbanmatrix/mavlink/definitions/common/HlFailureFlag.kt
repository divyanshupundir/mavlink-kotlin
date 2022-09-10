package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Flags to report failure cases over the high latency telemtry.
 */
@GeneratedMavEnum
public enum class HlFailureFlag(
  public override val `value`: Long,
) : MavEnum {
  /**
   * GPS failure.
   */
  @GeneratedMavEnumEntry
  HL_FAILURE_FLAG_GPS(1L),
  /**
   * Differential pressure sensor failure.
   */
  @GeneratedMavEnumEntry
  HL_FAILURE_FLAG_DIFFERENTIAL_PRESSURE(2L),
  /**
   * Absolute pressure sensor failure.
   */
  @GeneratedMavEnumEntry
  HL_FAILURE_FLAG_ABSOLUTE_PRESSURE(4L),
  /**
   * Accelerometer sensor failure.
   */
  @GeneratedMavEnumEntry
  HL_FAILURE_FLAG_3D_ACCEL(8L),
  /**
   * Gyroscope sensor failure.
   */
  @GeneratedMavEnumEntry
  HL_FAILURE_FLAG_3D_GYRO(16L),
  /**
   * Magnetometer sensor failure.
   */
  @GeneratedMavEnumEntry
  HL_FAILURE_FLAG_3D_MAG(32L),
  /**
   * Terrain subsystem failure.
   */
  @GeneratedMavEnumEntry
  HL_FAILURE_FLAG_TERRAIN(64L),
  /**
   * Battery failure/critical low battery.
   */
  @GeneratedMavEnumEntry
  HL_FAILURE_FLAG_BATTERY(128L),
  /**
   * RC receiver failure/no rc connection.
   */
  @GeneratedMavEnumEntry
  HL_FAILURE_FLAG_RC_RECEIVER(256L),
  /**
   * Offboard link failure.
   */
  @GeneratedMavEnumEntry
  HL_FAILURE_FLAG_OFFBOARD_LINK(512L),
  /**
   * Engine failure.
   */
  @GeneratedMavEnumEntry
  HL_FAILURE_FLAG_ENGINE(1024L),
  /**
   * Geofence violation.
   */
  @GeneratedMavEnumEntry
  HL_FAILURE_FLAG_GEOFENCE(2048L),
  /**
   * Estimator failure, for example measurement rejection or large variances.
   */
  @GeneratedMavEnumEntry
  HL_FAILURE_FLAG_ESTIMATOR(4096L),
  /**
   * Mission failure.
   */
  @GeneratedMavEnumEntry
  HL_FAILURE_FLAG_MISSION(8192L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): HlFailureFlag? = when (v) {
      1L -> HL_FAILURE_FLAG_GPS
      2L -> HL_FAILURE_FLAG_DIFFERENTIAL_PRESSURE
      4L -> HL_FAILURE_FLAG_ABSOLUTE_PRESSURE
      8L -> HL_FAILURE_FLAG_3D_ACCEL
      16L -> HL_FAILURE_FLAG_3D_GYRO
      32L -> HL_FAILURE_FLAG_3D_MAG
      64L -> HL_FAILURE_FLAG_TERRAIN
      128L -> HL_FAILURE_FLAG_BATTERY
      256L -> HL_FAILURE_FLAG_RC_RECEIVER
      512L -> HL_FAILURE_FLAG_OFFBOARD_LINK
      1024L -> HL_FAILURE_FLAG_ENGINE
      2048L -> HL_FAILURE_FLAG_GEOFENCE
      4096L -> HL_FAILURE_FLAG_ESTIMATOR
      8192L -> HL_FAILURE_FLAG_MISSION
      else -> null
    }
  }
}
