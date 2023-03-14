package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Generalized UAVCAN node mode
 */
@GeneratedMavEnum
public enum class UavcanNodeMode(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * The node is performing its primary functions.
   */
  @GeneratedMavEnumEntry
  OPERATIONAL(0u),
  /**
   * The node is initializing; this mode is entered immediately after startup.
   */
  @GeneratedMavEnumEntry
  INITIALIZATION(1u),
  /**
   * The node is under maintenance.
   */
  @GeneratedMavEnumEntry
  MAINTENANCE(2u),
  /**
   * The node is in the process of updating its software.
   */
  @GeneratedMavEnumEntry
  SOFTWARE_UPDATE(3u),
  /**
   * The node is no longer available online.
   */
  @GeneratedMavEnumEntry
  OFFLINE(7u),
  ;

  public companion object : MavEnum.Companion<UavcanNodeMode> {
    public override fun getEntryFromValueOrNull(v: UInt): UavcanNodeMode? = when (v) {
      0u -> OPERATIONAL
      1u -> INITIALIZATION
      2u -> MAINTENANCE
      3u -> SOFTWARE_UPDATE
      7u -> OFFLINE
      else -> null
    }
  }
}
