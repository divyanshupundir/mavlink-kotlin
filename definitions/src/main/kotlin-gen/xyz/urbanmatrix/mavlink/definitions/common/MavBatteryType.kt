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
  MAV_BATTERY_TYPE_UNKNOWN(0L),
  /**
   * Lithium polymer battery
   */
  @GeneratedMavEnumEntry
  MAV_BATTERY_TYPE_LIPO(1L),
  /**
   * Lithium-iron-phosphate battery
   */
  @GeneratedMavEnumEntry
  MAV_BATTERY_TYPE_LIFE(2L),
  /**
   * Lithium-ION battery
   */
  @GeneratedMavEnumEntry
  MAV_BATTERY_TYPE_LION(3L),
  /**
   * Nickel metal hydride battery
   */
  @GeneratedMavEnumEntry
  MAV_BATTERY_TYPE_NIMH(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavBatteryType? = when (v) {
      0L -> MAV_BATTERY_TYPE_UNKNOWN
      1L -> MAV_BATTERY_TYPE_LIPO
      2L -> MAV_BATTERY_TYPE_LIFE
      3L -> MAV_BATTERY_TYPE_LION
      4L -> MAV_BATTERY_TYPE_NIMH
      else -> null
    }
  }
}
