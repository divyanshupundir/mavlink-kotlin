package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Parameter protocol error types (see PARAM_ERROR).
 */
@GeneratedMavEnum
public enum class MavParamError(
  override val `value`: UInt,
) : MavEnum {
  /**
   * No error occurred (not expected in PARAM_ERROR but may be used in future implementations.
   */
  @GeneratedMavEnumEntry
  NO_ERROR(0u),
  /**
   * Parameter does not exist
   */
  @GeneratedMavEnumEntry
  DOES_NOT_EXIST(1u),
  /**
   * Parameter value does not fit within accepted range
   */
  @GeneratedMavEnumEntry
  VALUE_OUT_OF_RANGE(2u),
  /**
   * Caller is not permitted to set the value of this parameter
   */
  @GeneratedMavEnumEntry
  PERMISSION_DENIED(3u),
  /**
   * Unknown component specified
   */
  @GeneratedMavEnumEntry
  COMPONENT_NOT_FOUND(4u),
  /**
   * Parameter is read-only
   */
  @GeneratedMavEnumEntry
  READ_ONLY(5u),
  /**
   * Parameter data type (MAV_PARAM_TYPE) is not supported by flight stack (at all)
   */
  @GeneratedMavEnumEntry
  TYPE_UNSUPPORTED(6u),
  /**
   * Parameter type does not match expected type
   */
  @GeneratedMavEnumEntry
  TYPE_MISMATCH(7u),
  /**
   * Parameter exists but reading failed
   */
  @GeneratedMavEnumEntry
  READ_FAIL(8u),
  ;

  public companion object : MavEnum.MavCompanion<MavParamError> {
    override fun getEntryFromValueOrNull(v: UInt): MavParamError? = when (v) {
      0u -> NO_ERROR
      1u -> DOES_NOT_EXIST
      2u -> VALUE_OUT_OF_RANGE
      3u -> PERMISSION_DENIED
      4u -> COMPONENT_NOT_FOUND
      5u -> READ_ONLY
      6u -> TYPE_UNSUPPORTED
      7u -> TYPE_MISMATCH
      8u -> READ_FAIL
      else -> null
    }
  }
}
