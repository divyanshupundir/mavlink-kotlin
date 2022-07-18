package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * ACK / NACK / ERROR values as a result of MAV_CMDs and for mission item transmission.
 */
public enum class MavCmdAck(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Command / mission item is ok.
   */
  MAV_CMD_ACK_OK(0L),
  /**
   * Generic error message if none of the other reasons fails or if no detailed error reporting is
   * implemented.
   */
  MAV_CMD_ACK_ERR_FAIL(1L),
  /**
   * The system is refusing to accept this command from this source / communication partner.
   */
  MAV_CMD_ACK_ERR_ACCESS_DENIED(2L),
  /**
   * Command or mission item is not supported, other commands would be accepted.
   */
  MAV_CMD_ACK_ERR_NOT_SUPPORTED(3L),
  /**
   * The coordinate frame of this command / mission item is not supported.
   */
  MAV_CMD_ACK_ERR_COORDINATE_FRAME_NOT_SUPPORTED(4L),
  /**
   * The coordinate frame of this command is ok, but he coordinate values exceed the safety limits
   * of this system. This is a generic error, please use the more specific error messages below if
   * possible.
   */
  MAV_CMD_ACK_ERR_COORDINATES_OUT_OF_RANGE(5L),
  /**
   * The X or latitude value is out of range.
   */
  MAV_CMD_ACK_ERR_X_LAT_OUT_OF_RANGE(6L),
  /**
   * The Y or longitude value is out of range.
   */
  MAV_CMD_ACK_ERR_Y_LON_OUT_OF_RANGE(7L),
  /**
   * The Z or altitude value is out of range.
   */
  MAV_CMD_ACK_ERR_Z_ALT_OUT_OF_RANGE(8L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavCmdAck? = when (v) {
      0L -> MAV_CMD_ACK_OK
      1L -> MAV_CMD_ACK_ERR_FAIL
      2L -> MAV_CMD_ACK_ERR_ACCESS_DENIED
      3L -> MAV_CMD_ACK_ERR_NOT_SUPPORTED
      4L -> MAV_CMD_ACK_ERR_COORDINATE_FRAME_NOT_SUPPORTED
      5L -> MAV_CMD_ACK_ERR_COORDINATES_OUT_OF_RANGE
      6L -> MAV_CMD_ACK_ERR_X_LAT_OUT_OF_RANGE
      7L -> MAV_CMD_ACK_ERR_Y_LON_OUT_OF_RANGE
      8L -> MAV_CMD_ACK_ERR_Z_ALT_OUT_OF_RANGE
      else -> null
    }
  }
}
