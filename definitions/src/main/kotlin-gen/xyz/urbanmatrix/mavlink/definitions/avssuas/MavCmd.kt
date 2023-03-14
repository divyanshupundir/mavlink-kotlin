package xyz.urbanmatrix.mavlink.definitions.avssuas

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavCmd(
  public override val `value`: UInt,
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
  PRS_SET_ARM(60050u),
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
  PRS_GET_ARM(60051u),
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
  PRS_GET_BATTERY(60052u),
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
  PRS_GET_ERR(60053u),
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
  PRS_SET_ARM_ALTI(60070u),
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
  PRS_GET_ARM_ALTI(60071u),
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
  PRS_SHUTDOWN(60072u),
  ;

  public companion object : MavEnum.Companion<MavCmd> {
    public override fun getEntryFromValueOrNull(v: UInt): MavCmd? = when (v) {
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
