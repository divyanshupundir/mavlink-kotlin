package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Generalized UAVCAN node health
 */
@GeneratedMavEnum
public enum class UavcanNodeHealth(
  override val `value`: UInt,
) : MavEnum {
  /**
   * The node is functioning properly.
   */
  @GeneratedMavEnumEntry
  OK(0u),
  /**
   * A critical parameter went out of range or the node has encountered a minor failure.
   */
  @GeneratedMavEnumEntry
  WARNING(1u),
  /**
   * The node has encountered a major failure.
   */
  @GeneratedMavEnumEntry
  ERROR(2u),
  /**
   * The node has suffered a fatal malfunction.
   */
  @GeneratedMavEnumEntry
  CRITICAL(3u),
  ;

  public companion object : MavEnum.MavCompanion<UavcanNodeHealth> {
    override fun getEntryFromValueOrNull(v: UInt): UavcanNodeHealth? = when (v) {
      0u -> OK
      1u -> WARNING
      2u -> ERROR
      3u -> CRITICAL
      else -> null
    }
  }
}
