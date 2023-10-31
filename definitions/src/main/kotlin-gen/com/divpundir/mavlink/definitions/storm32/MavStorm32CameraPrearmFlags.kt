package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * STorM32 camera prearm check flags.
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavStorm32CameraPrearmFlags(
  public override val `value`: UInt,
) : MavBitmask {
  /**
   * The camera has been found and is connected.
   */
  @GeneratedMavEnumEntry
  CONNECTED(1u),
  ;

  public companion object : MavBitmask.MavCompanion<MavStorm32CameraPrearmFlags> {
    public override fun getEntryFromValueOrNull(v: UInt): MavStorm32CameraPrearmFlags? = when (v) {
      1u -> CONNECTED
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<MavStorm32CameraPrearmFlags> = buildList {
      if (v and 1u == 1u) add(CONNECTED)
    }
  }
}
