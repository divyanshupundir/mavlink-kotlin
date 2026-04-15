package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Source for GLOBAL_POSITION measurement or estimate.
 */
@GeneratedMavEnum
public enum class GlobalPositionSrc(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Source is unknown or not one of the listed types.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * Global Navigation Satellite System (e.g.: GPS, Galileo, Glonass, BeiDou).
   */
  @GeneratedMavEnumEntry
  GNSS(1u),
  /**
   * Vision system (e.g.: map matching).
   */
  @GeneratedMavEnumEntry
  VISION(2u),
  /**
   * A pseudo-satellite system using transceiver beacons to perform GNSS-like positioning.
   */
  @GeneratedMavEnumEntry
  PSEUDOLITES(3u),
  /**
   * Terrain referenced navigation.
   */
  @GeneratedMavEnumEntry
  TERRAIN(4u),
  /**
   * Magnetic positioning.
   */
  @GeneratedMavEnumEntry
  MAGNETIC(5u),
  /**
   * Estimated position based on various sensors (eg. a Kalman Filter).
   */
  @GeneratedMavEnumEntry
  ESTIMATOR(6u),
  ;

  public companion object : MavEnum.MavCompanion<GlobalPositionSrc> {
    override fun getEntryFromValueOrNull(v: UInt): GlobalPositionSrc? = when (v) {
      0u -> UNKNOWN
      1u -> GNSS
      2u -> VISION
      3u -> PSEUDOLITES
      4u -> TERRAIN
      5u -> MAGNETIC
      6u -> ESTIMATOR
      else -> null
    }
  }
}
