package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Specifies the datatype of a MAVLink extended parameter.
 */
@GeneratedMavEnum
public enum class MavParamExtType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * 8-bit unsigned integer
   */
  @GeneratedMavEnumEntry
  UINT8(1L),
  /**
   * 8-bit signed integer
   */
  @GeneratedMavEnumEntry
  INT8(2L),
  /**
   * 16-bit unsigned integer
   */
  @GeneratedMavEnumEntry
  UINT16(3L),
  /**
   * 16-bit signed integer
   */
  @GeneratedMavEnumEntry
  INT16(4L),
  /**
   * 32-bit unsigned integer
   */
  @GeneratedMavEnumEntry
  UINT32(5L),
  /**
   * 32-bit signed integer
   */
  @GeneratedMavEnumEntry
  INT32(6L),
  /**
   * 64-bit unsigned integer
   */
  @GeneratedMavEnumEntry
  UINT64(7L),
  /**
   * 64-bit signed integer
   */
  @GeneratedMavEnumEntry
  INT64(8L),
  /**
   * 32-bit floating-point
   */
  @GeneratedMavEnumEntry
  REAL32(9L),
  /**
   * 64-bit floating-point
   */
  @GeneratedMavEnumEntry
  REAL64(10L),
  /**
   * Custom Type
   */
  @GeneratedMavEnumEntry
  CUSTOM(11L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavParamExtType? = when (v) {
      1L -> UINT8
      2L -> INT8
      3L -> UINT16
      4L -> INT16
      5L -> UINT32
      6L -> INT32
      7L -> UINT64
      8L -> INT64
      9L -> REAL32
      10L -> REAL64
      11L -> CUSTOM
      else -> null
    }
  }
}
