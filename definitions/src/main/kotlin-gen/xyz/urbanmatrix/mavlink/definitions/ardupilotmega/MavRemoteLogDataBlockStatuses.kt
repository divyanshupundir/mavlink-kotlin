package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Possible remote log data block statuses.
 */
@GeneratedMavEnum
public enum class MavRemoteLogDataBlockStatuses(
  public override val `value`: UInt,
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

  public companion object : MavEnum.Companion<MavRemoteLogDataBlockStatuses> {
    public override fun getEntryFromValueOrNull(v: UInt): MavRemoteLogDataBlockStatuses? = when (v)
        {
      0u -> MAV_REMOTE_LOG_DATA_BLOCK_NACK
      1u -> MAV_REMOTE_LOG_DATA_BLOCK_ACK
      else -> null
    }
  }
}
