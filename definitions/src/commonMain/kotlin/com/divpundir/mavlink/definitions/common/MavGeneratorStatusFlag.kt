package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Flags to report status/failure cases for a power generator (used in GENERATOR_STATUS). Note that
 * FAULTS are conditions that cause the generator to fail. Warnings are conditions that require
 * attention before the next use (they indicate the system is not operating properly).
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavGeneratorStatusFlag(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Generator is off.
   */
  @GeneratedMavEnumEntry
  OFF(1u),
  /**
   * Generator is ready to start generating power.
   */
  @GeneratedMavEnumEntry
  READY(2u),
  /**
   * Generator is generating power.
   */
  @GeneratedMavEnumEntry
  GENERATING(4u),
  /**
   * Generator is charging the batteries (generating enough power to charge and provide the load).
   */
  @GeneratedMavEnumEntry
  CHARGING(8u),
  /**
   * Generator is operating at a reduced maximum power.
   */
  @GeneratedMavEnumEntry
  REDUCED_POWER(16u),
  /**
   * Generator is providing the maximum output.
   */
  @GeneratedMavEnumEntry
  MAXPOWER(32u),
  /**
   * Generator is near the maximum operating temperature, cooling is insufficient.
   */
  @GeneratedMavEnumEntry
  OVERTEMP_WARNING(64u),
  /**
   * Generator hit the maximum operating temperature and shutdown.
   */
  @GeneratedMavEnumEntry
  OVERTEMP_FAULT(128u),
  /**
   * Power electronics are near the maximum operating temperature, cooling is insufficient.
   */
  @GeneratedMavEnumEntry
  ELECTRONICS_OVERTEMP_WARNING(256u),
  /**
   * Power electronics hit the maximum operating temperature and shutdown.
   */
  @GeneratedMavEnumEntry
  ELECTRONICS_OVERTEMP_FAULT(512u),
  /**
   * Power electronics experienced a fault and shutdown.
   */
  @GeneratedMavEnumEntry
  ELECTRONICS_FAULT(1_024u),
  /**
   * The power source supplying the generator failed e.g. mechanical generator stopped, tether is no
   * longer providing power, solar cell is in shade, hydrogen reaction no longer happening.
   */
  @GeneratedMavEnumEntry
  POWERSOURCE_FAULT(2_048u),
  /**
   * Generator controller having communication problems.
   */
  @GeneratedMavEnumEntry
  COMMUNICATION_WARNING(4_096u),
  /**
   * Power electronic or generator cooling system error.
   */
  @GeneratedMavEnumEntry
  COOLING_WARNING(8_192u),
  /**
   * Generator controller power rail experienced a fault.
   */
  @GeneratedMavEnumEntry
  POWER_RAIL_FAULT(16_384u),
  /**
   * Generator controller exceeded the overcurrent threshold and shutdown to prevent damage.
   */
  @GeneratedMavEnumEntry
  OVERCURRENT_FAULT(32_768u),
  /**
   * Generator controller detected a high current going into the batteries and shutdown to prevent
   * battery damage.
   */
  @GeneratedMavEnumEntry
  BATTERY_OVERCHARGE_CURRENT_FAULT(65_536u),
  /**
   * Generator controller exceeded it's overvoltage threshold and shutdown to prevent it exceeding
   * the voltage rating.
   */
  @GeneratedMavEnumEntry
  OVERVOLTAGE_FAULT(131_072u),
  /**
   * Batteries are under voltage (generator will not start).
   */
  @GeneratedMavEnumEntry
  BATTERY_UNDERVOLT_FAULT(262_144u),
  /**
   * Generator start is inhibited by e.g. a safety switch.
   */
  @GeneratedMavEnumEntry
  START_INHIBITED(524_288u),
  /**
   * Generator requires maintenance.
   */
  @GeneratedMavEnumEntry
  MAINTENANCE_REQUIRED(1_048_576u),
  /**
   * Generator is not ready to generate yet.
   */
  @GeneratedMavEnumEntry
  WARMING_UP(2_097_152u),
  /**
   * Generator is idle.
   */
  @GeneratedMavEnumEntry
  IDLE(4_194_304u),
  ;

  public companion object : MavBitmask.MavCompanion<MavGeneratorStatusFlag> {
    override fun getEntryFromValueOrNull(v: UInt): MavGeneratorStatusFlag? = when (v) {
      1u -> OFF
      2u -> READY
      4u -> GENERATING
      8u -> CHARGING
      16u -> REDUCED_POWER
      32u -> MAXPOWER
      64u -> OVERTEMP_WARNING
      128u -> OVERTEMP_FAULT
      256u -> ELECTRONICS_OVERTEMP_WARNING
      512u -> ELECTRONICS_OVERTEMP_FAULT
      1024u -> ELECTRONICS_FAULT
      2048u -> POWERSOURCE_FAULT
      4096u -> COMMUNICATION_WARNING
      8192u -> COOLING_WARNING
      16384u -> POWER_RAIL_FAULT
      32768u -> OVERCURRENT_FAULT
      65536u -> BATTERY_OVERCHARGE_CURRENT_FAULT
      131072u -> OVERVOLTAGE_FAULT
      262144u -> BATTERY_UNDERVOLT_FAULT
      524288u -> START_INHIBITED
      1048576u -> MAINTENANCE_REQUIRED
      2097152u -> WARMING_UP
      4194304u -> IDLE
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<MavGeneratorStatusFlag> = buildList {
      if (v and 1u == 1u) add(OFF)
      if (v and 2u == 2u) add(READY)
      if (v and 4u == 4u) add(GENERATING)
      if (v and 8u == 8u) add(CHARGING)
      if (v and 16u == 16u) add(REDUCED_POWER)
      if (v and 32u == 32u) add(MAXPOWER)
      if (v and 64u == 64u) add(OVERTEMP_WARNING)
      if (v and 128u == 128u) add(OVERTEMP_FAULT)
      if (v and 256u == 256u) add(ELECTRONICS_OVERTEMP_WARNING)
      if (v and 512u == 512u) add(ELECTRONICS_OVERTEMP_FAULT)
      if (v and 1024u == 1024u) add(ELECTRONICS_FAULT)
      if (v and 2048u == 2048u) add(POWERSOURCE_FAULT)
      if (v and 4096u == 4096u) add(COMMUNICATION_WARNING)
      if (v and 8192u == 8192u) add(COOLING_WARNING)
      if (v and 16384u == 16384u) add(POWER_RAIL_FAULT)
      if (v and 32768u == 32768u) add(OVERCURRENT_FAULT)
      if (v and 65536u == 65536u) add(BATTERY_OVERCHARGE_CURRENT_FAULT)
      if (v and 131072u == 131072u) add(OVERVOLTAGE_FAULT)
      if (v and 262144u == 262144u) add(BATTERY_UNDERVOLT_FAULT)
      if (v and 524288u == 524288u) add(START_INHIBITED)
      if (v and 1048576u == 1048576u) add(MAINTENANCE_REQUIRED)
      if (v and 2097152u == 2097152u) add(WARMING_UP)
      if (v and 4194304u == 4194304u) add(IDLE)
    }
  }
}
