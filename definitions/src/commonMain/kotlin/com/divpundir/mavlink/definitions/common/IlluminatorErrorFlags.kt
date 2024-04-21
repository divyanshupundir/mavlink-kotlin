package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Illuminator module error flags (bitmap, 0 means no error)
 */
@GeneratedMavEnum(bitmask = true)
public enum class IlluminatorErrorFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Illuminator thermal throttling error.
   */
  @GeneratedMavEnumEntry
  THERMAL_THROTTLING(1u),
  /**
   * Illuminator over temperature shutdown error.
   */
  @GeneratedMavEnumEntry
  OVER_TEMPERATURE_SHUTDOWN(2u),
  /**
   * Illuminator thermistor failure.
   */
  @GeneratedMavEnumEntry
  THERMISTOR_FAILURE(4u),
  ;

  public companion object : MavBitmask.MavCompanion<IlluminatorErrorFlags> {
    override fun getEntryFromValueOrNull(v: UInt): IlluminatorErrorFlags? = when (v) {
      1u -> THERMAL_THROTTLING
      2u -> OVER_TEMPERATURE_SHUTDOWN
      4u -> THERMISTOR_FAILURE
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<IlluminatorErrorFlags> = buildList {
      if (v and 1u == 1u) add(THERMAL_THROTTLING)
      if (v and 2u == 2u) add(OVER_TEMPERATURE_SHUTDOWN)
      if (v and 4u == 4u) add(THERMISTOR_FAILURE)
    }
  }
}
