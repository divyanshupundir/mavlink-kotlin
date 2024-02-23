package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Enumeration of battery types
 */
@GeneratedMavEnum
public enum class MavBatteryType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Not specified.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * Lithium polymer battery
   */
  @GeneratedMavEnumEntry
  LIPO(1u),
  /**
   * Lithium-iron-phosphate battery
   */
  @GeneratedMavEnumEntry
  LIFE(2u),
  /**
   * Lithium-ION battery
   */
  @GeneratedMavEnumEntry
  LION(3u),
  /**
   * Nickel metal hydride battery
   */
  @GeneratedMavEnumEntry
  NIMH(4u),
  ;

  public companion object : MavEnum.MavCompanion<MavBatteryType> {
    override fun getEntryFromValueOrNull(v: UInt): MavBatteryType? = when (v) {
      0u -> UNKNOWN
      1u -> LIPO
      2u -> LIFE
      3u -> LION
      4u -> NIMH
      else -> null
    }
  }
}
