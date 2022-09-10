package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

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
  @GeneratedMavEnumEntry
  UAVCAN_NODE_HEALTH_OK(0L),
  /**
   * A critical parameter went out of range or the node has encountered a minor failure.
   */
  @GeneratedMavEnumEntry
  UAVCAN_NODE_HEALTH_WARNING(1L),
  /**
   * The node has encountered a major failure.
   */
  @GeneratedMavEnumEntry
  UAVCAN_NODE_HEALTH_ERROR(2L),
  /**
   * The node has suffered a fatal malfunction.
   */
  @GeneratedMavEnumEntry
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
