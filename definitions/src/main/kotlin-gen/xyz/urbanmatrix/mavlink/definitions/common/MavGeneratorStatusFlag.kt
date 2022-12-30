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
  OFF(1L),
  /**
   * Generator is ready to start generating power.
   */
  @GeneratedMavEnumEntry
  READY(2L),
  /**
   * Generator is generating power.
   */
  @GeneratedMavEnumEntry
  GENERATING(4L),
  /**
   * Generator is charging the batteries (generating enough power to charge and provide the load).
   */
  @GeneratedMavEnumEntry
  CHARGING(8L),
  /**
   * Generator is operating at a reduced maximum power.
   */
  @GeneratedMavEnumEntry
  REDUCED_POWER(16L),
  /**
   * Generator is providing the maximum output.
   */
  @GeneratedMavEnumEntry
  MAXPOWER(32L),
  /**
   * Generator is near the maximum operating temperature, cooling is insufficient.
   */
  @GeneratedMavEnumEntry
  OVERTEMP_WARNING(64L),
  /**
   * Generator hit the maximum operating temperature and shutdown.
   */
  @GeneratedMavEnumEntry
  OVERTEMP_FAULT(128L),
  /**
   * Power electronics are near the maximum operating temperature, cooling is insufficient.
   */
  @GeneratedMavEnumEntry
  ELECTRONICS_OVERTEMP_WARNING(256L),
  /**
   * Power electronics hit the maximum operating temperature and shutdown.
   */
  @GeneratedMavEnumEntry
  ELECTRONICS_OVERTEMP_FAULT(512L),
  /**
   * Power electronics experienced a fault and shutdown.
   */
  @GeneratedMavEnumEntry
  ELECTRONICS_FAULT(1024L),
  /**
   * The power source supplying the generator failed e.g. mechanical generator stopped, tether is no
   * longer providing power, solar cell is in shade, hydrogen reaction no longer happening.
   */
  @GeneratedMavEnumEntry
  POWERSOURCE_FAULT(2048L),
  /**
   * Generator controller having communication problems.
   */
  @GeneratedMavEnumEntry
  COMMUNICATION_WARNING(4096L),
  /**
   * Power electronic or generator cooling system error.
   */
  @GeneratedMavEnumEntry
  COOLING_WARNING(8192L),
  /**
   * Generator controller power rail experienced a fault.
   */
  @GeneratedMavEnumEntry
  POWER_RAIL_FAULT(16384L),
  /**
   * Generator controller exceeded the overcurrent threshold and shutdown to prevent damage.
   */
  @GeneratedMavEnumEntry
  OVERCURRENT_FAULT(32768L),
  /**
   * Generator controller detected a high current going into the batteries and shutdown to prevent
   * battery damage.
   */
  @GeneratedMavEnumEntry
  BATTERY_OVERCHARGE_CURRENT_FAULT(65536L),
  /**
   * Generator controller exceeded it's overvoltage threshold and shutdown to prevent it exceeding
   * the voltage rating.
   */
  @GeneratedMavEnumEntry
  OVERVOLTAGE_FAULT(131072L),
  /**
   * Batteries are under voltage (generator will not start).
   */
  @GeneratedMavEnumEntry
  BATTERY_UNDERVOLT_FAULT(262144L),
  /**
   * Generator start is inhibited by e.g. a safety switch.
   */
  @GeneratedMavEnumEntry
  START_INHIBITED(524288L),
  /**
   * Generator requires maintenance.
   */
  @GeneratedMavEnumEntry
  MAINTENANCE_REQUIRED(1048576L),
  /**
   * Generator is not ready to generate yet.
   */
  @GeneratedMavEnumEntry
  WARMING_UP(2097152L),
  /**
   * Generator is idle.
   */
  @GeneratedMavEnumEntry
  IDLE(4194304L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavGeneratorStatusFlag? = when (v) {
      1L -> OFF
      2L -> READY
      4L -> GENERATING
      8L -> CHARGING
      16L -> REDUCED_POWER
      32L -> MAXPOWER
      64L -> OVERTEMP_WARNING
      128L -> OVERTEMP_FAULT
      256L -> ELECTRONICS_OVERTEMP_WARNING
      512L -> ELECTRONICS_OVERTEMP_FAULT
      1024L -> ELECTRONICS_FAULT
      2048L -> POWERSOURCE_FAULT
      4096L -> COMMUNICATION_WARNING
      8192L -> COOLING_WARNING
      16384L -> POWER_RAIL_FAULT
      32768L -> OVERCURRENT_FAULT
      65536L -> BATTERY_OVERCHARGE_CURRENT_FAULT
      131072L -> OVERVOLTAGE_FAULT
      262144L -> BATTERY_UNDERVOLT_FAULT
      524288L -> START_INHIBITED
      1048576L -> MAINTENANCE_REQUIRED
      2097152L -> WARMING_UP
      4194304L -> IDLE
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<MavGeneratorStatusFlag> = buildList {
      if (v and 1L == 1L) add(OFF)
      if (v and 2L == 2L) add(READY)
      if (v and 4L == 4L) add(GENERATING)
      if (v and 8L == 8L) add(CHARGING)
      if (v and 16L == 16L) add(REDUCED_POWER)
      if (v and 32L == 32L) add(MAXPOWER)
      if (v and 64L == 64L) add(OVERTEMP_WARNING)
      if (v and 128L == 128L) add(OVERTEMP_FAULT)
      if (v and 256L == 256L) add(ELECTRONICS_OVERTEMP_WARNING)
      if (v and 512L == 512L) add(ELECTRONICS_OVERTEMP_FAULT)
      if (v and 1024L == 1024L) add(ELECTRONICS_FAULT)
      if (v and 2048L == 2048L) add(POWERSOURCE_FAULT)
      if (v and 4096L == 4096L) add(COMMUNICATION_WARNING)
      if (v and 8192L == 8192L) add(COOLING_WARNING)
      if (v and 16384L == 16384L) add(POWER_RAIL_FAULT)
      if (v and 32768L == 32768L) add(OVERCURRENT_FAULT)
      if (v and 65536L == 65536L) add(BATTERY_OVERCHARGE_CURRENT_FAULT)
      if (v and 131072L == 131072L) add(OVERVOLTAGE_FAULT)
      if (v and 262144L == 262144L) add(BATTERY_UNDERVOLT_FAULT)
      if (v and 524288L == 524288L) add(START_INHIBITED)
      if (v and 1048576L == 1048576L) add(MAINTENANCE_REQUIRED)
      if (v and 2097152L == 2097152L) add(WARMING_UP)
      if (v and 4194304L == 4194304L) add(IDLE)
    }
  }
}
