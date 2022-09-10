package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Special ACK block numbers control activation of dataflash log streaming.
 */
@GeneratedMavEnum
public enum class MavRemoteLogDataBlockCommands(
  public override val `value`: Long,
) : MavEnum {
  /**
   * UAV to stop sending DataFlash blocks.
   */
  @GeneratedMavEnumEntry
  MAV_REMOTE_LOG_DATA_BLOCK_STOP(2147483645L),
  /**
   * UAV to start sending DataFlash blocks.
   */
  @GeneratedMavEnumEntry
  MAV_REMOTE_LOG_DATA_BLOCK_START(2147483646L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavRemoteLogDataBlockCommands? = when (v) {
      2147483645L -> MAV_REMOTE_LOG_DATA_BLOCK_STOP
      2147483646L -> MAV_REMOTE_LOG_DATA_BLOCK_START
      else -> null
    }
  }
}
