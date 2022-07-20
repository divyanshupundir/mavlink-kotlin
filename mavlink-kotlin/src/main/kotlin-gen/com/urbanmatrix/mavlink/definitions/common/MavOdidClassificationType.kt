package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class MavOdidClassificationType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The classification type for the UA is undeclared.
   */
  MAV_ODID_CLASSIFICATION_TYPE_UNDECLARED(0L),
  /**
   * The classification type for the UA follows EU (European Union) specifications.
   */
  MAV_ODID_CLASSIFICATION_TYPE_EU(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidClassificationType? = when (v) {
      0L -> MAV_ODID_CLASSIFICATION_TYPE_UNDECLARED
      1L -> MAV_ODID_CLASSIFICATION_TYPE_EU
      else -> null
    }
  }
}
