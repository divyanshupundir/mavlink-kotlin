package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Generalized UAVCAN node health
 */
@GeneratedMavEnum
public enum class UavcanNodeHealth(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The node is functioning properly.
   */
  UAVCAN_NODE_HEALTH_OK(0L),
  /**
   * A critical parameter went out of range or the node has encountered a minor failure.
   */
  UAVCAN_NODE_HEALTH_WARNING(1L),
  /**
   * The node has encountered a major failure.
   */
  UAVCAN_NODE_HEALTH_ERROR(2L),
  /**
   * The node has suffered a fatal malfunction.
   */
  UAVCAN_NODE_HEALTH_CRITICAL(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UavcanNodeHealth? = when (v) {
      0L -> UAVCAN_NODE_HEALTH_OK
      1L -> UAVCAN_NODE_HEALTH_WARNING
      2L -> UAVCAN_NODE_HEALTH_ERROR
      3L -> UAVCAN_NODE_HEALTH_CRITICAL
      else -> null
    }
  }
}
