package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Flags to report failure cases over the high latency telemtry.
 */
@GeneratedMavEnum(bitmask = true)
public enum class HlFailureFlag(
  public override val `value`: Long,
) : MavBitmask {
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

    public fun getFlagsFromValue(v: Long): List<HlFailureFlag> = buildList {
      if (v and 1L == 1L) add(HL_FAILURE_FLAG_GPS)
      if (v and 2L == 2L) add(HL_FAILURE_FLAG_DIFFERENTIAL_PRESSURE)
      if (v and 4L == 4L) add(HL_FAILURE_FLAG_ABSOLUTE_PRESSURE)
      if (v and 8L == 8L) add(HL_FAILURE_FLAG_3D_ACCEL)
      if (v and 16L == 16L) add(HL_FAILURE_FLAG_3D_GYRO)
      if (v and 32L == 32L) add(HL_FAILURE_FLAG_3D_MAG)
      if (v and 64L == 64L) add(HL_FAILURE_FLAG_TERRAIN)
      if (v and 128L == 128L) add(HL_FAILURE_FLAG_BATTERY)
      if (v and 256L == 256L) add(HL_FAILURE_FLAG_RC_RECEIVER)
      if (v and 512L == 512L) add(HL_FAILURE_FLAG_OFFBOARD_LINK)
      if (v and 1024L == 1024L) add(HL_FAILURE_FLAG_ENGINE)
      if (v and 2048L == 2048L) add(HL_FAILURE_FLAG_GEOFENCE)
      if (v and 4096L == 4096L) add(HL_FAILURE_FLAG_ESTIMATOR)
      if (v and 8192L == 8192L) add(HL_FAILURE_FLAG_MISSION)
    }
  }
}
