package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Enumeration of possible shot modes.
 *
 */
@GeneratedMavEnum
public enum class MavQshotMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Undefined shot mode. Can be used to determine if qshots should be used or not.
   */
  @GeneratedMavEnumEntry
  UNDEFINED(0u),
  /**
   * Start normal gimbal operation. Is usually used to return back from a shot.
   */
  @GeneratedMavEnumEntry
  DEFAULT(1u),
  /**
   * Load and keep safe gimbal position and stop stabilization.
   */
  @GeneratedMavEnumEntry
  GIMBAL_RETRACT(2u),
  /**
   * Load neutral gimbal position and keep it while stabilizing.
   */
  @GeneratedMavEnumEntry
  GIMBAL_NEUTRAL(3u),
  /**
   * Start mission with gimbal control.
   */
  @GeneratedMavEnumEntry
  GIMBAL_MISSION(4u),
  /**
   * Start RC gimbal control.
   */
  @GeneratedMavEnumEntry
  GIMBAL_RC_CONTROL(5u),
  /**
   * Start gimbal tracking the point specified by Lat, Lon, Alt.
   */
  @GeneratedMavEnumEntry
  POI_TARGETING(6u),
  /**
   * Start gimbal tracking the system with specified system ID.
   */
  @GeneratedMavEnumEntry
  SYSID_TARGETING(7u),
  /**
   * Start 2-point cable cam quick shot.
   */
  @GeneratedMavEnumEntry
  CABLECAM_2POINT(8u),
  /**
   * Start gimbal tracking the home location.
   */
  @GeneratedMavEnumEntry
  HOME_TARGETING(9u),
  ;

  public companion object : MavEnum.MavCompanion<MavQshotMode> {
    override fun getEntryFromValueOrNull(v: UInt): MavQshotMode? = when (v) {
      0u -> UNDEFINED
      1u -> DEFAULT
      2u -> GIMBAL_RETRACT
      3u -> GIMBAL_NEUTRAL
      4u -> GIMBAL_MISSION
      5u -> GIMBAL_RC_CONTROL
      6u -> POI_TARGETING
      7u -> SYSID_TARGETING
      8u -> CABLECAM_2POINT
      9u -> HOME_TARGETING
      else -> null
    }
  }
}
