package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * State flags for X-Bit and reserved fields.
 */
@GeneratedMavEnum
public enum class UavionixAdsbXbit(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  ENABLED(128u),
  ;

  public companion object : MavEnum.MavCompanion<UavionixAdsbXbit> {
    override fun getEntryFromValueOrNull(v: UInt): UavionixAdsbXbit? = when (v) {
      128u -> ENABLED
      else -> null
    }
  }
}
