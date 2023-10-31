package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Gimbal manager profiles. Only standard profiles are defined. Any implementation can define its
 * own profile(s) in addition, and should use enum values > 16.
 */
@GeneratedMavEnum
public enum class MavStorm32GimbalManagerProfile(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Default profile. Implementation specific.
   */
  @GeneratedMavEnumEntry
  DEFAULT(0u),
  /**
   * Not supported/deprecated.
   */
  @GeneratedMavEnumEntry
  CUSTOM(1u),
  /**
   * Profile with cooperative behavior.
   */
  @GeneratedMavEnumEntry
  COOPERATIVE(2u),
  /**
   * Profile with exclusive behavior.
   */
  @GeneratedMavEnumEntry
  EXCLUSIVE(3u),
  /**
   * Profile with priority and cooperative behavior for equal priority.
   */
  @GeneratedMavEnumEntry
  PRIORITY_COOPERATIVE(4u),
  /**
   * Profile with priority and exclusive behavior for equal priority.
   */
  @GeneratedMavEnumEntry
  PRIORITY_EXCLUSIVE(5u),
  ;

  public companion object : MavEnum.MavCompanion<MavStorm32GimbalManagerProfile> {
    public override fun getEntryFromValueOrNull(v: UInt): MavStorm32GimbalManagerProfile? = when (v)
        {
      0u -> DEFAULT
      1u -> CUSTOM
      2u -> COOPERATIVE
      3u -> EXCLUSIVE
      4u -> PRIORITY_COOPERATIVE
      5u -> PRIORITY_EXCLUSIVE
      else -> null
    }
  }
}
