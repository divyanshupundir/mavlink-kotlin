package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidSpeedAcc(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The speed accuracy is unknown.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_SPEED_ACC_UNKNOWN(0L),
  /**
   * The speed accuracy is smaller than 10 meters per second.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_SPEED_ACC_10_METERS_PER_SECOND(1L),
  /**
   * The speed accuracy is smaller than 3 meters per second.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_SPEED_ACC_3_METERS_PER_SECOND(2L),
  /**
   * The speed accuracy is smaller than 1 meters per second.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_SPEED_ACC_1_METERS_PER_SECOND(3L),
  /**
   * The speed accuracy is smaller than 0.3 meters per second.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_SPEED_ACC_0_3_METERS_PER_SECOND(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidSpeedAcc? = when (v) {
      0L -> MAV_ODID_SPEED_ACC_UNKNOWN
      1L -> MAV_ODID_SPEED_ACC_10_METERS_PER_SECOND
      2L -> MAV_ODID_SPEED_ACC_3_METERS_PER_SECOND
      3L -> MAV_ODID_SPEED_ACC_1_METERS_PER_SECOND
      4L -> MAV_ODID_SPEED_ACC_0_3_METERS_PER_SECOND
      else -> null
    }
  }
}
