package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Flags to report status/failure cases for a power generator (used in GENERATOR_STATUS). Note that
 * FAULTS are conditions that cause the generator to fail. Warnings are conditions that require
 * attention before the next use (they indicate the system is not operating properly).
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavGeneratorStatusFlag(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * Generator is off.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_OFF(1L),
  /**
   * Generator is ready to start generating power.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_READY(2L),
  /**
   * Generator is generating power.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_GENERATING(4L),
  /**
   * Generator is charging the batteries (generating enough power to charge and provide the load).
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_CHARGING(8L),
  /**
   * Generator is operating at a reduced maximum power.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_REDUCED_POWER(16L),
  /**
   * Generator is providing the maximum output.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_MAXPOWER(32L),
  /**
   * Generator is near the maximum operating temperature, cooling is insufficient.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_OVERTEMP_WARNING(64L),
  /**
   * Generator hit the maximum operating temperature and shutdown.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_OVERTEMP_FAULT(128L),
  /**
   * Power electronics are near the maximum operating temperature, cooling is insufficient.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_OVERTEMP_WARNING(256L),
  /**
   * Power electronics hit the maximum operating temperature and shutdown.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_OVERTEMP_FAULT(512L),
  /**
   * Power electronics experienced a fault and shutdown.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_FAULT(1024L),
  /**
   * The power source supplying the generator failed e.g. mechanical generator stopped, tether is no
   * longer providing power, solar cell is in shade, hydrogen reaction no longer happening.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_POWERSOURCE_FAULT(2048L),
  /**
   * Generator controller having communication problems.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_COMMUNICATION_WARNING(4096L),
  /**
   * Power electronic or generator cooling system error.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_COOLING_WARNING(8192L),
  /**
   * Generator controller power rail experienced a fault.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_POWER_RAIL_FAULT(16384L),
  /**
   * Generator controller exceeded the overcurrent threshold and shutdown to prevent damage.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_OVERCURRENT_FAULT(32768L),
  /**
   * Generator controller detected a high current going into the batteries and shutdown to prevent
   * battery damage.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_BATTERY_OVERCHARGE_CURRENT_FAULT(65536L),
  /**
   * Generator controller exceeded it's overvoltage threshold and shutdown to prevent it exceeding
   * the voltage rating.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_OVERVOLTAGE_FAULT(131072L),
  /**
   * Batteries are under voltage (generator will not start).
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_BATTERY_UNDERVOLT_FAULT(262144L),
  /**
   * Generator start is inhibited by e.g. a safety switch.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_START_INHIBITED(524288L),
  /**
   * Generator requires maintenance.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_MAINTENANCE_REQUIRED(1048576L),
  /**
   * Generator is not ready to generate yet.
   */
  @GeneratedMavEnumEntry
  MAV_GENERATOR_STATUS_FLAG_WARMING_UP(2097152L),
  /**
   * Generator is idle.
   */
  @GeneratedMavEnumEntry
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

    public fun getFlagsFromValue(v: Long): List<MavGeneratorStatusFlag> = buildList {
      if (v and 1L == 1L) add(MAV_GENERATOR_STATUS_FLAG_OFF)
      if (v and 2L == 2L) add(MAV_GENERATOR_STATUS_FLAG_READY)
      if (v and 4L == 4L) add(MAV_GENERATOR_STATUS_FLAG_GENERATING)
      if (v and 8L == 8L) add(MAV_GENERATOR_STATUS_FLAG_CHARGING)
      if (v and 16L == 16L) add(MAV_GENERATOR_STATUS_FLAG_REDUCED_POWER)
      if (v and 32L == 32L) add(MAV_GENERATOR_STATUS_FLAG_MAXPOWER)
      if (v and 64L == 64L) add(MAV_GENERATOR_STATUS_FLAG_OVERTEMP_WARNING)
      if (v and 128L == 128L) add(MAV_GENERATOR_STATUS_FLAG_OVERTEMP_FAULT)
      if (v and 256L == 256L) add(MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_OVERTEMP_WARNING)
      if (v and 512L == 512L) add(MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_OVERTEMP_FAULT)
      if (v and 1024L == 1024L) add(MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_FAULT)
      if (v and 2048L == 2048L) add(MAV_GENERATOR_STATUS_FLAG_POWERSOURCE_FAULT)
      if (v and 4096L == 4096L) add(MAV_GENERATOR_STATUS_FLAG_COMMUNICATION_WARNING)
      if (v and 8192L == 8192L) add(MAV_GENERATOR_STATUS_FLAG_COOLING_WARNING)
      if (v and 16384L == 16384L) add(MAV_GENERATOR_STATUS_FLAG_POWER_RAIL_FAULT)
      if (v and 32768L == 32768L) add(MAV_GENERATOR_STATUS_FLAG_OVERCURRENT_FAULT)
      if (v and 65536L == 65536L) add(MAV_GENERATOR_STATUS_FLAG_BATTERY_OVERCHARGE_CURRENT_FAULT)
      if (v and 131072L == 131072L) add(MAV_GENERATOR_STATUS_FLAG_OVERVOLTAGE_FAULT)
      if (v and 262144L == 262144L) add(MAV_GENERATOR_STATUS_FLAG_BATTERY_UNDERVOLT_FAULT)
      if (v and 524288L == 524288L) add(MAV_GENERATOR_STATUS_FLAG_START_INHIBITED)
      if (v and 1048576L == 1048576L) add(MAV_GENERATOR_STATUS_FLAG_MAINTENANCE_REQUIRED)
      if (v and 2097152L == 2097152L) add(MAV_GENERATOR_STATUS_FLAG_WARMING_UP)
      if (v and 4194304L == 4194304L) add(MAV_GENERATOR_STATUS_FLAG_IDLE)
    }
  }
}
