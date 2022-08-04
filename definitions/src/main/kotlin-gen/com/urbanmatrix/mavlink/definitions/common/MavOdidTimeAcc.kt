package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class MavOdidTimeAcc(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The timestamp accuracy is unknown.
   */
  MAV_ODID_TIME_ACC_UNKNOWN(0L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.1 second.
   */
  MAV_ODID_TIME_ACC_0_1_SECOND(1L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.2 second.
   */
  MAV_ODID_TIME_ACC_0_2_SECOND(2L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.3 second.
   */
  MAV_ODID_TIME_ACC_0_3_SECOND(3L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.4 second.
   */
  MAV_ODID_TIME_ACC_0_4_SECOND(4L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.5 second.
   */
  MAV_ODID_TIME_ACC_0_5_SECOND(5L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.6 second.
   */
  MAV_ODID_TIME_ACC_0_6_SECOND(6L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.7 second.
   */
  MAV_ODID_TIME_ACC_0_7_SECOND(7L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.8 second.
   */
  MAV_ODID_TIME_ACC_0_8_SECOND(8L),
  /**
   * The timestamp accuracy is smaller than or equal to 0.9 second.
   */
  MAV_ODID_TIME_ACC_0_9_SECOND(9L),
  /**
   * The timestamp accuracy is smaller than or equal to 1.0 second.
   */
  MAV_ODID_TIME_ACC_1_0_SECOND(10L),
  /**
   * The timestamp accuracy is smaller than or equal to 1.1 second.
   */
  MAV_ODID_TIME_ACC_1_1_SECOND(11L),
  /**
   * The timestamp accuracy is smaller than or equal to 1.2 second.
   */
  MAV_ODID_TIME_ACC_1_2_SECOND(12L),
  /**
   * The timestamp accuracy is smaller than or equal to 1.3 second.
   */
  MAV_ODID_TIME_ACC_1_3_SECOND(13L),
  /**
   * The timestamp accuracy is smaller than or equal to 1.4 second.
   */
  MAV_ODID_TIME_ACC_1_4_SECOND(14L),
  /**
   * The timestamp accuracy is smaller than or equal to 1.5 second.
   */
  MAV_ODID_TIME_ACC_1_5_SECOND(15L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidTimeAcc? = when (v) {
      0L -> MAV_ODID_TIME_ACC_UNKNOWN
      1L -> MAV_ODID_TIME_ACC_0_1_SECOND
      2L -> MAV_ODID_TIME_ACC_0_2_SECOND
      3L -> MAV_ODID_TIME_ACC_0_3_SECOND
      4L -> MAV_ODID_TIME_ACC_0_4_SECOND
      5L -> MAV_ODID_TIME_ACC_0_5_SECOND
      6L -> MAV_ODID_TIME_ACC_0_6_SECOND
      7L -> MAV_ODID_TIME_ACC_0_7_SECOND
      8L -> MAV_ODID_TIME_ACC_0_8_SECOND
      9L -> MAV_ODID_TIME_ACC_0_9_SECOND
      10L -> MAV_ODID_TIME_ACC_1_0_SECOND
      11L -> MAV_ODID_TIME_ACC_1_1_SECOND
      12L -> MAV_ODID_TIME_ACC_1_2_SECOND
      13L -> MAV_ODID_TIME_ACC_1_3_SECOND
      14L -> MAV_ODID_TIME_ACC_1_4_SECOND
      15L -> MAV_ODID_TIME_ACC_1_5_SECOND
      else -> null
    }
  }
}
