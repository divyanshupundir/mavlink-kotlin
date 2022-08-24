package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Specifies the datatype of a MAVLink parameter.
 */
@GeneratedMavEnum
public enum class MavParamType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * 8-bit unsigned integer
   */
  MAV_PARAM_TYPE_UINT8(1L),
  /**
   * 8-bit signed integer
   */
  MAV_PARAM_TYPE_INT8(2L),
  /**
   * 16-bit unsigned integer
   */
  MAV_PARAM_TYPE_UINT16(3L),
  /**
   * 16-bit signed integer
   */
  MAV_PARAM_TYPE_INT16(4L),
  /**
   * 32-bit unsigned integer
   */
  MAV_PARAM_TYPE_UINT32(5L),
  /**
   * 32-bit signed integer
   */
  MAV_PARAM_TYPE_INT32(6L),
  /**
   * 64-bit unsigned integer
   */
  MAV_PARAM_TYPE_UINT64(7L),
  /**
   * 64-bit signed integer
   */
  MAV_PARAM_TYPE_INT64(8L),
  /**
   * 32-bit floating-point
   */
  MAV_PARAM_TYPE_REAL32(9L),
  /**
   * 64-bit floating-point
   */
  MAV_PARAM_TYPE_REAL64(10L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavParamType? = when (v) {
      1L -> MAV_PARAM_TYPE_UINT8
      2L -> MAV_PARAM_TYPE_INT8
      3L -> MAV_PARAM_TYPE_UINT16
      4L -> MAV_PARAM_TYPE_INT16
      5L -> MAV_PARAM_TYPE_UINT32
      6L -> MAV_PARAM_TYPE_INT32
      7L -> MAV_PARAM_TYPE_UINT64
      8L -> MAV_PARAM_TYPE_INT64
      9L -> MAV_PARAM_TYPE_REAL32
      10L -> MAV_PARAM_TYPE_REAL64
      else -> null
    }
  }
}
