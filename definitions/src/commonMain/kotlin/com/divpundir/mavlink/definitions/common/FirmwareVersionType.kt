package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * These values define the type of firmware release.  These values indicate the first version or
 * release of this type.  For example the first alpha release would be 64, the second would be 65.
 */
@GeneratedMavEnum
public enum class FirmwareVersionType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * development release
   */
  @GeneratedMavEnumEntry
  DEV(0u),
  /**
   * alpha release
   */
  @GeneratedMavEnumEntry
  ALPHA(64u),
  /**
   * beta release
   */
  @GeneratedMavEnumEntry
  BETA(128u),
  /**
   * release candidate
   */
  @GeneratedMavEnumEntry
  RC(192u),
  /**
   * official stable release
   */
  @GeneratedMavEnumEntry
  OFFICIAL(255u),
  ;

  public companion object : MavEnum.MavCompanion<FirmwareVersionType> {
    override fun getEntryFromValueOrNull(v: UInt): FirmwareVersionType? = when (v) {
      0u -> DEV
      64u -> ALPHA
      128u -> BETA
      192u -> RC
      255u -> OFFICIAL
      else -> null
    }
  }
}
