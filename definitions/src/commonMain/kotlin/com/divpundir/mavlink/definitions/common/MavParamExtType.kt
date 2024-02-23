package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Specifies the datatype of a MAVLink extended parameter.
 */
@GeneratedMavEnum
public enum class MavParamExtType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * 8-bit unsigned integer
   */
  @GeneratedMavEnumEntry
  UINT8(1u),
  /**
   * 8-bit signed integer
   */
  @GeneratedMavEnumEntry
  INT8(2u),
  /**
   * 16-bit unsigned integer
   */
  @GeneratedMavEnumEntry
  UINT16(3u),
  /**
   * 16-bit signed integer
   */
  @GeneratedMavEnumEntry
  INT16(4u),
  /**
   * 32-bit unsigned integer
   */
  @GeneratedMavEnumEntry
  UINT32(5u),
  /**
   * 32-bit signed integer
   */
  @GeneratedMavEnumEntry
  INT32(6u),
  /**
   * 64-bit unsigned integer
   */
  @GeneratedMavEnumEntry
  UINT64(7u),
  /**
   * 64-bit signed integer
   */
  @GeneratedMavEnumEntry
  INT64(8u),
  /**
   * 32-bit floating-point
   */
  @GeneratedMavEnumEntry
  REAL32(9u),
  /**
   * 64-bit floating-point
   */
  @GeneratedMavEnumEntry
  REAL64(10u),
  /**
   * Custom Type
   */
  @GeneratedMavEnumEntry
  CUSTOM(11u),
  ;

  public companion object : MavEnum.MavCompanion<MavParamExtType> {
    override fun getEntryFromValueOrNull(v: UInt): MavParamExtType? = when (v) {
      1u -> UINT8
      2u -> INT8
      3u -> UINT16
      4u -> INT16
      5u -> UINT32
      6u -> INT32
      7u -> UINT64
      8u -> INT64
      9u -> REAL32
      10u -> REAL64
      11u -> CUSTOM
      else -> null
    }
  }
}
