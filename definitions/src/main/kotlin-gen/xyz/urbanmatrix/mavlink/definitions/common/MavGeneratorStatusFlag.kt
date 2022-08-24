package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Flags to report status/failure cases for a power generator (used in GENERATOR_STATUS). Note that
 * FAULTS are conditions that cause the generator to fail. Warnings are conditions that require
 * attention before the next use (they indicate the system is not operating properly).
 */
@GeneratedMavEnum
public enum class MavGeneratorStatusFlag(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Generator is off.
   */
  MAV_GENERATOR_STATUS_FLAG_OFF(1L),
  /**
   * Generator is ready to start generating power.
   */
  MAV_GENERATOR_STATUS_FLAG_READY(2L),
  /**
   * Generator is generating power.
   */
  MAV_GENERATOR_STATUS_FLAG_GENERATING(4L),
  /**
   * Generator is charging the batteries (generating enough power to charge and provide the load).
   */
  MAV_GENERATOR_STATUS_FLAG_CHARGING(8L),
  /**
   * Generator is operating at a reduced maximum power.
   */
  MAV_GENERATOR_STATUS_FLAG_REDUCED_POWER(16L),
  /**
   * Generator is providing the maximum output.
   */
  MAV_GENERATOR_STATUS_FLAG_MAXPOWER(32L),
  /**
   * Generator is near the maximum operating temperature, cooling is insufficient.
   */
  MAV_GENERATOR_STATUS_FLAG_OVERTEMP_WARNING(64L),
  /**
   * Generator hit the maximum operating temperature and shutdown.
   */
  MAV_GENERATOR_STATUS_FLAG_OVERTEMP_FAULT(128L),
  /**
   * Power electronics are near the maximum operating temperature, cooling is insufficient.
   */
  MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_OVERTEMP_WARNING(256L),
  /**
   * Power electronics hit the maximum operating temperature and shutdown.
   */
  MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_OVERTEMP_FAULT(512L),
  /**
   * Power electronics experienced a fault and shutdown.
   */
  MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_FAULT(1024L),
  /**
   * The power source supplying the generator failed e.g. mechanical generator stopped, tether is no
   * longer providing power, solar cell is in shade, hydrogen reaction no longer happening.
   */
  MAV_GENERATOR_STATUS_FLAG_POWERSOURCE_FAULT(2048L),
  /**
   * Generator controller having communication problems.
   */
  MAV_GENERATOR_STATUS_FLAG_COMMUNICATION_WARNING(4096L),
  /**
   * Power electronic or generator cooling system error.
   */
  MAV_GENERATOR_STATUS_FLAG_COOLING_WARNING(8192L),
  /**
   * Generator controller power rail experienced a fault.
   */
  MAV_GENERATOR_STATUS_FLAG_POWER_RAIL_FAULT(16384L),
  /**
   * Generator controller exceeded the overcurrent threshold and shutdown to prevent damage.
   */
  MAV_GENERATOR_STATUS_FLAG_OVERCURRENT_FAULT(32768L),
  /**
   * Generator controller detected a high current going into the batteries and shutdown to prevent
   * battery damage.
   */
  MAV_GENERATOR_STATUS_FLAG_BATTERY_OVERCHARGE_CURRENT_FAULT(65536L),
  /**
   * Generator controller exceeded it's overvoltage threshold and shutdown to prevent it exceeding
   * the voltage rating.
   */
  MAV_GENERATOR_STATUS_FLAG_OVERVOLTAGE_FAULT(131072L),
  /**
   * Batteries are under voltage (generator will not start).
   */
  MAV_GENERATOR_STATUS_FLAG_BATTERY_UNDERVOLT_FAULT(262144L),
  /**
   * Generator start is inhibited by e.g. a safety switch.
   */
  MAV_GENERATOR_STATUS_FLAG_START_INHIBITED(524288L),
  /**
   * Generator requires maintenance.
   */
  MAV_GENERATOR_STATUS_FLAG_MAINTENANCE_REQUIRED(1048576L),
  /**
   * Generator is not ready to generate yet.
   */
  MAV_GENERATOR_STATUS_FLAG_WARMING_UP(2097152L),
  /**
   * Generator is idle.
   */
  MAV_GENERATOR_STATUS_FLAG_IDLE(4194304L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavGeneratorStatusFlag? = when (v) {
      1L -> MAV_GENERATOR_STATUS_FLAG_OFF
      2L -> MAV_GENERATOR_STATUS_FLAG_READY
      4L -> MAV_GENERATOR_STATUS_FLAG_GENERATING
      8L -> MAV_GENERATOR_STATUS_FLAG_CHARGING
      16L -> MAV_GENERATOR_STATUS_FLAG_REDUCED_POWER
      32L -> MAV_GENERATOR_STATUS_FLAG_MAXPOWER
      64L -> MAV_GENERATOR_STATUS_FLAG_OVERTEMP_WARNING
      128L -> MAV_GENERATOR_STATUS_FLAG_OVERTEMP_FAULT
      256L -> MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_OVERTEMP_WARNING
      512L -> MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_OVERTEMP_FAULT
      1024L -> MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_FAULT
      2048L -> MAV_GENERATOR_STATUS_FLAG_POWERSOURCE_FAULT
      4096L -> MAV_GENERATOR_STATUS_FLAG_COMMUNICATION_WARNING
      8192L -> MAV_GENERATOR_STATUS_FLAG_COOLING_WARNING
      16384L -> MAV_GENERATOR_STATUS_FLAG_POWER_RAIL_FAULT
      32768L -> MAV_GENERATOR_STATUS_FLAG_OVERCURRENT_FAULT
      65536L -> MAV_GENERATOR_STATUS_FLAG_BATTERY_OVERCHARGE_CURRENT_FAULT
      131072L -> MAV_GENERATOR_STATUS_FLAG_OVERVOLTAGE_FAULT
      262144L -> MAV_GENERATOR_STATUS_FLAG_BATTERY_UNDERVOLT_FAULT
      524288L -> MAV_GENERATOR_STATUS_FLAG_START_INHIBITED
      1048576L -> MAV_GENERATOR_STATUS_FLAG_MAINTENANCE_REQUIRED
      2097152L -> MAV_GENERATOR_STATUS_FLAG_WARMING_UP
      4194304L -> MAV_GENERATOR_STATUS_FLAG_IDLE
      else -> null
    }
  }
}
