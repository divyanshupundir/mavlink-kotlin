package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

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
