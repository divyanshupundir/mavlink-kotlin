package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * State flags for X-Bit and reserved fields.
 */
@GeneratedMavEnum(bitmask = true)
public enum class UavionixAdsbXbit(
  override val `value`: UInt,
) : MavBitmask {
  @GeneratedMavEnumEntry
  ENABLED(128u),
  ;

  public companion object : MavBitmask.MavCompanion<UavionixAdsbXbit> {
    override fun getEntryFromValueOrNull(v: UInt): UavionixAdsbXbit? = when (v) {
      128u -> ENABLED
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<UavionixAdsbXbit> = buildList {
      if (v and 128u == 128u) add(ENABLED)
    }
  }
}
