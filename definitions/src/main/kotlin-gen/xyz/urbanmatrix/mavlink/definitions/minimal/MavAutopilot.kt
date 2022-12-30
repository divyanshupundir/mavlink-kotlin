package xyz.urbanmatrix.mavlink.definitions.minimal

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Micro air vehicle / autopilot classes. This identifies the individual model.
 */
@GeneratedMavEnum
public enum class MavAutopilot(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Generic autopilot, full support for everything
   */
  @GeneratedMavEnumEntry
  GENERIC(0L),
  /**
   * Reserved for future use.
   */
  @GeneratedMavEnumEntry
  RESERVED(1L),
  /**
   * SLUGS autopilot, http://slugsuav.soe.ucsc.edu
   */
  @GeneratedMavEnumEntry
  SLUGS(2L),
  /**
   * ArduPilot - Plane/Copter/Rover/Sub/Tracker, https://ardupilot.org
   */
  @GeneratedMavEnumEntry
  ARDUPILOTMEGA(3L),
  /**
   * OpenPilot, http://openpilot.org
   */
  @GeneratedMavEnumEntry
  OPENPILOT(4L),
  /**
   * Generic autopilot only supporting simple waypoints
   */
  @GeneratedMavEnumEntry
  GENERIC_WAYPOINTS_ONLY(5L),
  /**
   * Generic autopilot supporting waypoints and other simple navigation commands
   */
  @GeneratedMavEnumEntry
  GENERIC_WAYPOINTS_AND_SIMPLE_NAVIGATION_ONLY(6L),
  /**
   * Generic autopilot supporting the full mission command set
   */
  @GeneratedMavEnumEntry
  GENERIC_MISSION_FULL(7L),
  /**
   * No valid autopilot, e.g. a GCS or other MAVLink component
   */
  @GeneratedMavEnumEntry
  INVALID(8L),
  /**
   * PPZ UAV - http://nongnu.org/paparazzi
   */
  @GeneratedMavEnumEntry
  PPZ(9L),
  /**
   * UAV Dev Board
   */
  @GeneratedMavEnumEntry
  UDB(10L),
  /**
   * FlexiPilot
   */
  @GeneratedMavEnumEntry
  FP(11L),
  /**
   * PX4 Autopilot - http://px4.io/
   */
  @GeneratedMavEnumEntry
  PX4(12L),
  /**
   * SMACCMPilot - http://smaccmpilot.org
   */
  @GeneratedMavEnumEntry
  SMACCMPILOT(13L),
  /**
   * AutoQuad -- http://autoquad.org
   */
  @GeneratedMavEnumEntry
  AUTOQUAD(14L),
  /**
   * Armazila -- http://armazila.com
   */
  @GeneratedMavEnumEntry
  ARMAZILA(15L),
  /**
   * Aerob -- http://aerob.ru
   */
  @GeneratedMavEnumEntry
  AEROB(16L),
  /**
   * ASLUAV autopilot -- http://www.asl.ethz.ch
   */
  @GeneratedMavEnumEntry
  ASLUAV(17L),
  /**
   * SmartAP Autopilot - http://sky-drones.com
   */
  @GeneratedMavEnumEntry
  SMARTAP(18L),
  /**
   * AirRails - http://uaventure.com
   */
  @GeneratedMavEnumEntry
  AIRRAILS(19L),
  /**
   * Fusion Reflex - https://fusion.engineering
   */
  @GeneratedMavEnumEntry
  REFLEX(20L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavAutopilot? = when (v) {
      0L -> GENERIC
      1L -> RESERVED
      2L -> SLUGS
      3L -> ARDUPILOTMEGA
      4L -> OPENPILOT
      5L -> GENERIC_WAYPOINTS_ONLY
      6L -> GENERIC_WAYPOINTS_AND_SIMPLE_NAVIGATION_ONLY
      7L -> GENERIC_MISSION_FULL
      8L -> INVALID
      9L -> PPZ
      10L -> UDB
      11L -> FP
      12L -> PX4
      13L -> SMACCMPILOT
      14L -> AUTOQUAD
      15L -> ARMAZILA
      16L -> AEROB
      17L -> ASLUAV
      18L -> SMARTAP
      19L -> AIRRAILS
      20L -> REFLEX
      else -> null
    }
  }
}
