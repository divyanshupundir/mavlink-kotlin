package com.divpundir.mavlink.definitions.avssuas

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavCmd(
  override val `value`: UInt,
) : MavEnum {
  /**
   * AVSS defined command. Set PRS arm statuses.
   *
   * index = 1; label = ARM status; 
   * PRS arm statuses
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; 
   * User defined
   *
   * index = 6; 
   * User defined
   *
   * index = 7; 
   * User defined
   */
  @GeneratedMavEnumEntry
  PRS_SET_ARM(60_050u),
  /**
   * AVSS defined command. Gets PRS arm statuses
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; 
   * User defined
   *
   * index = 6; 
   * User defined
   *
   * index = 7; 
   * User defined
   */
  @GeneratedMavEnumEntry
  PRS_GET_ARM(60_051u),
  /**
   * AVSS defined command.  Get the PRS battery voltage in millivolts
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; 
   * User defined
   *
   * index = 6; 
   * User defined
   *
   * index = 7; 
   * User defined
   */
  @GeneratedMavEnumEntry
  PRS_GET_BATTERY(60_052u),
  /**
   * AVSS defined command. Get the PRS error statuses.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; 
   * User defined
   *
   * index = 6; 
   * User defined
   *
   * index = 7; 
   * User defined
   */
  @GeneratedMavEnumEntry
  PRS_GET_ERR(60_053u),
  /**
   * AVSS defined command. Set the ATS arming altitude in meters.
   *
   * index = 1; label = Altitude; units = m; 
   * ATS arming altitude
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; 
   * User defined
   *
   * index = 6; 
   * User defined
   *
   * index = 7; 
   * User defined
   */
  @GeneratedMavEnumEntry
  PRS_SET_ARM_ALTI(60_070u),
  /**
   * AVSS defined command. Get the ATS arming altitude in meters.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; 
   * User defined
   *
   * index = 6; 
   * User defined
   *
   * index = 7; 
   * User defined
   */
  @GeneratedMavEnumEntry
  PRS_GET_ARM_ALTI(60_071u),
  /**
   * AVSS defined command. Shuts down the PRS system.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; 
   * User defined
   *
   * index = 6; 
   * User defined
   *
   * index = 7; 
   * User defined
   */
  @GeneratedMavEnumEntry
  PRS_SHUTDOWN(60_072u),
  ;

  public companion object : MavEnum.MavCompanion<MavCmd> {
    override fun getEntryFromValueOrNull(v: UInt): MavCmd? = when (v) {
      60050u -> PRS_SET_ARM
      60051u -> PRS_GET_ARM
      60052u -> PRS_GET_BATTERY
      60053u -> PRS_GET_ERR
      60070u -> PRS_SET_ARM_ALTI
      60071u -> PRS_GET_ARM_ALTI
      60072u -> PRS_SHUTDOWN
      else -> null
    }
  }
}
