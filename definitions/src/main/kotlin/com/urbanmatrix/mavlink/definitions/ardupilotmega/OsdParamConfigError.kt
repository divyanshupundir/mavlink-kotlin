package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * The error type for the OSD parameter editor.
 */
public enum class OsdParamConfigError(
  public override val `value`: Long,
) : MavEnum {
  OSD_PARAM_SUCCESS(0L),
  OSD_PARAM_INVALID_SCREEN(1L),
  OSD_PARAM_INVALID_PARAMETER_INDEX(2L),
  OSD_PARAM_INVALID_PARAMETER(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): OsdParamConfigError? = when (v) {
      0L -> OSD_PARAM_SUCCESS
      1L -> OSD_PARAM_INVALID_SCREEN
      2L -> OSD_PARAM_INVALID_PARAMETER_INDEX
      3L -> OSD_PARAM_INVALID_PARAMETER
      else -> null
    }
  }
}
