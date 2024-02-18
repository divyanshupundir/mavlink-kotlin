package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Possible remote log data block statuses.
 *
 */
@GeneratedMavEnum
public enum class MavRemoteLogDataBlockStatuses(
  override val `value`: UInt,
) : MavEnum {
  /**
   * This block has NOT been received.
   */
  @GeneratedMavEnumEntry
  MAV_REMOTE_LOG_DATA_BLOCK_NACK(0u),
  /**
   * This block has been received.
   */
  @GeneratedMavEnumEntry
  MAV_REMOTE_LOG_DATA_BLOCK_ACK(1u),
  ;

  public companion object : MavEnum.MavCompanion<MavRemoteLogDataBlockStatuses> {
    override fun getEntryFromValueOrNull(v: UInt): MavRemoteLogDataBlockStatuses? = when (v) {
      0u -> MAV_REMOTE_LOG_DATA_BLOCK_NACK
      1u -> MAV_REMOTE_LOG_DATA_BLOCK_ACK
      else -> null
    }
  }
}
