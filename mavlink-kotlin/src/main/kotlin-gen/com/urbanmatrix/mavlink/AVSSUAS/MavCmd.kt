package com.urbanmatrix.mavlink.AVSSUAS

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class MavCmd(
  public override val `value`: Long,
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
  MAV_CMD_PRS_SET_ARM(60050L),
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
  MAV_CMD_PRS_GET_ARM(60051L),
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
  MAV_CMD_PRS_GET_BATTERY(60052L),
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
  MAV_CMD_PRS_GET_ERR(60053L),
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
  MAV_CMD_PRS_SET_ARM_ALTI(60070L),
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
  MAV_CMD_PRS_GET_ARM_ALTI(60071L),
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
  MAV_CMD_PRS_SHUTDOWN(60072L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavCmd? = when (v) {
      60050L -> MAV_CMD_PRS_SET_ARM
      60051L -> MAV_CMD_PRS_GET_ARM
      60052L -> MAV_CMD_PRS_GET_BATTERY
      60053L -> MAV_CMD_PRS_GET_ERR
      60070L -> MAV_CMD_PRS_SET_ARM_ALTI
      60071L -> MAV_CMD_PRS_GET_ARM_ALTI
      60072L -> MAV_CMD_PRS_SHUTDOWN
      else -> null
    }
  }
}
