package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Special ACK block numbers control activation of dataflash log streaming.
 */
@GeneratedMavEnum
public enum class MavRemoteLogDataBlockCommands(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * UAV to stop sending DataFlash blocks.
   */
  @GeneratedMavEnumEntry
  MAV_REMOTE_LOG_DATA_BLOCK_STOP(2147483645u),
  /**
   * UAV to start sending DataFlash blocks.
   */
  @GeneratedMavEnumEntry
  MAV_REMOTE_LOG_DATA_BLOCK_START(2147483646u),
  ;

  public companion object : MavEnum.Companion<MavRemoteLogDataBlockCommands> {
    public override fun getEntryFromValueOrNull(v: UInt): MavRemoteLogDataBlockCommands? = when (v)
        {
      2147483645u -> MAV_REMOTE_LOG_DATA_BLOCK_STOP
      2147483646u -> MAV_REMOTE_LOG_DATA_BLOCK_START
      else -> null
    }
  }
}
