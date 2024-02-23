package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Generalized UAVCAN node mode
 */
@GeneratedMavEnum
public enum class UavcanNodeMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * The node is performing its primary functions.
   */
  @GeneratedMavEnumEntry
  OPERATIONAL(0u),
  /**
   * The node is initializing; this mode is entered immediately after startup.
   */
  @GeneratedMavEnumEntry
  INITIALIZATION(1u),
  /**
   * The node is under maintenance.
   */
  @GeneratedMavEnumEntry
  MAINTENANCE(2u),
  /**
   * The node is in the process of updating its software.
   */
  @GeneratedMavEnumEntry
  SOFTWARE_UPDATE(3u),
  /**
   * The node is no longer available online.
   */
  @GeneratedMavEnumEntry
  OFFLINE(7u),
  ;

  public companion object : MavEnum.MavCompanion<UavcanNodeMode> {
    override fun getEntryFromValueOrNull(v: UInt): UavcanNodeMode? = when (v) {
      0u -> OPERATIONAL
      1u -> INITIALIZATION
      2u -> MAINTENANCE
      3u -> SOFTWARE_UPDATE
      7u -> OFFLINE
      else -> null
    }
  }
}
