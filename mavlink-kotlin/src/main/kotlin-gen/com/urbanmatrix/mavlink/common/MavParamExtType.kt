package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Specifies the datatype of a MAVLink extended parameter.
 */
public enum class MavParamExtType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * 8-bit unsigned integer
   */
  MAV_PARAM_EXT_TYPE_UINT8(1L),
  /**
   * 8-bit signed integer
   */
  MAV_PARAM_EXT_TYPE_INT8(2L),
  /**
   * 16-bit unsigned integer
   */
  MAV_PARAM_EXT_TYPE_UINT16(3L),
  /**
   * 16-bit signed integer
   */
  MAV_PARAM_EXT_TYPE_INT16(4L),
  /**
   * 32-bit unsigned integer
   */
  MAV_PARAM_EXT_TYPE_UINT32(5L),
  /**
   * 32-bit signed integer
   */
  MAV_PARAM_EXT_TYPE_INT32(6L),
  /**
   * 64-bit unsigned integer
   */
  MAV_PARAM_EXT_TYPE_UINT64(7L),
  /**
   * 64-bit signed integer
   */
  MAV_PARAM_EXT_TYPE_INT64(8L),
  /**
   * 32-bit floating-point
   */
  MAV_PARAM_EXT_TYPE_REAL32(9L),
  /**
   * 64-bit floating-point
   */
  MAV_PARAM_EXT_TYPE_REAL64(10L),
  /**
   * Custom Type
   */
  MAV_PARAM_EXT_TYPE_CUSTOM(11L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavParamExtType? = when (v) {
      1L -> MAV_PARAM_EXT_TYPE_UINT8
      2L -> MAV_PARAM_EXT_TYPE_INT8
      3L -> MAV_PARAM_EXT_TYPE_UINT16
      4L -> MAV_PARAM_EXT_TYPE_INT16
      5L -> MAV_PARAM_EXT_TYPE_UINT32
      6L -> MAV_PARAM_EXT_TYPE_INT32
      7L -> MAV_PARAM_EXT_TYPE_UINT64
      8L -> MAV_PARAM_EXT_TYPE_INT64
      9L -> MAV_PARAM_EXT_TYPE_REAL32
      10L -> MAV_PARAM_EXT_TYPE_REAL64
      11L -> MAV_PARAM_EXT_TYPE_CUSTOM
      else -> null
    }
  }
}
