package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * RC type
 */
@GeneratedMavEnum
public enum class RcType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Spektrum DSM2
   */
  @GeneratedMavEnumEntry
  SPEKTRUM_DSM2(0u),
  /**
   * Spektrum DSMX
   */
  @GeneratedMavEnumEntry
  SPEKTRUM_DSMX(1u),
  ;

  public companion object : MavEnum.MavCompanion<RcType> {
    override fun getEntryFromValueOrNull(v: UInt): RcType? = when (v) {
      0u -> SPEKTRUM_DSM2
      1u -> SPEKTRUM_DSMX
      else -> null
    }
  }
}
