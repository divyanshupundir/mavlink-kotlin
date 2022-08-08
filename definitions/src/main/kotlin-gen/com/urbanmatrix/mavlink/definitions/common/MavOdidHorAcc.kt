package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

@GeneratedMavEnum
public enum class MavOdidHorAcc(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The horizontal accuracy is unknown.
   */
  MAV_ODID_HOR_ACC_UNKNOWN(0L),
  /**
   * The horizontal accuracy is smaller than 10 Nautical Miles. 18.52 km.
   */
  MAV_ODID_HOR_ACC_10NM(1L),
  /**
   * The horizontal accuracy is smaller than 4 Nautical Miles. 7.408 km.
   */
  MAV_ODID_HOR_ACC_4NM(2L),
  /**
   * The horizontal accuracy is smaller than 2 Nautical Miles. 3.704 km.
   */
  MAV_ODID_HOR_ACC_2NM(3L),
  /**
   * The horizontal accuracy is smaller than 1 Nautical Miles. 1.852 km.
   */
  MAV_ODID_HOR_ACC_1NM(4L),
  /**
   * The horizontal accuracy is smaller than 0.5 Nautical Miles. 926 m.
   */
  MAV_ODID_HOR_ACC_0_5NM(5L),
  /**
   * The horizontal accuracy is smaller than 0.3 Nautical Miles. 555.6 m.
   */
  MAV_ODID_HOR_ACC_0_3NM(6L),
  /**
   * The horizontal accuracy is smaller than 0.1 Nautical Miles. 185.2 m.
   */
  MAV_ODID_HOR_ACC_0_1NM(7L),
  /**
   * The horizontal accuracy is smaller than 0.05 Nautical Miles. 92.6 m.
   */
  MAV_ODID_HOR_ACC_0_05NM(8L),
  /**
   * The horizontal accuracy is smaller than 30 meter.
   */
  MAV_ODID_HOR_ACC_30_METER(9L),
  /**
   * The horizontal accuracy is smaller than 10 meter.
   */
  MAV_ODID_HOR_ACC_10_METER(10L),
  /**
   * The horizontal accuracy is smaller than 3 meter.
   */
  MAV_ODID_HOR_ACC_3_METER(11L),
  /**
   * The horizontal accuracy is smaller than 1 meter.
   */
  MAV_ODID_HOR_ACC_1_METER(12L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidHorAcc? = when (v) {
      0L -> MAV_ODID_HOR_ACC_UNKNOWN
      1L -> MAV_ODID_HOR_ACC_10NM
      2L -> MAV_ODID_HOR_ACC_4NM
      3L -> MAV_ODID_HOR_ACC_2NM
      4L -> MAV_ODID_HOR_ACC_1NM
      5L -> MAV_ODID_HOR_ACC_0_5NM
      6L -> MAV_ODID_HOR_ACC_0_3NM
      7L -> MAV_ODID_HOR_ACC_0_1NM
      8L -> MAV_ODID_HOR_ACC_0_05NM
      9L -> MAV_ODID_HOR_ACC_30_METER
      10L -> MAV_ODID_HOR_ACC_10_METER
      11L -> MAV_ODID_HOR_ACC_3_METER
      12L -> MAV_ODID_HOR_ACC_1_METER
      else -> null
    }
  }
}
