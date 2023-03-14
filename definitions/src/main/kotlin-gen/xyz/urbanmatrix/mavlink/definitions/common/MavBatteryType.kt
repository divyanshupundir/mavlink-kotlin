package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Enumeration of battery types
 */
@GeneratedMavEnum
public enum class MavBatteryType(
  public override val `value`: UInt,
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

  public companion object : MavEnum.Companion<MavBatteryType> {
    public override fun getEntryFromValueOrNull(v: UInt): MavBatteryType? = when (v) {
      0u -> UNKNOWN
      1u -> LIPO
      2u -> LIFE
      3u -> LION
      4u -> NIMH
      else -> null
    }
  }
}
