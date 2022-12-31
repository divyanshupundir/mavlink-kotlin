package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Type of landing target
 */
@GeneratedMavEnum
public enum class LandingTargetType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Landing target signaled by light beacon (ex: IR-LOCK)
   */
  @GeneratedMavEnumEntry
  LIGHT_BEACON(0L),
  /**
   * Landing target signaled by radio beacon (ex: ILS, NDB)
   */
  @GeneratedMavEnumEntry
  RADIO_BEACON(1L),
  /**
   * Landing target represented by a fiducial marker (ex: ARTag)
   */
  @GeneratedMavEnumEntry
  VISION_FIDUCIAL(2L),
  /**
   * Landing target represented by a pre-defined visual shape/feature (ex: X-marker, H-marker,
   * square)
   */
  @GeneratedMavEnumEntry
  VISION_OTHER(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): LandingTargetType? = when (v) {
      0L -> LIGHT_BEACON
      1L -> RADIO_BEACON
      2L -> VISION_FIDUCIAL
      3L -> VISION_OTHER
      else -> null
    }
  }
}
