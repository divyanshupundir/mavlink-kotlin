package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Enumeration of distance sensor types
 */
@GeneratedMavEnum
public enum class MavDistanceSensor(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Laser rangefinder, e.g. LightWare SF02/F or PulsedLight units
   */
  @GeneratedMavEnumEntry
  LASER(0L),
  /**
   * Ultrasound rangefinder, e.g. MaxBotix units
   */
  @GeneratedMavEnumEntry
  ULTRASOUND(1L),
  /**
   * Infrared rangefinder, e.g. Sharp units
   */
  @GeneratedMavEnumEntry
  INFRARED(2L),
  /**
   * Radar type, e.g. uLanding units
   */
  @GeneratedMavEnumEntry
  RADAR(3L),
  /**
   * Broken or unknown type, e.g. analog units
   */
  @GeneratedMavEnumEntry
  UNKNOWN(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavDistanceSensor? = when (v) {
      0L -> LASER
      1L -> ULTRASOUND
      2L -> INFRARED
      3L -> RADAR
      4L -> UNKNOWN
      else -> null
    }
  }
}
