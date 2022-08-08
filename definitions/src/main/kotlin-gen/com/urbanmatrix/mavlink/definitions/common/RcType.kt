package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * RC type
 */
@GeneratedMavEnum
public enum class RcType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Spektrum DSM2
   */
  RC_TYPE_SPEKTRUM_DSM2(0L),
  /**
   * Spektrum DSMX
   */
  RC_TYPE_SPEKTRUM_DSMX(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): RcType? = when (v) {
      0L -> RC_TYPE_SPEKTRUM_DSM2
      1L -> RC_TYPE_SPEKTRUM_DSMX
      else -> null
    }
  }
}
