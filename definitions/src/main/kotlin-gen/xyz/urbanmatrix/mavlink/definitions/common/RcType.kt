package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * RC type
 */
@GeneratedMavEnum
public enum class RcType(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Spektrum DSM2
   */
  @GeneratedMavEnumEntry
  SPEKTRUM_DSM2(0u),
  /**
   * Spektrum DSMX
   */
  @GeneratedMavEnumEntry
  SPEKTRUM_DSMX(1u),
  ;

  public companion object : MavEnum.Companion<RcType> {
    public override fun getEntryFromValueOrNull(v: UInt): RcType? = when (v) {
      0u -> SPEKTRUM_DSM2
      1u -> SPEKTRUM_DSMX
      else -> null
    }
  }
}
