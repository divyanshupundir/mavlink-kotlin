package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Possible remote log data block statuses.
 */
@GeneratedMavEnum
public enum class MavRemoteLogDataBlockStatuses(
  public override val `value`: Long,
) : MavEnum {
  /**
   * This block has NOT been received.
   */
  @GeneratedMavEnumEntry
  MAV_REMOTE_LOG_DATA_BLOCK_NACK(0L),
  /**
   * This block has been received.
   */
  @GeneratedMavEnumEntry
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
