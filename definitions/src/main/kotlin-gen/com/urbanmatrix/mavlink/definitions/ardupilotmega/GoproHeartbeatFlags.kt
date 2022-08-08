package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

@GeneratedMavEnum
public enum class GoproHeartbeatFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * GoPro is currently recording.
   */
  GOPRO_FLAG_RECORDING(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproHeartbeatFlags? = when (v) {
      1L -> GOPRO_FLAG_RECORDING
      else -> null
    }
  }
}
