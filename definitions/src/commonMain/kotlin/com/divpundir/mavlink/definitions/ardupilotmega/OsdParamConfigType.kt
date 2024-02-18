package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * The type of parameter for the OSD parameter editor.
 *
 */
@GeneratedMavEnum
public enum class OsdParamConfigType(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  OSD_PARAM_NONE(0u),
  @GeneratedMavEnumEntry
  OSD_PARAM_SERIAL_PROTOCOL(1u),
  @GeneratedMavEnumEntry
  OSD_PARAM_SERVO_FUNCTION(2u),
  @GeneratedMavEnumEntry
  OSD_PARAM_AUX_FUNCTION(3u),
  @GeneratedMavEnumEntry
  OSD_PARAM_FLIGHT_MODE(4u),
  @GeneratedMavEnumEntry
  OSD_PARAM_FAILSAFE_ACTION(5u),
  @GeneratedMavEnumEntry
  OSD_PARAM_FAILSAFE_ACTION_1(6u),
  @GeneratedMavEnumEntry
  OSD_PARAM_FAILSAFE_ACTION_2(7u),
  @GeneratedMavEnumEntry
  OSD_PARAM_NUM_TYPES(8u),
  ;

  public companion object : MavEnum.MavCompanion<OsdParamConfigType> {
    override fun getEntryFromValueOrNull(v: UInt): OsdParamConfigType? = when (v) {
      0u -> OSD_PARAM_NONE
      1u -> OSD_PARAM_SERIAL_PROTOCOL
      2u -> OSD_PARAM_SERVO_FUNCTION
      3u -> OSD_PARAM_AUX_FUNCTION
      4u -> OSD_PARAM_FLIGHT_MODE
      5u -> OSD_PARAM_FAILSAFE_ACTION
      6u -> OSD_PARAM_FAILSAFE_ACTION_1
      7u -> OSD_PARAM_FAILSAFE_ACTION_2
      8u -> OSD_PARAM_NUM_TYPES
      else -> null
    }
  }
}
