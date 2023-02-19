package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Flags to report failure cases over the high latency telemtry.
 */
@GeneratedMavEnum(bitmask = true)
public enum class HlFailureFlag(
  public override val `value`: UInt,
) : MavBitmask {
  /**
   * GPS failure.
   */
  @GeneratedMavEnumEntry
  GPS(1u),
  /**
   * Differential pressure sensor failure.
   */
  @GeneratedMavEnumEntry
  DIFFERENTIAL_PRESSURE(2u),
  /**
   * Absolute pressure sensor failure.
   */
  @GeneratedMavEnumEntry
  ABSOLUTE_PRESSURE(4u),
  /**
   * Accelerometer sensor failure.
   */
  @GeneratedMavEnumEntry
  _3D_ACCEL(8u),
  /**
   * Gyroscope sensor failure.
   */
  @GeneratedMavEnumEntry
  _3D_GYRO(16u),
  /**
   * Magnetometer sensor failure.
   */
  @GeneratedMavEnumEntry
  _3D_MAG(32u),
  /**
   * Terrain subsystem failure.
   */
  @GeneratedMavEnumEntry
  TERRAIN(64u),
  /**
   * Battery failure/critical low battery.
   */
  @GeneratedMavEnumEntry
  BATTERY(128u),
  /**
   * RC receiver failure/no rc connection.
   */
  @GeneratedMavEnumEntry
  RC_RECEIVER(256u),
  /**
   * Offboard link failure.
   */
  @GeneratedMavEnumEntry
  OFFBOARD_LINK(512u),
  /**
   * Engine failure.
   */
  @GeneratedMavEnumEntry
  ENGINE(1024u),
  /**
   * Geofence violation.
   */
  @GeneratedMavEnumEntry
  GEOFENCE(2048u),
  /**
   * Estimator failure, for example measurement rejection or large variances.
   */
  @GeneratedMavEnumEntry
  ESTIMATOR(4096u),
  /**
   * Mission failure.
   */
  @GeneratedMavEnumEntry
  MISSION(8192u),
  ;

  public companion object : MavEnum.Companion<HlFailureFlag>, MavBitmask.Companion<HlFailureFlag> {
    public override fun getEntryFromValueOrNull(v: UInt): HlFailureFlag? = when (v) {
      1u -> GPS
      2u -> DIFFERENTIAL_PRESSURE
      4u -> ABSOLUTE_PRESSURE
      8u -> _3D_ACCEL
      16u -> _3D_GYRO
      32u -> _3D_MAG
      64u -> TERRAIN
      128u -> BATTERY
      256u -> RC_RECEIVER
      512u -> OFFBOARD_LINK
      1024u -> ENGINE
      2048u -> GEOFENCE
      4096u -> ESTIMATOR
      8192u -> MISSION
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<HlFailureFlag> = buildList {
      if (v and 1u == 1u) add(GPS)
      if (v and 2u == 2u) add(DIFFERENTIAL_PRESSURE)
      if (v and 4u == 4u) add(ABSOLUTE_PRESSURE)
      if (v and 8u == 8u) add(_3D_ACCEL)
      if (v and 16u == 16u) add(_3D_GYRO)
      if (v and 32u == 32u) add(_3D_MAG)
      if (v and 64u == 64u) add(TERRAIN)
      if (v and 128u == 128u) add(BATTERY)
      if (v and 256u == 256u) add(RC_RECEIVER)
      if (v and 512u == 512u) add(OFFBOARD_LINK)
      if (v and 1024u == 1024u) add(ENGINE)
      if (v and 2048u == 2048u) add(GEOFENCE)
      if (v and 4096u == 4096u) add(ESTIMATOR)
      if (v and 8192u == 8192u) add(MISSION)
    }
  }
}
