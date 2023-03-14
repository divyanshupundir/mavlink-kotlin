package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class FenceBreach(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * No last fence breach
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Breached minimum altitude
   */
  @GeneratedMavEnumEntry
  MINALT(1u),
  /**
   * Breached maximum altitude
   */
  @GeneratedMavEnumEntry
  MAXALT(2u),
  /**
   * Breached fence boundary
   */
  @GeneratedMavEnumEntry
  BOUNDARY(3u),
  ;

  public companion object : MavEnum.Companion<FenceBreach> {
    public override fun getEntryFromValueOrNull(v: UInt): FenceBreach? = when (v) {
      0u -> NONE
      1u -> MINALT
      2u -> MAXALT
      3u -> BOUNDARY
      else -> null
    }
  }
}
