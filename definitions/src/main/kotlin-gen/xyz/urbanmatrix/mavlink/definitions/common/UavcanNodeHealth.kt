package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Generalized UAVCAN node health
 */
@GeneratedMavEnum
public enum class UavcanNodeHealth(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * The node is functioning properly.
   */
  @GeneratedMavEnumEntry
  OK(0u),
  /**
   * A critical parameter went out of range or the node has encountered a minor failure.
   */
  @GeneratedMavEnumEntry
  WARNING(1u),
  /**
   * The node has encountered a major failure.
   */
  @GeneratedMavEnumEntry
  ERROR(2u),
  /**
   * The node has suffered a fatal malfunction.
   */
  @GeneratedMavEnumEntry
  CRITICAL(3u),
  ;

  public companion object : MavEnum.Companion<UavcanNodeHealth> {
    public override fun getEntryFromValueOrNull(v: UInt): UavcanNodeHealth? = when (v) {
      0u -> OK
      1u -> WARNING
      2u -> ERROR
      3u -> CRITICAL
      else -> null
    }
  }
}
