package xyz.urbanmatrix.mavlink.definitions.minimal

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
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
  MAV_AUTOPILOT_GENERIC(0L),
  /**
   * Reserved for future use.
   */
  MAV_AUTOPILOT_RESERVED(1L),
  /**
   * SLUGS autopilot, http://slugsuav.soe.ucsc.edu
   */
  MAV_AUTOPILOT_SLUGS(2L),
  /**
   * ArduPilot - Plane/Copter/Rover/Sub/Tracker, https://ardupilot.org
   */
  MAV_AUTOPILOT_ARDUPILOTMEGA(3L),
  /**
   * OpenPilot, http://openpilot.org
   */
  MAV_AUTOPILOT_OPENPILOT(4L),
  /**
   * Generic autopilot only supporting simple waypoints
   */
  MAV_AUTOPILOT_GENERIC_WAYPOINTS_ONLY(5L),
  /**
   * Generic autopilot supporting waypoints and other simple navigation commands
   */
  MAV_AUTOPILOT_GENERIC_WAYPOINTS_AND_SIMPLE_NAVIGATION_ONLY(6L),
  /**
   * Generic autopilot supporting the full mission command set
   */
  MAV_AUTOPILOT_GENERIC_MISSION_FULL(7L),
  /**
   * No valid autopilot, e.g. a GCS or other MAVLink component
   */
  MAV_AUTOPILOT_INVALID(8L),
  /**
   * PPZ UAV - http://nongnu.org/paparazzi
   */
  MAV_AUTOPILOT_PPZ(9L),
  /**
   * UAV Dev Board
   */
  MAV_AUTOPILOT_UDB(10L),
  /**
   * FlexiPilot
   */
  MAV_AUTOPILOT_FP(11L),
  /**
   * PX4 Autopilot - http://px4.io/
   */
  MAV_AUTOPILOT_PX4(12L),
  /**
   * SMACCMPilot - http://smaccmpilot.org
   */
  MAV_AUTOPILOT_SMACCMPILOT(13L),
  /**
   * AutoQuad -- http://autoquad.org
   */
  MAV_AUTOPILOT_AUTOQUAD(14L),
  /**
   * Armazila -- http://armazila.com
   */
  MAV_AUTOPILOT_ARMAZILA(15L),
  /**
   * Aerob -- http://aerob.ru
   */
  MAV_AUTOPILOT_AEROB(16L),
  /**
   * ASLUAV autopilot -- http://www.asl.ethz.ch
   */
  MAV_AUTOPILOT_ASLUAV(17L),
  /**
   * SmartAP Autopilot - http://sky-drones.com
   */
  MAV_AUTOPILOT_SMARTAP(18L),
  /**
   * AirRails - http://uaventure.com
   */
  MAV_AUTOPILOT_AIRRAILS(19L),
  /**
   * Fusion Reflex - https://fusion.engineering
   */
  MAV_AUTOPILOT_REFLEX(20L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavAutopilot? = when (v) {
      0L -> MAV_AUTOPILOT_GENERIC
      1L -> MAV_AUTOPILOT_RESERVED
      2L -> MAV_AUTOPILOT_SLUGS
      3L -> MAV_AUTOPILOT_ARDUPILOTMEGA
      4L -> MAV_AUTOPILOT_OPENPILOT
      5L -> MAV_AUTOPILOT_GENERIC_WAYPOINTS_ONLY
      6L -> MAV_AUTOPILOT_GENERIC_WAYPOINTS_AND_SIMPLE_NAVIGATION_ONLY
      7L -> MAV_AUTOPILOT_GENERIC_MISSION_FULL
      8L -> MAV_AUTOPILOT_INVALID
      9L -> MAV_AUTOPILOT_PPZ
      10L -> MAV_AUTOPILOT_UDB
      11L -> MAV_AUTOPILOT_FP
      12L -> MAV_AUTOPILOT_PX4
      13L -> MAV_AUTOPILOT_SMACCMPILOT
      14L -> MAV_AUTOPILOT_AUTOQUAD
      15L -> MAV_AUTOPILOT_ARMAZILA
      16L -> MAV_AUTOPILOT_AEROB
      17L -> MAV_AUTOPILOT_ASLUAV
      18L -> MAV_AUTOPILOT_SMARTAP
      19L -> MAV_AUTOPILOT_AIRRAILS
      20L -> MAV_AUTOPILOT_REFLEX
      else -> null
    }
  }
}
