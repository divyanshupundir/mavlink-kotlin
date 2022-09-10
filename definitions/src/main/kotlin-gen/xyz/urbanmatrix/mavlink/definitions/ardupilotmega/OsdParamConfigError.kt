package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * The error type for the OSD parameter editor.
 */
@GeneratedMavEnum
public enum class OsdParamConfigError(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  OSD_PARAM_SUCCESS(0L),
  @GeneratedMavEnumEntry
  OSD_PARAM_INVALID_SCREEN(1L),
  @GeneratedMavEnumEntry
  OSD_PARAM_INVALID_PARAMETER_INDEX(2L),
  @GeneratedMavEnumEntry
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
