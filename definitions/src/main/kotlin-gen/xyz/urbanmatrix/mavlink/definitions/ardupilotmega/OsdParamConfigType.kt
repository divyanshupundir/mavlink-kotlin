package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * The type of parameter for the OSD parameter editor.
 */
@GeneratedMavEnum
public enum class OsdParamConfigType(
  public override val `value`: Long,
) : MavEnum {
  OSD_PARAM_NONE(0L),
  OSD_PARAM_SERIAL_PROTOCOL(1L),
  OSD_PARAM_SERVO_FUNCTION(2L),
  OSD_PARAM_AUX_FUNCTION(3L),
  OSD_PARAM_FLIGHT_MODE(4L),
  OSD_PARAM_FAILSAFE_ACTION(5L),
  OSD_PARAM_FAILSAFE_ACTION_1(6L),
  OSD_PARAM_FAILSAFE_ACTION_2(7L),
  OSD_PARAM_NUM_TYPES(8L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): OsdParamConfigType? = when (v) {
      0L -> OSD_PARAM_NONE
      1L -> OSD_PARAM_SERIAL_PROTOCOL
      2L -> OSD_PARAM_SERVO_FUNCTION
      3L -> OSD_PARAM_AUX_FUNCTION
      4L -> OSD_PARAM_FLIGHT_MODE
      5L -> OSD_PARAM_FAILSAFE_ACTION
      6L -> OSD_PARAM_FAILSAFE_ACTION_1
      7L -> OSD_PARAM_FAILSAFE_ACTION_2
      8L -> OSD_PARAM_NUM_TYPES
      else -> null
    }
  }
}
