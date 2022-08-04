package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class GoproFieldOfView(
  public override val `value`: Long,
) : MavEnum {
  /**
   * 0x00: Wide.
   */
  GOPRO_FIELD_OF_VIEW_WIDE(0L),
  /**
   * 0x01: Medium.
   */
  GOPRO_FIELD_OF_VIEW_MEDIUM(1L),
  /**
   * 0x02: Narrow.
   */
  GOPRO_FIELD_OF_VIEW_NARROW(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproFieldOfView? = when (v) {
      0L -> GOPRO_FIELD_OF_VIEW_WIDE
      1L -> GOPRO_FIELD_OF_VIEW_MEDIUM
      2L -> GOPRO_FIELD_OF_VIEW_NARROW
      else -> null
    }
  }
}
