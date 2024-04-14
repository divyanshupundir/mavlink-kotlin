package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Modes of illuminator
 */
@GeneratedMavEnum
public enum class IlluminatorMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Illuminator mode is not specified/unknown
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * Illuminator behavior is controlled by MAV_CMD_DO_ILLUMINATOR_CONFIGURE settings
   */
  @GeneratedMavEnumEntry
  INTERNAL_CONTROL(1u),
  /**
   * Illuminator behavior is controlled by external factors: e.g. an external hardware signal
   */
  @GeneratedMavEnumEntry
  EXTERNAL_SYNC(2u),
  ;

  public companion object : MavEnum.MavCompanion<IlluminatorMode> {
    override fun getEntryFromValueOrNull(v: UInt): IlluminatorMode? = when (v) {
      0u -> UNKNOWN
      1u -> INTERNAL_CONTROL
      2u -> EXTERNAL_SYNC
      else -> null
    }
  }
}
