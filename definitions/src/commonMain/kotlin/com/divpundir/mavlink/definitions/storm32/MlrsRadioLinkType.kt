package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * RADIO_LINK_TYPE enum.
 */
@GeneratedMavEnum
public enum class MlrsRadioLinkType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Unknown radio link type.
   */
  @GeneratedMavEnumEntry
  GENERIC(0u),
  /**
   * Radio link is HereLink.
   */
  @GeneratedMavEnumEntry
  HERELINK(1u),
  /**
   * Radio link is Dragon Link.
   */
  @GeneratedMavEnumEntry
  DRAGONLINK(2u),
  /**
   * Radio link is RFD900.
   */
  @GeneratedMavEnumEntry
  RFD900(3u),
  /**
   * Radio link is Crossfire.
   */
  @GeneratedMavEnumEntry
  CROSSFIRE(4u),
  /**
   * Radio link is ExpressLRS.
   */
  @GeneratedMavEnumEntry
  EXPRESSLRS(5u),
  /**
   * Radio link is mLRS.
   */
  @GeneratedMavEnumEntry
  MLRS(6u),
  ;

  public companion object : MavEnum.MavCompanion<MlrsRadioLinkType> {
    override fun getEntryFromValueOrNull(v: UInt): MlrsRadioLinkType? = when (v) {
      0u -> GENERIC
      1u -> HERELINK
      2u -> DRAGONLINK
      3u -> RFD900
      4u -> CROSSFIRE
      5u -> EXPRESSLRS
      6u -> MLRS
      else -> null
    }
  }
}
