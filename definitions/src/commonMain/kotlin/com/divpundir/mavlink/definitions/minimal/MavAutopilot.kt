package com.divpundir.mavlink.definitions.minimal

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Micro air vehicle / autopilot classes. This identifies the individual model.
 */
@GeneratedMavEnum
public enum class MavAutopilot(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Generic autopilot, full support for everything
   */
  @GeneratedMavEnumEntry
  GENERIC(0u),
  /**
   * Reserved for future use.
   */
  @GeneratedMavEnumEntry
  RESERVED(1u),
  /**
   * SLUGS autopilot, http://slugsuav.soe.ucsc.edu
   */
  @GeneratedMavEnumEntry
  SLUGS(2u),
  /**
   * ArduPilot - Plane/Copter/Rover/Sub/Tracker, https://ardupilot.org
   */
  @GeneratedMavEnumEntry
  ARDUPILOTMEGA(3u),
  /**
   * OpenPilot, http://openpilot.org
   */
  @GeneratedMavEnumEntry
  OPENPILOT(4u),
  /**
   * Generic autopilot only supporting simple waypoints
   */
  @GeneratedMavEnumEntry
  GENERIC_WAYPOINTS_ONLY(5u),
  /**
   * Generic autopilot supporting waypoints and other simple navigation commands
   */
  @GeneratedMavEnumEntry
  GENERIC_WAYPOINTS_AND_SIMPLE_NAVIGATION_ONLY(6u),
  /**
   * Generic autopilot supporting the full mission command set
   */
  @GeneratedMavEnumEntry
  GENERIC_MISSION_FULL(7u),
  /**
   * No valid autopilot, e.g. a GCS or other MAVLink component
   */
  @GeneratedMavEnumEntry
  INVALID(8u),
  /**
   * PPZ UAV - http://nongnu.org/paparazzi
   */
  @GeneratedMavEnumEntry
  PPZ(9u),
  /**
   * UAV Dev Board
   */
  @GeneratedMavEnumEntry
  UDB(10u),
  /**
   * FlexiPilot
   */
  @GeneratedMavEnumEntry
  FP(11u),
  /**
   * PX4 Autopilot - http://px4.io/
   */
  @GeneratedMavEnumEntry
  PX4(12u),
  /**
   * SMACCMPilot - http://smaccmpilot.org
   */
  @GeneratedMavEnumEntry
  SMACCMPILOT(13u),
  /**
   * AutoQuad -- http://autoquad.org
   */
  @GeneratedMavEnumEntry
  AUTOQUAD(14u),
  /**
   * Armazila -- http://armazila.com
   */
  @GeneratedMavEnumEntry
  ARMAZILA(15u),
  /**
   * Aerob -- http://aerob.ru
   */
  @GeneratedMavEnumEntry
  AEROB(16u),
  /**
   * ASLUAV autopilot -- http://www.asl.ethz.ch
   */
  @GeneratedMavEnumEntry
  ASLUAV(17u),
  /**
   * SmartAP Autopilot - http://sky-drones.com
   */
  @GeneratedMavEnumEntry
  SMARTAP(18u),
  /**
   * AirRails - http://uaventure.com
   */
  @GeneratedMavEnumEntry
  AIRRAILS(19u),
  /**
   * Fusion Reflex - https://fusion.engineering
   */
  @GeneratedMavEnumEntry
  REFLEX(20u),
  ;

  public companion object : MavEnum.MavCompanion<MavAutopilot> {
    override fun getEntryFromValueOrNull(v: UInt): MavAutopilot? = when (v) {
      0u -> GENERIC
      1u -> RESERVED
      2u -> SLUGS
      3u -> ARDUPILOTMEGA
      4u -> OPENPILOT
      5u -> GENERIC_WAYPOINTS_ONLY
      6u -> GENERIC_WAYPOINTS_AND_SIMPLE_NAVIGATION_ONLY
      7u -> GENERIC_MISSION_FULL
      8u -> INVALID
      9u -> PPZ
      10u -> UDB
      11u -> FP
      12u -> PX4
      13u -> SMACCMPILOT
      14u -> AUTOQUAD
      15u -> ARMAZILA
      16u -> AEROB
      17u -> ASLUAV
      18u -> SMARTAP
      19u -> AIRRAILS
      20u -> REFLEX
      else -> null
    }
  }
}
