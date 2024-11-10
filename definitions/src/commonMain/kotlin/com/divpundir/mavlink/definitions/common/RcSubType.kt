package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * RC sub-type of types defined in RC_TYPE. Used in MAV_CMD_START_RX_PAIR. Ignored if value does not
 * correspond to the set RC_TYPE.
 */
@GeneratedMavEnum
public enum class RcSubType(
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
  /**
   * Spektrum DSMX8
   */
  @GeneratedMavEnumEntry
  SPEKTRUM_DSMX8(2u),
  ;

  public companion object : MavEnum.MavCompanion<RcSubType> {
    override fun getEntryFromValueOrNull(v: UInt): RcSubType? = when (v) {
      0u -> SPEKTRUM_DSM2
      1u -> SPEKTRUM_DSMX
      2u -> SPEKTRUM_DSMX8
      else -> null
    }
  }
}
