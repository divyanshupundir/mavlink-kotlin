package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Enumeration of battery types
 */
@GeneratedMavEnum
public enum class MavBatteryType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Not specified.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0L),
  /**
   * Lithium polymer battery
   */
  @GeneratedMavEnumEntry
  LIPO(1L),
  /**
   * Lithium-iron-phosphate battery
   */
  @GeneratedMavEnumEntry
  LIFE(2L),
  /**
   * Lithium-ION battery
   */
  @GeneratedMavEnumEntry
  LION(3L),
  /**
   * Nickel metal hydride battery
   */
  @GeneratedMavEnumEntry
  NIMH(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavBatteryType? = when (v) {
      0L -> UNKNOWN
      1L -> LIPO
      2L -> LIFE
      3L -> LION
      4L -> NIMH
      else -> null
    }
  }
}
