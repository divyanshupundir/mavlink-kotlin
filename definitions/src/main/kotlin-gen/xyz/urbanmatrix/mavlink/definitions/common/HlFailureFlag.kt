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
  GPS(1L),
  /**
   * Differential pressure sensor failure.
   */
  @GeneratedMavEnumEntry
  DIFFERENTIAL_PRESSURE(2L),
  /**
   * Absolute pressure sensor failure.
   */
  @GeneratedMavEnumEntry
  ABSOLUTE_PRESSURE(4L),
  /**
   * Accelerometer sensor failure.
   */
  @GeneratedMavEnumEntry
  _3D_ACCEL(8L),
  /**
   * Gyroscope sensor failure.
   */
  @GeneratedMavEnumEntry
  _3D_GYRO(16L),
  /**
   * Magnetometer sensor failure.
   */
  @GeneratedMavEnumEntry
  _3D_MAG(32L),
  /**
   * Terrain subsystem failure.
   */
  @GeneratedMavEnumEntry
  TERRAIN(64L),
  /**
   * Battery failure/critical low battery.
   */
  @GeneratedMavEnumEntry
  BATTERY(128L),
  /**
   * RC receiver failure/no rc connection.
   */
  @GeneratedMavEnumEntry
  RC_RECEIVER(256L),
  /**
   * Offboard link failure.
   */
  @GeneratedMavEnumEntry
  OFFBOARD_LINK(512L),
  /**
   * Engine failure.
   */
  @GeneratedMavEnumEntry
  ENGINE(1024L),
  /**
   * Geofence violation.
   */
  @GeneratedMavEnumEntry
  GEOFENCE(2048L),
  /**
   * Estimator failure, for example measurement rejection or large variances.
   */
  @GeneratedMavEnumEntry
  ESTIMATOR(4096L),
  /**
   * Mission failure.
   */
  @GeneratedMavEnumEntry
  MISSION(8192L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): HlFailureFlag? = when (v) {
      1L -> GPS
      2L -> DIFFERENTIAL_PRESSURE
      4L -> ABSOLUTE_PRESSURE
      8L -> _3D_ACCEL
      16L -> _3D_GYRO
      32L -> _3D_MAG
      64L -> TERRAIN
      128L -> BATTERY
      256L -> RC_RECEIVER
      512L -> OFFBOARD_LINK
      1024L -> ENGINE
      2048L -> GEOFENCE
      4096L -> ESTIMATOR
      8192L -> MISSION
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<HlFailureFlag> = buildList {
      if (v and 1L == 1L) add(GPS)
      if (v and 2L == 2L) add(DIFFERENTIAL_PRESSURE)
      if (v and 4L == 4L) add(ABSOLUTE_PRESSURE)
      if (v and 8L == 8L) add(_3D_ACCEL)
      if (v and 16L == 16L) add(_3D_GYRO)
      if (v and 32L == 32L) add(_3D_MAG)
      if (v and 64L == 64L) add(TERRAIN)
      if (v and 128L == 128L) add(BATTERY)
      if (v and 256L == 256L) add(RC_RECEIVER)
      if (v and 512L == 512L) add(OFFBOARD_LINK)
      if (v and 1024L == 1024L) add(ENGINE)
      if (v and 2048L == 2048L) add(GEOFENCE)
      if (v and 4096L == 4096L) add(ESTIMATOR)
      if (v and 8192L == 8192L) add(MISSION)
    }
  }
}
