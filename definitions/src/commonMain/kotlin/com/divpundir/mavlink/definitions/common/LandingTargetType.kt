package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Type of landing target
 */
@GeneratedMavEnum
public enum class LandingTargetType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Landing target signaled by light beacon (ex: IR-LOCK)
   */
  @GeneratedMavEnumEntry
  LIGHT_BEACON(0u),
  /**
   * Landing target signaled by radio beacon (ex: ILS, NDB)
   */
  @GeneratedMavEnumEntry
  RADIO_BEACON(1u),
  /**
   * Landing target represented by a fiducial marker (ex: ARTag)
   */
  @GeneratedMavEnumEntry
  VISION_FIDUCIAL(2u),
  /**
   * Landing target represented by a pre-defined visual shape/feature (ex: X-marker, H-marker,
   * square)
   */
  @GeneratedMavEnumEntry
  VISION_OTHER(3u),
  ;

  public companion object : MavEnum.MavCompanion<LandingTargetType> {
    override fun getEntryFromValueOrNull(v: UInt): LandingTargetType? = when (v) {
      0u -> LIGHT_BEACON
      1u -> RADIO_BEACON
      2u -> VISION_FIDUCIAL
      3u -> VISION_OTHER
      else -> null
    }
  }
}
