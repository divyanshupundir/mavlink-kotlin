package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Enumeration of distance sensor types
 */
@GeneratedMavEnum
public enum class MavDistanceSensor(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Laser rangefinder, e.g. LightWare SF02/F or PulsedLight units
   */
  @GeneratedMavEnumEntry
  LASER(0u),
  /**
   * Ultrasound rangefinder, e.g. MaxBotix units
   */
  @GeneratedMavEnumEntry
  ULTRASOUND(1u),
  /**
   * Infrared rangefinder, e.g. Sharp units
   */
  @GeneratedMavEnumEntry
  INFRARED(2u),
  /**
   * Radar type, e.g. uLanding units
   */
  @GeneratedMavEnumEntry
  RADAR(3u),
  /**
   * Broken or unknown type, e.g. analog units
   */
  @GeneratedMavEnumEntry
  UNKNOWN(4u),
  ;

  public companion object : MavEnum.MavCompanion<MavDistanceSensor> {
    override fun getEntryFromValueOrNull(v: UInt): MavDistanceSensor? = when (v) {
      0u -> LASER
      1u -> ULTRASOUND
      2u -> INFRARED
      3u -> RADAR
      4u -> UNKNOWN
      else -> null
    }
  }
}
