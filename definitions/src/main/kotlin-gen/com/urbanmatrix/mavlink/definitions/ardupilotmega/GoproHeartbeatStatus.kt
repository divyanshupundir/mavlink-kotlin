package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

@GeneratedMavEnum
public enum class GoproHeartbeatStatus(
  public override val `value`: Long,
) : MavEnum {
  /**
   * No GoPro connected.
   */
  GOPRO_HEARTBEAT_STATUS_DISCONNECTED(0L),
  /**
   * The detected GoPro is not HeroBus compatible.
   */
  GOPRO_HEARTBEAT_STATUS_INCOMPATIBLE(1L),
  /**
   * A HeroBus compatible GoPro is connected.
   */
  GOPRO_HEARTBEAT_STATUS_CONNECTED(2L),
  /**
   * An unrecoverable error was encountered with the connected GoPro, it may require a power cycle.
   */
  GOPRO_HEARTBEAT_STATUS_ERROR(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproHeartbeatStatus? = when (v) {
      0L -> GOPRO_HEARTBEAT_STATUS_DISCONNECTED
      1L -> GOPRO_HEARTBEAT_STATUS_INCOMPATIBLE
      2L -> GOPRO_HEARTBEAT_STATUS_CONNECTED
      3L -> GOPRO_HEARTBEAT_STATUS_ERROR
      else -> null
    }
  }
}
