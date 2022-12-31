package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Generalized UAVCAN node mode
 */
@GeneratedMavEnum
public enum class UavcanNodeMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The node is performing its primary functions.
   */
  @GeneratedMavEnumEntry
  OPERATIONAL(0L),
  /**
   * The node is initializing; this mode is entered immediately after startup.
   */
  @GeneratedMavEnumEntry
  INITIALIZATION(1L),
  /**
   * The node is under maintenance.
   */
  @GeneratedMavEnumEntry
  MAINTENANCE(2L),
  /**
   * The node is in the process of updating its software.
   */
  @GeneratedMavEnumEntry
  SOFTWARE_UPDATE(3L),
  /**
   * The node is no longer available online.
   */
  @GeneratedMavEnumEntry
  OFFLINE(7L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UavcanNodeMode? = when (v) {
      0L -> OPERATIONAL
      1L -> INITIALIZATION
      2L -> MAINTENANCE
      3L -> SOFTWARE_UPDATE
      7L -> OFFLINE
      else -> null
    }
  }
}
