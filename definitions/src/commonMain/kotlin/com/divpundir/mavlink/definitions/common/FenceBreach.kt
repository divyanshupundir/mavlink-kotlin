package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class FenceBreach(
  override val `value`: UInt,
) : MavEnum {
  /**
   * No last fence breach
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Breached minimum altitude
   */
  @GeneratedMavEnumEntry
  MINALT(1u),
  /**
   * Breached maximum altitude
   */
  @GeneratedMavEnumEntry
  MAXALT(2u),
  /**
   * Breached fence boundary
   */
  @GeneratedMavEnumEntry
  BOUNDARY(3u),
  ;

  public companion object : MavEnum.MavCompanion<FenceBreach> {
    override fun getEntryFromValueOrNull(v: UInt): FenceBreach? = when (v) {
      0u -> NONE
      1u -> MINALT
      2u -> MAXALT
      3u -> BOUNDARY
      else -> null
    }
  }
}
