package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Actions being taken to mitigate/prevent fence breach
 */
public enum class FenceMitigate(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Unknown
   */
  FENCE_MITIGATE_UNKNOWN(0L),
  /**
   * No actions being taken
   */
  FENCE_MITIGATE_NONE(1L),
  /**
   * Velocity limiting active to prevent breach
   */
  FENCE_MITIGATE_VEL_LIMIT(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): FenceMitigate? = when (v) {
      0L -> FENCE_MITIGATE_UNKNOWN
      1L -> FENCE_MITIGATE_NONE
      2L -> FENCE_MITIGATE_VEL_LIMIT
      else -> null
    }
  }
}
