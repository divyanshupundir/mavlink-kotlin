package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Actions being taken to mitigate/prevent fence breach
 */
@GeneratedMavEnum
public enum class FenceMitigate(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Unknown
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0L),
  /**
   * No actions being taken
   */
  @GeneratedMavEnumEntry
  NONE(1L),
  /**
   * Velocity limiting active to prevent breach
   */
  @GeneratedMavEnumEntry
  VEL_LIMIT(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): FenceMitigate? = when (v) {
      0L -> UNKNOWN
      1L -> NONE
      2L -> VEL_LIMIT
      else -> null
    }
  }
}
