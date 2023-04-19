package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * The error type for the OSD parameter editor.
 */
@GeneratedMavEnum
public enum class OsdParamConfigError(
  public override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  OSD_PARAM_SUCCESS(0u),
  @GeneratedMavEnumEntry
  OSD_PARAM_INVALID_SCREEN(1u),
  @GeneratedMavEnumEntry
  OSD_PARAM_INVALID_PARAMETER_INDEX(2u),
  @GeneratedMavEnumEntry
  OSD_PARAM_INVALID_PARAMETER(3u),
  ;

  public companion object : MavEnum.Companion<OsdParamConfigError> {
    public override fun getEntryFromValueOrNull(v: UInt): OsdParamConfigError? = when (v) {
      0u -> OSD_PARAM_SUCCESS
      1u -> OSD_PARAM_INVALID_SCREEN
      2u -> OSD_PARAM_INVALID_PARAMETER_INDEX
      3u -> OSD_PARAM_INVALID_PARAMETER
      else -> null
    }
  }
}
