package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

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
  @GeneratedMavEnumEntry
  SPEKTRUM_DSM2(0L),
  /**
   * Spektrum DSMX
   */
  @GeneratedMavEnumEntry
  SPEKTRUM_DSMX(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): RcType? = when (v) {
      0L -> SPEKTRUM_DSM2
      1L -> SPEKTRUM_DSMX
      else -> null
    }
  }
}
