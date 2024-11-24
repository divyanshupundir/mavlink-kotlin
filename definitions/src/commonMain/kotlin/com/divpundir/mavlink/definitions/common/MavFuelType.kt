package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Fuel types for use in FUEL_TYPE. Fuel types specify the units for the maximum, available and
 * consumed fuel, and for the flow rates.
 */
@GeneratedMavEnum
public enum class MavFuelType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Not specified. Fuel levels are normalized (i.e. maximum is 1, and other levels are relative to
   * 1).
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * A generic liquid fuel. Fuel levels are in millilitres (ml). Fuel rates are in
   * millilitres/second.
   */
  @GeneratedMavEnumEntry
  LIQUID(1u),
  /**
   * A gas tank. Fuel levels are in kilo-Pascal (kPa), and flow rates are in milliliters per second
   * (ml/s).
   */
  @GeneratedMavEnumEntry
  GAS(2u),
  ;

  public companion object : MavEnum.MavCompanion<MavFuelType> {
    override fun getEntryFromValueOrNull(v: UInt): MavFuelType? = when (v) {
      0u -> UNKNOWN
      1u -> LIQUID
      2u -> GAS
      else -> null
    }
  }
}
