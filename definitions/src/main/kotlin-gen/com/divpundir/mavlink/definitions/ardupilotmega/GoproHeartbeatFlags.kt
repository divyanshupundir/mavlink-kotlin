package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

@GeneratedMavEnum(bitmask = true)
public enum class GoproHeartbeatFlags(
  public override val `value`: UInt,
) : MavBitmask {
  /**
   * GoPro is currently recording.
   */
  @GeneratedMavEnumEntry
  GOPRO_FLAG_RECORDING(1u),
  ;

  public companion object : MavBitmask.Companion<GoproHeartbeatFlags> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproHeartbeatFlags? = when (v) {
      1u -> GOPRO_FLAG_RECORDING
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<GoproHeartbeatFlags> = buildList {
      if (v and 1u == 1u) add(GOPRO_FLAG_RECORDING)
    }
  }
}
