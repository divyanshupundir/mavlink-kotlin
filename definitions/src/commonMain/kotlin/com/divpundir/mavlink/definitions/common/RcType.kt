package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * RC type. Used in MAV_CMD_START_RX_PAIR.
 */
@GeneratedMavEnum
public enum class RcType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Spektrum
   */
  @GeneratedMavEnumEntry
  SPEKTRUM(0u),
  /**
   * CRSF
   */
  @GeneratedMavEnumEntry
  CRSF(1u),
  ;

  public companion object : MavEnum.MavCompanion<RcType> {
    override fun getEntryFromValueOrNull(v: UInt): RcType? = when (v) {
      0u -> SPEKTRUM
      1u -> CRSF
      else -> null
    }
  }
}
