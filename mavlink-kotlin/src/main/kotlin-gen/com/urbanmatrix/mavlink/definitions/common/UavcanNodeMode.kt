package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Generalized UAVCAN node mode
 */
public enum class UavcanNodeMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The node is performing its primary functions.
   */
  UAVCAN_NODE_MODE_OPERATIONAL(0L),
  /**
   * The node is initializing; this mode is entered immediately after startup.
   */
  UAVCAN_NODE_MODE_INITIALIZATION(1L),
  /**
   * The node is under maintenance.
   */
  UAVCAN_NODE_MODE_MAINTENANCE(2L),
  /**
   * The node is in the process of updating its software.
   */
  UAVCAN_NODE_MODE_SOFTWARE_UPDATE(3L),
  /**
   * The node is no longer available online.
   */
  UAVCAN_NODE_MODE_OFFLINE(7L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UavcanNodeMode? = when (v) {
      0L -> UAVCAN_NODE_MODE_OPERATIONAL
      1L -> UAVCAN_NODE_MODE_INITIALIZATION
      2L -> UAVCAN_NODE_MODE_MAINTENANCE
      3L -> UAVCAN_NODE_MODE_SOFTWARE_UPDATE
      7L -> UAVCAN_NODE_MODE_OFFLINE
      else -> null
    }
  }
}
