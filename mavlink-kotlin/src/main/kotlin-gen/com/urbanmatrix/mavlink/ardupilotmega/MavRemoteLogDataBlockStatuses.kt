package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Possible remote log data block statuses.
 */
public enum class MavRemoteLogDataBlockStatuses(
  public override val `value`: Long,
) : MavEnum {
  /**
   * This block has NOT been received.
   */
  MAV_REMOTE_LOG_DATA_BLOCK_NACK(0L),
  /**
   * This block has been received.
   */
  MAV_REMOTE_LOG_DATA_BLOCK_ACK(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavRemoteLogDataBlockStatuses? = when (v) {
      0L -> MAV_REMOTE_LOG_DATA_BLOCK_NACK
      1L -> MAV_REMOTE_LOG_DATA_BLOCK_ACK
      else -> null
    }
  }
}
